/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8.command;

import it.unisa.SoftwreEngineering.Gruppo8.exception.CommandExecuteException;
import com.vm.jcomplex.Complex;
import it.unisa.SoftwreEngineering.Gruppo8.Calculator;
import it.unisa.SoftwreEngineering.Gruppo8.Command;
import it.unisa.SoftwreEngineering.Gruppo8.Variable;
import it.unisa.SoftwreEngineering.Gruppo8.Variables;

/**
 *
 * @author simon
 */
public class VariableSubtracterCommand implements Command{
    private int index;
    private Variables var;
    private Calculator calc;
    private Complex old;
    private Complex pop;

    /**
     *
     * @param index
     * @param var
     * @param calc
     */
    public VariableSubtracterCommand(int index, Variables var, Calculator calc) {
        this.index = index;
        this.var = var;
        this.calc = calc;
    }

    /**
     *Esegue il comando di sottrazione sulla variabile
     * @throws CommandExecuteException se il comando non è eseguibile a causa di un numero non sufficiente di elementi nello stack
     */
    @Override
    public void execute() throws CommandExecuteException {
        Variable v = var.getVar(index);
        old = v.getValue();
        try{
            pop = calc.getTop();
        }catch(IndexOutOfBoundsException ex){
            throw new CommandExecuteException("Comando non eseguibile");
        }
        Complex res = old.subtract(pop);
        var.setVar(res, index);
    }

    /**
     *Annulla il comando di sottrazione sulla variabile eseguito precedentemente
     */
    @Override
    public void undo() {
        var.setVar(old, index);
    }

    /**
     *@return il simbolo di operazione, sottoforma di stringa
     */
    @Override
    public String toString() {
        return "-" + var.indexToChar(index);
    }
}
