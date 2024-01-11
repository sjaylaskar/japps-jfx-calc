/**
 * Id: App.java 11-Nov-2022 4:44:04 am SubhajoyLaskar
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.jfx.calc.app;

import com.japps.log.util.*;

import javafx.application.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;

/**
 * The calculator app.
 *
 * @author Subhajoy Laskar
 */
public class CalculatorApp extends Application implements Loggable {

	/**
	 * Start.
	 *
	 * @param primaryStage the primary stage
	 */
	@Override
	public void start(final Stage primaryStage) {
		try {
			info("Opening JAPPS - Calculator.");
			final Parent root = FXMLLoader.load(getClass().getResource("calculator-app.fxml"));
			final Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("controlStyle2.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("JApps - Calculator");
			primaryStage.setResizable(false);
			primaryStage.setIconified(true);
			primaryStage.show();
		} catch(final Exception exception) {
			error(exception);
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