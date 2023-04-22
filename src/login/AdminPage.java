package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import operations.Manage;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 * @author Alexandra
 *
 */
public class AdminPage extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    /**
     * @param args main class
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminPage frame = new AdminPage();
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
    /**
     *
     */
    public AdminPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 950, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel contentPane_1 = new JPanel();
        contentPane_1.setLayout(null);
        contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane_1.setBackground(new Color(255, 250, 240));
        contentPane_1.setBounds(0, 0, 934, 561);
        contentPane.add(contentPane_1);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(205, 92, 92));
        panel.setBounds(0, 0, 934, 50);
        contentPane_1.add(panel);

        JLabel lblNewLabel = new JLabel("Book Store");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 35));
        lblNewLabel.setBounds(45, 11, 847, 28);
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBackground(new Color(233, 150, 122));
        panel_1.setBounds(0, 50, 934, 64);
        contentPane_1.add(panel_1);

        JButton btnNewButton = new JButton("Edit products");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Manage m = new Manage();
                dispose();
                m.setTitle("Manage stock");
                m.setVisible(true);
                m.setLocationRelativeTo(null);
            }
        });
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setBackground(new Color(153, 51, 51));
        btnNewButton.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
        btnNewButton.setBounds(153, 11, 210, 41);
        panel_1.add(btnNewButton);

        JButton btnVeziComenzile = new JButton("See orders");
        btnVeziComenzile.setForeground(Color.WHITE);
        btnVeziComenzile.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
        btnVeziComenzile.setBackground(new Color(153, 51, 51));
        btnVeziComenzile.setBounds(550, 11, 210, 41);
        panel_1.add(btnVeziComenzile);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Alexandra\\IdeaProjects\\Bookstore\\icons\\bookstore.png"));
        lblNewLabel_1.setBounds(562, 194, 260, 287);
        contentPane_1.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Administrate your store, products,");
        lblNewLabel_2.setFont(new Font("Book Antiqua", Font.PLAIN, 25));
        lblNewLabel_2.setBounds(69, 261, 387, 64);
        contentPane_1.add(lblNewLabel_2);

        JLabel lblNewLabel_2_1 = new JLabel("users and their orders.");
        lblNewLabel_2_1.setFont(new Font("Book Antiqua", Font.PLAIN, 25));
        lblNewLabel_2_1.setBounds(69, 302, 387, 64);
        contentPane_1.add(lblNewLabel_2_1);
    }

}
