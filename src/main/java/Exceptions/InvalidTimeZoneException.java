/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author Dennis
 */
public class InvalidTimeZoneException extends Exception {

    /**
     * Creates a new instance of <code>DateFormatterException</code> without
     * detail message.
     */
    public InvalidTimeZoneException() {
    }

    /**
     * Constructs an instance of <code>DateFormatterException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidTimeZoneException(String msg) {
        super(msg);
    }
}
