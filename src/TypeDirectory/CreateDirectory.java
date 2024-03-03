package TypeDirectory;

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

public class CreateDirectory extends JDialog {

    private static final long serialVersionUID = 1L;
    private static JPanel contentPanelCreateDir = new JPanel();

    private JTextField textF_path;
    private JTextField textF_nameDirectory;
    private JTextField textF_finalPath;

    private String PathCreate;
    private String file_Name = "";
    private File path;
    private File fileA;

    public static void main(String[] args) {
        try {
            CreateDirectory dialog = new CreateDirectory();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CreateDirectory() {
        setModal(true);
        setResizable(false);
        setTitle("// Создать каталог");
        setBounds(100, 100, 495, 205);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(contentPanelCreateDir, BorderLayout.CENTER);
        contentPanelCreateDir.setBackground(new Color(192, 192, 192));
        contentPanelCreateDir.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPanelCreateDir.setLayout(null);

        // по центру
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - getWidth()) / 2,
                (screenSize.height - getHeight()) / 2,
                getWidth(), getHeight());

        JButton pathFile_button = new JButton("путь\r\n");
        pathFile_button.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pathFile_button.setBackground(Color.WHITE);
        pathFile_button.setBounds(10, 11, 121, 30);
        pathFile_button.addActionListener(new ActionListener() {

            // получить путь для создания каталога
            // отобразить путь
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser ();
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                if (fc.showOpenDialog(CreateDirectory.this) ==
                        JFileChooser.APPROVE_OPTION) {
                    PathCreate = fc.getSelectedFile().getAbsolutePath();
                    textF_path.setText(String.valueOf(PathCreate));

                    path = new File(textF_path.getText());
                }
            }
        });
        contentPanelCreateDir.add(pathFile_button);

        textF_path = new JTextField();
        textF_path.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textF_path.setColumns(10);
        textF_path.setBounds(156, 11, 313, 30);
        contentPanelCreateDir.add(textF_path);

        JButton yesCreate_button = new JButton("Подтвердить\r\n");
        yesCreate_button.setBackground(new Color(255, 120, 120));
        yesCreate_button.setFont(new Font("Tahoma", Font.PLAIN, 14));
        yesCreate_button.setBounds(10, 60, 121, 30);
        yesCreate_button.addActionListener(new ActionListener() {

            // подтвердить путь + имя нового каталога
            public void actionPerformed(ActionEvent e) {
                file_Name = textF_nameDirectory.getText();
                fileA = new File(path,file_Name);
                yesCreate_button.setBackground(new Color(255,255,255));
            }
        });
        contentPanelCreateDir.add(yesCreate_button);

        textF_nameDirectory = new JTextField();
        textF_nameDirectory.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textF_nameDirectory.setColumns(10);
        textF_nameDirectory.setBounds(156, 61, 313, 30);
        contentPanelCreateDir.add(textF_nameDirectory);

        JButton createDirectory_button = new JButton("создать\r\n");
        createDirectory_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
        createDirectory_button.setBackground(Color.WHITE);
        createDirectory_button.setBounds(10, 113, 121, 30);
        createDirectory_button.addActionListener(new ActionListener() {

            // создание нового каталога
            // отобразить путь к новому каталогу
            public void actionPerformed(ActionEvent e) {
                try {
                    fileA.mkdir();
                } catch (Exception exception) {
                    System.out.println(exception);
                }
                textF_finalPath.setText(String.valueOf(fileA));
            }
        });
        contentPanelCreateDir.add(createDirectory_button);

        textF_finalPath = new JTextField();
        textF_finalPath.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textF_finalPath.setColumns(10);
        textF_finalPath.setBounds(156, 113, 313, 30);
        contentPanelCreateDir.add(textF_finalPath);
    }
}
