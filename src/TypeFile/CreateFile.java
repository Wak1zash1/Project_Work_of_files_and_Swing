package TypeFile;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

public class CreateFile extends JDialog  {

    private static final long serialVersionUID = 1L;
    private static JPanel contentPanelCreateFile = new JPanel();

    private JTextField textF_path;
    private JTextField textF_nameFile;
    private JTextField textF_fileExt;
    private JTextField textF_finalPath;

    private String PathCreate;
    private String fileName, fileExt;
    private File path;
    private File fileA;
    private String fullName;

    public static  void colorSet_CF(Color color) {

        try {
            contentPanelCreateFile.setBackground(color);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            CreateFile dialog = new CreateFile();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CreateFile()  {
        setModal(true);
        setResizable(false);
        setTitle("// Создать файл\r\n");
        setBounds(100, 100, 495, 205);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(contentPanelCreateFile, BorderLayout.CENTER);
        contentPanelCreateFile.setBackground(new Color(192, 192, 192));
        contentPanelCreateFile.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPanelCreateFile.setLayout(null);


        // по центру
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - getWidth()) / 2,
                (screenSize.height - getHeight()) / 2,
                getWidth(), getHeight());
        {
            JButton pathFile_button = new JButton("путь\r\n");
            pathFile_button.setBackground(new Color(255, 255, 255));
            pathFile_button.setFont(new Font("Tahoma", Font.PLAIN, 14));
            pathFile_button.setBounds(10, 9, 121, 30);
            pathFile_button.addActionListener(new ActionListener() {

                // получить путь для создания нового файла
                // отобразить этот путь
                public void actionPerformed(ActionEvent e) {
                    JFileChooser fc = new JFileChooser ();
                    fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    if (fc.showOpenDialog(CreateFile.this) ==
                            JFileChooser.APPROVE_OPTION) {
                        PathCreate = fc.getSelectedFile().getAbsolutePath();
                        textF_path.setText(String.valueOf(PathCreate));

                        path = new File(textF_path.getText());
                    }
                }
            });
            contentPanelCreateFile.add(pathFile_button);


            textF_path = new JTextField();
            textF_path.setFont(new Font("Tahoma", Font.PLAIN, 14));
            textF_path.setBounds(156, 10, 313, 30);
            textF_path.setColumns(10);
            contentPanelCreateFile.add(textF_path);

            JButton yesCreate_button = new JButton("Подтвердить\r\n");
            yesCreate_button.setBackground(new Color(255, 120, 120));
            yesCreate_button.setFont(new Font("Tahoma", Font.PLAIN, 14));
            yesCreate_button.setBounds(10, 61, 121, 30);
            yesCreate_button.addActionListener(new ActionListener() {

                // получения название и расширение файла
                // обьединение в единый файл
                public void actionPerformed(ActionEvent e) {
                    fileName = textF_nameFile.getText();
                    fileExt = textF_fileExt.getText();

                    fullName = fileName + fileExt;
                    fileA = new File(path,fullName);
                    yesCreate_button.setBackground(new Color(255,255,255));
                }
            });
            contentPanelCreateFile.add(yesCreate_button);

            textF_nameFile = new JTextField();
            textF_nameFile.setFont(new Font("Tahoma", Font.PLAIN, 14));
            textF_nameFile.setBounds(156, 62, 235, 30);
            textF_nameFile.setColumns(10);
            contentPanelCreateFile.add(textF_nameFile);

            textF_fileExt = new JTextField();
            textF_fileExt.setFont(new Font("Tahoma", Font.PLAIN, 14));
            textF_fileExt.setBounds(401, 62, 68, 30);
            textF_fileExt.setColumns(10);
            contentPanelCreateFile.add(textF_fileExt);

            JButton createFile_button = new JButton("создать\r\n");
            createFile_button.setBackground(new Color(255, 255, 255));
            createFile_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
            createFile_button.setBounds(10, 117, 121, 30);
            createFile_button.addActionListener(new ActionListener() {

                // создание нового файла
                public void actionPerformed(ActionEvent e) {
                    try {
                        fileA.createNewFile();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    textF_finalPath.setText(String.valueOf(fileA));
                }
            });
            contentPanelCreateFile.add(createFile_button);

            textF_finalPath = new JTextField();
            textF_finalPath.setFont(new Font("Tahoma", Font.PLAIN, 14));
            textF_finalPath.setBounds(156, 118, 313, 30);
            textF_finalPath.setColumns(10);
            contentPanelCreateFile.add(textF_finalPath);
        }
    }
}
