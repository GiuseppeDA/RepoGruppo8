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
public class InverterCommandTest {
    
    public InverterCommandTest() {
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
     * Test of execute method, of class InverterCommand.
     */
    @Test
    public void testExecute() throws CommandExecuteException{
        System.out.println("execute");
        ComplexNumber c1= new ComplexNumber(1,2);
        Calculator calc = new Calculator();
        InverterCommand instance = new InverterCommand(calc);
        
        CommandExecuteException exception = assertThrows(CommandExecuteException.class, () -> instance.execute());
        assertEquals("Comando non eseguibile",exception.getMessage());
        
        calc.insert(c1);
        instance.execute();
        ComplexNumber ris= new ComplexNumber(-1,-2);
        assertEquals(ris,calc.getTop());
    }

    /**
     * Test of undo method, of class InverterCommand.
     */
    @Test
    public void testUndo() throws CommandExecuteException {
        System.out.println("undo");
        ComplexNumber c1= new ComplexNumber(1,2);
        Calculator calc = new Calculator();
        InverterCommand instance = new InverterCommand(calc);
        
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> instance.undo());
        assertEquals("Index 0 out of bounds for length 0",exception.getMessage());
        
        calc.insert(c1);
        instance.execute();
        instance.undo();
        assertEquals(c1,calc.removeTop());
    }

    /**
     * Test of toString method, of class InverterCommand.
     */
    @Test
    public void testToString() {
        System.out.println("toString");    
        Calculator calc = new Calculator();
        InverterCommand instance = new InverterCommand(calc);
        String expResult = "+-";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
