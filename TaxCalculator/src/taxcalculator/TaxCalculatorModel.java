/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxcalculator;

/**
 *
 * @author sendy
 */
public class TaxCalculatorModel {
    
    private double grossAnnualSalary;
    private double totalTaxPaid;
    private String taxPaidDetail; 

    // get set
    public void setGrossAnnualSalary(double _grossAnnualSalary){
        grossAnnualSalary = _grossAnnualSalary;
    }
    public void setTotalTaxPaid(double _totalTaxPaid){
        totalTaxPaid = _totalTaxPaid;
    }
    public void setTaxPaidDetail(String _taxPaidDetail){
        taxPaidDetail = _taxPaidDetail;
    }
    public double getGrossAnnualSalary(){
        return grossAnnualSalary;
    }
    public double getTotalTaxPaid(){
        return totalTaxPaid;
    }
    public String getTaxPaidDetail(){
        return  taxPaidDetail;
    }
    
    // constructor 
    public TaxCalculatorModel(double _grossAnnualSalary){
        setGrossAnnualSalary(_grossAnnualSalary);
    }
    
    //  method calculateTaxCost
    public void calculate1250LTax(){
        
        // PARAMETERS FOR TAX RULE FOR 1250L
        final double TAXRATE_1 = 0.2;
        final double TAXRATE_2 = 0.4;
        final double TAXRATE_3 = 0.45;
    
        final double BOUNDARY_1 = 37500;
        final double BOUNDARY_2 = 150000;
        
        // allocate the taxed values for rate 1, 2, 3
        double[] taxed_value = {0.0, 0.0, 0.0};
        // 
        if (grossAnnualSalary>BOUNDARY_1){
            
            taxed_value[0] = BOUNDARY_1*TAXRATE_1;
            
            if(grossAnnualSalary>BOUNDARY_2){
                
                taxed_value[1] = (BOUNDARY_2-BOUNDARY_1)*TAXRATE_2;
                taxed_value[2] = (grossAnnualSalary - BOUNDARY_2)*TAXRATE_3;
                
            } else{
                taxed_value[1] = (grossAnnualSalary-BOUNDARY_1)*TAXRATE_2;
            }
            
        } else {
            taxed_value[0] = grossAnnualSalary*TAXRATE_1;
        }
        
        double totalTaxValue = taxed_value[0] + taxed_value[1] + taxed_value[2];
        totalTaxPaid = totalTaxValue;
        
        // tax detail 
        taxPaidDetail = "Tax Paid for 20% rate is £" + String.valueOf(taxed_value[0]) + ";";
        taxPaidDetail = taxPaidDetail + "\nTax Paid for 40% rate is £" + String.valueOf(taxed_value[1]) + ";";
        taxPaidDetail = taxPaidDetail + "\nTax Paid for 45% rate is £" + String.valueOf(taxed_value[2]) + ";";
        
        taxPaidDetail = taxPaidDetail + "\n\n\n\n\nPS: \nThe calculator do not include NI contribution.";
    
    } 
}
