/**
 * Id: CalcAppController.java 07-Jan-2024 2:29:23 am SubhajoyLaskar
 * Copyright (©) 2024 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.jfx.calc.controller;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.japps.jfx.calc.logic.CalculationTransformer;
import com.japps.lib.math.error.MathException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * The calc app controller.
 *
 * @author subhajoyl
 */
public class CalcAppController {

	/** The Constant MSG_CALCULATION_FAILURE. */
	private static final String MSG_CALCULATION_FAILURE = "Calculation failure!";

	/** The Constant LOG. */
	private static final Logger LOG = LogManager.getLogger(CalcAppController.class);

	/** The display result. */
	@FXML
	private final Label displayResult = new Label();

	/** The number 1. */
	private BigDecimal number1 = BigDecimal.ZERO;

	/** The operator. */
	private String operator = StringUtils.EMPTY;

	/** The start. */
	private boolean start = true;

	/**
	 * Process.
	 *
	 * @param event the event
	 */
	@FXML
	public void process(final ActionEvent event) {
		LOG.info("Process...");
		if (start) {
			displayResult.setText(StringUtils.EMPTY);
			start = false;
		}
		final String value = ((Button) event.getSource()).getText();
		displayResult.setText(displayResult.getText() + value);
	}

	/**
	 * Process one operand.
	 *
	 * @param event the event
	 */
	@FXML
	public void processOneOperand(final ActionEvent event) {
		LOG.info("Process one operand...");
		final String value = ((Button) event.getSource()).getText();
		if (StringUtils.isNotBlank(operator)) {
			return;
		}

		operator = value;
		number1 = new BigDecimal(displayResult.getText());
		displayResult.setText(StringUtils.EMPTY);

		try {
			final BigDecimal calculationResult = CalculationTransformer.calculate(number1, operator);
			LOG.info("Calculation result: " + calculationResult);
			displayResult.setText(String.valueOf(format(calculationResult)));
			throw new Exception("UNPRECEDENTED TODO");
		} catch (final MathException | UnsupportedOperationException exception) {
			LOG.error(exception);
			displayResult.setText(exception.getMessage());
		} catch (final Exception exception) {
			LOG.error(exception);
			displayResult.setText(MSG_CALCULATION_FAILURE);
		}

		operator = StringUtils.EMPTY;
	}

	/**
	 * Process two operands.
	 *
	 * @param event the event
	 */
	@FXML
	public void processTwoOperands(final ActionEvent event) {
		LOG.info("Process two operands...");
		final String value = ((Button) event.getSource()).getText();
		if (!StringUtils.equals(value, "=")) {
			if (StringUtils.isNotBlank(operator)) {
				return;
			}

			operator = value;
			number1 = new BigDecimal(displayResult.getText());
			displayResult.setText(StringUtils.EMPTY);
		} else {
			if (StringUtils.isBlank(operator)) {
				return;
			}

			final BigDecimal number2 = new BigDecimal(displayResult.getText());
			try {
				final BigDecimal calculationResult = CalculationTransformer.calculate(number1, number2, operator);
				LOG.info("Calculation result: " + calculationResult);
				displayResult.setText(format(calculationResult));
			} catch (final MathException | UnsupportedOperationException exception) {
				LOG.error(exception);
				displayResult.setText(exception.getMessage());
			} catch (final Exception exception) {
				LOG.error(exception);
				displayResult.setText(MSG_CALCULATION_FAILURE);
			}
			operator = StringUtils.EMPTY;
		}
	}

	/**
	 * Clear.
	 *
	 * @param event the event
	 */
	@FXML
	public void clear(final ActionEvent event) {
		LOG.info("Clear...");
		operator = StringUtils.EMPTY;
		start = true;
		displayResult.setText(StringUtils.EMPTY);
	}

	/**
	 * Format.
	 *
	 * @param calculationResult the calculation result
	 * @return the string
	 */
	private String format(final BigDecimal calculationResult) {
		return calculationResult.stripTrailingZeros().toString();
	}
}
