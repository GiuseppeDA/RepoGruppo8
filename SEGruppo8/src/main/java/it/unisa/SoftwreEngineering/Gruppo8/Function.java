/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8;
import it.unisa.SoftwreEngineering.Gruppo8.exception.CommandExecuteException;
import java.util.ArrayList;
/**
 *
 * @author 39324
 */
public class Function {
  private ArrayList<Command> commandList;

    
    public Function() {
        commandList=new ArrayList<Command>();
    }

    /**
     *esegue in ordine i comandi della funzione
     */
    public void run(){
        int i;
        for(i=0;i<commandList.size();i++){
            try{
            commandList.get(i).execute();
            }catch(CommandExecuteException e){
                for(int j=i-1;j>=0;j--){
                     commandList.get(j).undo();
                }
              break;
            }
        }   
    }

    /**
     *aggiunge un comanda alla lista di comandi della funzione
     * @param c il comando da aggiungere
     */
    public void add(Command c){
        commandList.add(c);
    }

    /**
     *
     * @return la lista di comandi della funzione
     */
    public ArrayList<Command> getCommandList() {
        return commandList;
    }
    
    @Override
    public String toString() {
        String commands=new String();
        for(Command c:commandList){
            commands=commands+c.toString()+" ";  
        }
        return commands;
    }
    
}
