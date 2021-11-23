/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8;

import com.vm.jcomplex.Complex;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Simone
 */
public class CalculatorTest {
    
    public CalculatorTest() {
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
     * Test of add method, of class Calculator.
     */
    @Test
    public void testAdd() {
        System.out.println("add\n");
        Calculator instance = new Calculator();
        instance.insert(1,2);
        boolean expResult0 = false;
        boolean result0 = instance.add();
        assertEquals(expResult0, result0);
        
        
        instance.insert(2,1);
        boolean expResult1 = true;
        boolean result1 = instance.add();
        assertEquals(expResult1, result1);

    }

    /**
     * Test of subcract method, of class Calculator.
     */
    @Test
    public void testSubcract() {
        System.out.println("subcract");
        Calculator instance = new Calculator();
        instance.insert(1,2);
        boolean expResult0 = false;
        boolean result0 = instance.subcract();
        assertEquals(expResult0, result0);
        
        
        instance.insert(2,1);
        boolean expResult1 = true;
        boolean result1 = instance.subcract();
        assertEquals(expResult1, result1);
        
    }

    /**
     * Test of multiply method, of class Calculator.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        Calculator instance = new Calculator();
        instance.insert(1,2);
        boolean expResult0 = false;
        boolean result0 = instance.multiply();
        assertEquals(expResult0, result0);
        
        
        instance.insert(2,1);
        boolean expResult1 = true;
        boolean result1 = instance.multiply();
        assertEquals(expResult1, result1);
    }

    /**
     * Test of divide method, of class Calculator.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        Calculator instance = new Calculator();
        instance.divide();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sqrt method, of class Calculator.
     */
    @Test
    public void testSqrt() {
        System.out.println("sqrt");
        Calculator instance = new Calculator();
        instance.sqrt();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of invert method, of class Calculator.
     */
    @Test
    public void testInvert() {
        System.out.println("invert");
        Calculator instance = new Calculator();
        instance.invert();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkSize method, of class Calculator.
     */
    @Test
    public void testCheckSize() {
        System.out.println("checkSize");
        Calculator instance = new Calculator();
        instance.insert(1, 2);
        instance.insert(2, 1);
        
        int a = -1;
        boolean expResult0 = false;
        boolean result0 = instance.checkSize(a);
        assertEquals(expResult0, result0);
        
        a = 0;
        boolean expResult1 = false;
        boolean result1 = instance.checkSize(a);
        assertEquals(expResult1, result1);
        
        a = 1;
        boolean expResult2 = true;
        boolean result2 = instance.checkSize(a);
        assertEquals(expResult2, result2);
        
        a = 2;
        boolean expResult3 = true;
        boolean result3 = instance.checkSize(a);
        assertEquals(expResult3, result3);
        
        a = 3;
        boolean expResult4 = false;
        boolean result4 = instance.checkSize(a);
        assertEquals(expResult4, result4);
    }

    /**
     * Test of insert method, of class Calculator.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Calculator instance = new Calculator();
        double real=1;
        double img=2;
        instance.insert(real,img);
        Complex ris= new Complex(1,2);
        assertEquals(ris,instance.getTop());
    }
    
}
