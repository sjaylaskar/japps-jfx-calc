/**
 * Id: App.java 11-Nov-2022 4:44:04 am SubhajoyLaskar
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.jfx.calc.app;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The app.
 *
 * @author Subhajoy Laskar
 */
public class CalculatorApp extends Application {

	/**
	 *  The Constant LOG.
	 *
	 */
	private static final Logger LOG = LogManager.getLogger(CalculatorApp.class);


	/**
	 * Start.
	 *
	 * @param primaryStage the primary stage
	 */
	@Override
	public void start(final Stage primaryStage) {
		try {
			final Parent root = FXMLLoader.load(getClass().getResource("calculator-app.fxml"));
			final Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("controlStyle2.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("JApps - Calculator");
			primaryStage.show();
		} catch(final Exception exception) {
			LOG.error(exception);
		}
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {
		launch(args);
	}

}