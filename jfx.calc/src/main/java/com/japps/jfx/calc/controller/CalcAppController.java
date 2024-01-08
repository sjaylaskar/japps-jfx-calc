/**
 * Id: CalcAppController.java 07-Jan-2024 2:29:23 am SubhajoyLaskar
 * Copyright (©) 2024 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.jfx.calc.controller;

import java.math.*;

import org.apache.commons.lang3.*;

import com.japps.jfx.calc.logic.*;
import com.japps.lib.math.error.*;
import com.japps.log.util.*;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;

/**
 * The calc app controller.
 *
 * @author subhajoyl
 */
public class CalcAppController implements Loggable {

    /** The msg calculation failure. */
    private static final String MSG_CALCULATION_FAILURE = "Calculation failure!";

    /** The display result. */
    @FXML
    private Label displayResult = new Label();

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
	info("Process...");
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
	info("Process one operand...");
	final String value = ((Button) event.getSource()).getText();
	if (StringUtils.isNotBlank(operator)) {
	    return;
	}

	operator = value;
	info("operator: " + operator);
	number1 = new BigDecimal(displayResult.getText());
	info("number1: " + number1);
	displayResult.setText(StringUtils.EMPTY);
	info("displayResult: " + displayResult.getText());

	try {
	    info("number1: " + number1);
	    info("operator: " + operator);
	    info("displayResult: " + displayResult.getText());
	    final BigDecimal calculationResult = CalculationTransformer.calculate(number1, operator);
	    info("Calculation result: " + calculationResult);
	    final String formattedCalculationResult = String.valueOf(format(calculationResult));
	    info("Formatted calculation result: " + formattedCalculationResult);
	    displayResult.setText(formattedCalculationResult);
	} catch (final MathException | UnsupportedOperationException exception) {
	    error(exception);
	    displayResult.setText(exception.getMessage());
	} catch (final Exception exception) {
	    error(exception);
	    displayResult.setText(MSG_CALCULATION_FAILURE);
	}

	operator = StringUtils.EMPTY;
	info("operator: " + operator);
    }

    /**
     * Process two operands.
     *
     * @param event the event
     */
    @FXML
    public void processTwoOperands(final ActionEvent event) {
	info("Process two operands...");
	final String value = ((Button) event.getSource()).getText();
	if (!StringUtils.equals(value, "=")) {
	    if (StringUtils.isNotBlank(operator)) {
		return;
	    }

	    operator = value;
	    info("operator: " + operator);
	    number1 = new BigDecimal(displayResult.getText());
	    info("number1: " + number1);
	    displayResult.setText(StringUtils.EMPTY);
	    info("displayResult: " + displayResult.getText());
	} else {
	    if (StringUtils.isBlank(operator)) {
		return;
	    }

	    try {
		final BigDecimal number2 = new BigDecimal(displayResult.getText());
		info("number1: " + number1);
		info("number2: " + number2);
		info("operator: " + operator);
		info("displayResult: " + displayResult.getText());
		final BigDecimal calculationResult = CalculationTransformer.calculate(number1, number2, operator);
		info("Calculation result: " + calculationResult);
		final String formattedCalculationResult = String.valueOf(format(calculationResult));
		info("Formatted calculation result: " + formattedCalculationResult);
		displayResult.setText(formattedCalculationResult);
	    } catch (final MathException | UnsupportedOperationException exception) {
		error(exception);
		displayResult.setText(exception.getMessage());
	    } catch (final Exception exception) {
		error(exception);
		displayResult.setText(MSG_CALCULATION_FAILURE);
	    }
	    operator = StringUtils.EMPTY;
	    info("operator: " + operator);
	}
    }

    /**
     * Clear.
     *
     * @param event the event
     */
    @FXML
    public void clear(final ActionEvent event) {
	info("Clear...");
	operator = StringUtils.EMPTY;
	number1 = BigDecimal.ZERO;
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
	return calculationResult.stripTrailingZeros().toPlainString();
    }
}
