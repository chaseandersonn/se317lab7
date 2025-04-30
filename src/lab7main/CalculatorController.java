package lab7main;

import java.awt.event.*;

import javax.swing.JButton;

class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;
    private String input = "";
    private String currentOp = "";
    private double firstOperand;
    private boolean awaitingSecond = false;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;

        model.addObserver(view);

        for (JButton b : view.btn) {
            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String cmd = b.getText();
                    handleInput(cmd);
                }
            });
        }
    }

    private void handleInput(String cmd) {
        switch (cmd) {
            case "+": case "-": case "*": case "/":
                if (!input.isEmpty()) {
                    firstOperand = Double.parseDouble(input);
                    currentOp = cmd;
                    awaitingSecond = true;
                }
                break;
            case "=":
                if (!input.isEmpty() && !currentOp.isEmpty()) {
                    double secondOperand = Double.parseDouble(input);
                    model.calculate(firstOperand, secondOperand, currentOp);
                    input = String.valueOf(model.getResult());
                    currentOp = "";
                    awaitingSecond = false;
                }
                break;
            case "sqrt": case "sqr":
                if (!input.isEmpty()) {
                    double val = Double.parseDouble(input);
                    model.calculateSingle(val, cmd);
                    input = String.valueOf(model.getResult());
                }
                break;
            case "M+":
                try { model.memoryAdd(Double.parseDouble(view.screen.getText())); }
                catch (Exception e) { view.screen.setText("Error"); }
                break;
            case "M-":
                try { model.memorySubtract(Double.parseDouble(view.screen.getText())); }
                catch (Exception e) { view.screen.setText("Error"); }
                break;
            case "MR":
                Double mem = model.memoryRecall();
                if (mem != null) input = String.valueOf(mem);
                view.screen.setText(input);
                break;
            case "MC":
                model.memoryClear();
                break;
            case "Del":
                if (!input.isEmpty()) {
                    input = input.substring(0, input.length() - 1);
                    view.screen.setText(input);
                }
                break;
            case "C":
                input = ""; currentOp = ""; awaitingSecond = false;
                view.screen.setText("");
                model.memoryClear();
                break;
            default: // Digits and decimal
                if (awaitingSecond) { input = ""; awaitingSecond = false; }
                input += cmd;
                view.screen.setText(input);
        }
    }
}