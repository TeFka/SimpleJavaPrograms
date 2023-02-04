/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxcalculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sendy
 */
public class TaxCalculatorModelTest {
    
    public TaxCalculatorModelTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    

    /**
     * Test of calculate1250LTax method, of class TaxCalculatorModel.
     */
    @Test
    public void testCalculate1250LTax() {
        
        System.out.println("calculate1250LTax");
        TaxCalculatorModel instance = new TaxCalculatorModel(170000);
        
        double expResult = 61500.0;
        instance.calculate1250LTax();
        
        System.out.println(instance.getTotalTaxPaid());
        System.out.println(instance.getTaxPaidDetail());
        
        assertEquals(expResult, instance.getTotalTaxPaid(), 0.0);
        
    }
    
}
