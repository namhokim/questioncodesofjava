package com.naver.cafe.javachobostudy.dyrhl456;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class Calculator extends JFrame implements ActionListener {
    private JTextArea displayInputArea = new JTextArea(3, 25);
    private JTextArea displayResultArea = new JTextArea(1, 21);
    private JButton btnclear = new JButton("Clear");
    private JButton btnsum = new JButton("=");
    private JButton btnadd = new JButton("+");
    private JButton btnsub = new JButton("-");
    private JButton btnmul = new JButton("*");
    private JButton btndiv = new JButton("/");
    private JButton btn0 = new JButton("0");
    private JButton btn1 = new JButton("1");
    private JButton btn2 = new JButton("2");
    private JButton btn3 = new JButton("3");
    private JButton btn4 = new JButton("4");
    private JButton btn5 = new JButton("5");
    private JButton btn6 = new JButton("6");
    private JButton btn7 = new JButton("7");
    private JButton btn8 = new JButton("8");
    private JButton btn9 = new JButton("9");

    private StringBuilder number1 = new StringBuilder();
    private char operator = ' ';
    private StringBuilder number2 = new StringBuilder();

    public Calculator(String title) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 275);
        setTitle(title);
        setLayout();
        setVisible(true);
    }

    public void setLayout() {
        setLayout(new BorderLayout());
        JPanel Top = new JPanel();

        Top.add(displayInputArea);

        JPanel Center = new JPanel();
        displayResultArea.setBackground(Color.CYAN);
        Center.add(new JLabel("연 산 결 과 "), "West");
        Center.add(displayResultArea, "East");

        JPanel Bottom = new JPanel();
        Bottom.setLayout(new BorderLayout());
        JPanel btnT = new JPanel();
        btnT.setLayout(new GridLayout(1, 2));
        btnT.add(btnclear);
        btnT.add(btnsum);

        JPanel btnC = new JPanel();
        btnC.setLayout(new BorderLayout());
        JPanel btnC1 = new JPanel();
        btnC1.setLayout(new GridLayout(3, 3));
        btnC1.add(btn1);
        btnC1.add(btn2);
        btnC1.add(btn3);
        btnC1.add(btn4);
        btnC1.add(btn5);
        btnC1.add(btn6);
        btnC1.add(btn7);
        btnC1.add(btn8);
        btnC1.add(btn9);
        btnC.add(btnC1, "North");
        JPanel btnC2 = new JPanel();
        btnC2.setLayout(new GridLayout(0, 1));
        btnC2.add(btn0);
        btnC.add(btnC2, "South");

        JPanel btnR = new JPanel();
        btnR.setLayout(new GridLayout(4, 1));
        btnR.add(btnadd);
        btnR.add(btnsub);
        btnR.add(btnmul);
        btnR.add(btndiv);

        Bottom.add(btnT, "North");
        Bottom.add(btnC, "Center");
        Bottom.add(btnR, "East");

        add(Top, "North");
        add(Center, "Center");
        add(Bottom, "South");

        btnclear.addActionListener(this);
        btnsum.addActionListener(this);
        btnadd.addActionListener(this);
        btnsub.addActionListener(this);
        btnmul.addActionListener(this);
        btndiv.addActionListener(this);
        btn0.addActionListener(this);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String value = evt.getActionCommand();
        if (value.matches("[0-9]")) {
            appendNumber(value);
        } else if (value.matches("[+/*\\-]")) {
            setOperator(value);
        } else if (value.equals("Clear")) {
            clear();
        } else if (value.equals("=")) {
            evaluate();
        }
        refreshDisplayPad();
    }

    private void appendNumber(String value) {
        if (operator != ' ') {
            number1.append(value);
        } else {
            number2.append(value);
        }
    }

    private void setOperator(String value) {
        operator = value.charAt(0);
    }

    private void clear() {
        number1.setLength(0);
        operator = ' ';
        number2.setLength(0);
    }

    private void evaluate() {
        BigDecimal bigDecimal1 = new BigDecimal(number1.toString());
        BigDecimal bigDecimal2 = new BigDecimal(number2.toString());
        BigDecimal result;
        switch (operator) {
            case '+':
                result = bigDecimal1.add(bigDecimal2);
                break;
            case '-':
                result = bigDecimal1.subtract(bigDecimal2);
                break;
            case '*':
                result = bigDecimal1.multiply(bigDecimal2);
                break;
            case '/':
                result = bigDecimal1.divide(bigDecimal2, BigDecimal.ROUND_UNNECESSARY);
                break;
            default:
                result = new BigDecimal(0);
        }
        clear();
        displayResultArea.setText(result.toString());
    }

    private void refreshDisplayPad() {
        final String displayText = String.format("%s%n%c%n%s", number2.toString(), operator, number1.toString());
        displayInputArea.setText(displayText);
    }

    public static void main(String[] args) {
        new Calculator("계산기");
    }
}
