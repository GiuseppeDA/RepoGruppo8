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
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;


/**
 *
 * @author 39324
 */
public class Functions {
    ObservableMap<String,Function> map;
    Calculator calc;
    Variables var;

    public Functions(Calculator calc, Variables var) {
        map=FXCollections.observableHashMap();
        this.calc = calc;
        this.var = var;
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
        Parser p=new Parser(calc,var);
        Command c;
        try(Scanner i = new Scanner(new BufferedReader(new FileReader(filename)))) {
            ObservableMap<String,Function> temp=FXCollections.emptyObservableMap();
            while(i.hasNextLine()){
                StringTokenizer str= new StringTokenizer(i.nextLine(),"()\\s");
                String name=str.nextToken();
                Function f=new Function();     
                while(str.hasMoreTokens()){
                    c=p.parse(str.nextToken());
                    if(c!=null)     
                      f.add(c);
                    else
                        return false;
                }
                setFunction(name,f);
            }
            
            } catch (FileNotFoundException ex) {     
            return false;
        }
         return true;
        }
    
    private ArrayList<Command> functionToCommands(String name){
        return map.get(name).getCommandList();       
    }
    public void stringToFunction(String name,String commands) throws InvalidCommandException{
        String s = commands.replaceAll("\\s+"," ");
        Parser p=new Parser(calc,var);
        Command c;
        StringTokenizer str= new StringTokenizer(s,"()\\s");
                Function f=new Function();
                while(str.hasMoreTokens()){
                    String token=str.nextToken();
                    c=p.parse(token);
                    if(c!=null)     
                      f.add(c);
                    else if(map.containsKey(token))
                        for(Command com:functionToCommands(token)){
                            f.add(com);
                        }
                    else
                        throw new InvalidCommandException();
                }
                setFunction(name,f);
                 
        
    }
        
}
