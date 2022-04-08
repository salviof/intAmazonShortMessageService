package br.org.coletivoJava.integracoes.restAmazonsms.implementacao;

import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoHeaderBuilder;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.transmissao_recepcao_rest_client.ItfAcaoApiRest;

public class IntegracaoRestAmazonsms_HeaderPadrao
		extends
			AcaoApiIntegracaoHeaderBuilder {

	public IntegracaoRestAmazonsms_HeaderPadrao(final ItfAcaoApiRest pAcao) {
		super(pAcao);
	}
}