package com.example.calculadora;

/**
 * @author Alexis
 * @version 1.0
 * @since 1.0
 */
public class Calculator {


    public int hacerOperacion(String expression) throws IllegalArgumentException {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("La expresión no puede estar vacía.");
        }
        return calculate(expression);
    }


    private int calculate(String expression) throws IllegalArgumentException {
        String[] additionAndSubtractionParts = expression.split("(?=[+-])|(?<=[+-])");
        int result = 0;
        int index = 0;

        while (index < additionAndSubtractionParts.length) {
            String part = additionAndSubtractionParts[index];
            int value;

            if (part.contains("*") || part.contains("/")) {
                value = handleMultiplicationAndDivision(part);
            } else {
                value = Integer.parseInt(part);
            }

            if (index == 0) {
                result = value;
            } else if (additionAndSubtractionParts[index - 1].equals("+")) {
                result += value;
            } else if (additionAndSubtractionParts[index - 1].equals("-")) {
                result -= value;
            }

            index += 2;
        }

        return result;
    }

    private int handleMultiplicationAndDivision(String expression) {
        String[] parts = expression.split("(?=[*/])|(?<=[*/])");
        int result = Integer.parseInt(parts[0]);

        for (int i = 1; i < parts.length; i += 2) {
            String operator = parts[i];
            int nextValue = Integer.parseInt(parts[i + 1]);

            if (operator.equals("*")) {
                result *= nextValue;
            } else if (operator.equals("/")) {
                if (nextValue == 0) {
                    throw new ArithmeticException("División por cero no permitida.");
                }
                result /= nextValue;
            }
        }

        return result;
    }

    public int evaluate(String expression) throws IllegalArgumentException {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("La expresión no puede estar vacía.");
        }
        return calculate(expression);
    }
}
