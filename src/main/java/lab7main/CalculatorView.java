package main.java.lab7main;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class CalculatorView extends JFrame implements Observer {
    JTextField screen = new JTextField();
    JPanel buttonPanel = new JPanel(new GridLayout(6, 4));
    String[] buttons = {
        "7", "8", "9", "/",
        "4", "5", "6", "*",
        "1", "2", "3", "-",
        "0", ".", "=", "+",
        "sqr", "sqrt", "Del", "C",
        "M+", "M-", "MR", "MC"
    };
    JButton[] btn = new JButton[buttons.length];

    public CalculatorView() {
        setTitle("Scientific Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        screen.setEditable(false);
        screen.setFont(new Font("Arial", Font.BOLD, 24));
        add(screen, BorderLayout.NORTH);

        for (int i = 0; i < buttons.length; i++) {
            btn[i] = new JButton(buttons[i]);
            btn[i].setFont(new Font("Arial", Font.BOLD, 18));
            btn[i].setName("btn_" + buttons[i]);
            buttonPanel.add(btn[i]);
        }

        add(buttonPanel);
        setVisible(true);
    }

    public void update(Observable o, Object arg) {
        double res = (Double) arg;
        screen.setText(Double.isNaN(res) ? "Error" : String.valueOf(res));
    }
}