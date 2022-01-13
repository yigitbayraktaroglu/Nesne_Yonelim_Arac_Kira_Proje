module com.example.projetaslaks {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projetaslaks to javafx.fxml;
    exports com.example.projetaslaks;
}