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
public class Variable {
    private String name;
    private Complex value;

    public Variable(String name, Complex value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Complex getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(Complex value) {
        this.value = value;
    }
    
}
