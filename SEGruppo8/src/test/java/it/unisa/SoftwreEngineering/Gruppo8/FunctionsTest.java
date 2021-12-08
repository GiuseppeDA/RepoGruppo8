/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8;

import com.vm.jcomplex.Complex;
import javafx.collections.ObservableMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 39324
 */
public class FunctionsTest {
    
    public FunctionsTest() {
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
     * Test of getMap method, of class Functions.
     */
    @Test
    public void testGetMap() {
        System.out.println("getMap");
        Functions instance = null;
        ObservableMap<String, Function> expResult = null;
        ObservableMap<String, Function> result = instance.getMap();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFunction method, of class Functions.
     */
    @Test
    public void testGetFunction() {
        System.out.println("getFunction");
        String name = "";
        Functions instance = null;
        Function expResult = null;
        Function result = instance.getFunction(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFunction method, of class Functions.
     */
    @Test
    public void testSetFunction() {
        System.out.println("setFunction");
        String name = "";
        Function f = null;
        Functions instance = null;
        instance.setFunction(name, f);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addFunction method, of class Functions.
     */
    @Test
    public void testAddFunction() throws Exception {
        System.out.println("addFunction");
        String name = "";
        Function f = null;
        Functions instance = null;
        instance.addFunction(name, f);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class Functions.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        String filename = "";
        Functions instance = null;
        boolean expResult = false;
        boolean result = instance.save(filename);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of restore method, of class Functions.
     */
    @Test
    public void testRestore() {
        System.out.println("restore");
        String filename = "";
        Functions instance = null;
        boolean expResult = false;
        boolean result = instance.restore(filename);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stringToFunction method, of class Functions.
     */
    @Test
    public void testStringToFunction() throws Exception {
        System.out.println("stringToFunction");
        String name = "prova";
        String commands = "(2) (1) +";
        Calculator calc=new Calculator();
        Variables variable=new Variables();
        Functions instance = new Functions(calc,variable);
        instance.stringToFunction(name, commands);
        instance.getFunction(name).run();
        Complex c =new Complex(3,0.0);
        assertEquals(calc.removeTop(),c);
    }
    
}
