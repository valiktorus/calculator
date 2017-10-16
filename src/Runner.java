import beans.Calculator;
import interfaces.ICalculator;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            String task = scanner.nextLine();
            ICalculator calculator = new Calculator();
            calculator.calculateTask(task);
            System.out.println(calculator.getResult());
        } finally {
            if (scanner!= null) {
                scanner.close();
            }
        }
    }
}