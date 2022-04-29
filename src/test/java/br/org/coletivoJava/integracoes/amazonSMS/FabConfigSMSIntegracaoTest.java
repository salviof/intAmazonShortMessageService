/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.integracoes.amazonSMS;

import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import org.junit.Test;
import static org.junit.Assert.*;
import testes.testesSupers.TestesApiRest;

/**
 *
 * @author sfurbino
 */
public class FabConfigSMSIntegracaoTest extends TestesApiRest {

    public FabConfigSMSIntegracaoTest() {
    }

    /**
     * Test of values method, of class FabConfigSMSIntegracao.
     */
    @Test
    public void testValues() {
        SBCore.configurar(new ConfiguradorCoreShortMessageService(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        gerarCodigosChamadasEndpoint(FabIntegracaoSMS.class);
    }

}
