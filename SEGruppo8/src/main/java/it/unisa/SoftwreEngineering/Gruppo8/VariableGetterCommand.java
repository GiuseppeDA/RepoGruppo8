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

    public VariableGetterCommand(int index, Variables var, Calculator calc) {
        this.index = index;
        this.var = var;
        this.calc = calc;
    }

    @Override
    public void execute() throws CommandExecuteException {
        Variable v = var.getVar(index);
        value = v.getValue();
        calc.insert(value);
    }

    @Override
    public void undo() {
        calc.removeTop();
    }

    @Override
    public String toString() {
        return "<" + var.indexToChar(index);
    }
}
