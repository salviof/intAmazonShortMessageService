package br.org.coletivoJava.integracoes.restAmazonsms.implementacao;

import br.org.coletivoJava.integracoes.amazonSMS.FabConfigSMSIntegracao;
import br.org.coletivoJava.integracoes.restAmazonsms.api.InfoIntegracaoRestAmazonsms;
import br.org.coletivoJava.integracoes.amazonSMS.FabIntegracaoSMS;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.oauth.FabStatusToken;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.gestaoToken.GestaoTokenChaveUnica;

import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.token.ItfTokenDeAcessoExterno;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.token.TokenDeAcessoExternoChavePublicaPrivada;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

@InfoIntegracaoRestAmazonsms(tipo = FabIntegracaoSMS.ENVIAR_MENSAGEM)
public class GestaoTokenRestAmazonsms extends GestaoTokenChaveUnica {

    @Override
    public boolean validarToken() {
        return false;
    }

    public GestaoTokenRestAmazonsms(final FabTipoAgenteClienteApi pTipoAgente,
            final ItfUsuario pUsuario) {
        super(FabIntegracaoSMS.class, pTipoAgente, pUsuario);
    }

    @Override
    public ItfTokenDeAcessoExterno loadTokenArmazenado() {
        if (getStatusToken().equals(FabStatusToken.ATIVO)) {
            return getTokenCompleto();
        }
        String chavePublica = getConfig().getPropriedade(FabConfigSMSIntegracao.CHAVE_PUBLICA);
        String chavePrivada = getConfig().getPropriedade(FabConfigSMSIntegracao.CHAVE_PRIVADA);
        TokenDeAcessoExternoChavePublicaPrivada token = new TokenDeAcessoExternoChavePublicaPrivada(chavePublica, chavePrivada);
        setToken(token);
        return getTokenCompleto();
    }

    @Override
    public ItfTokenDeAcessoExterno gerarNovoToken() {
        return loadTokenArmazenado();
    }

}
