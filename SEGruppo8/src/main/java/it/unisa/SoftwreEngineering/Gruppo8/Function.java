/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8;
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
}
