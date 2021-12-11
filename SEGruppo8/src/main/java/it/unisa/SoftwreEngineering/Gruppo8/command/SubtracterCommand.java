/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8.command;

import it.unisa.SoftwreEngineering.Gruppo8.exception.CommandExecuteException;
import com.vm.jcomplex.Complex;
import it.unisa.SoftwreEngineering.Gruppo8.Calculator;
import it.unisa.SoftwreEngineering.Gruppo8.Command;

/**
 *
 * @author simon
 */
public class SubtracterCommand implements Command {
    private Calculator calc;
    private Complex pop1;
    private Complex pop2;

    /**
     *
     * @param calc
     */
    public SubtracterCommand(Calculator calc) {
        this.calc = calc;
    }
    
    /**
     *Esegue il comando di sottrazione
     * @throws CommandExecuteException se il comando non è eseguibile a causa di un numero non sufficiente di elementi nello stack
     */
    @Override
    public void execute() throws CommandExecuteException {
        try{
          pop1 = calc.getTop();
          pop2 = calc.getOver();  
        }catch(IndexOutOfBoundsException ex){
            
            throw new CommandExecuteException("Comando non eseguibile");
        }
        
        if(calc.subtract() == false)
            throw new CommandExecuteException("Comando non eseguibile");
    }

    /**
     *Annulla il comando di sottrazione eseguito precedentemente
     */
    @Override
    public void undo(){
        calc.removeTop();
        calc.insert(pop2);
        calc.insert(pop1);
    }

    /**
     *@return il simbolo di operazione, sottoforma di stringa
     */
    @Override
    public String toString() {
        return "-";
    }
    
}
