module bts.ciel.tp_conversion_euro {
    requires javafx.controls;
    requires javafx.fxml;


    opens bts.ciel.tp_conversion_euro to javafx.fxml;
    exports bts.ciel.tp_conversion_euro;
}