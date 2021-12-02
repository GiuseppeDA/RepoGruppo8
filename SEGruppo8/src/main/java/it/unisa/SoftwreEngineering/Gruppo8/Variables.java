/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8;

import com.vm.jcomplex.Complex;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.lang.UnsupportedOperationException;
/**
 *
 * @author 39324
 */
public class Variables {
    private ObservableList<Variable> variablesList;

    /**
     *
     */
    public Variables() {
         variablesList= FXCollections.observableArrayList();
         Complex c;
         for(int i=0;i<26;i++){
             c=new ComplexNumber(0,0);
             Variable v=new Variable(String.valueOf(Character.toChars(i+65)),c);
             variablesList.add(i, v);
         }
    }
    
    /**
     *
     * @param c
     * @param index
     */
    public void setVar(Complex c,int index){
        Complex a=new ComplexNumber(c.getReal(),c.getImaginary());
        Variable v=variablesList.get(index);
        v.setValue(a);
        variablesList.set(index, v);
    }
    
    /**
     *
     * @param index
     * @return
     */
    public Variable getVar(int index){
        return variablesList.get(index);
    }

    /**
     *
     * @param c
     * @param index
     */
    public void addVar(Complex c,int index){
        Complex a=variablesList.get(index).getValue().add(c);
        Variable v=variablesList.get(index);
        v.setValue(a);
        variablesList.set(index, v);
    }

    /**
     *
     * @param c
     * @param index
     */
    public void subVar(Complex c,int index){
        Complex a=variablesList.get(index).getValue().subtract(c);
        Variable v=variablesList.get(index);
        v.setValue(a);
        variablesList.set(index, v);  
    }

    /**
     *
     * @return
     */
    public ObservableList<Variable> getVariablesList() {
        return variablesList;
    }
    
}

    