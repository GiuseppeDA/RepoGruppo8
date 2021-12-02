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
 * @author simon
 */
public class VariablesTest {
    
    public VariablesTest() {
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
     * Test of setVar method, of class Variables.
     */
    @Test
    public void testSetVar() {
        System.out.println("setVar");
        Variables instance = new Variables();
        Complex c = new ComplexNumber(1,2);
        int indexN =-1;
        
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> instance.setVar(c, indexN));
        assertEquals("Index -1 out of bounds for length 26",exception.getMessage());
        
        int indexP = 0;
        instance.setVar(c, indexP);
        
        assertEquals(c,instance.getVar(0).getValue());
    }

    /**
     * Test of addVar method, of class Variables.
     */
    @Test
    public void testAddVar() {
        System.out.println("addVar");
        Variables instance = new Variables();
        Complex c1 = new ComplexNumber(1,2);
        int indexN = -1;
        Complex c2 = new ComplexNumber(2,1);
        
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> instance.addVar(c2, indexN));
        assertEquals("Index -1 out of bounds for length 26",exception.getMessage());
        
        int indexP = 0;
        instance.setVar(c1, indexP);
        instance.addVar(c2, indexP);
        Complex c3 = new ComplexNumber(3,3);
        assertEquals(c3,instance.getVar(0).getValue());
    }

    /**
     * Test of subVar method, of class Variables.
     */
    @Test
    public void testSubVar() {
        System.out.println("subVar");
        Variables instance = new Variables();
        Complex c1 = new ComplexNumber(1,2);
        int indexN = -1;
        Complex c2 = new ComplexNumber(2,1);
        
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> instance.subVar(c2, indexN));
        assertEquals("Index -1 out of bounds for length 26",exception.getMessage());
        
        int indexP = 0;
        instance.setVar(c1, indexP);
        instance.subVar(c2, indexP);
        Complex c3 = new ComplexNumber(-1,1);
        assertEquals(c3,instance.getVar(0).getValue());
    }
    
}
