package SameFunction;

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
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.awt.event.ActionEvent;

public class DeleteFD extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField textF_path1;

    private String Path_delete1;

    public static void main(String[] args) {
        try {
            DeleteFD dialog = new DeleteFD();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DeleteFD() {
        setResizable(false);
        setModal(true);
        setTitle("// Удалить файл\\каталог\r\n");
        setBounds(100, 100, 479, 134);
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

        // выбранный обьект
        textF_path1 = new JTextField();
        textF_path1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textF_path1.setColumns(10);
        textF_path1.setBounds(141, 11, 312, 30);
        contentPanel.add(textF_path1);

        JButton pathFile_button = new JButton("путь\r\n");
        pathFile_button.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pathFile_button.setBackground(Color.WHITE);
        pathFile_button.setBounds(10, 11, 121, 30);
        pathFile_button.addActionListener(new ActionListener() {

            // получить файл или каталог
            // отобразить выбранный обьект для удаления
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser ();
                fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                if (fc.showOpenDialog(DeleteFD.this) ==
                        JFileChooser.APPROVE_OPTION) {
                    Path_delete1 = fc.getSelectedFile().getAbsolutePath();

                    textF_path1.setText(String.valueOf(Path_delete1));
                }
            }
        });
        contentPanel.add(pathFile_button);

        JButton createFile_button = new JButton("удалить");
        createFile_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
        createFile_button.setBackground(new Color(255, 125, 129));
        createFile_button.setBounds(141, 52, 121, 30);
        createFile_button.addActionListener(new ActionListener() {

            // удалить выбранный обьект
            public void actionPerformed(ActionEvent e) {
                try {
                    Files.deleteIfExists(Path.of(Path_delete1));
                }
                catch (NoSuchFileException e1) {
                    System.out.println("Такого файла/каталога не существует.");
                }
                catch (DirectoryNotEmptyException e2) {
                    System.out.println("Каталог не пуст.");
                }
                catch (IOException e3) {
                    System.out.println("Недопустимые разрешения.");
                }
            }
        });
        contentPanel.add(createFile_button);

    }
}
