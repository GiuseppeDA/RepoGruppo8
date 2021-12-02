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

    public Variables() {
         variablesList= FXCollections.observableArrayList();
         for(int i=0;i<26;i++){
             Complex c=new ComplexNumber(0,0);
             Variable v=new Variable(String.valueOf(Character.toChars(+65)),c);
             variablesList.add(i, v);
         }
    }
    
    public void setVar(Complex c,int index){
        Complex a=new ComplexNumber(c.getReal(),c.getImaginary());
        variablesList.get(index).setValue(a);
    }
    
    public Variable getVar(int index){
        return variablesList.get(index);
    }
    public void addVar(Complex c,int index){
        Complex a=variablesList.get(index).getValue().add(c);
        variablesList.get(index).setValue(a);
    }
    public void subVar(Complex c,int index){
        Complex a=variablesList.get(index).getValue().subtract(c);
        variablesList.get(index).setValue(a);  
    }

    public ObservableList<Variable> getVariablesList() {
        return variablesList;
    }
    
}

    