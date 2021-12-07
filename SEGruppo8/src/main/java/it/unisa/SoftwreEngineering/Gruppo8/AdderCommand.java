/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8;

import com.vm.jcomplex.Complex;

/**
 *
 * @author giuseppe
 */
public class AdderCommand implements Command{
    private Calculator calc;
    private Complex pop1;
    private Complex pop2;

    public AdderCommand(Calculator calc) {
        this.calc = calc;
    }
    
    @Override
    public void execute() throws CommandExecuteException {
        if(calc.add() == false)
            throw new CommandExecuteException();
    }

    @Override
    public void undo() {
        
    }

    @Override
    public String toString() {
        return "+";
    }
    
    
    
}
