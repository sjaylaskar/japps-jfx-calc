/**
 * Id: BigDecimalUtil.java 07-Jan-2024 5:03:29 am SubhajoyLaskar
 * Copyright (©) 2024 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */

package com.japps.lib.math.util;

import java.math.BigDecimal;

/**
 * The big decimal util.
 *
 * @author subhajoyl
 */
public class BigDecimalUtil {

	/**
	 * Pow.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the big decimal
	 */
	public static BigDecimal pow(final BigDecimal x, final BigDecimal y) {
		return BigDecimal.valueOf(Math.pow(x.doubleValue(), y.doubleValue()));
	}

	/**
	 * Log 10.
	 *
	 * @param x the x
	 * @return the big decimal
	 */
	public static BigDecimal log10(final BigDecimal x) {
		return BigDecimal.valueOf(Math.log10(x.doubleValue()));
	}

	/**
	 * Ln.
	 *
	 * @param x the x
	 * @return the big decimal
	 */
	public static BigDecimal ln(final BigDecimal x) {
		return BigDecimal.valueOf(Math.log(x.doubleValue()));
	}

	/**
	 * Sin.
	 *
	 * @param x the x
	 * @return the big decimal
	 */
	public static BigDecimal sin(final BigDecimal x) {
		return BigDecimal.valueOf(Math.sin(x.doubleValue()));
	}

	/**
	 * Cos.
	 *
	 * @param x the x
	 * @return the big decimal
	 */
	public static BigDecimal cos(final BigDecimal x) {
		return BigDecimal.valueOf(Math.cos(x.doubleValue()));
	}

	/**
	 * Tan.
	 *
	 * @param x the x
	 * @return the big decimal
	 */
	public static BigDecimal tan(final BigDecimal x) {
		return BigDecimal.valueOf(Math.tan(x.doubleValue()));
	}

	/**
	 * Exp.
	 *
	 * @param x the x
	 * @return the big decimal
	 */
	public static BigDecimal exp(final BigDecimal x) {
		return BigDecimal.valueOf(Math.exp(x.doubleValue()));
	}

}
