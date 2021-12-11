/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8;

import it.unisa.SoftwreEngineering.Gruppo8.exception.CommandExecuteException;
import it.unisa.SoftwreEngineering.Gruppo8.command.VariableGetterCommand;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author simon
 */
public class VariableGetterCommandTest {
    
    public VariableGetterCommandTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of execute method, of class VariableGetterCommand.
     */
    @Test
    public void testExecute() throws CommandExecuteException  {
        System.out.println("execute");
        ComplexNumber c1= new ComplexNumber(1,2);
        Variables var = new Variables();
        Calculator calc = new Calculator();
        int index=0;
        var.setVar(c1, index);
        
        VariableGetterCommand instance = new VariableGetterCommand(index,var,calc);
        instance.execute();
        assertEquals(c1,calc.removeTop());
    }

    /**
     * Test of undo method, of class VariableGetterCommand.
     */
    @Test
    public void testUndo() throws CommandExecuteException {
        System.out.println("undo");
        ComplexNumber c1= new ComplexNumber(1,2);
        ComplexNumber c2= new ComplexNumber(2,1);
        Variables var = new Variables();
        Calculator calc = new Calculator();
        int index=0;     
        VariableGetterCommand instance = new VariableGetterCommand(index,var,calc);
        
        calc.insert(c1);
        var.setVar(c2, index);
        
        instance.execute();
        instance.undo();
        
        assertEquals(c1,calc.removeTop());
    }

    /**
     * Test of toString method, of class VariableGetterCommand.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ComplexNumber c1= new ComplexNumber(1,2);
        Variables var = new Variables();
        Calculator calc = new Calculator();
        int index=0;
        VariableGetterCommand instance = new VariableGetterCommand(index,var,calc);
        String expResult = "<" + "A";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
