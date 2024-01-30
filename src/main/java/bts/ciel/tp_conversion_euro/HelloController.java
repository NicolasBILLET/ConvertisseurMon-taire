package bts.ciel.tp_conversion_euro;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {


    @FXML
    public ToggleGroup Convert_Select;
    public ComboBox boxSelect;
    @FXML
    private RadioButton Euro_DollarButton;
    @FXML
    private RadioButton Dollar_EuroButton;
    @FXML
    private Label labelMoneyUp;
    @FXML
    private Label labelMoneyDown;
    @FXML
    private TextField dollarTextField;
    @FXML
    private TextField euroTextField;
    @FXML
    private Button buttonConvertion;

    private double taux_Euro_Livre;
    private double taux_Euro_Dollar;
    private double taux_Euro_Yen;
    private double valeurInit;
    private double valeur_Conversion;
    private double valeur_Finale;

    public HelloController() {
    }

    public void initialize(URL location, ResourceBundle resources) throws NumberFormatException{
        euroTextField.textProperty().addListener(event -> {
                dollarTextField.getStyleClass().clear();
                dollarTextField.getStyleClass().addAll("text-field", "text-input","event");
                miseAJour();
        });
//        Euro_DollarButton.setOnAction(event -> euro_Dollarconvert());
        fabriqueDonnees();
        boxSelect.setOnAction(event -> comboSelection(event));
    }

    private ArrayList<String> fabriqueDonnees() {
        ArrayList<String> conversion = new ArrayList<>();
        conversion.add("Euro - Dollar");
        conversion.add("Dollar - Euro");
        conversion.add("Euro - Livre");
        conversion.add("Livre - Euro");
        conversion.add("Euro - Yen");
        conversion.add("Yen - Euro");
        conversion.forEach(element-> boxSelect.getItems().add(element));

        return conversion;
    }

    private void comboSelection(Event event) {
        int index = ((ComboBox)event.getSource()).getSelectionModel().getSelectedIndex();
        System.out.println(((ComboBox<?>) event.getSource()).getItems().get(index));
    }


//    private void euro_Dollarconvert() {
//    }


    private void miseAJour() throws NumberFormatException{
        dollarTextField.setEditable(false);
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e){
                try{
                double calc;
                calc = Double.parseDouble(euroTextField.getText());
                calc = calc*1.09;
                dollarTextField.setText(String.valueOf(calc));
                }catch (NumberFormatException n){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning");
                    alert.setResizable(false);
                    alert.setHeaderText(null);
                    alert.setContentText("Mauvais format de texte entré");
                    alert.showAndWait();
                }
            }
        };
        buttonConvertion.setOnAction(event);


    }
}