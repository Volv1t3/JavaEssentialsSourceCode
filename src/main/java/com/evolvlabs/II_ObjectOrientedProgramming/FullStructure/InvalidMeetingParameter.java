package com.evolvlabs.II_ObjectOrientedProgramming.FullStructure;

import java.security.InvalidParameterException;

public class InvalidMeetingParameter extends InvalidParameterException {

  private String prettyMessage;
  /**
   * Constructs an {@code InvalidParameterException} with no detail message. A detail message is a {@code String} that
   * describes this particular exception.
   */
  public InvalidMeetingParameter() {
    super();
    this.prettyMessage = "Error InvalidMeetingParameter extends InvalidParameterException Thrown";
  }

  /**
   * Constructs an {@code InvalidParameterException} with the specified detail message.  A detail message is a
   * {@code String} that describes this particular exception.
   *
   * @param msg the detail message.
   */
  public InvalidMeetingParameter(String msg) {
    super(msg);
    this.prettyMessage = "Error InvalidMeetingParameter extends InvalidParameterException Thrown: A causa de " + msg;
  }

  /**
   * Constructs an {@code InvalidParameterException} with the specified detail message and cause. A detail message is
   * a {@code String} that describes this particular exception.
   *
   * <p>Note that the detail message associated with {@code cause} is
   * <i>not</i> automatically incorporated in this exception's detail
   * message.
   *
   * @param msg   the detail message (which is saved for later retrieval by the {@link Throwable#getMessage()}
   *              method).
   * @param cause the cause (which is saved for later retrieval by the {@link Throwable#getCause()} method). (A
   *              {@code null} value is permitted, and indicates that the cause is nonexistent or unknown.)
   * @since 20
   */
  public InvalidMeetingParameter(String msg, Throwable cause) {
    super(msg, cause);
    this.prettyMessage = "Error InvalidMeetingParameter extends InvalidParameterException Thrown: A causa de " + msg;
  }

  /**
   * Constructs an {@code InvalidParameterException} with the specified cause and a detail message of
   * {@code (cause==null ? null : cause.toString())} (which typically contains the class and detail message of
   * {@code cause}). This constructor is useful for exceptions that are little more than wrappers for other
   * throwables.
   *
   * @param cause the cause (which is saved for later retrieval by the {@link Throwable#getCause()} method). (A
   *              {@code null} value is permitted, and indicates that the cause is nonexistent or unknown.)
   * @since 20
   */
  public InvalidMeetingParameter(Throwable cause) {
    super(cause);
    this.prettyMessage = "Error InvalidMeetingParameter extends InvalidParameterException Thrown: A causa de " + cause.getMessage();
  }

  public String getPrettyMessage() {
    return prettyMessage;
  }
}
