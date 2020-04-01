package com.naver.cafe.javachobostudy.top1604;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;

@SuppressWarnings("unchecked")
public class Manager extends JFrame implements ActionListener {

    String[] departments = {"컴퓨터공학부", "전자공학과", "기계공학과", "건축공학과", "간호학과",
            "재료공학과", "경영학과", "일어일문학과", "산업경영공학과", "체육학과", "교육학과"};

    Object[][] students = {
            {"컴퓨터공학부", "1학년", "홍길동", "학부생", "111111"},
            {"컴퓨터공학부", "4학년", "김철수", "학부생", "123467"},
            {"컴퓨터공학부", "4학년", "이병헌", "학부생", "100011"},
            {"컴퓨터공학부", "2학년", "푸하하", "학부생", "145361"},
            {"컴퓨터공학부", "1학년", "하하하", "학부생", "111551"},
            {"컴퓨터공학부", "1학년", "강호동", "학부생", "123111"},
            {"컴퓨터공학부", "3학년", "이수근", "학부생", "165101"},
            {"컴퓨터공학부", "1학년", "서장훈", "학부생", "133411"},
            {"전자공학과", "1학년", "홍길동", "학부생", "111111"},
            {"전자공학과", "1학년", "김철수", "학부생", "123467"},
            {"전자공학과", "4학년", "이병헌", "학부생", "100011"},
            {"전자공학과", "4학년", "푸하하", "학부생", "145361"},
            {"전자공학과", "1학년", "하하하", "학부생", "111551"},
            {"전자공학과", "2학년", "강호동", "학부생", "123111"},
            {"전자공학과", "1학년", "이수근", "대학원생", "165101"},
            {"전자공학과", "3학년", "서장훈", "대학원생", "133411"}
    };

    //이벤트 리스너 필드
    MyMultiListener ml = new MyMultiListener();

    //메뉴용 필드
    JMenuBar mb = new JMenuBar();
    JMenu homeMenu = new JMenu("HOME");
    JMenu etcMenu = new JMenu("Etc");
    JMenuItem newMI = new JMenuItem("NEW");
    JMenuItem openMI = new JMenuItem("OPEN");
    JMenuItem exitMI = new JMenuItem("EXIT");


    //영역용 패널
    JPanel NewManagerContainer = new JPanel();
    JPanel basePanel = new JPanel(new BorderLayout());
    JPanel westPanel = new JPanel(new FlowLayout());
    JPanel centerPanel = new JPanel(new BorderLayout());


    //웨스트 패널용 컴포넌트  선언 (2019.09.25)
    JLabel titleLabel = new JLabel("Select Student Type");
    JCheckBox usCheck = new JCheckBox("학부생");
    JCheckBox gsCheck = new JCheckBox("대학원생");
    JComboBox comboBox;
    JTree tree;
    JButton exitBtn = new JButton("EXIT");
    JButton openBtn = new JButton("OPEN");
    DefaultMutableTreeNode root;
    DefaultTreeModel treeModel;
    JLabel imageLabel = new JLabel();

    //센터 패널용 컴포넌트 선언
    DefaultTableModel tableModel;
    JTable table;
    String columnNames[] = {"학과명", "학년", "이름", "구분", "학번"};

