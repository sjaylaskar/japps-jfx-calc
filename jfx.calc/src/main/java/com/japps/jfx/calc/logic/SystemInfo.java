/**
 * Id: SystemInfo.java 11-Nov-2022 4:43:54 am SubhajoyLaskar
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.jfx.calc.logic;


/**
 * The system info.
 *
 * @author Subhajoy Laskar
 */
public class SystemInfo {

	/**
	 * Java version.
	 *
	 * @return the string
	 */
	public static String javaVersion() {
		return System.getProperty("java.version");
	}

	/**
	 * Javafx version.
	 *
	 * @return the string
	 */
	public static String javafxVersion() {
		return System.getProperty("javafx.version");
	}

}