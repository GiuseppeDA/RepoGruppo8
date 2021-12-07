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
public class AdderCommandTest {
    
    public AdderCommandTest() {
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
     * Test of execute method, of class AdderCommand.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        ComplexNumber c1= new ComplexNumber(1,2);
        Calculator calc = new Calculator();
        
        calc.insert(c1);
        AdderCommand instance = new AdderCommand(calc);
        
        CommandExecuteException exception = assertThrows(CommandExecuteException.class, () -> instance.execute());
        assertEquals("Comando non eseguibile",exception.getMessage());
        
        ComplexNumber c2= new ComplexNumber(2,1); 
        calc.insert(c2);
        instance.execute();
        ComplexNumber ris= new ComplexNumber(3,3);
        assertEquals(ris,calc.getTop());
    }

    /**
     * Test of undo method, of class AdderCommand.
     */
    @Test
    public void testUndo() {
        System.out.println("undo");
        AdderCommand instance = null;
        instance.undo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class AdderCommand.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Calculator calc = new Calculator();
        AdderCommand instance = new AdderCommand(calc);
        String expResult = "+";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
