/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;


/**
 *
 * @author 39324
 */
public class Functions {
    ObservableMap<String,Function> map;

    public Functions() {
        map=FXCollections.emptyObservableMap();
    }


    public ObservableMap<String, Function> getMap() {
        return map;
    }
    public Function getFunction(String name){
       return map.get(name);
    }
    public void setFunction(String name,Function f){
        map.put(name, f);
    }
    public void addFunction(String name,Function f) throws FunctionDuplicateException{
        if(map.putIfAbsent(name, f)==null)
            throw new FunctionDuplicateException();
    }
    public boolean save(String filename){
        try(BufferedWriter writer=new BufferedWriter(new FileWriter(filename))) {
            for(String name:map.keySet()){
                writer.write( name +" "+ map.get(name).toString()+"\n");
            }     
        } catch (IOException ex) {
            return false;
        }
        return true;
    }
    public boolean restore(String filename){
        try(Scanner i = new Scanner(new BufferedReader(new FileReader(filename)))) {
            ObservableMap<String,Function> temp=FXCollections.emptyObservableMap();
            i.useDelimiter("\\s|\\n");
            while(i.hasNext()){
                String name=i.next();
                
            }
            
            } catch (FileNotFoundException ex) {     
            return false;
        }
         return true;
        }
        
}
