/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8.exception;

/**
 *
 * @author 39324
 */
public class NotExistingFunctionException extends Exception{

    /**
     * Creates a new instance of <code>NotExistingFunctionException</code>
     * without detail message.
     */
    public NotExistingFunctionException() {
    }

    /**
     * Constructs an instance of <code>NotExistingFunctionException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public NotExistingFunctionException(String msg) {
        super(msg);
    }
}
