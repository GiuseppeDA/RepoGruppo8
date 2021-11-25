package it.unisa.SoftwreEngineering.Gruppo8;

import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import com.vm.jcomplex.Complex;
import javafx.scene.control.TextArea;
import javafx.stage.Screen;

public class PrimaryController {

    @FXML
    private ListView<Complex> memory;
    @FXML
    private TextField real;
    @FXML
    private TextField imag;
    @FXML
    private Button insButton;
    
    private Calculator calc = new Calculator();

    @FXML
    private Button addButton;
    @FXML
    private Button subtractButton;
    @FXML
    private Button sqrtButton;
    @FXML
    private Button multiplyButton;
    @FXML
    private Button divideButton;
    @FXML
    private Button invertButton;
    @FXML
    private TextArea screen;
    
    
    //Initializing
    
    public void initialize() {
        // Initialization code can go here. 
        // The parameters url and resources can be omitted if they are not needed
        screen.setEditable(false);
        
    }
    
    @FXML
    private void insertComplex(MouseEvent event) {
        Double realNum;
        Double imagNum;
        
        try {
            if(real.getText() == null || real.getText().trim().isEmpty())
                realNum = 0.0;
            else
                realNum = Double.parseDouble(real.getText());
            
            if(imag.getText() == null || imag.getText().trim().isEmpty())
                imagNum = 0.0;
            else
                imagNum = Double.parseDouble(imag.getText());
            
            calc.insert(realNum, imagNum);

            //righe da eliminare dopo aver inserito la observable
            memory.getItems().add(0,calc.getTop());
            screen.setText(memory.getItems().get(0).toString());

        }catch(NumberFormatException exc){
                SecondaryController.display("Inserisci solo numeri con segno che li pecede!");
        }

    }
    
    @FXML
    private void add(MouseEvent event) {
        if(calc.add()){
            //righe da eliminare dopo aver inserito la observable
            memory.getItems().remove(0);
            memory.getItems().remove(0);
            memory.getItems().add(0,calc.getTop());
            screen.setText(memory.getItems().get(0).toString());

        }else
            SecondaryController.display("Non sono presnti abbastanza valori!");
    }

    @FXML
    private void subtract(MouseEvent event) {
        if(calc.subtract()){
            //righe da eliminare dopo aver inserito la observable
            memory.getItems().remove(0);
            memory.getItems().remove(0);
            memory.getItems().add(0,calc.getTop()); 
            screen.setText(memory.getItems().get(0).toString());
        }
    }

    @FXML
    private void sqrt(MouseEvent event) {
        if(calc.sqrt()){
            //righe da eliminare dopo aver inserito la observable
            memory.getItems().remove(0);
            memory.getItems().add(0,calc.getTop());
            screen.setText(memory.getItems().get(0).toString());
        }
    }

    @FXML
    private void multiply(MouseEvent event) {
        if(calc.multiply()){
            //righe da eliminare dopo aver inserito la observable
            memory.getItems().remove(0);
            memory.getItems().remove(0);
            memory.getItems().add(0,calc.getTop());
            screen.setText(memory.getItems().get(0).toString());
        }
    }

    @FXML
    private void divide(MouseEvent event) {
        if(calc.divide()){
            //righe da eliminare dopo aver inserito la observable
            memory.getItems().remove(0);
            memory.getItems().remove(0);
            memory.getItems().add(0,calc.getTop());
            screen.setText(memory.getItems().get(0).toString());
        }
    }

    @FXML
    private void invert(MouseEvent event) {
        if(calc.invert()){
            //righe da eliminare dopo aver inserito la observable
            memory.getItems().remove(0);
            memory.getItems().add(0,calc.getTop());
            screen.setText(memory.getItems().get(0).toString());
        }
    }
}
