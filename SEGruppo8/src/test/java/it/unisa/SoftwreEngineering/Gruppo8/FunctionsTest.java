/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8;

import com.vm.jcomplex.Complex;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
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
    public void testSave() throws InvalidCommandException, FunctionDuplicateException {
        try {
            System.out.println("restore");
            String name = "prova";
            String commands = "(2) (1) /";
            Calculator calc=new Calculator();
            Variables variable=new Variables();
            Functions instance = new Functions(calc,variable);
            instance.stringToFunction(name, commands);
            File file = new File("prova.txt");
            if (!file.exists())
                file.createNewFile();
            instance.save("prova.txt");
            try(Scanner i = new Scanner(new BufferedReader(new FileReader("prova.txt")))){
               assertEquals(i.nextLine(),"prova (2.0) (1.0) / "); 
            }
            // TODO review the generated test code and remove the default call to fail.
       
    }       catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * Test of restore method, of class Functions.
     */
    @Test
    public void testRestore() throws InvalidCommandException, FunctionDuplicateException {
        System.out.println("restore");
        String name = "prova0";
        String commands = "(2) (1) +";
        Calculator calc=new Calculator();
        Variables variable=new Variables();
        Functions instance = new Functions(calc,variable);
        instance.stringToFunction(name, commands);
        File file = new File("prova0.txt");
            if (!file.exists())
                try {
                    file.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        instance.save("prova0.txt");
        Functions instance1 = new Functions(calc,variable);
        instance1.restore("prova0.txt");
        instance1.getFunction(name).run();
        Complex c =new Complex(3,0);
        assertEquals(calc.removeTop(),c);
        
    }

    /**
     * Test of stringToFunction method, of class Functions.
     */
    @Test
    public void testStringToFunction() throws  InvalidCommandException, FunctionDuplicateException {
        System.out.println("stringToFunction");
        String name = "prova";
        String commands = "(2) (1) +";
        Calculator calc=new Calculator();
        Variables variable=new Variables();
        Functions instance = new Functions(calc,variable);
        instance.stringToFunction(name, commands);
        instance.getFunction(name).run();
        Complex c =new Complex(3,0);
        assertEquals(calc.removeTop(),c);
        commands="(2+j) +-";
        String name1="ciao";
        instance.stringToFunction(name1, commands);
        
        instance.getFunction(name1).run();
        Complex c1 =new Complex(-2,-1);
        assertEquals(calc.removeTop(),c1);
    }
    
        }
