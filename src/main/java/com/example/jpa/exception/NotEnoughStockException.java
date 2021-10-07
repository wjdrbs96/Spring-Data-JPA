package com.example.jpa.exception;

/**
 * created by Gyunny 2021/10/07
 */
public class NotEnoughStockException extends RuntimeException {

    public NotEnoughStockException(String message) {
        super(message);
    }

}
