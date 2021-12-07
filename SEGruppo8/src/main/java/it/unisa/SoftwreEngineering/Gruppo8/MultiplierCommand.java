/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8;

import com.vm.jcomplex.Complex;

/**
 *
 * @author simon
 */
public class MultiplierCommand implements Command{
    private Calculator calc;
    private Complex pop1;
    private Complex pop2;

    public MultiplierCommand(Calculator calc) {
        this.calc = calc;
    }
    
    @Override
    public void execute() throws CommandExecuteException {
        try{
          pop1 = calc.getTop();
          pop2 = calc.getOver();  
        }catch(IndexOutOfBoundsException ex){
            
            throw new CommandExecuteException("Comando non eseguibile");
        }
        
        if(calc.multiply() == false)
            throw new CommandExecuteException("Comando non eseguibile");
    }

    @Override
    public void undo() throws CommandExecuteException {
        try{
            calc.removeTop();}
        catch(IndexOutOfBoundsException ex){
            throw new CommandExecuteException("Comando non eseguibile");
        }
        calc.insert(pop2);
        calc.insert(pop1);
    }

    @Override
    public String toString() {
        return "*";
    }
    
}
