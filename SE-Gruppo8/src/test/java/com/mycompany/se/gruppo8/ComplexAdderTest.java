/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.se.gruppo8;

import com.vm.jcomplex.Complex;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mario
 */
public class ComplexAdderTest {
    
    public ComplexAdderTest() {
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
     * Test of addComplex method, of class ComplexAdder.
     */
    @Test
    public void testAddComplex() {
        System.out.println("addComplex");
        Complex a = new Complex(1,1);
        Complex b = new Complex(1,1);
        Complex expResult = new Complex(2,2);
        Complex result = ComplexAdder.addComplex(a, b);
        assertEquals(expResult, result);
       
    }
    
}
