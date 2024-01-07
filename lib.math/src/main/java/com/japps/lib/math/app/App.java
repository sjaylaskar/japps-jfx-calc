/**
 * Id: App.java 07-Jan-2024 1:36:07 am SubhajoyLaskar
 * Copyright (©) 2024 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.lib.math.app;

import java.math.BigDecimal;

import com.japps.lib.math.util.ops.basic.StandardOperations;

/**
 * The app.
 *
 * @author Subhajoy Laskar
 */
public class App {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args) {
		System.out.println("Math operations.");
		System.out.println(StandardOperations.pow(BigDecimal.valueOf(11), BigDecimal.valueOf(2)).longValue());
	}
}
