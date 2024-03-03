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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.awt.event.ActionEvent;

public class MoveFD extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField textF_which;
    private JTextField textF_where;

    private String PathMove_which;
    private String  PathName_file;
    private String PathMove_where;

    public static void main(String[] args) {
        try {
            MoveFD dialog = new MoveFD();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MoveFD() {
        setModal(true);
        setResizable(false);
        setTitle("Переместить файл\\каталог\r\n");
        setBounds(100, 100, 495, 205);
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

        JButton pathFile_button = new JButton("Откуда");
        pathFile_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
        pathFile_button.setBackground(Color.WHITE);
        pathFile_button.setBounds(10, 11, 121, 30);
        pathFile_button.addActionListener(new ActionListener() {

            // получить  обьект для перемещения
            // отобразить этот обьект
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser ();
                fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                if (fc.showOpenDialog(MoveFD.this) ==
                        JFileChooser.APPROVE_OPTION) {
                    PathMove_which = fc.getSelectedFile().getAbsolutePath();
                    PathName_file = fc.getSelectedFile().getName();

                    textF_which.setText(String.valueOf(PathMove_which));
                }
            }
        });
        contentPanel.add(pathFile_button);

        textF_which = new JTextField();
        textF_which.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textF_which.setColumns(10);
        textF_which.setBounds(156, 11, 313, 30);
        contentPanel.add(textF_which);

        JButton yesCreate_button = new JButton("Куда\r\n");
        yesCreate_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
        yesCreate_button.setBackground(Color.WHITE);
        yesCreate_button.setBounds(10, 64, 121, 30);
        yesCreate_button.addActionListener(new ActionListener() {

            // получить путь для перемещения обьекта в этот путь
            // отобразить путь куда будет перемещен обьект
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser ();
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                if (fc.showOpenDialog(MoveFD.this) ==
                        JFileChooser.APPROVE_OPTION) {
                    PathMove_where = fc.getSelectedFile().getPath();

                    textF_where.setText(String.valueOf(PathMove_where));
                }
            }
        });
        contentPanel.add(yesCreate_button);

        textF_where = new JTextField();
        textF_where.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textF_where.setColumns(10);
        textF_where.setBounds(156, 65, 313, 30);
        contentPanel.add(textF_where);

        JButton yesCreate_button_1 = new JButton("Переместить\r\n");
        yesCreate_button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        yesCreate_button_1.setBackground(Color.WHITE);
        yesCreate_button_1.setBounds(153, 125, 121, 30);
        yesCreate_button_1.addActionListener(new ActionListener() {

            // перемещение
            public void actionPerformed(ActionEvent e) {
                try {
                    Path pathChosen = Path.of(PathMove_which);
                    Files.move(
                                    pathChosen,
                                    Path.of(PathMove_where, PathName_file),
                                    StandardCopyOption.REPLACE_EXISTING)
                            .resolve(pathChosen.getFileName().toString());
                }
                catch (Exception exc) {
                }
            }
        });
        contentPanel.add(yesCreate_button_1);
    }
}
