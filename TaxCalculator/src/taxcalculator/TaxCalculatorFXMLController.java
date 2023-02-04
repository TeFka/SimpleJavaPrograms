/**
 * Sample Skeleton for 'TaxCalculatorGUIFXML.fxml' Controller Class
 */

package taxcalculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TaxCalculatorFXMLController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="gas"
    private TextField gas; // Value injected by FXMLLoader

    @FXML // fx:id="taxPaid"
    private TextArea taxPaid; // Value injected by FXMLLoader

    @FXML // fx:id="monthlyEarning"
    private TextField monthlyEarning; // Value injected by FXMLLoader

    @FXML // fx:id="calcButton"
    private Button calcButton; // Value injected by FXMLLoader

    @FXML
    void calcButtonPressed(ActionEvent event) {
        
        // get the gross annual salary
        double grossAnnualSalary =  Double.valueOf(gas.getText());
        
        // make the instance of TaxCalculatorModel
        TaxCalculatorModel instance = new TaxCalculatorModel(grossAnnualSalary);
        
        // perform the calculate method
        instance.calculate1250LTax();
        
        // set the text to the TextArea
        taxPaid.setText(instance.getTaxPaidDetail());
        
        // calculate the take home earning
        double nettMonthlyEarning = (grossAnnualSalary - instance.getTotalTaxPaid())/12.0;
        
        // set the takehome earning to the GUI
        monthlyEarning.setText(String.valueOf(nettMonthlyEarning));
        
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert gas != null : "fx:id=\"gas\" was not injected: check your FXML file 'TaxCalculatorGUIFXML.fxml'.";
        assert taxPaid != null : "fx:id=\"taxPaid\" was not injected: check your FXML file 'TaxCalculatorGUIFXML.fxml'.";
        assert monthlyEarning != null : "fx:id=\"monthlyEarning\" was not injected: check your FXML file 'TaxCalculatorGUIFXML.fxml'.";
        assert calcButton != null : "fx:id=\"calcButton\" was not injected: check your FXML file 'TaxCalculatorGUIFXML.fxml'.";

    }
}
