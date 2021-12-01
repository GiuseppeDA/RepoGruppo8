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
    private ObservableList<Complex> variablesList;

    public Variables() {
         variablesList= FXCollections.observableArrayList();
         variablesList.setAll(Complex.ZERO);
    }
    
    public void setVar(Complex c,int index){
        Complex a=new ComplexNumber(c.getReal(),c.getImaginary());
        variablesList.set(index, a);
    }
    public Complex getVar(int index){
        return variablesList.get(index);
    }
    public void addVar(Complex c,int index){
        Complex a=c.add(variablesList.get(index));
        setVar(a,index);
    }
    public void subVar(Complex c,int index){
        throw new UnsupportedOperationException();   
    }
}

    