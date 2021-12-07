/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8;

import com.vm.jcomplex.Complex;
import java.util.ListIterator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author simon
 */
public class ClearerCommand implements Command{
    private Calculator calc;
    private ObservableList<Complex> values;

    public ClearerCommand(Calculator calc) {
        this.calc = calc;
        values= FXCollections.observableArrayList();
    }
    
    @Override
    public void execute() throws CommandExecuteException {
        values.addAll(calc.getMemory());
        calc.clear();
        
    }

    @Override
    public void undo() {
        ListIterator<Complex> li = values.listIterator(values.size());
        while(li.hasPrevious()){
            calc.insert(li.previous());
        }
    }
    
    @Override
    public String toString() {
        return "clear";
    }
    
}
