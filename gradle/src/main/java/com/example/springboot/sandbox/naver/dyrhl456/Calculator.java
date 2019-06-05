package com.example.springboot.sandbox.naver.dyrhl456;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    public static final long serialVersionUID = 1L;

    JTextArea txt1 = new JTextArea(3,28);
    JTextArea txt2 = new JTextArea(1,21);
    JButton btnclear = new JButton("Clear");
    JButton btnsum = new JButton("=");
    JButton btnadd = new JButton("+");
    JButton btnsub = new JButton("-");
    JButton btnmul = new JButton("*");
    JButton btndiv = new JButton("/");
    JButton btn0 = new JButton("0");
    JButton btn1 = new JButton("1");
    JButton btn2 = new JButton("2");
    JButton btn3 = new JButton("3");
    JButton btn4 = new JButton("4");
    JButton btn5 = new JButton("5");
    JButton btn6 = new JButton("6");
    JButton btn7 = new JButton("7");
    JButton btn8 = new JButton("8");
    JButton btn9 = new JButton("9");
    static int x,y;
    String a,b="";
    int sum[] = new int[4];
    public static int cnt = 1;

    public Calculator(String title) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,275);
        setTitle(title);
        pad();
        setVisible(true);
    }

    public void pad() {
        setLayout(new BorderLayout());
        JPanel Top = new JPanel();

        Top.add(txt1);

        JPanel Center = new JPanel();
        txt2.setBackground(Color.CYAN);
        Center.add(new JLabel("연 산 결 과 "),"West");
        Center.add(txt2,"East");

        JPanel Bottom = new JPanel();
        Bottom.setLayout(new BorderLayout());
        JPanel btnT = new JPanel();
        btnT.setLayout(new GridLayout(1,2));
        btnT.add(btnclear); btnT.add(btnsum);

        JPanel btnC = new JPanel();
        btnC.setLayout(new BorderLayout());
        JPanel btnC1 = new JPanel();
        btnC1.setLayout(new GridLayout(3,3));
        btnC1.add(btn1); btnC1.add(btn2); btnC1.add(btn3);
        btnC1.add(btn4); btnC1.add(btn5); btnC1.add(btn6);
        btnC1.add(btn7); btnC1.add(btn8); btnC1.add(btn9);
        btnC.add(btnC1,"North");
        JPanel btnC2 = new JPanel();
        btnC2.setLayout(new GridLayout(0,1));
        btnC2.add(btn0);
        btnC.add(btnC2,"South");

        JPanel btnR = new JPanel();
        btnR.setLayout(new GridLayout(4,1));
        btnR.add(btnadd);
        btnR.add(btnsub);
        btnR.add(btnmul);
        btnR.add(btndiv);

        Bottom.add(btnT,"North");
        Bottom.add(btnC,"Center");
        Bottom.add(btnR,"East");

        add(Top,"North");
        add(Center,"Center");
        add(Bottom,"South");

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

    public void actionPerformed(ActionEvent evt) {
        String value = evt.getActionCommand();
        if(value.equals("Clear")) {
            txt1.setText("");
            txt2.setText("");
        }

        else {
            txt1.append(value);

            if(value.equals("0")|value.equals("1")|value.equals("2")
                    |value.equals("3")|value.equals("4")|value.equals("5")
                    |value.equals("6")|value.equals("7")|value.equals("8")
                    |value.equals("9")) {

                if(cnt==1) {
                    a += value;
                    x = Integer.parseInt(a);
                }
                else if (cnt==2) {
                    b += value;
                    y = Integer.parseInt(b);
                }
            }


            if (x!=0 && y!=0) {
                if(sum[0] == 1) {
                    x += y;
                    cnt--;
                }
                else if(sum[1] == 1) {
                    x -= y;
                    cnt--;
                }
                else if(sum[2] == 1) {
                    x *= y;
                    cnt--;
                }
                else if(sum[3] == 1) {
                    x /= y;
                    cnt--;
                }
                sum[0] = 0;
                sum[1] = 0;
                sum[2] = 0;
                sum[3] = 0;
            }
        }

        switch(value) {
            case "+" :
                sum[0] = 1;
                sum[1] = 0;
                sum[2] = 0;
                sum[3] = 0;
                cnt++;
                break;
            case "-" :
                sum[0] = 0;
                sum[1] = 1;
                sum[2] = 0;
                sum[3] = 0;
                cnt++;
                break;
            case "*" :
                sum[0] = 0;
                sum[1] = 0;
                sum[2] = 1;
                sum[3] = 0;
                cnt++;
                break;
            case "/" :
                sum[0] = 0;
                sum[1] = 0;
                sum[2] = 0;
                sum[3] = 1;
                cnt++;
                break;
            case "=" :
                y=0;
                txt2.setText(x+"");
                break;
            case "clear" :
                x=0;
                y=0;
                break;
        }
    }

    public static void main(String[] args) {
        Calculator cal = new Calculator("계산기");
    }
}
