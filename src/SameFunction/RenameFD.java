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
import java.io.File;
import java.awt.event.ActionEvent;

public class RenameFD extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField textF_path;
    private JTextField textF_nameFile;
    private JTextField textF_ExtFile;
    private JTextField textF_rename;

    private String File_path;
    private String File_par;
    private String fileName, fileExt;
    private File NewFile;


    public static void main(String[] args) {
        try {
            RenameFD dialog = new RenameFD();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RenameFD() {
        setModal(true);
        setResizable(false);
        setTitle("Переименовать файл\\каталог");
        setBounds(100, 100, 486, 204);
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

        {
            textF_nameFile = new JTextField();
            textF_nameFile.setFont(new Font("Tahoma", Font.PLAIN, 14));
            textF_nameFile.setColumns(10);
            textF_nameFile.setBounds(141, 65, 241, 30);
            contentPanel.add(textF_nameFile);

            textF_ExtFile = new JTextField();
            textF_ExtFile.setFont(new Font("Tahoma", Font.PLAIN, 14));
            textF_ExtFile.setColumns(10);
            textF_ExtFile.setBounds(392, 65, 68, 30);
            contentPanel.add(textF_ExtFile);

            textF_rename = new JTextField();
            textF_rename.setFont(new Font("Tahoma", Font.PLAIN, 14));
            textF_rename.setColumns(10);
            textF_rename.setBounds(141, 117, 319, 30);
            contentPanel.add(textF_rename);

            JButton pathFile_button = new JButton("путь\r\n");
            pathFile_button.setFont(new Font("Tahoma", Font.PLAIN, 14));
            pathFile_button.setBackground(Color.WHITE);
            pathFile_button.setBounds(10, 11, 121, 30);
            pathFile_button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    // получить путь  обьекта для переименования
                    JFileChooser fc = new JFileChooser ();
                    fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                    if (fc.showOpenDialog(RenameFD.this) ==
                            JFileChooser.APPROVE_OPTION) {
                        File_path = fc.getSelectedFile().getPath(); // абсалютный путь
                        File_par = fc.getSelectedFile().getParent(); // получение род.пути

                        textF_path.setText(String.valueOf(File_path));
                    }
                }
            });
            contentPanel.add(pathFile_button);

            textF_path = new JTextField();
            textF_path.setFont(new Font("Tahoma", Font.PLAIN, 14));
            textF_path.setColumns(10);
            textF_path.setBounds(141, 11, 319, 30);
            contentPanel.add(textF_path);

            JButton yesCreate_button = new JButton("Подтвердить\r\n");
            yesCreate_button.setFont(new Font("Tahoma", Font.PLAIN, 14));
            yesCreate_button.setBackground(new Color(255, 120, 120));
            yesCreate_button.setBounds(10, 64, 121, 30);
            yesCreate_button.addActionListener(new ActionListener() {

                // подтвердить переименования
                public void actionPerformed(ActionEvent e) {
                    fileName = textF_nameFile.getText();
                    fileExt = textF_ExtFile.getText();
                    NewFile = new File(File_par, (fileName + fileExt));

                    yesCreate_button.setBackground(new Color(255,255,255));
                }
            });
            contentPanel.add(yesCreate_button);

            JButton renameFile_button = new JButton("переименовать\r\n");
            renameFile_button.setFont(new Font("Tahoma", Font.PLAIN, 11));
            renameFile_button.setBackground(Color.WHITE);
            renameFile_button.setBounds(10, 116, 121, 30);
            renameFile_button.addActionListener(new ActionListener() {

                // окончательно переименовать обьект
                public void actionPerformed(ActionEvent e) {
                    File oldName = new File(File_path);
                    oldName.renameTo(NewFile);
                    textF_rename.setText(String.valueOf(NewFile));
                }
            });
            contentPanel.add(renameFile_button);
        }
    }
}
