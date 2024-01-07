/**
 * Id: AbstractMathException.java 07-Jan-2024 3:32:19 am SubhajoyLaskar
 * Copyright (©) 2024 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.lib.math.error;

/**
 * The abstract math exception.
 *
 * @author subhajoyl
 */
public class MathException extends RuntimeException {

	/**
	 * Instantiates a new math exception.
	 *
	 * @param message the message
	 */
	public MathException(final String message) {
		super(message);
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 657026885453471132L;

}
