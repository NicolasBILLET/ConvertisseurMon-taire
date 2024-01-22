package bts.ciel.tp_conversion_euro;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private TextField dollarTextField;
    @FXML
    private TextField euroTextField;

    @FXML
    protected void onButtonAction() {
        double calc;
        calc = Double.parseDouble(euroTextField.getText());
        calc = calc*1.09;
        dollarTextField.setText(String.valueOf(calc));
    }

    public void initialize(URL location, ResourceBundle resources){
        euroTextField.textProperty().addListener(event -> {
            miseAJour();
        });
    }

    private void miseAJour(){
        double calc;
        calc = Double.parseDouble(euroTextField.getText());
        calc = calc*1.09;
        dollarTextField.setText(String.valueOf(calc));
    }


    /*

     public void initialize(URL location, ResourceBundle resources) {
        textFieldequation.textProperty().addListener(event -> {
            miseAJour();
        });
    }

    private void miseAJour() {
        if (eqResoudre.typeEquationOk(textFieldequation.getText())) {
            labelResultat.setText(eqResoudre.resoudre(textFieldequation.getText()));
        } else {
            labelResultat.setText("nok");
        }
        if(eqResoudre.typeEquationOk(textFieldequation.getText())){
            textFieldequation.getStyleClass().clear();
            textFieldequation.getStyleClass().addAll("text-field", "text-input","ok");
        }else{
            textFieldequation.getStyleClass().clear();
            textFieldequation.getStyleClass().addAll("text-field", "text-input","nOk");
        }
    }


     */
}