/*
 *  Super-Bits.com CODE CNPJ 20.019.971/0001-90

 */
package br.org.coletivoJava.integracoes.amazonSMS;

import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.ItfFabricaIntegracaoRest;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.InfoConsumoRestService;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.servicoRegistrado.FabTipoAutenticacaoRest;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.servicoRegistrado.InfoConfigRestClientIntegracao;

/**
 *
 * @author desenvolvedor
 */
@InfoConfigRestClientIntegracao(configuracao = FabConfigSMSIntegracao.class,
        nomeIntegracao = "amazonSMS",
        tipoAutenticacao = FabTipoAutenticacaoRest.CHAVE_PUBLICA_PRIVADA)
public enum FabIntegracaoSMS implements ItfFabricaIntegracaoRest {

    @InfoConsumoRestService(getPachServico = "", parametrosPost = {"Mensagem", "id", "ClienteID"})
    ENVIAR_MENSAGEM;
}
