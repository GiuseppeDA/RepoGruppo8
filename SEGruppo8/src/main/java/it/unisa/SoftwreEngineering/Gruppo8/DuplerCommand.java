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
public class DuplerCommand implements Command{
    private Calculator calc;

    /**
     *
     * @param calc
     */
    public DuplerCommand(Calculator calc) {
        this.calc = calc;
    }
    
    /**
     *Esegue il comando di duplicazione
     * @throws CommandExecuteException se il comando non è eseguibile a causa di un numero non sufficiente di elementi nello stack
     */
    @Override
    public void execute() throws CommandExecuteException {
        if(calc.dup()== false)
            throw new CommandExecuteException("Comando non eseguibile");
    }

    /**
     *Annulla il comando di duplicazione eseguito precedentemente
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
        return "dup";
    }
    
}
