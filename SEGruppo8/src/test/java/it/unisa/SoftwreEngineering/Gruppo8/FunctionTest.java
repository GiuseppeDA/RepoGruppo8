/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8;

import it.unisa.SoftwreEngineering.Gruppo8.command.AdderCommand;
import it.unisa.SoftwreEngineering.Gruppo8.command.InserterCommand;
import it.unisa.SoftwreEngineering.Gruppo8.command.InverterCommand;
import java.util.ArrayList;
import java.util.Arrays;
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
public class FunctionTest {
    
    public FunctionTest() {
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
     * Test of run method, of class Function.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        ComplexNumber c1= new ComplexNumber(1,2);
        ComplexNumber c2= new ComplexNumber(2,1);
        ComplexNumber c3= new ComplexNumber(-3,-3);
        Calculator calc = new Calculator();
        Command addCommand = new AdderCommand(calc);
        Command invertCommand = new InverterCommand(calc);
        Function instance = new Function();
        instance.add(addCommand);
        instance.add(invertCommand);
        
        calc.insert(c1);
        calc.insert(c2);
        instance.run();
        assertEquals(c3,calc.removeTop());
        
    }

    /**
     * Test of add method, of class Function.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        ComplexNumber c1= new ComplexNumber(1,2);
        Calculator calc = new Calculator();
        Command insertCommand = new InserterCommand(c1,calc);
        Function instance = new Function();
        
        instance.add(insertCommand);
        instance.run();
        assertEquals(c1,calc.removeTop());
        
    }

    /**
     * Test of getCommandList method, of class Function.
     */
    @Test
    public void testGetCommandList() {
        System.out.println("getCommandList");
        Calculator calc = new Calculator();
        Command addCommand = new AdderCommand(calc);
        Command invertCommand = new InverterCommand(calc);
        Function instance = new Function();
        instance.add(addCommand);
        instance.add(invertCommand);
        
        ArrayList<Command> expResult = new ArrayList<>(Arrays.asList(addCommand,invertCommand));
        ArrayList<Command> result = instance.getCommandList();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of toString method, of class Function.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Calculator calc = new Calculator();
        Command addCommand = new AdderCommand(calc);
        Command invertCommand = new InverterCommand(calc);
        Function instance = new Function();
        instance.add(addCommand);
        instance.add(invertCommand);
        String expResult = "+ +- " ;
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
