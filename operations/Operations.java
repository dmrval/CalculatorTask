package calculatorTask.operations;

import calculatorTask.calcInterface.Calculable;

public enum Operations {
    ADDITION(OperatorHandler::getSum, "+"),
    DIVISION(OperatorHandler::getDivision, "/"),
    MULTIPLICATION(OperatorHandler::getMult, "*"),
    SUBTRACTION(OperatorHandler::getSubtraction, "-");

    String operation;
    Calculable calc;

    Operations(Calculable calc, String s) {
        operation = s;
        this.calc = calc;
    }

    public String getOperation() {
        return operation;
    }

    public Calculable getCalc() {
        return calc;
    }
}
