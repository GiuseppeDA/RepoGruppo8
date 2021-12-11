/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8.command;

import it.unisa.SoftwreEngineering.Gruppo8.Calculator;
import it.unisa.SoftwreEngineering.Gruppo8.Command;
import it.unisa.SoftwreEngineering.Gruppo8.ComplexNumber;
import it.unisa.SoftwreEngineering.Gruppo8.exception.CommandExecuteException;



/**
 *
 * @author giuseppe
 */
public class InserterCommand implements Command{
    private Calculator calc;
    private ComplexNumber compl;

    /**
     *
     * @param compl
     * @param calc
     */
    public InserterCommand(ComplexNumber compl, Calculator calc) {
        this.calc = calc;
        this.compl = compl;
    }
    
    /**
     *Esegue il comando di inserimento
     */
    @Override 
    public void execute() throws CommandExecuteException {
        calc.insert(compl);
    }

    /**
     *Annulla il comando di inserimento eseguito precedentemente
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
        return "(" + compl + ")";
    }
}
