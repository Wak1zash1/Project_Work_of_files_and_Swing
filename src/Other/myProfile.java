package Other;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Toolkit;


public class myProfile extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();

    public static void main(String[] args) {
        try {
            myProfile dialog = new myProfile();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public myProfile() {
        setModal(true);
        setResizable(false);
        setTitle("// О проекте :>");
        setBounds(100, 100, 450, 243);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setBackground(new Color(192, 192, 192));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPanel.setLayout(null);

        // по центру
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - getWidth()) / 2,
                (screenSize.height - getHeight()) / 2,
                getWidth(), getHeight());


        // текст
        JTextPane textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setFont(new Font("Tahoma", Font.ITALIC, 12));
        textPane.setText("     Данный проект был создан с целью закрепить тему \"работа с файлами\" на практие и просто как пет-проект. Особо он ничем похвастаться не может, особенно дизайном, потому что Swing я сильно не затрагивал. Начал я проектирование с 15.02.2024, с листка бумаги для наброска как будет примерно выглядеть данный проект. 20.02.2024 я закончил функционал в консольном виде, и надо было переходить в Eclipse, чтобы реализовать это все в граф. виде. И сейчас 02.03.2024, я пишу этот текст, c камнем что сделать проект я должен был еще 29.02.2024. Завтра буду делать класс с арифметикой, рефакторинг и заливать на GitHub.    // на будущее: Мне 15, изучаю Java, английский, фин.грамотность и недавно PostgreSQL.");
        textPane.setBackground(new Color(192, 192, 192));
        textPane.setBounds(10, 11, 414, 184);
        contentPanel.add(textPane);
    }
}
