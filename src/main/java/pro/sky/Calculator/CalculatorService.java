package pro.sky.Calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int subtract(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public double divide(int num1, int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero!");
        }
        return (double) num1 / num2;
    }

    public String calculate(String operator, int num1, int num2) {
        return switch (operator) {
            case "plus" -> formatResult(num1, num2, add(num1, num2), "+");
            case "minus" -> formatResult(num1, num2, subtract(num1, num2), "-");
            case "multiply" -> formatResult(num1, num2, multiply(num1, num2), "*");
            case "divide" -> formatResult(num1, num2, divide(num1, num2), "/");
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }

    private String formatResult(int num1, int num2, double result, String operator) {
        return String.format("%d %s %d = %s", num1, operator, num2, result);
    }
}