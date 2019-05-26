package naver.rudflrudfl45;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Calculator extends Frame implements ActionListener {
    private Dimension dimen, dimenOne;
    private int xpos, ypos, cnt = 0, cnt_p;
    private double result;
    private String imsi = "", imsi2 = "",
            imsi3 = "", flag = "", all = "", flag2 = "";
    private String[] bt_num =
            {"7", "8", "9", "/", "4", "5",
                    "6", "*", "1", "2", "3",
                    "-", "0", "+/-", ".", "+"};

    //"0"==12번 원소
    private String[] string;
    private Button[] bt = new Button[bt_num.length];

    private TextField tf = new TextField("0.");

    private Button bt_result = new Button("   =   ");
    private Button bt_c = new Button("   C   ");


    public Calculator() {
        super("계산기");
        //this.init();
        //this.start();
        this.setSize(300, 250);
        dimen = Toolkit.getDefaultToolkit().getScreenSize();
        dimenOne = this.getSize();
        xpos = dimen.width / 2 - dimenOne.width / 2;
        ypos = dimen.height / 2 - dimenOne.height / 2;
        this.setLocation(xpos, ypos);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new Calculator();
    }
}