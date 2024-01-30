package bts.ciel.tp_conversion_euro;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public ComboBox comboSelection;
    @FXML
    private Label label_Init;
    @FXML
    private Label label_Final;
    @FXML
    private TextField textField_Final;
    @FXML
    private TextField textField_Init;
    @FXML
    private Button buttonConvertion;
    DecimalFormat df = new DecimalFormat("##.##");
    ArrayList<ConversionDevise> devise = new ArrayList<>();
    private double tx_Euro_Dollar = 1.08;
    private double tx_Euro_Livre = 0.85;
    private double Tx_Euro_Yen = 160;
    private double valeur_Conversion, valeur_Init, valeur_Final;


    public Controller() {
    }

    public void initialize(URL location, ResourceBundle resources){
        buttonConvertion.setOnAction(event -> convertion());
        fabriqueDonnees();
        comboSelection.setOnAction(event -> comboSelection(event));
    }

    private void fabriqueDonnees() {
        devise.add(new ConversionDevise("Euro - Dollar", "Euro", "Dollar", tx_Euro_Dollar));
        devise.add(new ConversionDevise("Dollar - Euros", "Dollar", "Euro", tx_Euro_Dollar));
        devise.add(new ConversionDevise("Euro - Livre", "Euro", "Livre", tx_Euro_Livre));
        devise.add(new ConversionDevise("Livre - Euro", "Livre", "Euro", tx_Euro_Livre));
        devise.add(new ConversionDevise("Euro - Yen", "Euro", "Yen", Tx_Euro_Yen));
        devise.add(new ConversionDevise("Yen - Euro", "Yen", "Euro", Tx_Euro_Yen));
        devise.forEach(element-> comboSelection.getItems().add(element.getPrompt()));
    }

    private void convertion(){
        try{
            valeur_Init = Double.parseDouble(textField_Init.getText());
            int index = comboSelection.getSelectionModel().getSelectedIndex();
            if (index % 2 == 0){
                valeur_Conversion = devise.get(index).getTaux();
            }else{
                valeur_Conversion = 1/devise.get(index).getTaux();
            }
            valeur_Final = valeur_Init * valeur_Conversion;
            textField_Final.setText(String.valueOf(df.format(valeur_Final)));
        }catch(Exception e){
            alerteFormat();
        }
    }

    private void alerteFormat(){
        Alert dialogW = new Alert(Alert.AlertType.WARNING);
        dialogW.setTitle("Erreur de saisie");
        dialogW.setHeaderText(null);
        dialogW.setContentText("Veuillez remplacer votre virgule décimale par un point");
        dialogW.showAndWait();
    }

    private void comboSelection(Event event) {
        int index = ((ComboBox)event.getSource()).getSelectionModel().getSelectedIndex();
        label_Init.setText(devise.get(index).getSource());
        label_Final.setText(devise.get(index).getCible());
        System.out.println(index);

    }
}