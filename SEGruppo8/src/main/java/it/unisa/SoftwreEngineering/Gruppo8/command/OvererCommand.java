/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8.command;

import it.unisa.SoftwreEngineering.Gruppo8.exception.CommandExecuteException;
import it.unisa.SoftwreEngineering.Gruppo8.Calculator;
import it.unisa.SoftwreEngineering.Gruppo8.Command;

/**
 *
 * @author simon
 */
public class OvererCommand implements Command{
    private Calculator calc;

    /**
     *
     * @param calc
     */
    public OvererCommand(Calculator calc) {
        this.calc = calc;
    }
    
    /**
     *Esegue il comando di over
     * @throws CommandExecuteException se il comando non è eseguibile a causa di un numero non sufficiente di elementi nello stack
     */
    @Override
    public void execute() throws CommandExecuteException {
        if(calc.over()== false)
            throw new CommandExecuteException("Comando non eseguibile");
    }

    /**
     *Annulla il comando di over eseguito precedentemente
     */
    @Override
    public void undo(){
        calc.removeTop();
    }

    /**
     *@return il simbolo di operazione, sottoforma di stringa
     */
    @Override
    public String toString() {
        return "over";
    }
    
    
}
