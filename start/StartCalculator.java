package calculatorTask.start;


import calculatorTask.operations.Addition;
import calculatorTask.operations.Division;
import calculatorTask.operations.Multiplication;
import calculatorTask.operations.Subtraction;
import calculatorTask.service.Calculator;

public class StartCalculator {
    public static void main(String[] args) {
        new Calculator(
                new Addition(),
                new Division(),
                new Multiplication(),
                new Subtraction()
        )
                .startCalculator();
    }
}
