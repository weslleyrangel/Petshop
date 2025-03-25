/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petshop.exception;

/**
 *
 * @author wesll
 */
public class PetshopException extends Exception {
    public PetshopException(String message, Throwable cause) {
        super(message, cause);
    }

    public PetshopException(String message) {
        super(message);
    }
}