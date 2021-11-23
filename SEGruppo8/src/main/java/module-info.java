module it.unisa.SoftwreEngineering.Gruppo8 {
    requires javafx.controls;
    requires javafx.fxml;

    opens it.unisa.SoftwreEngineering.Gruppo8 to javafx.fxml;
    exports it.unisa.SoftwreEngineering.Gruppo8;
    requires jcomplex;
    requires java.base;
}
