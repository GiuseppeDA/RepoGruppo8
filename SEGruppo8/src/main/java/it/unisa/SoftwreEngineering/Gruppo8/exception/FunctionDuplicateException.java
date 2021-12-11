/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8.exception;

/**
 *
 * @author 39324
 */
public class FunctionDuplicateException extends Exception{

    /**
     * Creates a new instance of <code>FunctionDuplicateException</code> without
     * detail message.
     */
    public FunctionDuplicateException() {
    }

    /**
     * Constructs an instance of <code>FunctionDuplicateException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public FunctionDuplicateException(String msg) {
        super(msg);
    }
}
