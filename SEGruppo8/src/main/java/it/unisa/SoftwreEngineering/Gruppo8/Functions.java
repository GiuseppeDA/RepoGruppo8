/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
    public void addFunction(String name,Function f){
        map.putIfAbsent(name, f);
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
}
