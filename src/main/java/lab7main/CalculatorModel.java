package main.java.lab7main;

import java.util.Observable;

public class CalculatorModel extends Observable {
    private double result = 0.0;
    private Double memory = null;
    private String currentOp = "";

    public void calculate(double op1, double op2, String operation) {
        try {
            switch (operation) {
                case "+": result = op1 + op2; break;
                case "-": result = op1 - op2; break;
                case "*": result = op1 * op2; break;
                case "/": result = (op2 == 0) ? Double.NaN : op1 / op2; break;
            }
        } catch (Exception e) {
            result = Double.NaN;
        }
        setChanged();
        notifyObservers(result);
        memory = result;
    }

    public void calculateSingle(double op1, String operation) {
        switch (operation) {
            case "sqrt": result = (op1 < 0) ? Double.NaN : Math.sqrt(op1); break;
            case "sqr": result = op1 * op1; break;
        }
        setChanged();
        notifyObservers(result);
    }

    public void memoryAdd(double value) {
        if (!Double.isNaN(result)) {
            memory = (memory == null) ? value : memory + value;
        }
    }

    public void memorySubtract(double value) {
        if (memory != null) {
            memory -= value;
        }
    }

    public Double memoryRecall() {
        if (!Double.isNaN(memory)) {
            System.out.println("Memory Recall is Null");
            System.out.println(memory);
        }
            return memory;

    }

    public void memoryClear() {
        memory = null;
    }

    public double getResult() {
        return result;
    }
}