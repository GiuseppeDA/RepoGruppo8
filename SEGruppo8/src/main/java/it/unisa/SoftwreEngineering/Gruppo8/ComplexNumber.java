/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8;
import com.vm.jcomplex.Complex;
/**
 *
 * @author 39324
 */
public class ComplexNumber extends Complex {
    
    public ComplexNumber(double real,double img) {
        super(real,img);
    }
     public ComplexNumber(double real) {
        super(real);
    }

    @Override
    public String toString() {
        return Double.toString(getReal()) + " "+Double.toString(getImaginary())+'j';
    }
    
}
