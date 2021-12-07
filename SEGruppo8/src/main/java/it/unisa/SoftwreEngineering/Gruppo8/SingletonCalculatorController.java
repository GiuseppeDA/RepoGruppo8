/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8;

/**
 *
 * @author mario
 */
public class SingletonCalculatorController {
    
    private static SingletonCalculatorController instance = null;
    private Calculator calculator;

    private SingletonCalculatorController() {};
    
    public static SingletonCalculatorController getIstance(){
        if(instance == null){
            instance = new SingletonCalculatorController();
        }
        return instance;
    }

    public Calculator getCalculator() {
        return calculator;
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

}
