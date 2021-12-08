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
public class DividerCommand implements Command{
    private Calculator calc;
    private Complex pop1;
    private Complex pop2;

    /**
     *
     * @param calc
     */
    public DividerCommand(Calculator calc) {
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
          pop2 = calc.getOver();  
        }catch(IndexOutOfBoundsException ex){
            
            throw new CommandExecuteException("Comando non eseguibile");
        }
        
        try {
            if(calc.divide() == false)
                throw new CommandExecuteException("Comando non eseguibile");
        } catch (ImpossibleDivisionException ex) {
            throw new CommandExecuteException("Divisione per 0 non consentita");
        }
    }

    /**
     *
     */
    @Override
    public void undo(){
        calc.removeTop();
        calc.insert(pop2);
        calc.insert(pop1);
    }

    @Override
    public String toString() {
        return "/";
    }
    
}
