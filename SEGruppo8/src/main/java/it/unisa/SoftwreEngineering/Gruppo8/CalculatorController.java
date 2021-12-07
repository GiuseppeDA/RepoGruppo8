/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8;

import com.vm.jcomplex.Complex;
import java.lang.reflect.InvocationTargetException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author mario
 */
public abstract class CalculatorController {
    
    protected Calculator calculator;
    
    @FXML
    private ListView<Complex> memory;
    
    @FXML
    public abstract void insertComplex(ActionEvent event) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
    
    @FXML
    public abstract void add(MouseEvent event);
        
    @FXML
    public abstract void subtract(MouseEvent event);
    
    @FXML
    public abstract void sqrt(MouseEvent event);

    @FXML
    public abstract void multiply(MouseEvent event);

    @FXML
    public abstract void divide(MouseEvent event);

    @FXML
    public abstract void invert(MouseEvent event);
    
    @FXML
    public abstract void clear(MouseEvent event);
    
    @FXML
    public abstract void drop(MouseEvent event);
    
    @FXML
    public abstract void dup(MouseEvent event);
    
    @FXML
    public abstract void over(MouseEvent event);
    
    @FXML
    public abstract void swap(MouseEvent event);

    @FXML
    public abstract void setVar(MouseEvent event);

    @FXML
    public abstract void insertVarInStack(MouseEvent event);

    @FXML
    public abstract void addVar(MouseEvent event);

    @FXML
    public abstract void subVar(MouseEvent event);
    
    public ListView<Complex> getMemory() {
        return memory;
    }

    public void setMemory(ObservableList<Complex> memory) {
        this.memory.setItems(memory);
    }

    public Calculator getCalculator() {
        return calculator;
    }

    public void setCalculatorMemory(ObservableList<Complex> memory) {
        this.calculator.setMemory(memory);
    }

}
