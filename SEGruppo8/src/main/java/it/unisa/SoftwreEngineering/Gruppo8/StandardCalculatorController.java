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
    
    private Calculator calc = new Calculator();
    
    private String sizeMsg="Operandi non sufficienti!";
    
    private String inseMsg="Inserisci solo numeri e relativo segno!";
    
    private String divideeMsg="impossibile dividere per 0!"; 
    
    @FXML
    private ListView<Complex> memory;
    @FXML
    private TextField input;
    @FXML
    private TextField imag;
    @FXML
    private Text screen;
    
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
            if(input.getText() == null || input.getText().trim().isEmpty())
                realNum = 0.0;
            else
                realNum = Double.parseDouble(input.getText());
            
            if(imag.getText() == null || imag.getText().trim().isEmpty())
                imagNum = 0.0;
            else
                imagNum = Double.parseDouble(imag.getText());
                 
            calc.insert(realNum, imagNum);
            
            input.setText("");
            imag.setText("");
   
        }catch(NumberFormatException exc){
                input.setText("");
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
    
    @FXML
    private void clear(MouseEvent event){
        //if(!calc.clear())
          //  popupCaller(sizeMsg);
    }
    
    @FXML
    private void drop(MouseEvent event){
        //if(!calc.drop())
          //  popupCaller(sizeMsg);
    }
    
    @FXML
    private void dup(MouseEvent event){
        //if(!calc.dup())
          //  popupCaller(sizeMsg);
    }
    
    @FXML
    private void over(MouseEvent event){
        //if(!calc.over())
          //  popupCaller(sizeMsg);
    }
    
    @FXML
    private void swap(MouseEvent event){
        //if(!calc.swap())
          //  popupCaller(sizeMsg);
    }
    
    private void popupCaller(String msg){
        PopupController.display(msg);
    }

}
