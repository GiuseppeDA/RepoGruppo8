module com.mycompany.se.gruppo8 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.se.gruppo8 to javafx.fxml;
    exports com.mycompany.se.gruppo8;
    requires jcomplex;
}
