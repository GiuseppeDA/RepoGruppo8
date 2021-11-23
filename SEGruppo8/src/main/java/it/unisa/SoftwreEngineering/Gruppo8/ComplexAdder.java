/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8;
import com.vm.jcomplex.Complex;

/**
 *
 * @author mario
 */
public class ComplexAdder {
    
    private Complex c;

    public ComplexAdder(Complex c) {
        System.out.println("MARIO E' GAY");
        this.c = c;
    }
    
    public static Complex addComplex(Complex a, Complex b){  
        return a.add(b);
    }
    
    
}
