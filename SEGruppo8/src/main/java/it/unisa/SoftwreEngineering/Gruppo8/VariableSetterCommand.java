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
public class VariableSetterCommand implements Command{
    private int index;
    private Variables var;
    private Calculator calc;
    private Complex pop;
    private Complex old;

    /**
     *
     * @param index
     * @param var
     * @param calc
     */
    public VariableSetterCommand(int index, Variables var, Calculator calc) {
        this.index = index;
        this.var = var;
        this.calc = calc;
    }

    /**
     *Esegue il comando di inserimento nella variabile da stack
     * @throws CommandExecuteException se il comando non è eseguibile a causa di un numero non sufficiente di elementi nello stack
     */
    @Override
    public void execute() throws CommandExecuteException {
        try{
            pop = calc.removeTop();
            Variable v = var.getVar(index);
            old = v.getValue();
        }catch(IndexOutOfBoundsException ex){
            throw new CommandExecuteException("Comando non eseguibile");
        }
        
        var.setVar(pop, index);
    }

    /**
     *Annulla il comando di inserimento nella variabile da stack, eseguito precedentemente
     */
    @Override
    public void undo() {
        var.setVar(old, index);
        calc.insert(pop);
    }

    /**
     *@return il simbolo di operazione, sottoforma di stringa
     */
    @Override
    public String toString() {
        return ">" + var.indexToChar(index);
    }
    
}
