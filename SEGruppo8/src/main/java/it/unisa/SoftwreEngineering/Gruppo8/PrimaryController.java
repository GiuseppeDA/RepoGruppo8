package it.unisa.SoftwreEngineering.Gruppo8;

import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import com.vm.jcomplex.Complex;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Screen;

public class PrimaryController implements Initializable{

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
    private Text screen;
    
    private String sizeMsg="Operandi non sufficienti!";
    
    private String inseMsg="Inserisci solo numeri e relativo segno!";
    
    private String divideeMsg="impossibile dividere per 0!";
    
    //Initializing
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        memory.setItems(calc.getMemory());
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
            
            real.setText("");
            imag.setText("");
            
            screen.setText(memory.getItems().get(0).toString());
        }catch(NumberFormatException exc){
                SecondaryController.display(inseMsg);
        }

    }
    
    @FXML
    private void add(MouseEvent event) {
        if(calc.add()){
            screen.setText(memory.getItems().get(0).toString());

        }else
            SecondaryController.display(sizeMsg);
    }

    @FXML
    private void subtract(MouseEvent event) {
        if(calc.subtract()){
            screen.setText(memory.getItems().get(0).toString());
        }else
            SecondaryController.display(sizeMsg);
    }

    @FXML
    private void sqrt(MouseEvent event) {
        if(calc.sqrt()){
            screen.setText(memory.getItems().get(0).toString());
        }else
            SecondaryController.display(sizeMsg);
    }

    @FXML
    private void multiply(MouseEvent event) {
        if(calc.multiply()){
            screen.setText(memory.getItems().get(0).toString());
        }else
            SecondaryController.display(sizeMsg);
    }

    @FXML
    private void divide(MouseEvent event) {
        try {
            if(calc.divide()){
            screen.setText(memory.getItems().get(0).toString());
            }else
                SecondaryController.display(sizeMsg);
        } catch (ImpossibleDivisionException e) {
            SecondaryController.display(divideeMsg);
        }
    }

    @FXML
    private void invert(MouseEvent event) {
        if(calc.invert()){
            screen.setText(memory.getItems().get(0).toString());
        }else
            SecondaryController.display(sizeMsg);
    }

    
}
