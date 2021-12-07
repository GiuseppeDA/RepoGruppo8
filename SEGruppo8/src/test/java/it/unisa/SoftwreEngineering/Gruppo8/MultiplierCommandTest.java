/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8;

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
public class MultiplierCommandTest {
    
    public MultiplierCommandTest() {
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
     * Test of execute method, of class MultiplierCommand.
     */
    @Test
    public void testExecute() throws CommandExecuteException {
        System.out.println("execute");
        
        ComplexNumber c1= new ComplexNumber(1,2);
        Calculator calc = new Calculator();
        
        calc.insert(c1);
        MultiplierCommand instance = new MultiplierCommand(calc);
        
        CommandExecuteException exception = assertThrows(CommandExecuteException.class, () -> instance.execute());
        assertEquals("Comando non eseguibile",exception.getMessage());
        
        ComplexNumber c2= new ComplexNumber(2,1); 
        calc.insert(c2);
        instance.execute();
        ComplexNumber ris= new ComplexNumber(0,5);
        assertEquals(ris,calc.getTop());
    }

    /**
     * Test of undo method, of class MultiplierCommand.
     */
    @Test
    public void testUndo() throws CommandExecuteException {
        System.out.println("undo");
        
        ComplexNumber c1= new ComplexNumber(1,2);
        ComplexNumber c2= new ComplexNumber(2,1);
        Calculator calc = new Calculator();
        MultiplierCommand instance = new MultiplierCommand(calc);
        
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> instance.undo());
        assertEquals("Index 0 out of bounds for length 0",exception.getMessage());
        
        calc.insert(c1);
        calc.insert(c2);
        instance.execute();
        instance.undo();
        assertEquals(c2,calc.removeTop());
        assertEquals(c1,calc.removeTop());
    }

    /**
     * Test of toString method, of class MultiplierCommand.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Calculator calc = new Calculator();
        MultiplierCommand instance = new MultiplierCommand(calc);
        String expResult = "*";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
