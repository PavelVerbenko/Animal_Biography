package UsingMenuApplication;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class MyFrame extends JFrame implements ActionListener {
    private int state;
    private JPanel pnl;
    private Border bdr;
    private Color[] clr = new Color[10];
    private JButton btn;
    private JMenu content, view, program;
    private ImageIcon[] imgs;
    private String[] engNames = {"Fox", "Wolf", "Bear", "Raccoon", "Turtle", "Lion", "Monitor Lizard", "Elephant", "Rhinoceros", "Zebra", "Gorilla", "Giraffe"};
    private String[] cyrNames = {"Лиса", "Волк", "Медведь", "Енот", "Черепаха", "Лев", "Варан", "Слон", "Носорог", "Зебра", "Горилла", "Жираф"};
    private String[] files;
    private JLabel lbl;
    private JTextPane tp;
    private JMenuBar mb;
    private JMenuItem about, exit;
    private JMenuItem[]animals;
    private JCheckBoxMenuItem color;
    private JRadioButtonMenuItem Light, Dark, Ordinary, Pink, Blue, Green, Cyan, Red, Yellow, Orange, Gray;
    private JToolBar tb;
    private MyButton exitBin,  nextBtn, prevBtn, startBtn;
    private JPopupMenu pm;

    class MyButton extends JButton {
        MyButton(String txt) {
            super(new ImageIcon("C:\\Users\\dinky\\Downloads\\проект JavaCore\\buttons\\" + txt));
            setFocusPainted(false);
        }
    }

    private void setContent() {
        lbl.setIcon(imgs[state]);
        try {
            tp.setPage(files[state]);
        }
        catch (IOException err) {
            tp.setText("Информация недоступна");
        }
    }

    public void actionPerformed(ActionEvent e) {
        state = Integer.parseInt(((JMenuItem)e.getSource()).getActionCommand());
        setContent();
    }

    MyFrame() {
        super("Окно с панелью меню");
        setBounds(250, 250, 350, 230);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        state = 0;
        bdr = BorderFactory.createEtchedBorder();
        clr[0] = getBackground();
        clr[1] = Color.WHITE;
        clr[2] = Color.DARK_GRAY;
        clr[3] = Color.PINK;
        clr[4] = Color.BLUE;
        clr[5] = Color.GREEN;
        clr[6] = Color.CYAN;
        clr[7] = Color.RED;
        clr[8] = Color.YELLOW;
        clr[9] = Color.ORANGE;
        clr[10] = Color.GRAY;

        imgs = new ImageIcon[engNames.length];
        files = new String[engNames.length];
        animals = new JMenuItem[cyrNames.length];

        for (int k = 0; k < engNames.length; k++) {
            imgs[k] = new ImageIcon("C:\\Users\\dinky\\Downloads\\проект JavaCore\\animal\\" + engNames[k] + "jpg");
            files[k] = "C:\\Users\\dinky\\Downloads\\проект JavaCore\\animal\\" + engNames[k] + ".txt";  //разобрать тут
            Image img = imgs[k].getImage();
            Image scaledImg = img.getScaledInstance(150, 100, Image.SCALE_DEFAULT);
            imgs[k] = new ImageIcon(scaledImg);
        }

        tb = new JToolBar("Панель меню");
        exitBtn = new MyButton("exit.png");
        exitBin.setToolTipText("Завершение работы");
    }
}


class UsingMenuDemo {
}
