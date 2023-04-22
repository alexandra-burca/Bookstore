package operations;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import login.DBConnection;
import login.Login_Registration;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;

/**
 * @author Alexandra
 *
 */
public class scrieRecenzie extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private JTextField textID;

    public static String currentUser;

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
                    scrieRecenzie frame = new scrieRecenzie();
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

    DBConnection conn;

    public scrieRecenzie() {
        initialize();
        conn = new DBConnection();
        if(conn == null) {
            JOptionPane.showMessageDialog(null, "Data base connection not available.", "Connection Error",JOptionPane.ERROR_MESSAGE);

        }

    }

    public void initialize() {
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
        lblNewLabel.setBounds(390, 10, 160, 30);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Alexandra\\IdeaProjects\\Bookstore\\icons\\repository.png"));
        lblNewLabel_2.setBounds(550, 10, 30, 30);
        panel.add(lblNewLabel_2);

        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBackground(new Color(233, 150, 122));
        panel_1.setBounds(0, 50, 934, 66);
        contentPane_1.add(panel_1);

        JButton btnBrowse = new JButton("See books");
        btnBrowse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                veziProduse v = new veziProduse();
                dispose();
                v.setTitle("Books");
                v.setVisible(true);
                v.setLocationRelativeTo(null);
            }
        });
        btnBrowse.setForeground(Color.WHITE);
        btnBrowse.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
        btnBrowse.setBackground(new Color(153, 51, 51));
        btnBrowse.setBounds(45, 11, 180, 41);
        panel_1.add(btnBrowse);

        JButton btnComanda = new JButton("Order");
        btnComanda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Comanda c = new Comanda();
                dispose();
                c.setTitle("Order");
                c.setVisible(true);
                c.setLocationRelativeTo(null);
            }
        });
        btnComanda.setForeground(Color.WHITE);
        btnComanda.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
        btnComanda.setBackground(new Color(153, 51, 51));
        btnComanda.setBounds(265, 11, 180, 41);
        panel_1.add(btnComanda);

        JButton btnVeziRecenziile = new JButton("See reviews");
        btnVeziRecenziile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                veziRecenzii r = new veziRecenzii();
                dispose();
                r.setTitle("See reviews");
                r.setVisible(true);
                r.setLocationRelativeTo(null);
            }
        });
        btnVeziRecenziile.setForeground(Color.WHITE);
        btnVeziRecenziile.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
        btnVeziRecenziile.setBackground(new Color(153, 51, 51));
        btnVeziRecenziile.setBounds(486, 11, 180, 41);
        panel_1.add(btnVeziRecenziile);

        JButton btnScrieORecenzie = new JButton("Write a review");
        btnScrieORecenzie.setForeground(Color.WHITE);
        btnScrieORecenzie.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
        btnScrieORecenzie.setBackground(new Color(153, 51, 51));
        btnScrieORecenzie.setBounds(704, 11, 180, 41);
        panel_1.add(btnScrieORecenzie);

        JLabel lblNewLabel_1 = new JLabel("Book ID");
        lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 25));
        lblNewLabel_1.setBounds(35, 155, 99, 30);
        contentPane_1.add(lblNewLabel_1);

        textID = new JTextField();
        textID.setBounds(131, 155, 120, 27);
        contentPane_1.add(textID);
        textID.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Rating");
        lblNewLabel_1_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 25));
        lblNewLabel_1_1.setBounds(332, 155, 70, 30);
        contentPane_1.add(lblNewLabel_1_1);

        String[] rating = { "1", "2", "3", "4", "5" };
        JComboBox<Object> Rating = new JComboBox<Object>(rating);
        Rating.setMaximumRowCount(5);
        Rating.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
        Rating.setBounds(412, 156, 107, 30);
        contentPane_1.add(Rating);

        JTextPane textRecenzie = new JTextPane();
        textRecenzie.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        textRecenzie.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
        textRecenzie.setBounds(45, 259, 623, 257);
        contentPane_1.add(textRecenzie);

        JLabel lblNewLabel_1_1_1 = new JLabel("Write your review:");
        lblNewLabel_1_1_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 25));
        lblNewLabel_1_1_1.setBounds(35, 206, 290, 27);
        contentPane_1.add(lblNewLabel_1_1_1);

        JButton btnTrimite = new JButton("Send");
        btnTrimite.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connection dbconn = DBConnection.connectDB();
                PreparedStatement st = null;
                try {
                    st = dbconn.prepareStatement("INSERT INTO `recenzii` (`username`, `bookID`, `rating`, `textrecenzie`) VALUES ('"+Login_Registration.currentUser+"','"+Integer.parseInt(textID.getText())+"', '"+Integer.parseInt((String) Rating.getSelectedItem())+"', '"+textRecenzie.getText()+"')");
                    JOptionPane.showMessageDialog(null, "Your review has been posted!", "Sent",JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException e1) {

                    e1.printStackTrace();
                }

                try {
                    st.executeUpdate();
                } catch (SQLException e1) {

                    e1.printStackTrace();
                }

            }
        });
        btnTrimite.setForeground(Color.WHITE);
        btnTrimite.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
        btnTrimite.setBackground(new Color(255, 99, 71));
        btnTrimite.setBounds(734, 475, 131, 41);
        contentPane_1.add(btnTrimite);


    }
}
