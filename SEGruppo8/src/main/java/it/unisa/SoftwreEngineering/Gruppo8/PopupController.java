package it.unisa.SoftwreEngineering.Gruppo8;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class PopupController {

    /*
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    */
    public static void display(String message){
        Stage window = new Stage();
        window. initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Error");
        window.setMinWidth(250);
        Label label = new Label();
        label.setPadding(new Insets(10,10,10,10));
        label.setText(message);
        Button closeButton = new Button ("Ok");
        closeButton.setOnAction(e -> window.close());
        
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
    
}