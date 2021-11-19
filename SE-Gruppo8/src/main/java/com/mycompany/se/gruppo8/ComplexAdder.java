/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.se.gruppo8;
import com.vm.jcomplex.Complex;

/**
 *
 * @author mario
 */
public class ComplexAdder {
    
    private Complex c;

    public ComplexAdder(Complex c) {
        this.c = c;
    }
    
    public static Complex addComplex(Complex a, Complex b){  
        return a.add(b);
    }
    
    
}
