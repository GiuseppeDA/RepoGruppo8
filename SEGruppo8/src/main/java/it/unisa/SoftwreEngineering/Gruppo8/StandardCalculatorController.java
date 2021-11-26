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
import javafx.collections.ListChangeListener;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Screen;

public class StandardCalculatorController implements Initializable{

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
        
        
        memory.getItems().addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change change) {
                if(memory.getItems().size() > 0)
                    screen.setText(memory.getItems().get(0).toString());
            }
        });
        
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
   
        }catch(NumberFormatException exc){
                real.setText("");
                imag.setText("");
                popupCaller(inseMsg);
        }

    }
    
    @FXML
    private void add(MouseEvent event) {
        if(!calc.add())
            popupCaller(sizeMsg);
    }

    @FXML
    private void subtract(MouseEvent event) {
        if(!calc.subtract())
            popupCaller(sizeMsg);
    }

    @FXML
    private void sqrt(MouseEvent event) {
        if(!calc.sqrt())
            popupCaller(sizeMsg);
    }

    @FXML
    private void multiply(MouseEvent event) {
        if(!calc.multiply())
            popupCaller(sizeMsg);
    }

    @FXML
    private void divide(MouseEvent event) {
        try {
            if(!calc.divide())
                popupCaller(sizeMsg);
        } catch (ImpossibleDivisionException e) {
            popupCaller(divideeMsg);
        }
    }

    @FXML
    private void invert(MouseEvent event) {
        if(!calc.invert())
            popupCaller(sizeMsg);
    }
    
    private void popupCaller(String msg){
        PopupController.display(msg);
    }

}
