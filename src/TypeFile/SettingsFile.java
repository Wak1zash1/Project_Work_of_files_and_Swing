package TypeFile;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.io.File;
import java.util.Date;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SettingsFile extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField textF_path;

    private String File_path;

    public static void main(String[] args) {
        try {
            SettingsFile dialog = new SettingsFile();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SettingsFile() {
        setResizable(false);
        setModal(true);
        setTitle("// Свойства файла\r\n");
        setBounds(100, 100, 450, 350);
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

        JTextPane textPane = new JTextPane();
        textPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textPane.setBackground(new Color(232, 232, 232));
        textPane.setBounds(10, 52, 414, 248);
        contentPanel.add(textPane);

        JButton pathFile_button = new JButton("путь\r\n");
        pathFile_button.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pathFile_button.setBackground(Color.WHITE);
        pathFile_button.setBounds(10, 11, 121, 30);
        pathFile_button.addActionListener(new ActionListener() {

            // получить путь к файлу
            // отобразить путь
            // отобразить его свойства
            public void actionPerformed(ActionEvent e) {
                textPane.setText("");

                JFileChooser fc = new JFileChooser ();
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                if (fc.showOpenDialog(SettingsFile.this) ==
                        JFileChooser.APPROVE_OPTION) {
                    File_path = fc.getSelectedFile().getAbsolutePath();
                    textF_path.setText(String.valueOf(File_path));

                    File a = new File(File_path);

                    long lastTime = a.lastModified();

                    textPane.setText("имя = " + a.getName() + "\n" +
                            "путь = " + a.getPath() + "\n" +
                            "абсалютный путь = " + a.getAbsolutePath() + "\n" +
                            "родитель = " + a.getParent() + "\n" +
                            "существует = " + a.exists() + "\n" +
                            "длинна байтов = " + a.length() + "\n" +
                            "Исполняемый: = " + a.canExecute() + "\n" +
                            "Чтение: = " + a.canRead() + "\n" +
                            "Запись: = " + a.canWrite() + "\n" +
                            "Файл = " + a.isFile() + "\n" +
                            "Каталог = " + a.isDirectory() + "\n" +
                            "Скрытый файл = " + a.isDirectory() + "\n" +
                            "Последнее изменение = " + new Date(lastTime)
                    );
                }
            }
        });
        contentPanel.add(pathFile_button);

        textF_path = new JTextField();
        textF_path.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textF_path.setColumns(10);
        textF_path.setBounds(141, 11, 283, 30);
        contentPanel.add(textF_path);

    }
}
