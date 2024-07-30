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
            super(new ImageIcon("C:\\Users\\dinky\\OneDrive\\Рабочий стол\\Java\\Java Core\\Уровень 9 Меню и панель инструментов\\Menu and toolbar\\src\\main\\java\\UsingMenuApplication\\img\\buttons\\" + txt));
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
            imgs[k] = new ImageIcon("C:\\Users\\dinky\\OneDrive\\Рабочий стол\\Java\\Java Core\\Уровень 9 Меню и панель инструментов\\Menu and toolbar\\src\\main\\java\\UsingMenuApplication\\img\\animal\\" + engNames[k] + "jpg");
            files[k] = "C:C:\\Users\\dinky\\OneDrive\\Рабочий стол\\Java\\Java Core\\Уровень 9 Меню и панель инструментов\\Menu and toolbar\\src\\main\\java\\UsingMenuApplication\\img\\animal\\" + engNames[k] + ".txt";  //разобрать тут
            Image img = imgs[k].getImage();
            Image scaledImg = img.getScaledInstance(150, 100, Image.SCALE_DEFAULT);
            imgs[k] = new ImageIcon(scaledImg);
        }

        tb = new JToolBar("Панель меню");
        exitBin = new MyButton("exit.png");
        exitBin.setToolTipText("Завершение работы");
        startBtn = new MyButton("start.png");
        startBtn.setToolTipText("Начальное изображение");
        prevBtn = new MyButton("prev.png");
        prevBtn.setToolTipText("Предыдущее изображение");
        nextBtn = new MyButton("next.png");
        nextBtn.setToolTipText("Следующее изображение");
        tb.add(exitBin);
        tb.add(startBtn);
        tb.add(prevBtn);
        tb.add(nextBtn);

        add(tb, BorderLayout.NORTH);

        pnl = new JPanel();
        pnl.setBorder(bdr);
        pnl.setLayout(new GridLayout(1, 2));
        lbl = new JLabel();
        lbl.setHorizontalAlignment(JLabel.CENTER);
        pnl.add(lbl);
        add(pnl, BorderLayout.CENTER);
        JScrollPane sp = new JScrollPane();
        tp = new JTextPane();
        tp.setEditable(false);
        sp.getViewport().add(tp);
        pnl.add(sp);
        btn = new JButton("OK");
        btn.setFocusPainted(false);
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1, 3));
        p.setBorder(bdr);
        p.add(new JPanel());
        p.add(btn);
        p.add(new JPanel());
        add(p, BorderLayout.SOUTH);

        mb = new JMenuBar();
        content = new JMenu();
        content = new JMenu("Содержимое");
        view = new JMenu("Вид");
        program = new JMenu("Программа");

        about = new JMenuItem("О программе");
        exit = new JMenuItem("Выход", exitBin.getIcon());
        program.add(about);
        program.addSeparator();
        program.add(exit);

        color = new JCheckBoxMenuItem("Цвет панели", true);

        Light = new JRadioButtonMenuItem("Светлый", false);
        Dark = new JRadioButtonMenuItem("Черный", false);
        Ordinary = new JRadioButtonMenuItem("Обычный", true);
        Pink = new JRadioButtonMenuItem("Розовый", false);
        Blue = new JRadioButtonMenuItem("Синий", false);
        Green = new JRadioButtonMenuItem("Зеленый", false);
        Cyan = new JRadioButtonMenuItem("Морской", false);
        Red = new JRadioButtonMenuItem("Красный", false);
        Yellow = new JRadioButtonMenuItem("Желтый", false);
        Orange = new JRadioButtonMenuItem("Оранжевый", false);
        Gray = new JRadioButtonMenuItem("Серый", false);

        ButtonGroup bg = new ButtonGroup();
        bg.add(Light);
        bg.add(Dark);
        bg.add(Ordinary);
        bg.add(Pink);
        bg.add(Blue);
        bg.add(Green);
        bg.add(Cyan);
        bg.add(Red);
        bg.add(Yellow);
        bg.add(Orange);
        bg.add(Gray);

        view.add(color);
        view.addSeparator();
        view.add(Light);
        view.add(Dark);
        view.add(Ordinary);
        view.add(Pink);
        view.add(Blue);
        view.add(Green);
        view.add(Cyan);
        view.add(Red);
        view.add(Yellow);
        view.add(Orange);
        view.add(Gray);

        for (int k = 0; k < animals.length; k++) {
            animals[k] = new JMenuItem(cyrNames[k]);
            animals[k].setActionCommand("" + k);
            animals[k].addActionListener(this);
            content.add(animals[k]);
        }
    }
}


class UsingMenuDemo {
}
