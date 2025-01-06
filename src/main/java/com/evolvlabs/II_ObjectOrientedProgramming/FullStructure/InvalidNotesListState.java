package com.evolvlabs.II_ObjectOrientedProgramming.FullStructure;

import java.security.PrivilegedActionException;

public class InvalidNotesListState extends IllegalStateException {

  private String prettyMessage;
  /**
   * Constructs an IllegalStateException with no detail message. A detail message is a String that describes this
   * particular exception.
   */
  public InvalidNotesListState() {
    super();
    prettyMessage = "Invalid Notes List State";
  }

  /**
   * Constructs an IllegalStateException with the specified detail message.  A detail message is a String that
   * describes this particular exception.
   *
   * @param s the String that contains a detailed message
   */
  public InvalidNotesListState(String s) {
    super(s);
    prettyMessage = "Error: InvalidNotesListState extends IllegalStateException Thrown, con la razon de: " + s;
  }

  /**
   * Constructs a new exception with the specified detail message and cause.
   *
   * <p>Note that the detail message associated with {@code cause} is
   * <i>not</i> automatically incorporated in this exception's detail
   * message.
   *
   * @param message the detail message (which is saved for later retrieval by the {@link Throwable#getMessage()}
   *                method).
   * @param cause   the cause (which is saved for later retrieval by the {@link Throwable#getCause()} method).  (A
   *                {@code null} value is permitted, and indicates that the cause is nonexistent or unknown.)
   * @since 1.5
   */
  public InvalidNotesListState(String message, Throwable cause) {
    super(message, cause);
    prettyMessage = "Error: InvalidNotesListState extends IllegalStateException Thrown, con la razon de: " + message;
  }

  /**
   * Constructs a new exception with the specified cause and a detail message of
   * {@code (cause==null ? null : cause.toString())} (which typically contains the class and detail message of
   * {@code cause}). This constructor is useful for exceptions that are little more than wrappers for other throwables
   * (for example, {@link PrivilegedActionException}).
   *
   * @param cause the cause (which is saved for later retrieval by the {@link Throwable#getCause()} method).  (A
   *              {@code null} value is permitted, and indicates that the cause is nonexistent or unknown.)
   * @since 1.5
   */
  public InvalidNotesListState(Throwable cause) {
    super(cause);
    prettyMessage = "Error: InvalidNotesListState extends IllegalStateException Thrown, con la razon de: " + cause.getLocalizedMessage();
  }

  public String getPrettyMessage() {
    return prettyMessage;
  }
}
