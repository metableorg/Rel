package ca.mb.armchair.rel3.exceptions;

/**
 * This exception is thrown when semantic errors are encountered.
 */
public class ExceptionSemantic extends Error {

	static final long serialVersionUID = 0;
	
	public ExceptionSemantic(String message) {
		super(message);
	}
	
	public ExceptionSemantic(String message, Throwable cause) {
		super(message, cause);
	}
}
