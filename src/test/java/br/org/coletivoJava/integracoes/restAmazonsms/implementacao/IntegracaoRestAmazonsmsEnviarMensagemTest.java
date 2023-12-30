/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.integracoes.restAmazonsms.implementacao;

import br.org.coletivoJava.integracoes.amazonSMS.ConfiguradorCoreShortMessageService;
import br.org.coletivoJava.integracoes.amazonSMS.FabIntegracaoSMS;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfResposta;
import org.coletivojava.fw.api.tratamentoErros.FabErro;
import org.junit.Test;
import spark.utils.Assert;
import testes.testesSupers.TestesApiRest;

/**
 *
 * @author sfurbino
 */
public class IntegracaoRestAmazonsmsEnviarMensagemTest extends TestesApiRest {

    /**
     * Test of executarAcao method, of class
     * IntegracaoRestAmazonsmsEnviarMensagem.
     */
    @Test
    public void testExecutarAcao() {
        try {
            SBCore.configurar(new ConfiguradorCoreShortMessageService(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
            ItfRespostaWebServiceSimples resposta = FabIntegracaoSMS.ENVIAR_MENSAGEM.getAcao("+553197140804", "Teste 2").getResposta();
            Assert.notNull(resposta, "A resposta foi nula");

            if (!resposta.isSucesso()) {
                resposta.dispararMensagens();
            }
            System.out.println(resposta.getRespostaTexto());
            Assert.isTrue(resposta.isSucesso(), "Falha enviando SMS");

        } catch (Throwable t) {
            SBCore.RelatarErro(FabErro.SOLICITAR_REPARO, "Erro " + t.getMessage(), t);
        }
    }

}
