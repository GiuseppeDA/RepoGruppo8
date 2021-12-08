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
     *
     * @throws CommandExecuteException
     */
    @Override
    public void execute() throws CommandExecuteException {
        if(calc.dup()== false)
            throw new CommandExecuteException("Comando non eseguibile");
    }

    /**
     *
     */
    @Override
    public void undo(){
        calc.removeTop();
    }

    @Override
    public String toString() {
        return "dup";
    }
    
}
