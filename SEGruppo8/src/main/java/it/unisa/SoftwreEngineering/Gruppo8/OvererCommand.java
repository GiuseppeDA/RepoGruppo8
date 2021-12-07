/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8;

/**
 *
 * @author simon
 */
public class OvererCommand implements Command{
    private Calculator calc;

    public OvererCommand(Calculator calc) {
        this.calc = calc;
    }
    
    @Override
    public void execute() throws CommandExecuteException {
        if(calc.over()== false)
            throw new CommandExecuteException("Comando non eseguibile");
    }

    @Override
    public void undo(){
        calc.removeTop();
    }

    @Override
    public String toString() {
        return "over";
    }
    
    
}
