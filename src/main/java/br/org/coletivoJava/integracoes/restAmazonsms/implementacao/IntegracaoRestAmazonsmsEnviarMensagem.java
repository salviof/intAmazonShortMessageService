package br.org.coletivoJava.integracoes.restAmazonsms.implementacao;

import br.org.coletivoJava.integracoes.amazonSMS.FabConfigSMSIntegracao;
import br.org.coletivoJava.integracoes.restAmazonsms.api.InfoIntegracaoRestAmazonsms;
import br.org.coletivoJava.integracoes.amazonSMS.FabIntegracaoSMS;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreStringValidador;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.RespostaWebServiceRestIntegracao;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteRest;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;
import java.util.HashMap;
import java.util.Map;

@InfoIntegracaoRestAmazonsms(tipo = FabIntegracaoSMS.ENVIAR_MENSAGEM)
public class IntegracaoRestAmazonsmsEnviarMensagem
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestAmazonsmsEnviarMensagem(
            final FabTipoAgenteClienteRest pTipoAgente,
            final ItfUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabIntegracaoSMS.ENVIAR_MENSAGEM, pTipoAgente, pUsuario,
                pParametro);
    }

    @Override
    protected void executarAcao() {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(getConfiguracao().getPropriedade(FabConfigSMSIntegracao.CHAVE_PUBLICA), getConfiguracao().getPropriedade(FabConfigSMSIntegracao.CHAVE_PRIVADA));

        AmazonSNS snsClient = AmazonSNSClientBuilder.standard().withRegion(Regions.US_EAST_1).withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();

        String numeroTelefone = parametros[0].toString();
        String mensagem = parametros[1].toString();
        Map<String, MessageAttributeValue> smsAttributes
                = new HashMap<>();
        //<set SMS attributes>
        String respstr = sendSMSMessage(snsClient, mensagem, numeroTelefone, smsAttributes);

    }

    private String sendSMSMessage(AmazonSNS snsClient, String message,
            String phoneNumber, Map<String, MessageAttributeValue> smsAttributes) {
        if (!UtilSBCoreStringValidador.isNuloOuEmbranco(phoneNumber)) {
            PublishResult result = snsClient.publish(new PublishRequest()
                    .withMessage(message)
                    .withPhoneNumber(phoneNumber)
                    .withMessageAttributes(smsAttributes));
            System.out.println(result); // Prints the message ID.

            resposta = new RespostaWebServiceRestIntegracao(result.toString(), result.getSdkHttpMetadata().getHttpStatusCode());
            return result.toString();
        } else {
            return null;
        }
    }

}
