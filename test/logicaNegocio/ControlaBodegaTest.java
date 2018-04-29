/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaNegocio;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import modelo.Bodega;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cristian gomez ruiz
 */
public class ControlaBodegaTest {
    
    public ControlaBodegaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of consultarDestinatarios method, of class ControlaBodega.
     */
    @Test
    public void testConsultarDestinatarios() throws Exception {
        System.out.println("consultarBodegas");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ControlaBodega instance = (ControlaBodega)container.getContext().lookup("java:global/classes/ControlaBodega");
        List<Bodega> expResult = null;
        List<Bodega> result = instance.consultarBodegas();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
