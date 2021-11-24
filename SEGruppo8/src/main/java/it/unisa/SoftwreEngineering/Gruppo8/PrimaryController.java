package it.unisa.SoftwreEngineering.Gruppo8;

import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import com.vm.jcomplex.Complex;

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
    private void insertComplex(MouseEvent event) {
        Double realNum;
        Double imagNum;
        
        try {
            if(real.getText() == null || real.getText().trim().isEmpty())
                realNum = 0;
            else
                realNum = Double.parseDouble(real.getText());
            
            if(imag.getText() == null || imag.getText().trim().isEmpty())
                imagNum = 0;
            else
                imagNum = Double.parseDouble(imag.getText());
            
            calc.insert(realNum, imagNum);

            //righe da eliminare dopo aver inserito la observable
            memory.getItems().add(calc.getTop());
        }catch(NumberFormatException exc){
                System.out.println("Mariojfhsdujkhfjk");
        }
        
        
        
    }
    
    @FXML
    private void add(MouseEvent event) {
    }

    @FXML
    private void subtract(MouseEvent event) {
    }

    @FXML
    private void sqrt(MouseEvent event) {
    }

    @FXML
    private void multiply(MouseEvent event) {
    }

    @FXML
    private void divide(MouseEvent event) {
    }

    @FXML
    private void invert(MouseEvent event) {
    }
}
