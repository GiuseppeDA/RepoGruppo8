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
public class VariableGetterCommand implements Command{
    private int index;
    private Variables var;
    private Calculator calc;
    private Complex value;

    /**
     *
     * @param index
     * @param var
     * @param calc
     */
    public VariableGetterCommand(int index, Variables var, Calculator calc) {
        this.index = index;
        this.var = var;
        this.calc = calc;
    }

    /**
     *Esegue il comando di inserimento nello stack da variabile
     * @throws CommandExecuteException se il comando non è eseguibile a causa di un numero non sufficiente di elementi nello stack
     */
    @Override
    public void execute() throws CommandExecuteException {
        Variable v = var.getVar(index);
        value = v.getValue();
        calc.insert(value);
    }

    /**
     *Annulla il comando di inserimento nello stack da variabile, eseguito precedentemente
     */
    @Override
    public void undo() {
        calc.removeTop();
    }

    /**
     *@return il simbolo di operazione, sottoforma di stringa
     */
    @Override
    public String toString() {
        return "<" + var.indexToChar(index);
    }
}
