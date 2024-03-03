package default_main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Other.*;
import TypeDirectory.*;
import TypeFile.*;
import SameFunction.*;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class MainFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private static JPanel contentPaneMainFrame;


    // метод изменения цвета бекграунда MainFrame
    public static  void colorSet(Color color) {
        try {
            contentPaneMainFrame.setBackground(color);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame frame = new MainFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 648, 229);
        contentPaneMainFrame = new JPanel();
        contentPaneMainFrame.setBackground(new Color(16, 179, 214));
        contentPaneMainFrame.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPaneMainFrame);
        contentPaneMainFrame.setLayout(null);

        // по центру
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - getWidth()) / 2,
                (screenSize.height - getHeight()) / 2,
                getWidth(), getHeight());

        // --- прочие функции ---
        JPanel panel_other = new JPanel();
        panel_other.setBorder(new TitledBorder(null,
                "\u041F\u0440\u043E\u0447\u0435\u0435",
                TitledBorder.LEADING,
                TitledBorder.TOP,
                null,
                null));

        panel_other.setBounds(475, 11, 145, 168);
        contentPaneMainFrame.add(panel_other);
        panel_other.setLayout(null);

        // Темы беграунда
        JButton btnNewButton_15 = new JButton("Theme");
        btnNewButton_15.setBackground(new Color(192, 192, 192));
        btnNewButton_15.setBounds(10, 20, 125, 39);
        panel_other.add(btnNewButton_15);
        btnNewButton_15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Themes p3b3 = new Themes();
                    p3b3.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    p3b3.setVisible(true);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        // мини игра
        JButton btnNewButton_14 = new JButton("Mini Game\r\n");
        btnNewButton_14.setBackground(new Color(192, 192, 192));
        btnNewButton_14.setBounds(10, 71, 125, 39);
        panel_other.add(btnNewButton_14);
        btnNewButton_14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Arithmetic p3b2 = new Arithmetic();
                    p3b2.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    p3b2.setVisible(true);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        // о проекте
        JButton btnNewButton_13 = new JButton("The project");
        btnNewButton_13.setBackground(new Color(192, 192, 192));
        btnNewButton_13.setBounds(10, 122, 125, 39);
        panel_other.add(btnNewButton_13);
        btnNewButton_13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    myProfile p3b1 = new myProfile();
                    p3b1.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    p3b1.setVisible(true);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        // --- панель общих функций ---
        JPanel panel_same = new JPanel();
        panel_same.setBorder(new TitledBorder(null,
                "\u041E\u0431\u0449\u0435\u0435",
                TitledBorder.LEADING,
                TitledBorder.TOP,
                null,
                null));

        panel_same.setBounds(320, 11, 145, 168);
        contentPaneMainFrame.add(panel_same);
        panel_same.setLayout(null);

        // переместить файл\каталог
        JButton btnNewButton_2 = new JButton("Move F\\D\r\n");
        btnNewButton_2.setBackground(new Color(192, 192, 192));
        btnNewButton_2.setBounds(10, 20, 125, 39);
        panel_same.add(btnNewButton_2);
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    MoveFD p1b5 = new MoveFD();
                    p1b5.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    p1b5.setVisible(true);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        //  переименовать файл\каталог
        JButton btnNewButton_7 = new JButton("Rename F\\D");
        btnNewButton_7.setBackground(new Color(192, 192, 192));
        btnNewButton_7.setBounds(10, 71, 125, 39);
        panel_same.add(btnNewButton_7);
        btnNewButton_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    RenameFD p1b4 = new RenameFD();
                    p1b4.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    p1b4.setVisible(true);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        // удалить файл\каталог
        JButton btnNewButton_9 = new JButton("Delete F\\D\r\n");
        btnNewButton_9.setBackground(new Color(192, 192, 192));
        btnNewButton_9.setBounds(10, 122, 125, 39);
        panel_same.add(btnNewButton_9);
        btnNewButton_9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    DeleteFD p1b6 = new DeleteFD();
                    p1b6.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    p1b6.setVisible(true);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        // --- панель функций каталога ---
        JPanel panel_dir = new JPanel();
        panel_dir.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED,
                new Color(255, 255, 255),
                new Color(160, 160, 160)),
                "\u041A\u0430\u0442\u0430\u043B\u043E\u0433\u0438",
                TitledBorder.LEADING,
                TitledBorder.TOP,
                null,
                new Color(0, 0, 0)));

        panel_dir.setBounds(165, 11, 145, 168);
        contentPaneMainFrame.add(panel_dir);
        panel_dir.setLayout(null);

        // создать каталог
        JButton btnNewButton_3 = new JButton("Create Dir.");
        btnNewButton_3.setBackground(new Color(192, 192, 192));
        btnNewButton_3.setBounds(10, 20, 125, 39);
        panel_dir.add(btnNewButton_3);
        btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    CreateDirectory p2b1 = new CreateDirectory();
                    p2b1.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    p2b1.setVisible(true);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        // лист всех внутри.файлов
        JButton btnNewButton_5 = new JButton("ListInDir");
        btnNewButton_5.setBackground(new Color(192, 192, 192));
        btnNewButton_5.setBounds(10, 71, 125, 39);
        panel_dir.add(btnNewButton_5);
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    ListDirectory p2b2 = new ListDirectory();
                    p2b2.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    p2b2.setVisible(true);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        // настройки каталога
        JButton btnNewButton_12 = new JButton("SettingsDir");
        btnNewButton_12.setBackground(new Color(192, 192, 192));
        btnNewButton_12.setBounds(10, 122, 125, 39);
        panel_dir.add(btnNewButton_12);
        btnNewButton_12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    SettingsDirectory p2b3 = new SettingsDirectory();
                    p2b3.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    p2b3.setVisible(true);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        // --- панель функций файла ---
        JPanel panel_file = new JPanel();
        panel_file.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED,
                new Color(255, 255, 255),
                new Color(160, 160, 160)),
                "\u0424\u0430\u0439\u043B\u044B",
                TitledBorder.LEADING,
                TitledBorder.TOP,
                null,
                new Color(0, 0, 0)));

        panel_file.setBounds(10, 11, 145, 168);
        contentPaneMainFrame.add(panel_file);
        panel_file.setLayout(null);

        // создать файл
        JButton btnNewButton_1 = new JButton("Create File");
        btnNewButton_1.setBackground(new Color(192, 192, 192));
        btnNewButton_1.setBounds(10, 20, 125, 39);
        panel_file.add(btnNewButton_1);
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    CreateFile p1b1 = new CreateFile();
                    p1b1.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    p1b1.setVisible(true);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        // запись в файл\чтение в файл
        JButton btnNewButton_6 = new JButton("Record\\read\r\n");
        btnNewButton_6.setBackground(new Color(192, 192, 192));
        btnNewButton_6.setBounds(10, 71, 125, 39);
        panel_file.add(btnNewButton_6);
        btnNewButton_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    RecordReadFile p1b2 = new RecordReadFile();
                    p1b2.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    p1b2.setVisible(true);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        // настройки файла
        JButton btnNewButton_11 = new JButton("SettingsFile");
        btnNewButton_11.setBackground(new Color(192, 192, 192));
        btnNewButton_11.setBounds(10, 122, 125, 39);
        panel_file.add(btnNewButton_11);
        btnNewButton_11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    SettingsFile p1b3 = new SettingsFile();
                    p1b3.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    p1b3.setVisible(true);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}