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
public class VariableSubtracterCommand implements Command{
    private int index;
    private Variables var;
    private Calculator calc;
    private Complex old;
    private Complex pop;

    public VariableSubtracterCommand(int index, Variables var, Calculator calc) {
        this.index = index;
        this.var = var;
        this.calc = calc;
    }

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

    @Override
    public void undo() {
        var.setVar(old, index);
    }

    @Override
    public String toString() {
        return "-" + var.indexToChar(index);
    }
}
