/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8;

import it.unisa.SoftwreEngineering.Gruppo8.command.InserterCommand;
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
public class InserterCommandTest {
    
    public InserterCommandTest() {
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
     * Test of execute method, of class InserterCommand.
     */
    @Test
    public void testExecute() throws CommandExecuteException  {
        System.out.println("execute");
        ComplexNumber c1= new ComplexNumber(1,2);
        Calculator calc = new Calculator();
        InserterCommand instance = new InserterCommand(c1,calc);

        instance.execute();
        assertEquals(c1,calc.removeTop());
    }

    /**
     * Test of undo method, of class InserterCommand.
     */
    @Test
    public void testUndo() throws CommandExecuteException {
        System.out.println("undo");
        ComplexNumber c1= new ComplexNumber(1,2);
        ComplexNumber c2= new ComplexNumber(2,1);
        Calculator calc = new Calculator();
        InserterCommand instance1 = new InserterCommand(c1,calc);
        InserterCommand instance2 = new InserterCommand(c2,calc);

        
        instance1.execute();
        instance2.execute();
        instance2.undo();
        assertEquals(c1,calc.removeTop());
    }

    /**
     * Test of toString method, of class InserterCommand.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ComplexNumber c1= new ComplexNumber(1,2);
        Calculator calc = new Calculator();
        InserterCommand instance = new InserterCommand(c1,calc);
        String expResult = "(" + c1 + ")";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
