package TypeFile;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.awt.event.ActionEvent;

public class RecordReadFile extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField textF_path;

    private String textPath;
    private  Path filename;


    public static void main(String[] args) {
        try {
            RecordReadFile dialog = new RecordReadFile();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RecordReadFile() {
        setModal(true);
        setResizable(false);
        setTitle("// Запись\\чтение файла\r\n");
        setBounds(100, 100, 489, 356);
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

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 52, 453, 218);
        contentPanel.add(scrollPane);

        JTextPane textPane = new JTextPane();
        scrollPane.setViewportView(textPane);

        JButton pathFile_button = new JButton("путь\r\n");
        pathFile_button.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pathFile_button.setBackground(Color.WHITE);
        pathFile_button.setBounds(10, 11, 121, 30);
        pathFile_button.addActionListener(new ActionListener() {

            // получить путь для создания нового каталога
            // отобразить путь
            public void actionPerformed(ActionEvent e) {
                textPane.setText("");

                JFileChooser fc = new JFileChooser ();
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                if (fc.showOpenDialog(RecordReadFile.this) ==
                        JFileChooser.APPROVE_OPTION) {
                    textPath = fc.getSelectedFile().getAbsolutePath();
                    textF_path.setText(String.valueOf(textPath));
                }
            }
        });
        contentPanel.add(pathFile_button);

        textF_path = new JTextField();
        textF_path.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textF_path.setColumns(10);
        textF_path.setBounds(141, 12, 322, 30);
        contentPanel.add(textF_path);

        JButton pathFile_button_1 = new JButton("запись ");
        pathFile_button_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        pathFile_button_1.setBackground(Color.WHITE);
        pathFile_button_1.setBounds(342, 276, 121, 30);
        pathFile_button_1.addActionListener(new ActionListener() {

            // получить текст
            // и записать его в, поддерживаемый записи текста, файл
            public void actionPerformed(ActionEvent e) {
                filename = Path.of(String.valueOf(textPath));
                try {
                    Files.writeString(filename, textPane.getText());
                }
                catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        contentPanel.add(pathFile_button_1);

        JButton pathFile_button_2 = new JButton("чтение\r\n");
        pathFile_button_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        pathFile_button_2.setBackground(Color.WHITE);
        pathFile_button_2.setBounds(213, 276, 121, 30);
        pathFile_button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // прочитать текст из файла
                Path filename = Path.of(String.valueOf(textPath));
                textPane.setText("");

                try {
                    String fileout = Files.readString(filename);
                    textPane.setText(fileout);
                }
                catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        contentPanel.add(pathFile_button_2);
    }
}
