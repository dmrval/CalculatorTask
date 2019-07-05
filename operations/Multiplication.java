package calculatorTask.operations;

import calculatorTask.calcInterface.Calculable;

public class Multiplication implements Calculable {

    @Override
    public String getOperator() {
        return "*";
    }

    @Override
    public double getResolve(double n1, double n2) {
        return n1 * n2;
    }
}
