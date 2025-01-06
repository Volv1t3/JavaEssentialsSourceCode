package com.evolvlabs.II_ObjectOrientedProgramming.FullStructure;

public class InvalidNoteTitleParameter extends IllegalArgumentException {

    private String prettyMessage;

    public InvalidNoteTitleParameter(String message) {
        super(message);
        prettyMessage = "Error: InvalidNoteTitleParameter extends IllegalArgumentException Thrown, con la razon de: " + message;
    }
    public InvalidNoteTitleParameter(String message, Throwable cause) {
        super(message, cause);
        prettyMessage = "Error: InvalidNoteTitleParameter extends IllegalArgumentException Thrown, con la razon de: " + message;
    }
    public String getPrettyMessage() {
        return prettyMessage;
    }

}
