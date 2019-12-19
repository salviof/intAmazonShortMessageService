package br.org.coletivoJava.integracoes.restAmazonsms.implementacao;

import br.org.coletivoJava.integracoes.restAmazonsms.api.InfoIntegracaoRestAmazonsms;
import br.org.coletivoJava.integracoes.amazonSMS.FabIntegracaoSMS;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.gestaoToken.GestaoTokenChaveUnica;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteRest;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

@InfoIntegracaoRestAmazonsms(tipo = FabIntegracaoSMS.ENVIAR_MENSAGEM)
public class GestaoTokenRestAmazonsms extends GestaoTokenChaveUnica {

    @Override
    public String gerarNovoToken() {
        return null;
    }

    @Override
    public boolean validarToken() {
        return false;
    }

    public GestaoTokenRestAmazonsms(final FabTipoAgenteClienteRest pTipoAgente,
            final ItfUsuario pUsuario) {
        super(FabIntegracaoSMS.class, pTipoAgente, pUsuario);
    }
}
