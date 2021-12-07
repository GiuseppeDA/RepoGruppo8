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
        for(int i=0;i<commandList.size();i++){
            commandList.get(i).execute();
        }
    }
}
