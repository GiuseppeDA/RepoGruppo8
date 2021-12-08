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

    /**
     *
     * @param calc
     * @param var
     */
    public Functions(Calculator calc, Variables var) {
        map=FXCollections.observableHashMap();
        this.calc = calc;
        this.var = var;
    }

    /**
     *
     * @return
     */
    public ObservableMap<String, Function> getMap() {
        return map;
    }

    /**
     *
     * @param name
     * @return
     */
    public Function getFunction(String name){
       return map.get(name);
    }

    /**
     *
     * @param name
     * @param f
     */
    public void setFunction(String name,Function f){
        map.put(name, f);
    }

    /**
     *
     * @param name
     * @param f
     * @throws FunctionDuplicateException
     */
    public void addFunction(String name,Function f) throws FunctionDuplicateException{
        if(map.putIfAbsent(name, f)!=null)
            throw new FunctionDuplicateException();
    }

    /**
     *
     * @param filename
     * @return
     */
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

    /**
     *
     * @param filename
     * @return
     */
    public boolean restore(String filename){
        Parser p=new Parser(calc,var);
        Command c;
        try(Scanner i = new Scanner(new BufferedReader(new FileReader(filename)))) {
            ObservableMap<String,Function> temp=FXCollections.emptyObservableMap();
            while(i.hasNextLine()){
               
                StringTokenizer str0= new StringTokenizer(i.nextLine(),"()",true);
                String s="";
                while(str0.hasMoreTokens()){
                s=s+str0.nextToken("(");
                if(str0.hasMoreTokens())
                  s=s+str0.nextToken(")").replaceAll("\\s+","");
                }
                StringTokenizer str= new StringTokenizer(s," ");
                String name=str.nextToken();
                Function f=new Function();     
                while(str.hasMoreTokens()){
                    String token=str.nextToken(" ");
                    if(token.startsWith("(")){;
                       token=token.replace("(", "");
                       token=token.replace(")", "");
                    }
                    c=p.parse(token);
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

    /**
     *
     * @param name
     * @param commands
     * @throws InvalidCommandException
     * @throws FunctionDuplicateException
     */
    public void stringToFunction(String name,String commands) throws InvalidCommandException, FunctionDuplicateException{
        String s0 = commands.replaceAll("\\s+"," ");;
        Parser p=new Parser(calc,var);
        Command c;
        StringTokenizer str0= new StringTokenizer(s0,"()",true);
        String s="";
        while(str0.hasMoreTokens()){
            s=s+str0.nextToken("(");
            if(str0.hasMoreTokens())
                s=s+str0.nextToken(")").replaceAll("\\s+","");
            
        }
          
         StringTokenizer str= new StringTokenizer(s," ");
                Function f=new Function();     
                while(str.hasMoreTokens()){
                    String token=str.nextToken(" ");
                    if(token.startsWith("(")){;
                       token=token.replace("(", "");
                       token=token.replace(")", "");
                    }
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

            addFunction(name,f);

                 
        
    }
        
}
