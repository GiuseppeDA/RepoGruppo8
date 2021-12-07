/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8;



/**
 *
 * @author giuseppe
 */
public class InsertCommand implements Command{
    private Calculator calc;
    private ComplexNumber compl;

    public InsertCommand(Calculator calc, ComplexNumber compl) {
        this.calc = calc;
        this.compl = compl;
    }
    
    @Override
    public void execute() throws CommandExecuteException {
        calc.insert(compl);
    }

    @Override
    public void undo(){
        calc.removeTop();
    }

    @Override
    public String toString() {
        return "(" + compl + ")";
    }
}
