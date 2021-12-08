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
public class SqrterCommand implements Command{
    private Calculator calc;
    private Complex pop1;

    /**
     *
     * @param calc
     */
    public SqrterCommand(Calculator calc) {
        this.calc = calc;
    }
    
    /**
     *
     * @throws CommandExecuteException
     */
    @Override
    public void execute() throws CommandExecuteException {
        try{
          pop1 = calc.getTop();
        }catch(IndexOutOfBoundsException ex){
            
            throw new CommandExecuteException("Comando non eseguibile");
        }
        
        if(calc.sqrt() == false)
            throw new CommandExecuteException("Comando non eseguibile");
    }

    /**
     *
     */
    @Override
    public void undo(){
        calc.removeTop();
        calc.insert(pop1);
    }

    @Override
    public String toString() {
        return "sqrt";
    }
}
