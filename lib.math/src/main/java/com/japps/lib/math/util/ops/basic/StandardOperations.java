/**
 * Id: StandardOperations.java 18-Nov-2022 3:00:52 am SubhajoyLaskar
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.lib.math.util.ops.basic;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.stream.LongStream;

import com.japps.lib.math.error.MathException;
import com.japps.lib.math.util.BigDecimalUtil;
import com.japps.log.util.LogUtil;
import com.japps.log.util.Loggable;

/**
 * The standard operations.
 *
 * @author subhajoyl
 */
public final class StandardOperations implements Loggable {

	/** The Constant MATH_CONTEXT_DECIMAL128. */
	private static final MathContext MATH_CONTEXT_DECIMAL128 = MathContext.DECIMAL128;

	/**
	 * Instantiates a new standard operations.
	 */
	private StandardOperations() {

	}


	/**
	 * Adds the.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the big decimal
	 */
	public static BigDecimal add(final BigDecimal x, final BigDecimal y) {
		return x.add(y, MATH_CONTEXT_DECIMAL128);
	}


	/**
	 * Subtract.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the big decimal
	 */
	public static BigDecimal subtract(final BigDecimal x, final BigDecimal y) {
		return x.subtract(y, MATH_CONTEXT_DECIMAL128);
	}


	/**
	 * Multiply.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the big decimal
	 */
	public static BigDecimal multiply(final BigDecimal x, final BigDecimal y) {
		return x.multiply(y, MATH_CONTEXT_DECIMAL128);
	}


	/**
	 * Divide.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the big decimal
	 */
	public static BigDecimal divide(final BigDecimal x, final BigDecimal y) {
		validateDivisionByZero(y);
		return x.divide(y, MATH_CONTEXT_DECIMAL128);
	}


	/**
	 * Mod.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the big decimal
	 */
	public static BigDecimal mod(final BigDecimal x, final BigDecimal y) {
		validateDivisionByZero(y);
		return x.remainder(y, MATH_CONTEXT_DECIMAL128);
	}


	/**
	 * Pow.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the big decimal
	 */
	public static BigDecimal pow(final BigDecimal x, final BigDecimal y) {
		return BigDecimalUtil.pow(x, y);
	}

	/**
	 * Sqrt.
	 *
	 * @param x the x
	 * @return the big decimal
	 */
	public static BigDecimal sqrt(final BigDecimal x) {
		validatePositive(x);
		return x.sqrt(MATH_CONTEXT_DECIMAL128);
	}

	/**
	 * Sin.
	 *
	 * @param x the x
	 * @return the big decimal
	 */
	public static BigDecimal sin(final BigDecimal x) {
		return BigDecimalUtil.sin(x);
	}

	/**
	 * Cos.
	 *
	 * @param x the x
	 * @return the big decimal
	 */
	public static BigDecimal cos(final BigDecimal x) {
		return BigDecimalUtil.cos(x);
	}

	/**
	 * Tan.
	 *
	 * @param x the x
	 * @return the big decimal
	 */
	public static BigDecimal tan(final BigDecimal x) {
		return BigDecimalUtil.tan(x);
	}

	/**
	 * Exp.
	 *
	 * @param x the x
	 * @return the big decimal
	 */
	public static BigDecimal exp(final BigDecimal x) {
		return BigDecimalUtil.exp(x);
	}

	/**
	 * Square.
	 *
	 * @param x the x
	 * @return the big decimal
	 */
	public static BigDecimal square(final BigDecimal x) {
		return x.pow(2);
	}

	/**
	 * Cube.
	 *
	 * @param x the x
	 * @return the big decimal
	 */
	public static BigDecimal cube(final BigDecimal x) {
		return x.pow(3);
	}

	/**
	 * Log.
	 *
	 * @param x the x
	 * @return the double
	 */
	public static BigDecimal log(final BigDecimal x) {
		validatePositive(x);
		return BigDecimalUtil.log10(x);
	}

	/**
	 * Ln.
	 *
	 * @param x the x
	 * @return the double
	 */
	public static BigDecimal ln(final BigDecimal x) {
		validatePositive(x);
		return BigDecimalUtil.ln(x);
	}

	/**
	 * Factorial.
	 *
	 * @param x the x
	 * @return the big decimal
	 */
	public static BigDecimal factorial(final BigDecimal x) {
		try {
			x.longValueExact();
		} catch (final ArithmeticException exception) {
			LogUtil.newInstance(StandardOperations.class).error(exception.getMessage());
			throw new MathException("Only whole numbers are allowed for factorial.");
		}
		return BigDecimal.valueOf(factorial(x.longValue()));
	}

	/**
	 * Factorial.
	 *
	 * @param x the x
	 * @return the long
	 */
	public static long factorial(final long x) {
		if (x == 0) {
			return 1;
		}
		boolean isNegative = false;
		final long negatedX = -x;
		if (x < 0) {
			isNegative = true;

		}
		return  (!isNegative)
				? LongStream.rangeClosed(1, x).reduce(1, (a, b) -> a * b)
						: - LongStream.rangeClosed(1, negatedX).reduce(1, (a, b) -> a * b);
	}

	/**
	 * Validate division by zero.
	 *
	 * @param y the y
	 */
	private static void validateDivisionByZero(final BigDecimal y) {
		if (BigDecimal.ZERO.equals(y)) {
			LogUtil.newInstance(StandardOperations.class).error("Division by zero not allowed.");
			throw new MathException("Division by zero not allowed.");
		}
	}

	/**
	 * Validate positive.
	 *
	 * @param x the x
	 */
	private static void validatePositive(final BigDecimal x) {
		if (x.compareTo(BigDecimal.ZERO) < 1) {
			LogUtil.newInstance(StandardOperations.class).error("Number must be positive.");
			throw new MathException("Number must be positive.");
		}
	}

}
