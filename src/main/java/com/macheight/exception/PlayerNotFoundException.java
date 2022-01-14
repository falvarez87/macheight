package com.macheight.exception;

public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException(int input) {
        super("No matches found, input " + input);
    }
}
