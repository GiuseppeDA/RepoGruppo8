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
        Double insReal=getReal();
        Double insImaginary=getImaginary();
        if (getImaginary()==0.0){
            insImaginary=0.0;
            return Double.toString(insReal);
        }                
        if (getReal()==0.0){
            insReal=0.0;
            return Double.toString(insImaginary)+'j';            
        }
    
        if(getImaginary()>=0){
             return Double.toString(insReal) + " + "+Double.toString(insImaginary)+'j';
        }
        return Double.toString(insReal) + " "+Double.toString(insImaginary)+'j';
    }
    
}
