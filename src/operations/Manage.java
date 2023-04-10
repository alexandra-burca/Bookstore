package operations;

import java.awt.EventQueue;




import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import login.DBConnection;

import javax.swing.JScrollPane;
import java.sql.*;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.awt.Dimension;
import java.awt.Component;


/**
 * @author Alexandra
 *
 */
public class Manage extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private JTextField textID;

    private JTextField textTitlu;

    private JTextField textNrbucati;

    private JTextField textPret;

    private JTextField textAutor;

    private JTable displayTable;

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
                    Manage frame = new Manage();
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

    public Manage() {
        initialize();
        conn = new DBConnection();
        if(conn == null) {
            JOptionPane.showMessageDialog(null, "Data base connection not available.", "Connection Error",JOptionPane.ERROR_MESSAGE);

        }
        ShowTable();
    }

    public ArrayList<Book> getBooks()
    {
        ArrayList<Book> bookList = new ArrayList<Book>();
        Connection dbconn = DBConnection.connectDB();

        String query = "SELECT * FROM  books";
        Statement st;
        ResultSet rs;

        try {
            st = dbconn.createStatement();
            rs = st.executeQuery(query);
            Book book;
            while(rs.next())
            {
                book = new Book(rs.getInt("bookID"),rs.getString("titlu"),rs.getString("autor"),rs.getInt("nrbucati"),rs.getDouble("pret"));
                bookList.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public void ShowTable() {
        ArrayList<Book> list = getBooks();
        DefaultTableModel model = (DefaultTableModel)displayTable.getModel();
        Object[] row = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getTitlu();
            row[2] = list.get(i).getAutor();
            row[3] = list.get(i).getNrbucati();
            row[4] = list.get(i).getPret();

            model.addRow(row);
        }

    }

    public void RefreshQuery() {
        DefaultTableModel model= (DefaultTableModel)displayTable.getModel();
        model.setRowCount(0);
        ShowTable();

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

    /**
     *
     */
    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 950, 600);
        setTitle("Manage");
        setVisible(true);
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

        JLabel lblNewLabel = new JLabel("Librarie");
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
        btnManage.setForeground(Color.WHITE);
        btnManage.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
        btnManage.setBackground(new Color(153, 51, 51));
        btnManage.setBounds(153, 11, 210, 41);
        panel_1.add(btnManage);

        JButton btnVeziComenzile = new JButton("Vezi comenzile");
        btnVeziComenzile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                veziComenzi v = new veziComenzi();
                dispose();
                v.setTitle("Comenzi");
                v.setVisible(true);
                v.setLocationRelativeTo(null);
            }
        });
        btnVeziComenzile.setForeground(Color.WHITE);
        btnVeziComenzile.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
        btnVeziComenzile.setBackground(new Color(153, 51, 51));
        btnVeziComenzile.setBounds(550, 11, 210, 41);
        panel_1.add(btnVeziComenzile);

        JLabel lblNewLabel_1 = new JLabel("ID");
        lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 25));
        lblNewLabel_1.setBounds(56, 136, 37, 22);
        contentPane_1.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Titlu");
        lblNewLabel_1_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 25));
        lblNewLabel_1_1.setBounds(56, 169, 64, 22);
        contentPane_1.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("Autor");
        lblNewLabel_1_1_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 25));
        lblNewLabel_1_1_1.setBounds(56, 205, 81, 22);
        contentPane_1.add(lblNewLabel_1_1_1);

        JLabel lblNewLabel_1_1_2 = new JLabel("Nr. bucati");
        lblNewLabel_1_1_2.setFont(new Font("Baskerville Old Face", Font.PLAIN, 25));
        lblNewLabel_1_1_2.setBounds(475, 133, 110, 22);
        contentPane_1.add(lblNewLabel_1_1_2);

        JLabel lblNewLabel_1_1_3 = new JLabel("Pret");
        lblNewLabel_1_1_3.setFont(new Font("Baskerville Old Face", Font.PLAIN, 25));
        lblNewLabel_1_1_3.setBounds(497, 166, 64, 22);
        contentPane_1.add(lblNewLabel_1_1_3);

        textID = new JTextField();
        textID.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
        textID.setBounds(144, 128, 212, 28);
        contentPane_1.add(textID);
        textID.setColumns(10);

        textTitlu = new JTextField();
        textTitlu.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
        textTitlu.setColumns(10);
        textTitlu.setBounds(144, 166, 212, 28);
        contentPane_1.add(textTitlu);

        textNrbucati = new JTextField();
        textNrbucati.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
        textNrbucati.setColumns(10);
        textNrbucati.setBounds(598, 125, 212, 28);
        contentPane_1.add(textNrbucati);

        textPret = new JTextField();
        textPret.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
        textPret.setColumns(10);
        textPret.setBounds(598, 163, 212, 28);
        contentPane_1.add(textPret);

        textAutor = new JTextField();
        textAutor.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
        textAutor.setColumns(10);
        textAutor.setBounds(144, 205, 212, 28);
        contentPane_1.add(textAutor);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(80, 260, 780, 250);
        contentPane_1.add(scrollPane);

        DefaultTableModel model;
        displayTable = new JTable();
        displayTable.setRowHeight(20);
        displayTable.setPreferredScrollableViewportSize(new Dimension(400, 400));
        displayTable.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
        displayTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = displayTable.getSelectedRow();
                DefaultTableModel model = (DefaultTableModel)displayTable.getModel();
                textID.setText(model.getValueAt(i,0).toString());
                textTitlu.setText(model.getValueAt(i,1).toString());
                textAutor.setText(model.getValueAt(i,2).toString());
                textNrbucati.setText(model.getValueAt(i,3).toString());
                textPret.setText(model.getValueAt(i,4).toString());

            }
        });
        model = new DefaultTableModel();
        Object[] column = {"ID", "Titlu", "Autor", "Nr bucati", "Pret"};
        model.setColumnIdentifiers(column);
        displayTable.setModel(model);
        scrollPane.setViewportView(displayTable);

        JButton btnNewButton = new JButton("Add");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connection dbconn = DBConnection.connectDB();
                PreparedStatement st = null;
                try {
                    st = (PreparedStatement)dbconn.prepareStatement("INSERT INTO `books` (`bookID`, `titlu`, `autor`, `nrbucati`, `pret`) VALUES ('"+textID.getText()+"', '"+textTitlu.getText()+"', '"+textAutor.getText()+"', '"+textNrbucati.getText()+"', '"+textPret.getText()+"')");

                } catch (SQLException e1) {

                    e1.printStackTrace();
                }

                try {
                    st.executeUpdate();
                    RefreshQuery();
                } catch (SQLException e1) {

                    e1.printStackTrace();
                }

            }
        });
        btnNewButton.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
        btnNewButton.setBackground(new Color(255, 102, 51));
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBounds(383, 205, 100, 40);
        contentPane_1.add(btnNewButton);

        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connection dbconn = DBConnection.connectDB();
                PreparedStatement st = null;
                try {
                    st = (PreparedStatement)dbconn.prepareStatement("DELETE FROM `books` WHERE `bookID` ="+textID.getText());

                } catch (SQLException e1) {

                    e1.printStackTrace();
                }

                try {
                    st.executeUpdate();
                    RefreshQuery();
                } catch (SQLException e1) {

                    e1.printStackTrace();
                }
            }
        });
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
        btnDelete.setBackground(new Color(255, 102, 51));
        btnDelete.setBounds(659, 205, 100, 40);
        contentPane_1.add(btnDelete);

        JButton btnEdit = new JButton("Edit");
        btnEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connection dbconn = DBConnection.connectDB();
                PreparedStatement st = null;
                try {
                    st = (PreparedStatement)dbconn.prepareStatement("UPDATE `books` SET `titlu`='"+textTitlu.getText()+"',`autor`='"+textAutor.getText()+"',`nrbucati`='"+textNrbucati.getText()+"' ,`pret`="+textPret.getText()+" WHERE `bookID` = "+textID.getText());

                } catch (SQLException e1) {

                    e1.printStackTrace();
                }
                try {
                    st.executeUpdate();
                    RefreshQuery();
                } catch (SQLException e1) {

                    e1.printStackTrace();
                }

            }
        });
        btnEdit.setForeground(Color.WHITE);
        btnEdit.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
        btnEdit.setBackground(new Color(255, 102, 51));
        btnEdit.setBounds(521, 205, 100, 40);
        contentPane_1.add(btnEdit);

        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textID.setText("");
                textTitlu.setText("");
                textAutor.setText("");
                textNrbucati.setText("");
                textPret.setText("");

            }
        });


        btnClear.setForeground(Color.WHITE);
        btnClear.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
        btnClear.setBackground(new Color(255, 102, 51));
        btnClear.setBounds(800, 205, 100, 40);
        contentPane_1.add(btnClear);

        JButton btnExport = new JButton("Export books");
        btnExport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fchoose = new JFileChooser();
                int option = fchoose.showSaveDialog(Manage.this);
                if(option == JFileChooser.APPROVE_OPTION) {
                    String name = fchoose.getSelectedFile().getName();
                    String path = fchoose.getSelectedFile().getParentFile().getPath();
                    String file = path + "\\" + name + ".xls";
                    export(displayTable, new File(file));
                }
            }
        });
        btnExport.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnExport.setForeground(Color.WHITE);
        btnExport.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
        btnExport.setBackground(new Color(208, 79, 79));
        btnExport.setBounds(670, 525, 189, 25);
        contentPane_1.add(btnExport);



    }
}
