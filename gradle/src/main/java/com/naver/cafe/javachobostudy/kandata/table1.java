package com.naver.cafe.javachobostudy.kandata;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import javax.swing.table.TableColumn;

public class table1 extends JFrame {

    ////////안되는 부분
    public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
        Component c = super.prepareRenderer(renderer, row, col);
        String status = (String)getValueAt(row,0);
        if ("고양이".equals("종류")) {
            c.setBackground(Color.BLACK);
            c.setForeground(Color.WHITE);
        } else {
            c.setBackground(super.getBackground());
            c.setForeground(super.getForeground());
        }
        return c;
    }
    ///////////

    JPanel p1;
    JTable tb;
    JScrollPane sc;
    Icon icon;

    Vector<String> columnNames = new Vector<String>(3);
    Vector rowData;
    DefaultTableModel TableModel;

    public void addToRowDataTeam(String s1, String s2, String s3) {
        if (columnNames.size() == 0) {
            columnNames.add("사진");
            columnNames.add("이름");
            columnNames.add("종류");
            TableModel = new DefaultTableModel(columnNames, 0) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
        }
        rowData = new Vector();
        s1 = "test1/cat.png";
        s2 = "냥냥";
        s3 = "고양이";

        rowData = new Vector();
        ImageIcon imageI = new ImageIcon(s1, "image");
        Image image = imageI.getImage();
        Image image2 = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        ImageIcon imageI2 = new ImageIcon(image2);
        rowData.addElement(imageI2);
        rowData.addElement(s2);
        rowData.addElement(s3);

        TableModel.addRow(rowData);
        tb.setModel(TableModel);
        tb.getTableHeader().setReorderingAllowed(false);
        tb.setSelectionMode(1);

        ////////////안되는 부분
        Enumeration<TableColumn> en = tb.getColumnModel().getColumns();
        while (en.hasMoreElements()) {
            TableColumn tc = en.nextElement();
            tc.setCellRenderer();(new MyTableCellRenderer());
        ///////////
        }
    }

    public table1() {
        p1 = new JPanel();
        tb = new JTable();
        sc = new JScrollPane(tb);
        tb.setRowHeight(70);
        p1.setBounds(0, 0, 200, 200);
        p1.setLayout(new BorderLayout());
        p1.setBackground(Color.white);
        add(p1);
        p1.add(sc);
        setVisible(true);
        validate();
    }

    class TableModel extends DefaultTableModel {
        TableModel(Vector<String> columnNames, int rowNum) {
            super(columnNames, rowNum);
        }
        public Class getColumnClass(int col) {
            return getValueAt(0, col).getClass();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                table1 ts = new table1();
                ts.setSize(400, 400);
                ts.addToRowDataTeam("", "", "");
                ts.addToRowDataTeam("", "", "");
                ts.addToRowDataTeam("", "", "");
                ts.addToRowDataTeam("", "", "");

                ts.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            }
        });

    }
}
