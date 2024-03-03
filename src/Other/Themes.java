package Other;

import java.awt.BorderLayout;

import default_main.*;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Themes extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();

    public static void main(String[] args) {
        try {
            Themes dialog = new Themes();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Themes() {
        setModal(true);
        setResizable(false);
        setTitle("// Темы \r\n");
        setBounds(100, 100, 187, 398);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(192, 192, 192));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        // по центру
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - getWidth()) / 2,
                (screenSize.height - getHeight()) / 2,
                getWidth(), getHeight());

        // включить черную тему
        JButton theme_black = new JButton("");
        theme_black.setBackground(new Color(65, 65, 65));
        theme_black.setBounds(138, 325, 23, 23);
        theme_black.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                MainFrame.colorSet(new Color(65, 65, 65));
            }
        });
        contentPanel.add(theme_black);

        // включить фиолетовую тему
        JButton theme_violet = new JButton("");
        theme_violet.setBackground(new Color(176, 81, 255));
        theme_violet.setBounds(138, 291, 23, 23);
        theme_violet.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                MainFrame.colorSet(new Color(176, 81, 255));
            }
        });
        contentPanel.add(theme_violet);

        // включить синию тему
        JButton theme_blue = new JButton("");
        theme_blue.setBackground(new Color(79, 101, 255));
        theme_blue.setBounds(138, 257, 23, 23);
        theme_blue.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                MainFrame.colorSet(new Color(79, 101, 255));
            }
        });
        contentPanel.add(theme_blue);

        // включить светл. синию  тему
        JButton theme_light_blue = new JButton("");
        theme_light_blue.setBackground(new Color(150, 235, 231));
        theme_light_blue.setBounds(138, 223, 23, 23);
        theme_light_blue.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                MainFrame.colorSet(new Color(150, 235, 231));
            }
        });
        contentPanel.add(theme_light_blue);

        // включить зеленую тему
        JButton theme_green = new JButton("");
        theme_green.setBackground(new Color(0, 128, 128));
        theme_green.setBounds(138, 189, 23, 23);
        theme_green.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                MainFrame.colorSet(new Color(255,128,128));
            }
        });
        contentPanel.add(theme_green);

        // включить светл. зеленую  тему
        JButton theme_light_green = new JButton("");
        theme_light_green.setBackground(new Color(124, 252, 124));
        theme_light_green.setBounds(138, 155, 23, 23);
        theme_light_green.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                MainFrame.colorSet(new Color(124, 252, 124));
            }
        });
        contentPanel.add(theme_light_green);

        // включить желтую тему
        JButton theme_yellow = new JButton("");
        theme_yellow.setBackground(new Color(255, 252, 121));
        theme_yellow.setBounds(138, 121, 23, 23);
        theme_yellow.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                MainFrame.colorSet(new Color(255, 252, 121));
            }
        });
        contentPanel.add(theme_yellow);

        // включить оранжевую  тему
        JButton  theme_orange = new JButton("");
        theme_orange.setBackground(new Color(253, 182, 96));
        theme_orange.setBounds(138, 87, 23, 23);
        theme_orange.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                MainFrame.colorSet(new Color(253, 182, 96));
            }
        });
        contentPanel.add(theme_orange);

        // включить красную тему
        JButton theme_red = new JButton("");
        theme_red.setBackground(new Color(255, 119, 119));
        theme_red.setBounds(138, 53, 23, 23);
        theme_red.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                MainFrame.colorSet(new Color(255, 119, 119));
            }
        });
        contentPanel.add(theme_red);

        // включить дефолтную тему
        JButton theme_default = new JButton("");
        theme_default.setBackground(Color.WHITE);
        theme_default.setBounds(138, 19, 23, 23);
        theme_default.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                MainFrame.colorSet(new Color(16, 179, 214));
            }
        });
        contentPanel.add(theme_default);

        JTextPane textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textPane.setText("черный\r\n");
        textPane.setBounds(10, 328, 118, 20);
        contentPanel.add(textPane);

        JTextPane textPane_1 = new JTextPane();
        textPane_1.setEditable(false);
        textPane_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textPane_1.setText("фиолетовый\r\n");
        textPane_1.setBounds(10, 294, 118, 20);
        contentPanel.add(textPane_1);

        JTextPane textPane_2 = new JTextPane();
        textPane_2.setEditable(false);
        textPane_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textPane_2.setText("синий\r\n");
        textPane_2.setBounds(10, 260, 118, 20);
        contentPanel.add(textPane_2);

        JTextPane textPane_3 = new JTextPane();
        textPane_3.setEditable(false);
        textPane_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textPane_3.setText("голубой");
        textPane_3.setBounds(10, 226, 118, 20);
        contentPanel.add(textPane_3);

        JTextPane textPane_4 = new JTextPane();
        textPane_4.setEditable(false);
        textPane_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textPane_4.setText("зеленый\r\n");
        textPane_4.setBounds(10, 192, 118, 20);
        contentPanel.add(textPane_4);

        JTextPane textPane_5 = new JTextPane();
        textPane_5.setEditable(false);
        textPane_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textPane_5.setText("свет.зеленый");
        textPane_5.setBounds(10, 158, 118, 20);
        contentPanel.add(textPane_5);

        JTextPane textPane_6 = new JTextPane();
        textPane_6.setEditable(false);
        textPane_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textPane_6.setText("желтый \r\n");
        textPane_6.setBounds(10, 124, 118, 20);
        contentPanel.add(textPane_6);

        JTextPane textPane_7 = new JTextPane();
        textPane_7.setEditable(false);
        textPane_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textPane_7.setText("оранжевый \r\n");
        textPane_7.setBounds(10, 90, 118, 20);
        contentPanel.add(textPane_7);

        JTextPane textPane_8 = new JTextPane();
        textPane_8.setEditable(false);
        textPane_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textPane_8.setText("красный ");
        textPane_8.setBounds(10, 56, 118, 20);
        contentPanel.add(textPane_8);

        JTextPane textPane_9 = new JTextPane();
        textPane_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textPane_9.setText("по умолчанию ");
        textPane_9.setEditable(false);
        textPane_9.setBounds(10, 22, 118, 20);
        contentPanel.add(textPane_9);
    }
}
