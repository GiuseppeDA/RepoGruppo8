/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8.exception;

/**
 *
 * @author 39324
 */
public class ImpossibleDivisionException extends Exception {

    /**
     * Creates a new instance of <code>ImpossibleDivisionException</code>
     * without detail message.
     */
    public ImpossibleDivisionException() {
    }

    /**
     * Constructs an instance of <code>ImpossibleDivisionException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ImpossibleDivisionException(String msg) {
        super(msg);
    }
}
