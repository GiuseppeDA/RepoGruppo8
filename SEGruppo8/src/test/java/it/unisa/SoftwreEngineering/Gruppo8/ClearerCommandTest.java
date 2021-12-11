/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8;

import it.unisa.SoftwreEngineering.Gruppo8.command.ClearerCommand;
import it.unisa.SoftwreEngineering.Gruppo8.exception.CommandExecuteException;
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
public class ClearerCommandTest {
    
    public ClearerCommandTest() {
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
     * Test of execute method, of class ClearerCommand.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        ComplexNumber c1= new ComplexNumber(1,2);
        Calculator calc = new Calculator();
        ClearerCommand instance = new ClearerCommand(calc);
        
        
        calc.insert(c1);
        instance.execute();
        IndexOutOfBoundsException exception2 = assertThrows(IndexOutOfBoundsException.class, () -> calc.getTop());
        assertEquals("Index 0 out of bounds for length 0",exception2.getMessage());
    }

    /**
     * Test of undo method, of class ClearerCommand.
     */
    @Test
    public void testUndo() throws CommandExecuteException {
        System.out.println("undo");
        ComplexNumber c1= new ComplexNumber(1,2);
        Calculator calc = new Calculator();
        ClearerCommand instance = new ClearerCommand(calc);

        
        calc.insert(c1);
        instance.execute();
        instance.undo();
        assertEquals(c1,calc.removeTop());
    }

    /**
     * Test of toString method, of class ClearerCommand.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Calculator calc = new Calculator();
        ClearerCommand instance = new ClearerCommand(calc);
        String expResult = "clear";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
