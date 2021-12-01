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
    }
    
    public boolean setVar(Complex c,int index){
        throw new UnsupportedOperationException();   
    }
    public Complex getVar(int index){
        throw new UnsupportedOperationException();   
    }
    public boolean addVar(Complex c,int intex){
        throw new UnsupportedOperationException();   
    }
    public boolean subVar(Complex c,int index){
        throw new UnsupportedOperationException();   
    }
}

