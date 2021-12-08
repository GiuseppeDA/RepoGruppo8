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
public class InverterCommand implements Command{
    private Calculator calc;
    private Complex pop1;

    /**
     *
     * @param calc
     */
    public InverterCommand(Calculator calc) {
        this.calc = calc;
    }
    
    /**
     *Esegue il comando di inversione
     * @throws CommandExecuteException se il comando non è eseguibile a causa di un numero non sufficiente di elementi nello stack
     */
    @Override
    public void execute() throws CommandExecuteException {
        try{
          pop1 = calc.getTop(); 
        }catch(IndexOutOfBoundsException ex){
            
            throw new CommandExecuteException("Comando non eseguibile");
        }
        
        if(calc.invert() == false)
            throw new CommandExecuteException("Comando non eseguibile");
    }

    /**
     *Annulla il comando di inversione eseguito precedentemente
     */
    @Override
    public void undo(){
        calc.removeTop();
        calc.insert(pop1);
    }

    /**
     *@return il simbolo di operazione, sottoforma di stringa
     */
    @Override
    public String toString() {
        return "+-";
    }
}
