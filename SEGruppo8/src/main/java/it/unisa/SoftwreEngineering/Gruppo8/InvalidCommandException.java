/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8;

/**
 *
 * @author 39324
 */
public class InvalidCommandException extends Exception {

    /**
     * Creates a new instance of <code>InvalidCommandException</code> without
     * detail message.
     */
    public InvalidCommandException() {
    }

    /**
     * Constructs an instance of <code>InvalidCommandException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidCommandException(String msg) {
        super(msg);
    }
}
