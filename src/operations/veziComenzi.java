package operations;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import login.DBConnection;
import login.User;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Alexandra
 *
 */
public class veziComenzi extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTable displayTable;

    DBConnection conn;

    private JTable table;

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
                    veziComenzi frame = new veziComenzi();
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

    public veziComenzi() {
        initialize();
        conn = new DBConnection();
        if(conn == null) {
            JOptionPane.showMessageDialog(null, "Data base connection not available.", "Connection Error",JOptionPane.ERROR_MESSAGE);

        }
        ShowUserTable();
        ShowOrderTable();
    }

    /**
     * @return
     */
    public ArrayList<User> getUsers()
    {
        ArrayList<User> userList = new ArrayList<User>();
        Connection dbconn = DBConnection.connectDB();

        String query = "SELECT * FROM  users";
        Statement st;
        ResultSet rs;

        try {
            st = dbconn.createStatement();
            rs = st.executeQuery(query);
            User user;
            while(rs.next())
            {
                user = new User(rs.getInt("userID"),rs.getString("name"), rs.getString("username"),rs.getString("password"),rs.getString("telefon"),rs.getString("adresa"));
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void ShowUserTable() {
        ArrayList<User> list = getUsers();
        DefaultTableModel model = (DefaultTableModel)displayTable.getModel();
        Object[] row = new Object[6];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getUsername();
            row[3] = list.get(i).getPassword();
            row[4] = list.get(i).getTelefon();
            row[5] = list.get(i).getAdresa();

            model.addRow(row);
        }

    }

    /**
     * @return
     */
    public ArrayList<Order> getOrders()
    {
        ArrayList<Order> orderList = new ArrayList<Order>();
        Connection dbconn = DBConnection.connectDB();

        String query = "SELECT com.orderID, com.userID, det.bookID, det.quantity FROM comenzi com JOIN detaliicomenzi det ON com.orderID = det.orderID";
        Statement st;
        ResultSet rs;

        try {
            st = dbconn.createStatement();
            rs = st.executeQuery(query);
            Order order;
            while(rs.next())
            {
                order = new Order(rs.getInt("orderID"),rs.getInt("userID"), rs.getInt("bookID"),rs.getInt("quantity"));
                orderList.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList;
    }

    public void ShowOrderTable() {
        ArrayList<Order> list = getOrders();
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        Object[] row = new Object[4];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getOrderID();
            row[1] = list.get(i).getUserID();
            row[2] = list.get(i).getBookID();
            row[3] = list.get(i).getQuantity();
            model.addRow(row);
        }

    }

    /**
     * @param table
     * @param file
     */
    public void export(JTable table, File file){
        try
        {
            TableModel m = table.getModel();
            FileWriter fw = new FileWriter(file);
            for(int i = 0; i < m.getColumnCount(); i++){
                fw.write(m.getColumnName(i) + "\t");
            }
            fw.write("\n");
            for(int i=0; i < m.getRowCount(); i++) {
                for(int j=0; j < m.getColumnCount(); j++) {
                    fw.write(m.getValueAt(i,j).toString()+"\t");
                }
                fw.write("\n");
            }
            fw.close();
        }
        catch(Exception e)
        { e.printStackTrace(); }
    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 950, 600);
        getContentPane().setLayout(null);

        JPanel contentPane_1 = new JPanel();
        contentPane_1.setLayout(null);
        contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane_1.setBackground(new Color(255, 250, 240));
        contentPane_1.setBounds(0, 0, 934, 561);
        getContentPane().add(contentPane_1);

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

        JButton btnManage = new JButton("Manage products");
        btnManage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Manage m = new Manage();
                dispose();
                m.setTitle("Manage");
                m.setVisible(true);
                m.setLocationRelativeTo(null);
            }
        });
        btnManage.setForeground(Color.WHITE);
        btnManage.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
        btnManage.setBackground(new Color(153, 51, 51));
        btnManage.setBounds(153, 11, 210, 41);
        panel_1.add(btnManage);

        JButton btnVeziComenzile = new JButton("See reviews");
        btnVeziComenzile.setForeground(Color.WHITE);
        btnVeziComenzile.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
        btnVeziComenzile.setBackground(new Color(153, 51, 51));
        btnVeziComenzile.setBounds(550, 11, 210, 41);
        panel_1.add(btnVeziComenzile);

        JLabel lblNewLabel_1_1_1 = new JLabel("Users");
        lblNewLabel_1_1_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 25));
        lblNewLabel_1_1_1.setBounds(23, 125, 81, 22);
        contentPane_1.add(lblNewLabel_1_1_1);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(49, 158, 820, 112);
        contentPane_1.add(scrollPane);

        DefaultTableModel model;
        displayTable = new JTable();
        displayTable.setRowHeight(25);
        displayTable.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
        scrollPane.setViewportView(displayTable);
        displayTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                displayTable.getSelectedRow();
                displayTable.getModel();

            }
        });
        model = new DefaultTableModel();
        Object[] column = {"userID", "Name", "Username", "Password", "Phone", "Adress"};
        model.setColumnIdentifiers(column);
        displayTable.setModel(model);
        scrollPane.setViewportView(displayTable);


        JLabel lblNewLabel_1_1_1_1 = new JLabel("Orders");
        lblNewLabel_1_1_1_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 25));
        lblNewLabel_1_1_1_1.setBounds(23, 289, 109, 22);
        contentPane_1.add(lblNewLabel_1_1_1_1);

        JScrollPane pane = new JScrollPane();
        pane.setBounds(49, 322, 822, 199);
        contentPane_1.add(pane);

        DefaultTableModel model1;
        table = new JTable();
        table.setRowHeight(25);
        table.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
        pane.setViewportView(table);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                table.getSelectedRow();
                table.getModel();

            }
        });
        model1 = new DefaultTableModel();
        Object[] column1 = {"orderID", "userID", "bookID", "Quantity"};
        model1.setColumnIdentifiers(column1);
        table.setModel(model1);
        pane.setViewportView(table);

        JButton btnExport = new JButton("Export users");
        btnExport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fchoose = new JFileChooser();
                int option = fchoose.showSaveDialog(veziComenzi.this);
                if(option == JFileChooser.APPROVE_OPTION) {
                    String name = fchoose.getSelectedFile().getName();
                    String path = fchoose.getSelectedFile().getParentFile().getPath();
                    String file = path + "\\" + name + ".xls";
                    export(displayTable, new File(file));
                }
            }
        });
        btnExport.setForeground(Color.WHITE);
        btnExport.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
        btnExport.setBackground(new Color(208, 79, 79));
        btnExport.setAlignmentX(0.5f);
        btnExport.setBounds(680, 280, 190, 25);
        contentPane_1.add(btnExport);

        JButton btnExport_1 = new JButton("Export orders");
        btnExport_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fchoose = new JFileChooser();
                int option = fchoose.showSaveDialog(veziComenzi.this);
                if(option == JFileChooser.APPROVE_OPTION) {
                    String name = fchoose.getSelectedFile().getName();
                    String path = fchoose.getSelectedFile().getParentFile().getPath();
                    String file = path + "\\" + name + ".xls";
                    export(table, new File(file));
                }
            }
        });
        btnExport_1.setForeground(Color.WHITE);
        btnExport_1.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
        btnExport_1.setBackground(new Color(208, 79, 79));
        btnExport_1.setAlignmentX(0.5f);
        btnExport_1.setBounds(680, 527, 190, 25);
        contentPane_1.add(btnExport_1);


    }
}
