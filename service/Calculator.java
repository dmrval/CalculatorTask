package calculatorTask.service;

import calculatorTask.calcInterface.Calculable;
import calculatorTask.operations.Operations;
import jdk.dynalink.Operation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calculator {
    private double n1 = 0;
    private double n2 = 0;
    private List<Operations> defaultOperations;


    public Calculator(Operations... operations) {
        defaultOperations = new ArrayList<>();
        Collections.addAll(defaultOperations, operations);
    }

    public void startCalculator() {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        boolean repeat = true;
        String proceed;
        while (repeat) {
            n1 = getNumber(bf, "Enter the first number");
            n2 = getNumber(bf, "Enter the second number");
            getResolve(bf);
            try {
                System.out.println("Do you want again?" + "\n" + "NO  : 'N' or 'n' + Enter" + "\n" + "YES : press Enter");
                proceed = bf.readLine();
                if (proceed.equals("N") || proceed.equals("n")) {
                    repeat = false;
                }
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    private void getResolve(BufferedReader bf) {
        String operation;
        boolean errorInput;
        double res;
        do {
            errorInput = true;
            try {
                System.out.println("Enter the operation : " + getSymbolOperations());
                if (defaultOperations.size() != 0) {
                    operation = bf.readLine();
                    if (getOperator(operation) != null) {
                        res = getOperator(operation).getResolve(n1, n2);
                        System.out.println("Result : " + res + "\n");
                        errorInput = false;
                    }
                    if (errorInput) {
                        System.out.println("Bad operation!!!");
                    }
                } else {
                    System.out.println("You don't have registered operations...");
                    System.exit(0);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } while (errorInput);
    }

    private double getNumber(BufferedReader bf, String message) {
        boolean errorInput;
        double number = 0;
        do {
            errorInput = false;
            try {
                System.out.println(message);
                number = Double.parseDouble(bf.readLine());
            } catch (IOException | NumberFormatException e) {
                errorInput = true;
                System.out.println("You pressed not a digit!!!");
            }
        } while (errorInput);
        return number;
    }

    private Calculable getOperator(String operation) {
        for (Operations operations : defaultOperations) {
            if (operations.getOperation().equals(operation)) {
                return operations.getCalc();
            }
        }
        return null;
    }

    private String getSymbolOperations() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        for (Operations operation : defaultOperations) {
            sb.append(operation.getOperation());
            sb.append(" ");
        }
        return sb.toString();
    }

}