    Manager() {
        setTitle("학생관리프로그램_2016244097 박민석");
        setSize(900, 300);
        setVisible(true);

        ///////////////////////////////////////////////////////////////////////

        //메뉴바 작업
        setJMenuBar(mb);
        homeMenu.add(newMI);
        homeMenu.addSeparator();
        homeMenu.add(openMI);
        homeMenu.addSeparator(); // 분리선을 생기게 해주는 메소드
        homeMenu.add(exitMI);
        mb.add(homeMenu);
        mb.add(etcMenu);

        //패널 작업
        westPanel.setBackground(Color.WHITE);
        centerPanel.setBackground(Color.YELLOW);
        westPanel.setPreferredSize(new Dimension(160, basePanel.getHeight())); // 컴포넌트 westsize 사이즈 조정하는 메소드
        setContentPane(basePanel);
        basePanel.add(westPanel, BorderLayout.WEST);
        basePanel.add(centerPanel, BorderLayout.CENTER);

        //웨스트패널 컴포넌트 작업용
        comboBox = new JComboBox(departments);
        root = new DefaultMutableTreeNode("학과");
        tree = new JTree(root);

        titleLabel.setPreferredSize(new Dimension(160, 20));

        //usCheck.setPreferredSize(new Dimension(160, 20));
        //gsCheck.setPreferredSize(new Dimension(160, 20));
        comboBox.setPreferredSize(new Dimension(160, 20));
        exitBtn.setPreferredSize(new Dimension(160, 20));
        tree.setPreferredSize(new Dimension(160, 100));

        westPanel.add(titleLabel);
        westPanel.add(usCheck);
        westPanel.add(gsCheck);
        westPanel.add(comboBox);
        westPanel.add(tree);
        westPanel.add(exitBtn);

        // 센터 패널 컴포넌트 작업용
        tableModel = new DefaultTableModel(students, columnNames);
        table = new JTable(tableModel);

        JScrollPane sc = new JScrollPane(table);
        centerPanel.add(sc, BorderLayout.CENTER);

        //리스너 추가 작업
        openMI.addActionListener(ml);
        exitMI.addActionListener(ml);
        exitBtn.addActionListener(ml);
        usCheck.addItemListener(ml);
        gsCheck.addItemListener(ml);
        comboBox.addActionListener(ml);
        tree.addTreeSelectionListener(ml);

        ///////////////////////////////////////////////////////////////////////
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    //파일 불러오기
    public class MyMultiListener implements ActionListener, ItemListener, TreeSelectionListener {
        JFileChooser chooser;

        MyMultiListener() {
            chooser = new JFileChooser();
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == exitMI) {
                System.exit(0);
            } else if (e.getSource() == exitBtn) {
                System.exit(0);
            } else if (e.getSource() == openMI) {
                //여기에 FIleCHooser를 이용해서 txt파일을 찾아오고 싶은데 아무리 검색해도 이해가 안되서요ㅠ
            } else if (e.getSource() == comboBox) {
                int i = comboBox.getSelectedIndex();
                System.out.println(departments[i] + "가 선택되어졌음");
                root = new DefaultMutableTreeNode(departments[i]);
                for (int j = 1; j <= 4; j++) {
                    DefaultMutableTreeNode node = new DefaultMutableTreeNode(j + "학년");
                    root.add(node);
                }
                treeModel = (DefaultTreeModel) tree.getModel();
                treeModel.setRoot(root);
            }
        }

        public void itemStateChanged(ItemEvent e) {
            if (e.getItem() == usCheck) {
                if (usCheck.isSelected()) {
                    tableModel = new DefaultTableModel(null, columnNames);
                    System.out.println("학부생이 선택되어졌음");
                }
            } else if (e.getItem() == gsCheck) {
                if (gsCheck.isSelected()) {
                    System.out.println("대학원생이 선택되어졌음");
                }
            }
        }

        public void valueChanged(TreeSelectionEvent e) {
            TreePath path = e.getPath();
            // System.out.println(path.toString());

            if (path.getLastPathComponent().toString().equals("1학년")) {
                tableModel = new DefaultTableModel(null, columnNames);
                for (int i = 0; i < students.length; i++) {
                    if (departments[comboBox.getSelectedIndex()].
                            equals(students[i][0].toString()) &&
                            path.getLastPathComponent().toString().
                                    equals(students[i][1].toString())) {
                        tableModel.addRow(students[i]);
                    }
                }
                table.setModel(tableModel);
            } else if (path.getLastPathComponent().toString().equals("2학년")) {
                tableModel = new DefaultTableModel(null, columnNames);
                for (int i = 0; i < students.length; i++) {
                    if (departments[comboBox.getSelectedIndex()].
                            equals(students[i][0].toString()) &&
                            path.getLastPathComponent().toString().
                                    equals(students[i][1].toString())) {
                        tableModel.addRow(students[i]);
                    }
                }
                table.setModel(tableModel);
            } else if (path.getLastPathComponent().toString().equals("3학년")) {
                tableModel = new DefaultTableModel(null, columnNames);
                for (int i = 0; i < students.length; i++) {
                    if (departments[comboBox.getSelectedIndex()].
                            equals(students[i][0].toString()) &&
                            path.getLastPathComponent().toString().
                                    equals(students[i][1].toString())) {
                        tableModel.addRow(students[i]);
                    }
                }
                table.setModel(tableModel);
            } else if (path.getLastPathComponent().toString().equals("4학년")) {
                tableModel = new DefaultTableModel(null, columnNames);
                for (int i = 0; i < students.length; i++) {
                    if (departments[comboBox.getSelectedIndex()].
                            equals(students[i][0].toString()) &&
                            path.getLastPathComponent().toString().
                                    equals(students[i][1].toString())) {
                        tableModel.addRow(students[i]);
                    }
                }
                table.setModel(tableModel);
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        new Manager();
    }
}
