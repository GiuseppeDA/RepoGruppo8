package it.unisa.SoftwreEngineering.Gruppo8;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class PrimaryController {

    @FXML
    private ListView<String> memory;
    @FXML
    private TextField real;
    @FXML
    private TextField imag;
    @FXML
    private Button insButton;

    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void insertComplex(MouseEvent event) {
        memory.getItems().add(real.getText());
    }
}
