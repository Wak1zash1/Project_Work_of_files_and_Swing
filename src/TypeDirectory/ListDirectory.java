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
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class ListDirectory extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField textF_path;

    private String PathListDir;


    public static void main(String[] args) {
        try {
            ListDirectory dialog = new ListDirectory();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ListDirectory() {
        setModal(true);
        setResizable(false);
        setTitle("// Показать файлы в каталоге\r\n\r\n");
        setBounds(100, 100, 495, 341);
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

        JTextPane textF_List = new JTextPane();
        textF_List.setEditable(false);
        textF_List.setToolTipText("");
        textF_List.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textF_List.setCaretPosition(0);

        JScrollPane scrollPane = new JScrollPane(textF_List);
        scrollPane.setBounds(10, 52, 459, 239);
        contentPanel.add(scrollPane);
        scrollPane.setViewportView(textF_List);

        JButton pathFile_button = new JButton("путь\r\n");
        pathFile_button.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pathFile_button.setBackground(Color.WHITE);
        pathFile_button.setBounds(10, 11, 121, 30);
        pathFile_button.addActionListener(new ActionListener() {


            // получить путь к каталогу
            // отобразить путь к каталогу
            // отобразить вложенные в каталог обьекты
            public void actionPerformed(ActionEvent e) {
                textF_List.setText("");
                JFileChooser fc = new JFileChooser ();
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                if (fc.showOpenDialog(ListDirectory.this) ==
                        JFileChooser.APPROVE_OPTION) {
                    PathListDir = fc.getSelectedFile().getAbsolutePath();
                    textF_path.setText(String.valueOf(PathListDir));

                    File file = new File(PathListDir);

                    if (file.exists()) {
                        String arr[] = file.list();
                        int n = arr.length;

                        for (int i = 0; i < n; i++) {
                            textF_List.setText(textF_List.getText() +"\n" + String.valueOf(arr[i]));
                        }
                    }
                }
            }
        });
        contentPanel.add(pathFile_button);

        textF_path = new JTextField();
        textF_path.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textF_path.setColumns(10);
        textF_path.setBounds(156, 11, 313, 30);
        contentPanel.add(textF_path);
    }
}
