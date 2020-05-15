package calculatorTask.start;


import calculatorTask.operations.Operations;
import calculatorTask.service.Calculator;

public class StartCalculator {
    public static void main(String[] args) {
        new Calculator(Operations.values())
                .startCalculator();
    }
}
