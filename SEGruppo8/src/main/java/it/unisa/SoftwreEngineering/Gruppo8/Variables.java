/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8;

import it.unisa.SoftwreEngineering.Gruppo8.Variable;
import com.vm.jcomplex.Complex;
import it.unisa.SoftwreEngineering.Gruppo8.ComplexNumber;
import it.unisa.SoftwreEngineering.Gruppo8.ComplexNumber;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.lang.UnsupportedOperationException;
import java.util.regex.Pattern;
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
     *si inserisce un numero complesso in una variabile 
     * @param c il numero complesso da inserire nella variabile
     * @param index l'indice della variabile desiderata
     */
    public void setVar(Complex c,int index){
        Complex a=new ComplexNumber(c.getReal(),c.getImaginary());
        Variable v=variablesList.get(index);
        v.setValue(a);
        variablesList.set(index, v);
    }
    
    /**
     * ritorna una variabile dato il suo indice
     * @param index l'indice della variabile desiderata
     * @return la variabile corrispondente all'indice
     */
    public Variable getVar(int index){
        return variablesList.get(index);
    }

    /**
     *somma un valore a una variabile
     * @param c coplex da aggiungere al valore della variabile
     * @param index indice di riferimento della variabile
     */
    public void addVar(Complex c,int index){
        Complex a=variablesList.get(index).getValue().add(c);
        setVar(a, index);
    }

    /**
     *sottrae un valore a una variabile
     * @param c coplex da sottrarre al valore della variabile
     * @param index indice di riferimento della variabile
     */
    public void subVar(Complex c,int index){
        Complex a=variablesList.get(index).getValue().subtract(c);
        setVar(a, index);  
    }

    /**
     *
     * @return il riferimento alla lista di variabili
     */
    public ObservableList<Variable> getVariablesList() {
        return variablesList;
    }
    
    /**
     *
     * @param a
     * @return l'indice corrispondente al char passato come parametro
     */
    public int charToIndex(char a){
        int index = (int) a;
        
        if( a > 64 && a < 91){
            return a-65;
        }
        return -1;
    }
    
    /**
     *
     * @param a
     * @return il char corrispondente all'indice passato come parametro
     */
    public char indexToChar(int a){
        char c;
        
        if( a >= 0 && a < 26){
            c = (char) (a+65);
            return c;}
        
        return '@';
        
    }
}

    