/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8;

/**
 *
 * @author 39324
 */
public class CommandExecuteException extends Exception {

    /**
     * Creates a new instance of <code>CommandExecuteException</code> without
     * detail message.
     */
    public CommandExecuteException() {
    }

    /**
     * Constructs an instance of <code>CommandExecuteException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CommandExecuteException(String msg) {
        super(msg);
    }
}
