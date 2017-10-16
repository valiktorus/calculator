package beans;

import interfaces.ICalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator implements ICalculator {
    private static final String CALCULATION_ACTION_REGEX = "(\\d+|[+*-/])";
    private static final int FIRST_NUMBER_INDEX = 0;
    private static final int CALCULATION_GROUP_INDEX = 1;
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

    private double result;

    public Calculator() {
        this.result = 0;
    }

    @Override
    public double sum(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    @Override
    public double minus(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    @Override
    public double multiply(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    @Override
    public double divide(double firstNumber, double secondNumber) {
        return firstNumber / secondNumber;
    }

    @Override
    public void calculateTask(String task) {
        List<String> listOfNumbers = new ArrayList<>();
        Pattern pattern = Pattern.compile(CALCULATION_ACTION_REGEX);
        Matcher matcher = pattern.matcher(task);
        while (matcher.find()){
            listOfNumbers.add(matcher.group(CALCULATION_GROUP_INDEX));
        }
        double tmpResult = Double.parseDouble(listOfNumbers.get(FIRST_NUMBER_INDEX));
        for (int i = 1; i < listOfNumbers.size() ; i = i + 2) {
            tmpResult = doCalculation(listOfNumbers.get(i), tmpResult, Double.parseDouble(listOfNumbers.get(i+1)));
        }
        result = tmpResult;
    }

    @Override
    public double getResult() {
        return result;
    }

    private double doCalculation(String action, double firstNumber, double secondNumber){
        switch (action){
            case PLUS:
                return sum(firstNumber, secondNumber);
            case MINUS:
                return minus(firstNumber, secondNumber);
            case MULTIPLY:
                return multiply(firstNumber, secondNumber);
            case DIVIDE:
                return divide(firstNumber, secondNumber);
            default: return 0;
        }
    }
}
