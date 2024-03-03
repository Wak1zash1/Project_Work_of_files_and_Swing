package Other;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Dimension;

public class Arithmetic extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();

    private int
            a = 0,
            b = 0,
            res = 0;
    private String input;
    Random rd = new Random();

    public static void main(String[] args) {
        try {
            Arithmetic dialog = new Arithmetic();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Arithmetic() {
        setModal(true);
        setResizable(false);
        setTitle("// Мини игра\r\n");
        setBounds(100, 100, 356, 145);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPanel.setLayout(null);

        // по центру
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - getWidth()) / 2,
                (screenSize.height - getHeight()) / 2,
                getWidth(), getHeight());

        JButton btnNewButton = new JButton("start\r\n");
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.setBounds(126, 80, 89, 23);
        contentPanel.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            // старт игры
            public void actionPerformed(ActionEvent e) {
                arif(rd.nextInt(5)); // вызов метода "арифметика"
            }
        });

        JTextPane textPane = new JTextPane();
        textPane.setText(" Эта мини игра - \"проверь свою арифметику\". Суть данной игры очень проста: правильно считать и записывать ответ.");
        textPane.setBackground(new Color(240, 240, 240));
        textPane.setBounds(10, 11, 336, 58);
        contentPanel.add(textPane);
    }

    // метод "арифметика"
    private void arif(int random) {

        switch (random) {

            // сложение
            case 1:

                a = rd.nextInt(100);
                b = rd.nextInt(100);
                res = a + b;

                // отображение примера
                input = JOptionPane.showInputDialog(
                        null,
                        a + " + " + b + " = ",
                        "Ввод данных",
                        JOptionPane.INFORMATION_MESSAGE);

                // если правильно
                if (Integer.parseInt(input) == res) {
                    JOptionPane.showConfirmDialog(
                            null,
                            res + " это правильный ответ ! ",
                            "Ответ ..",
                            JOptionPane.CANCEL_OPTION);

                    arif(rd.nextInt(5));

                    // иначе не правильно
                } else {
                    JOptionPane.showConfirmDialog(
                            null,
                            input + " это НЕ правильный ответ ! Правильный ответ = " + res,
                            "Ответ ..",
                            JOptionPane.CANCEL_OPTION);

                    arif(rd.nextInt(5));
                }
                break;

            // вычитание
            case 2:

                a = rd.nextInt(100);
                b = rd.nextInt(100);
                res = a - b;

                // отображение примера
                input = JOptionPane.showInputDialog(
                        null,
                        a + " - " + b + " = ",
                        "Ввод данных",
                        JOptionPane.INFORMATION_MESSAGE);

                // если правильно
                if (Integer.parseInt(input) == res) {
                    JOptionPane.showConfirmDialog(
                            null,
                            res + " это правильный ответ ! ",
                            "Ответ ..",
                            JOptionPane.CANCEL_OPTION);

                    arif(rd.nextInt(5));

                    // иначе не правильно
                } else {
                    JOptionPane.showConfirmDialog(
                            null,
                            input + " это НЕ правильный ответ ! Правильный ответ = " + res,
                            "Ответ ..",
                            JOptionPane.CANCEL_OPTION);

                    arif(rd.nextInt(5));
                }
                break;

            // умножение
            case 3:

                a = rd.nextInt(15);
                b = rd.nextInt(15);
                res = a * b;

                // отображение примера
                input = JOptionPane.showInputDialog(
                        null,
                        a + " * " + b + " = ",
                        "Ввод данных",
                        JOptionPane.INFORMATION_MESSAGE);

                // если правильно
                if (Integer.parseInt(input) == res) {
                    JOptionPane.showConfirmDialog(
                            null,
                            res + " это правильный ответ ! ",
                            "Ответ ..",
                            JOptionPane.CANCEL_OPTION);

                    arif(rd.nextInt(5));

                    // иначе не правильно
                } else {
                    JOptionPane.showConfirmDialog(
                            null,
                            input + " это НЕ правильный ответ ! Правильный ответ = " + res,
                            "Ответ ..",
                            JOptionPane.CANCEL_OPTION);

                    arif(rd.nextInt(5));
                }
                break;

            // деление
            case 4:

                a = rd.nextInt(100);
                b = rd.nextInt(10);
                res = a / b;

                // отображение примера
                input = JOptionPane.showInputDialog(
                        null,
                        a + " / " + b + " = ",
                        "Ввод данных",
                        JOptionPane.INFORMATION_MESSAGE);

                // если правильно
                if (Integer.parseInt(input) == res) {
                    JOptionPane.showConfirmDialog(
                            null,
                            input + " это правильный ответ ! ",
                            "Ответ ..",
                            JOptionPane.CANCEL_OPTION);

                    arif(rd.nextInt(5));

                    // иначе не правильно
                } else {
                    JOptionPane.showConfirmDialog(
                            null,
                            input + " это НЕ правильный ответ ! Правильный ответ = " + res,
                            "Ответ ..",
                            JOptionPane.CANCEL_OPTION);

                    arif(rd.nextInt(5));
                }
                break;

            default:
                arif(rd.nextInt(5));
        }
    }
}
