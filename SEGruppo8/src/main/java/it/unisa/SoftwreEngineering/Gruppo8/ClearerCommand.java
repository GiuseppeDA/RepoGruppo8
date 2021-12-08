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

    /**
     *
     * @param calc
     */
    public ClearerCommand(Calculator calc) {
        this.calc = calc;
        values= FXCollections.observableArrayList();
    }
    
    /**
     *Esegue il comando di clear
     *
     */
    @Override
    public void execute() throws CommandExecuteException {
        values.addAll(calc.getMemory());
        calc.clear();
        
    }

    /**
     *Annulla il comando di clear eseguito precedentemente
     */
    @Override
    public void undo() {
        ListIterator<Complex> li = values.listIterator(values.size());
        while(li.hasPrevious()){
            calc.insert(li.previous());
        }
    }
    
    /**
     *@return il simbolo di operazione, sottoforma di stringa
     */
    @Override
    public String toString() {
        return "clear";
    }
    
}
