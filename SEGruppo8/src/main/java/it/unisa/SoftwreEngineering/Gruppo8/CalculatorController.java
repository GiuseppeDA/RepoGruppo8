/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8;

import java.lang.reflect.InvocationTargetException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author mario
 */
public abstract class CalculatorController {
    
    @FXML
    public abstract void insertComplex(ActionEvent event) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
    
    @FXML
    public abstract void add(MouseEvent event);
    
    /*
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
        calc.clear();
    }
    
    @FXML
    private abstract void drop(MouseEvent event){
        if(!calc.drop())
            popupCaller(sizeMsg);
    }
    
    @FXML
    private abstract void dup(MouseEvent event){
        if(!calc.dup())
            popupCaller(sizeMsg);
    }
    
    @FXML
    private abstract void over(MouseEvent event){
        if(!calc.over())
          popupCaller(sizeMsg);
    }
    
    @FXML
    private abstract void swap(MouseEvent event){
        if(!calc.swap())
          popupCaller(sizeMsg);
    }
    

    @FXML
    private abstract void setVar(MouseEvent event) {
        varList.setVar(calc.removeTop(),selectedVarIndices.get(0));
    }

    @FXML
    private abstract void insertVarInStack(MouseEvent event) {
        Variable v = varList.getVar(selectedVarIndices.get(0));       
        calc.insert(v.getValue());
    }

    @FXML
    private abstract void addVar(MouseEvent event) {
        varList.addVar(calc.getTop(), selectedVarIndices.get(0));
    }

    @FXML
    private abstract void subVar(MouseEvent event) {
        varList.subVar(calc.getTop(), selectedVarIndices.get(0));
    }
    
    */
    
}
