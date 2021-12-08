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

    /**
     * restituisce una funzione daato il nome
     * @param name nome della funzione
     * @return la funzione corrispondente al nome dato
     */
    public Function getFunction(String name){
       return map.get(name);
    }

    /**
     * sovrascrive o aggiunge una funzione
     * @param name nome della funzione da settare
     * @param f funzione da settare
     */
    public void setFunction(String name,Function f){
        map.put(name, f);
    }
     /**
     * rimuove una funzione dato il nome
     * @param name nome della funzione da rimuovere
     */
    public void removeFunction(String name) throws NotExistingFunctionException{
       if(map.remove(name)==null)
           throw new NotExistingFunctionException();
    }

    /**
     * aggiunge una funzione
     * @param name nome della funzione da aggiungere
     * @param f funzione da aggiungere
     * @throws FunctionDuplicateException se il nome della funzione è già presente
     */
    public void addFunction(String name,Function f) throws FunctionDuplicateException{
        if(map.putIfAbsent(name, f)!=null)
            throw new FunctionDuplicateException();
    }

    /**
     *salva le funzioni su file
     * @param filename il nome del file su cui slavare
     * @return true se va a buon fine false altrimenti
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
     *legge e setta le funzioni da file
     * @param filename il nome del file da cui leggere
     * @return true se va a buon fine false altrimenti
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
     *inserisce una funzione partendo da una stringa di comandi
     * @param name il nome della funzione di aggiungere
     * @param commandsi comandi della funzione sottoforma di stringa
     * @throws InvalidCommandException se i comandi non sono validi
     * @throws FunctionDuplicateException se il nome è già presente
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
    
     public void stringToFunctionReplace (String name,String commands) throws InvalidCommandException{
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

            setFunction(name,f);

                 
        
    }
        
}
