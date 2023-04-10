package login;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Window;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 * @author Alexandra
 *
 */
public class Register extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private JTextField textName;

    private JTextField textUsername;

    private JTextField textPassword;

    protected Window frame;

    private JTextField textTelefon;

    private JTextField textAdresa;

    /**
     * Launch the application.
     */
    /**
     * @param args
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Register frame = new Register();
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */

    public Register() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(250, 235, 215));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(204, 102, 102));
        panel.setBounds(0, 0, 584, 73);
        contentPane.add(panel);

        JLabel lblNewLabel = new JLabel("Librarie");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 40));
        lblNewLabel.setBounds(115, 21, 195, 41);
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBackground(Color.WHITE);
        panel_1.setBounds(352, 21, 232, 31);
        panel.add(panel_1);

        JLabel lblNewLabel_2_1_1 = new JLabel("");
        lblNewLabel_2_1_1.setBounds(382, 11, 85, 51);
        panel_1.add(lblNewLabel_2_1_1);

        JLabel lblNewLabel_2_2 = new JLabel("");
        lblNewLabel_2_2.setIcon(new ImageIcon("C:\\Users\\Alexandra\\IdeaProjects\\Bookstore\\icons\\open-book.gif"));
        lblNewLabel_2_2.setBounds(96, 0, 37, 30);
        panel_1.add(lblNewLabel_2_2);

        JLabel lblNewLabel_1 = new JLabel("Creaza un cont nou");
        lblNewLabel_1.setForeground(new Color(160, 82, 45));
        lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 25));
        lblNewLabel_1.setBounds(21, 84, 209, 45);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Nume");
        lblNewLabel_2.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
        lblNewLabel_2.setBounds(31, 129, 64, 33);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Username");
        lblNewLabel_3.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
        lblNewLabel_3.setBounds(31, 173, 95, 33);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Password");
        lblNewLabel_4.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
        lblNewLabel_4.setBounds(31, 217, 95, 33);
        contentPane.add(lblNewLabel_4);

        textName = new JTextField();
        textName.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
        textName.setBounds(124, 129, 172, 33);
        contentPane.add(textName);
        textName.setColumns(10);

        textUsername = new JTextField();
        textUsername.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
        textUsername.setColumns(10);
        textUsername.setBounds(124, 173, 172, 33);
        contentPane.add(textUsername);

        textPassword = new JTextField();
        textPassword.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
        textPassword.setColumns(10);
        textPassword.setBounds(124, 217, 172, 33);
        contentPane.add(textPassword);

        textTelefon = new JTextField();
        textTelefon.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
        textTelefon.setColumns(10);
        textTelefon.setBounds(388, 129, 172, 33);
        contentPane.add(textTelefon);

        JLabel lblNewLabel_2_1 = new JLabel("Telefon");
        lblNewLabel_2_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
        lblNewLabel_2_1.setBounds(314, 129, 64, 33);
        contentPane.add(lblNewLabel_2_1);

        JLabel lblNewLabel_3_1 = new JLabel("Adresa");
        lblNewLabel_3_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
        lblNewLabel_3_1.setBounds(314, 173, 95, 33);
        contentPane.add(lblNewLabel_3_1);

        textAdresa = new JTextField();
        textAdresa.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
        textAdresa.setColumns(10);
        textAdresa.setBounds(388, 173, 172, 77);
        contentPane.add(textAdresa);

        JButton btnRegister = new JButton("Register");
        btnRegister.setForeground(Color.WHITE);
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textName.getText();
                String username = textUsername.getText();
                String password = textPassword.getText();
                String telefon = textTelefon.getText();
                String adresa = textAdresa.getText();

                if(name.isEmpty() || username.isEmpty() || password.isEmpty() || telefon.isEmpty() || adresa.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Completati toate campurile.", "Login Error",JOptionPane.ERROR_MESSAGE);
                }
                else {
                    userRegister(name, username, password, telefon, adresa);
                }

            }

            private void userRegister(String name, String username, String password, String telefon, String adresa) {
                Connection dbconn = DBConnection.connectDB();

                if(dbconn != null) {
                    try {
                        PreparedStatement st = (PreparedStatement)dbconn.prepareStatement("INSERT INTO users (name, username, password, telefon, adresa) VALUES(?,?,?,?,?)");

                        st.setString(1, name);
                        st.setString(2, username);
                        st.setString(3, password);
                        st.setString(4, telefon);
                        st.setString(5, adresa);

                        st.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Contul a fost creat.", "Succes!",JOptionPane.INFORMATION_MESSAGE);

                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }else {
                    System.out.println("Connection not available.");
                }

            }
        });
        btnRegister.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
        btnRegister.setBackground(new Color(165, 62, 56));
        btnRegister.setBounds(403, 282, 157, 40);
        contentPane.add(btnRegister);

        JButton btnBackLogin = new JButton("Back to Login");
        btnBackLogin.setForeground(Color.WHITE);
        btnBackLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                dispose();

            }
        });
        btnBackLogin.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
        btnBackLogin.setBackground(new Color(189, 134, 98));
        btnBackLogin.setBounds(22, 299, 157, 40);
        contentPane.add(btnBackLogin);


    }
}
