package interfaces;

public interface ICalculator {
    double sum(double firstNumber, double secondNumber);
    double minus(double firstNumber, double secondNumber);
    double multiply(double firstNumber, double secondNumber);
    double divide(double firstNumber, double secondNumber);
    void calculateTask(String task);
    double getResult();
}
