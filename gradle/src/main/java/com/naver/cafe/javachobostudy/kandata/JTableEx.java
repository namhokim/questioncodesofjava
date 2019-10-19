package com.naver.cafe.javachobostudy.kandata;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.Vector;

public class JTableEx extends JFrame {
    private static final int COLUMN_SIZE = 3;
    private static final int INDEX_OF_TYPE_COLUMN = 2;

    private JTable table;
    private DefaultTableModel tableModel;

    private JTableEx() {
        super();
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 200, 200);
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.white);

        table = new JTable() {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
                Component component = super.prepareRenderer(renderer, row, col);
                Object column = getValueAt(row, INDEX_OF_TYPE_COLUMN);
                if (column instanceof String) {
                    String type = (String) column;
                    if (type.equals("고양이")) {
                        component.setBackground(Color.BLACK);
                        component.setForeground(Color.WHITE);
                    } else {
                        component.setBackground(super.getBackground());
                        component.setForeground(super.getForeground());
                    }
                }
                return component;
            }
        };
        table.setRowHeight(70);
        panel.add(new JScrollPane(table));

        add(panel);
        setVisible(true);
        validate();
    }

    private void initializeColumn() {
        Vector<String> columnNames = new Vector<>(COLUMN_SIZE);
        columnNames.add("사진");
        columnNames.add("이름");
        columnNames.add("종류");
        tableModel = new DefaultTableModel(columnNames, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            public Class getColumnClass(int col) {
                return getValueAt(0, col).getClass();
            }
        };
    }

    private void addRowData(String imagePath, String name, String type) {
        Vector<Object> row = new Vector<>();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imagePath).getImage()
                .getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        row.addElement(imageIcon);
        row.addElement(name);
        row.addElement(type);

        tableModel.addRow(row);
        table.setModel(tableModel);
        table.getTableHeader().setReorderingAllowed(false);
        table.setSelectionMode(1);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JTableEx tableEx = new JTableEx();
                tableEx.setSize(400, 400);
                tableEx.initializeColumn();

                String image = "test1/cat.png";

                tableEx.addRowData(image, "야옹이", "고양이");
                tableEx.addRowData(image, "고냥이", "고양이");
                tableEx.addRowData(image, "수호랑", "호랑이");
                tableEx.addRowData(image, "개냥이", "고양이");

                tableEx.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            }
        });

    }
}
