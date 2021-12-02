/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8;

import com.vm.jcomplex.Complex;
import static com.vm.jcomplex.Complex.NaN;
import javafx.collections.ObservableList;
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
        boolean result0 = instance.add();
        assertFalse(result0);
        
        
        instance.insert(2,1);
        boolean result1 = instance.add();
        assertTrue(result1);
        
        ComplexNumber ris= new ComplexNumber(3,3);
        assertEquals(ris,instance.getTop());

    }

    /**
     * Test of subcract method, of class Calculator.
     */
    @Test
    public void testSubtract() {
        System.out.println("subcract");
        Calculator instance = new Calculator();
        instance.insert(1,2);
        boolean result0 = instance.subtract();
        assertFalse(result0);
        
        
        instance.insert(2,1);
        boolean result1 = instance.subtract();
        assertTrue(result1);
        
        ComplexNumber ris= new ComplexNumber(-1,1);
        assertEquals(ris,instance.getTop());
    }

    /**
     * Test of multiply method, of class Calculator.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        Calculator instance = new Calculator();
        instance.insert(1,2);
        boolean result0 = instance.multiply();
        assertFalse(result0);
        
        
        instance.insert(2,1);
        boolean result1 = instance.multiply();
        assertTrue(result1);
        
        ComplexNumber ris= new ComplexNumber(0,5);
        assertEquals(ris,instance.getTop());
    }

    /**
     * Test of divide method, of class Calculator.
     */
    @Test
    public void testDivide() throws ImpossibleDivisionException {
        System.out.println("divide");
        Calculator instance = new Calculator();

        instance.insert(1,2);
        boolean result0 = instance.divide();
        assertFalse(result0);
        
        
        instance.insert(2,-1);
        boolean result1 = instance.divide();
        assertTrue(result1);
        
        ComplexNumber ris= new ComplexNumber(0,1);
        assertEquals(ris,instance.getTop());
        
        instance.insert(0,0);
        
        ImpossibleDivisionException exception = assertThrows(ImpossibleDivisionException.class, () -> instance.divide());
        assertEquals("Divisione per 0 non consentita",exception.getMessage());
        
    }

    /**
     * Test of sqrt method, of class Calculator.
     */
    @Test
    public void testSqrt() {
        System.out.println("sqrt");
        Calculator instance = new Calculator();
        boolean result0 = instance.sqrt();
        assertFalse(result0);
        
        instance.insert(-3,4);
        boolean result1 = instance.sqrt();
        assertTrue(result1);
        
        ComplexNumber ris1= new ComplexNumber(1,2);
        assertEquals(ris1,instance.getTop());
        
        
    }

    /**
     * Test of invert method, of class Calculator.
     */
    @Test
    public void testInvert() {
        System.out.println("invert");
        Calculator instance = new Calculator();
        boolean result0 = instance.invert();
        assertFalse(result0);
        
        instance.insert(1,2);
        boolean result1 = instance.invert();
        assertTrue(result1);
        
        ComplexNumber ris= new ComplexNumber(-1,-2);
        assertEquals(ris,instance.getTop());

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
        boolean result0 = instance.checkSize(a);
        assertFalse(result0);
        
        a = 0;
        boolean result1 = instance.checkSize(a);
        assertFalse(result1);
        
        a = 1;
        boolean result2 = instance.checkSize(a);
        assertTrue(result2);
        
        a = 2;
        boolean result3 = instance.checkSize(a);
        assertTrue(result3);
        
        a = 3;
        boolean result4 = instance.checkSize(a);
        assertFalse(result4);
    }


    /**
     * Test of insert method, of class Calculator.
     */
    @Test
    public void testInsert_double_double() {
        System.out.println("insert");
        Calculator instance = new Calculator();
        double real=1;
        double img=2;
        instance.insert(real,img);
        ComplexNumber ris= new ComplexNumber(1,2);
        assertEquals(ris,instance.getTop());
    }

    /**
     * Test of insert method, of class Calculator.
     */
    @Test
    public void testInsert_Complex() {
        System.out.println("insert");
        Calculator instance = new Calculator();
        Complex x = new ComplexNumber(1,2);
        instance.insert(x);
        ComplexNumber ris= new ComplexNumber(1,2);
        assertEquals(ris,instance.getTop());
    }


    /**
     * Test of drop method, of class Calculator.
     */
    @Test
    public void testDrop() {
        System.out.println("drop");
        Calculator instance = new Calculator();
        boolean result0 = instance.drop();
        assertFalse(result0);
        
        instance.insert(1,2);
        instance.insert(2,1);
        boolean result1 = instance.drop();
        assertTrue(result1);
        
        ComplexNumber ris= new ComplexNumber(1,2);
        assertEquals(ris,instance.removeTop());
        
    }

    
    /**
     * Test of swap method, of class Calculator.
     */
    @Test
    public void testSwap() {
        System.out.println("swap");
        Calculator instance = new Calculator();
        instance.insert(1,2);
        boolean result0 = instance.swap();
        assertFalse(result0);
        
        instance.insert(2,1);
        boolean result1 = instance.swap();
        assertTrue(result1);
        
        
        ComplexNumber ris0= new ComplexNumber(1,2);
        ComplexNumber ris1= new ComplexNumber(2,1);
        
        assertEquals(ris0,instance.removeTop());
        assertEquals(ris1,instance.removeTop());
        
    }

    /**
     * Test of over method, of class Calculator.
     */
    @Test
    public void testOver() {
        System.out.println("over");
        Calculator instance = new Calculator();
        instance.insert(1,2);
        boolean result0 = instance.over();
        assertFalse(result0);
        
        instance.insert(2,1);
        boolean result1 = instance.over();
        assertTrue(result1);
        
        
        ComplexNumber ris= new ComplexNumber(1,2);
        assertEquals(ris,instance.removeTop());
        instance.removeTop();
        assertEquals(ris,instance.removeTop());
    }

    /**
     * Test of dup method, of class Calculator.
     */
    @Test
    public void testDup() {
        System.out.println("dup");
        Calculator instance = new Calculator();
        boolean result0 = instance.over();
        assertFalse(result0);
        
        instance.insert(1,2);
        boolean result1 = instance.dup();
        assertTrue(result1);
        
        ComplexNumber ris= new ComplexNumber(1,2);
        assertEquals(ris,instance.removeTop());
        assertEquals(ris,instance.removeTop());
    }

    /**
     * Test of clear method, of class Calculator.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        Calculator instance = new Calculator();
        instance.insert(1,2);
        instance.clear();
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> instance.getTop());
        assertEquals("Index 0 out of bounds for length 0",exception.getMessage());
    }

 
}
