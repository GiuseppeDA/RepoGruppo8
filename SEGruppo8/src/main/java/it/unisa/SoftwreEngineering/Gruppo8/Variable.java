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

    /**
     *
     * @param name
     * @param value
     */
    public Variable(String name, Complex value) {
        this.name = name;
        this.value = value;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public Complex getValue() {
        return value;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param value
     */
    public void setValue(Complex value) {
        this.value = value;
    }
    
}
