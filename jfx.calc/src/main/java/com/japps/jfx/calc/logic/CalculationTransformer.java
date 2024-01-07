/**
 * Id: CalculationTransformer.java 07-Jan-2024 1:38:08 am SubhajoyLaskar
 * Copyright (©) 2024 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.jfx.calc.logic;

import java.math.BigDecimal;

import com.japps.lib.math.util.ops.basic.StandardOperations;

/**
 * The calculation transformer.
 *
 * @author subhajoyl
 */
public final class CalculationTransformer {

	/**
	 * Instantiates a new calculation transformer.
	 */
	private CalculationTransformer() {

	}

	/**
	 * Calculate.
	 *
	 * @param number
	 *            the number
	 * @param operator
	 *            the operator
	 * @return the big decimal
	 */
	public static BigDecimal calculate(final BigDecimal number,
			final String operator) {
		return switch (operator) {
			case "√" -> StandardOperations.sqrt(number);
			case "sin" -> StandardOperations.sin(number);
			case "cos" -> StandardOperations.cos(number);
			case "tan" -> StandardOperations.tan(number);
			case "e^x" -> StandardOperations.exp(number);
			case "x^2" -> StandardOperations.square(number);
			case "x^3" -> StandardOperations.cube(number);
			case "log" -> StandardOperations.log(number);
			case "ln" -> StandardOperations.ln(number);
			case "x!" -> StandardOperations.factorial(number);
			default -> throw new UnsupportedOperationException(
					"Operation not supported.");
		};
	}

	/**
	 * Calculate.
	 *
	 * @param number1
	 *            the number 1
	 * @param number2
	 *            the number 2
	 * @param operator
	 *            the operator
	 * @return the big decimal
	 */
	public static BigDecimal calculate(final BigDecimal number1,
			final BigDecimal number2, final String operator) {
		return switch (operator) {
			case "+" -> StandardOperations.add(number1, number2);
			case "-" -> StandardOperations.subtract(number1, number2);
			case "*" -> StandardOperations.multiply(number1, number2);
			case "/" -> StandardOperations.divide(number1, number2);
			case "mod" -> StandardOperations.mod(number1, number2);
			case "x^y" -> StandardOperations.pow(number1, number2);
			default -> throw new UnsupportedOperationException(
					"Operation not supported.");
		};
	}
}
