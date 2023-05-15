/*
 * Java-Rice - An Interactive Food Ordering System group project for Intermediate Proggraming
 * 
 * Group Members:
 * 1. Kurt Daniel S. Cano
 * 2. Mike Rufino J. Caram II
 * 3. Joshua O. Lonoza
 * 4. Kevin A. Llanes
 * 5. Jhon Keneth Ryan B. Namias
 */

package Java_Rice;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class Main_menu extends javax.swing.JFrame {

    Home_source OOP = new Home_source();

    public Main_menu() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);

        data_load();
        data();
        sDate();
        sTime();
        setDate();
        setTime();
        cdata();
        org.jdesktop.swingx.autocomplete.AutoCompleteDecorator.decorate(jComboBox1);
        org.jdesktop.swingx.autocomplete.AutoCompleteDecorator.decorate(jComboBox2);
        org.jdesktop.swingx.autocomplete.AutoCompleteDecorator.decorate(jComboBox3);
        org.jdesktop.swingx.autocomplete.AutoCompleteDecorator.decorate(jComboBox4);
        org.jdesktop.swingx.autocomplete.AutoCompleteDecorator.decorate(jComboBox5);
        sdata();
        stockdata();
        dataLoad();
        costumerdata();
        costumerd();
        ccdata();
    }

    public void cdata() {
        try {
            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("select product_name from tblproduct order by `product_name` asc ");

            Vector v = new Vector();

            while (rs.next()) {
                v.add(rs.getString("product_name"));
                DefaultComboBoxModel c = new DefaultComboBoxModel(v);
                jComboBox1.setModel(c);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void ccdata() {
        try {
            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("select product_name from tblproduct order by `product_name` asc ");

            Vector r = new Vector();

            while (rs.next()) {
                r.add(rs.getString("product_name"));
                DefaultComboBoxModel c = new DefaultComboBoxModel(r);
                jComboBox5.setModel(c);

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void costumerdata() {
        try {
            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("select fname from tblcostumer order by `fname` asc ");

            Vector v = new Vector();

            while (rs.next()) {
                v.add(rs.getString("fname"));
                DefaultComboBoxModel c = new DefaultComboBoxModel(v);
                jComboBox2.setModel(c);

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void costumerd() {
        try {
            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("select fname from tblcostumer order by `fname` asc ");

            Vector v = new Vector();

            while (rs.next()) {
                v.add(rs.getString("fname"));
                DefaultComboBoxModel c = new DefaultComboBoxModel(v);
                jComboBox4.setModel(c);

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void sDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        posdate.setText(s.format(d));

    }

    public void sTime() {

        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
                postime.setText(s.format(d));
            }
        }
        ).start();
    }

    public void setDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        daTE.setText(s.format(d));

    }

    public void setTime() {

        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
                tiME.setText(s.format(d));
            }
        }
        ).start();
    }

    public void data_load() {

        try {
            DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
            table.setRowCount(0);

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery(" select * from tblcostumer ");

            while (rs.next()) {
                Vector r = new Vector();

                r.add(rs.getString(1));
                r.add(rs.getString(2));
                r.add(rs.getString(3));
                r.add(rs.getString(4));
                r.add(rs.getString(5));
                r.add(rs.getString(6));
                r.add(rs.getString(7));
                r.add(rs.getString(8));
                r.add(rs.getString(9));
                table.addRow(r);
            }
        } catch (Exception x) {
            System.out.println(x.getMessage());

        }
    }

    public void data() {

        try {
            DefaultTableModel table1 = (DefaultTableModel) jTable2.getModel();
            table1.setRowCount(0);

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery(" select * from tblproduct ");

            while (rs.next()) {
                Vector r = new Vector();

                r.add(rs.getString(1));
                r.add(rs.getString(2));
                r.add(rs.getString(3));
                r.add(rs.getString(4));
                r.add(rs.getString(5));
                r.add(rs.getString(6));
                r.add(rs.getString(7));
                r.add(rs.getString(8));
                r.add(rs.getString(9));
                table1.addRow(r);
            }
        } catch (Exception x) {
            System.out.println(x.getMessage());

        }
    }

    public void sdata() {

        try {
            DefaultTableModel table1 = (DefaultTableModel) jTable4.getModel();
            table1.setRowCount(0);

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("select `selling_id`,`product_id`,`product_name`,sum(`quantity`),sum(`total_price`) FROM `tblselling`  GROUP BY `product_id` order by sum(`quantity`) desc");

            while (rs.next()) {

                Vector r = new Vector();

                r.add(rs.getString(1));
                r.add(rs.getString(2));
                r.add(rs.getString(3));
                r.add(rs.getString(4));
                r.add(rs.getString(5));
                table1.addRow(r);

            }
        } catch (Exception x) {
            System.out.println(x.getMessage());

        }
    }

    public void stockdata() {

        try {
            DefaultTableModel table1 = (DefaultTableModel) jTable5.getModel();
            table1.setRowCount(0);

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("select prod_id,product_name,quantity from tblproduct");

            while (rs.next()) {
                Vector r = new Vector();

                r.add(rs.getString(1));
                r.add(rs.getString(2));
                r.add(rs.getString(3));
                table1.addRow(r);
            }
        } catch (Exception x) {
            System.out.println(x.getMessage());
        }
    }

    public void total_purchase() {

        int numofrow = jTable3.getRowCount();

        double total = 0;
        int i;

        for (i = 0; i < numofrow; i++) {

            double value = Double.valueOf(jTable3.getValueAt(i, 4).toString());
            total += value;
        }

        total_purchase.setText(Double.toString(total));

        int numofrows = jTable3.getRowCount();
        double totals = 0;
        int ii;
        for (ii = 0; ii < numofrows; ii++) {

            double values = Double.valueOf(jTable3.getValueAt(ii, 2).toString());
            totals += values;

        }
        total_qty.setText(Double.toString(totals));

        int row = jTable4.getRowCount();
        double totalsss = 0;
        int iiii;
        for (iiii = 0; iiii < row; iiii++) {

            double values = Double.valueOf(jTable4.getValueAt(iiii, 3).toString());
            totalsss += values;

        }
        tot_quantity.setText(Double.toString(totalsss));

        int rowS = jTable6.getRowCount();
        double totalssss = 0;
        int iiiii;
        for (iiiii = 0; iiiii < rowS; iiiii++) {

            double values = Double.valueOf(jTable6.getValueAt(iiiii, 4).toString());
            totalssss += values;

        }
        Total_Income.setText(Double.toString(totalssss));

    }

    public void mark_up() {

        Double mar = Double.valueOf(mark_p.getText());
        Double qty = Double.valueOf(jSpinner1.getValue().toString());
        Double mark_Up;

        mark_Up = mar * qty;

        mark_p.setText(String.valueOf(mark_Up));
    }

    public void dataLoad() {

        try {

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("select * from tblnum where numid = 1");

            if (rs.next()) {
                jLabel75.setText(rs.getString("value"));
            }
        } catch (Exception x) {
            System.out.println(x.getMessage());
        }
        int i = Integer.valueOf(jLabel75.getText());
        i++;
        jLabel75.setText(String.valueOf(i));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel_choose = new javax.swing.JPanel();
        panel_pos = new javax.swing.JPanel();
        chooose_POS = new javax.swing.JLabel();
        panel_cos = new javax.swing.JPanel();
        choose_COSTUMER = new javax.swing.JLabel();
        panel_prod = new javax.swing.JPanel();
        choose_PRODUCT = new javax.swing.JLabel();
        panel_income = new javax.swing.JPanel();
        choose_INCOME = new javax.swing.JLabel();
        panel_invoice = new javax.swing.JPanel();
        choose_INVOICE = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        Panelhome = new javax.swing.JPanel();
        jLabel94 = new javax.swing.JLabel();
        panel_invoice1 = new javax.swing.JPanel();
        choose_SETTINGS = new javax.swing.JLabel();
        panel_invoice2 = new javax.swing.JPanel();
        choose_SETTINGS1 = new javax.swing.JLabel();
        panel_main = new javax.swing.JPanel();
        home = new javax.swing.JPanel();
        jPanel71 = new javax.swing.JPanel();
        home_pos = new javax.swing.JPanel();
        jLabel102 = new javax.swing.JLabel();
        home_costumer = new javax.swing.JPanel();
        jLabel109 = new javax.swing.JLabel();
        home_product = new javax.swing.JPanel();
        jLabel110 = new javax.swing.JLabel();
        home_most = new javax.swing.JPanel();
        jLabel111 = new javax.swing.JLabel();
        home_stock = new javax.swing.JPanel();
        jLabel112 = new javax.swing.JLabel();
        home_remove = new javax.swing.JPanel();
        jLabel113 = new javax.swing.JLabel();
        home_income = new javax.swing.JPanel();
        jLabel114 = new javax.swing.JLabel();
        home_invoice = new javax.swing.JPanel();
        jLabel115 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        daTE = new javax.swing.JLabel();
        tiME = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        Costumer = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        fname = new javax.swing.JLabel();
        costumerName = new javax.swing.JTextField();
        lname = new javax.swing.JLabel();
        costumerLastname = new javax.swing.JTextField();
        sex = new javax.swing.JLabel();
        costumerSex = new javax.swing.JTextField();
        address = new javax.swing.JLabel();
        costumerAddress = new javax.swing.JTextField();
        costumerNumber = new javax.swing.JTextField();
        contact = new javax.swing.JLabel();
        costumerEmail = new javax.swing.JTextField();
        email = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        costumerID = new javax.swing.JTextField();
        jPanel63 = new javax.swing.JPanel();
        csearch = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel64 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panel_a = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        panel_s = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        panel_u = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        panel_d = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        panel_c = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel61 = new javax.swing.JPanel();
        jPanel62 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        POS = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        stocks = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        panel_cart = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jPanel7 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        total_purchase = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        avail_stocks = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        mark_p = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        paid = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        change = new javax.swing.JLabel();
        pAy = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        rEmove = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        rEfresh = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        t_price = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        total_qty = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        product_id = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        unit_price = new javax.swing.JLabel();
        postime = new javax.swing.JLabel();
        posdate = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        sellingID = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel14 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        log = new javax.swing.JLabel();
        jPanel65 = new javax.swing.JPanel();
        jLabel106 = new javax.swing.JLabel();
        Product = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        pname = new javax.swing.JLabel();
        product = new javax.swing.JTextField();
        b_code = new javax.swing.JLabel();
        bar_code = new javax.swing.JTextField();
        pri = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        qua = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        mark_up = new javax.swing.JTextField();
        m_up = new javax.swing.JLabel();
        exp_date = new javax.swing.JTextField();
        edate = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        pid = new javax.swing.JTextField();
        jPanel57 = new javax.swing.JPanel();
        jPanel59 = new javax.swing.JPanel();
        jPanel67 = new javax.swing.JPanel();
        product_MOST = new javax.swing.JLabel();
        jPanel68 = new javax.swing.JPanel();
        product_STOCKS = new javax.swing.JLabel();
        jPanel69 = new javax.swing.JPanel();
        product_REMOVE = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jPanel60 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        panel_all = new javax.swing.JPanel();
        product_ALL = new javax.swing.JLabel();
        panel_p = new javax.swing.JPanel();
        product_SAVE = new javax.swing.JLabel();
        panelu = new javax.swing.JPanel();
        product_UPDATE = new javax.swing.JLabel();
        panel_del = new javax.swing.JPanel();
        product_DELETE = new javax.swing.JLabel();
        panel_clear = new javax.swing.JPanel();
        product_REFRESH = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel56 = new javax.swing.JPanel();
        jPanel58 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        psearch = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        Selling = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        panel_day = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        panel_Refresh = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jPanel53 = new javax.swing.JPanel();
        m_search = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jPanel55 = new javax.swing.JPanel();
        tot_quantity = new javax.swing.JLabel();
        Stock_in = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        panel_UPdate = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        panel_REfresh = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel96 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel21 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        addd = new javax.swing.JTextField();
        jPanel40 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        ans = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        Removed = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jPanel45 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        income_search1 = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        panel_DAY1 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        panel_REFRESH1 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        profit1 = new javax.swing.JLabel();
        Income = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        panel_DAY = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        panel_REFRESH = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        income_search = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        profit = new javax.swing.JLabel();
        jPanel51 = new javax.swing.JPanel();
        Total_Income = new javax.swing.JLabel();
        Invoice = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jPanel31 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jPanel33 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel85 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        UNPAID = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        PAID = new javax.swing.JLabel();
        PARTIAL = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        paRTIAL = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        unPAID = new javax.swing.JLabel();
        jPanel66 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        pay_balance = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        Total_Income2 = new javax.swing.JLabel();
        pay_all = new javax.swing.JPanel();
        jLabel98 = new javax.swing.JLabel();
        pay_unpaid = new javax.swing.JPanel();
        jLabel100 = new javax.swing.JLabel();
        pay_refresh = new javax.swing.JPanel();
        jLabel99 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));

        jPanel1.setLayout(new java.awt.BorderLayout());

        panel_choose.setBackground(new java.awt.Color(54, 65, 77));

        panel_pos.setBackground(new java.awt.Color(84, 86, 91));
        panel_pos.setForeground(new java.awt.Color(255, 255, 255));

        chooose_POS.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        chooose_POS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chooose_POS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_sale_price_tag_30px.png"))); // NOI18N
        chooose_POS.setText("Point of Sale");
        chooose_POS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chooose_POSMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                chooose_POSMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                chooose_POSMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_posLayout = new javax.swing.GroupLayout(panel_pos);
        panel_pos.setLayout(panel_posLayout);
        panel_posLayout.setHorizontalGroup(
            panel_posLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chooose_POS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_posLayout.setVerticalGroup(
            panel_posLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chooose_POS, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        panel_cos.setBackground(new java.awt.Color(84, 86, 91));

        choose_COSTUMER.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        choose_COSTUMER.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        choose_COSTUMER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_parenting_30px_1.png"))); // NOI18N
        choose_COSTUMER.setText("Costumer");
        choose_COSTUMER.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                choose_COSTUMERMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                choose_COSTUMERMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                choose_COSTUMERMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_cosLayout = new javax.swing.GroupLayout(panel_cos);
        panel_cos.setLayout(panel_cosLayout);
        panel_cosLayout.setHorizontalGroup(
            panel_cosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(choose_COSTUMER, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_cosLayout.setVerticalGroup(
            panel_cosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(choose_COSTUMER, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        panel_prod.setBackground(new java.awt.Color(84, 86, 91));

        choose_PRODUCT.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        choose_PRODUCT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        choose_PRODUCT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_product_30px_1.png"))); // NOI18N
        choose_PRODUCT.setText("Products");
        choose_PRODUCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                choose_PRODUCTMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                choose_PRODUCTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                choose_PRODUCTMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_prodLayout = new javax.swing.GroupLayout(panel_prod);
        panel_prod.setLayout(panel_prodLayout);
        panel_prodLayout.setHorizontalGroup(
            panel_prodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(choose_PRODUCT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_prodLayout.setVerticalGroup(
            panel_prodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(choose_PRODUCT, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        panel_income.setBackground(new java.awt.Color(84, 86, 91));

        choose_INCOME.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        choose_INCOME.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        choose_INCOME.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_cost_30px_1.png"))); // NOI18N
        choose_INCOME.setText("Income");
        choose_INCOME.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                choose_INCOMEMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                choose_INCOMEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                choose_INCOMEMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_incomeLayout = new javax.swing.GroupLayout(panel_income);
        panel_income.setLayout(panel_incomeLayout);
        panel_incomeLayout.setHorizontalGroup(
            panel_incomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(choose_INCOME, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_incomeLayout.setVerticalGroup(
            panel_incomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(choose_INCOME, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        panel_invoice.setBackground(new java.awt.Color(84, 86, 91));

        choose_INVOICE.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        choose_INVOICE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        choose_INVOICE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_invoice_25px.png"))); // NOI18N
        choose_INVOICE.setText("Invoice");
        choose_INVOICE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                choose_INVOICEMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                choose_INVOICEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                choose_INVOICEMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_invoiceLayout = new javax.swing.GroupLayout(panel_invoice);
        panel_invoice.setLayout(panel_invoiceLayout);
        panel_invoiceLayout.setHorizontalGroup(
            panel_invoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(choose_INVOICE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_invoiceLayout.setVerticalGroup(
            panel_invoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(choose_INVOICE, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jPanel16.setBackground(new java.awt.Color(84, 86, 91));
        jPanel16.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel74.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(51, 204, 0));
        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Java-Rice-Logo-2 - small.png"))); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel74, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Panelhome.setBackground(new java.awt.Color(84, 86, 91));

        jLabel94.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel94.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel94.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_home_25px.png"))); // NOI18N
        jLabel94.setText("Home");
        jLabel94.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel94MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel94MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel94MouseExited(evt);
            }
        });

        javax.swing.GroupLayout PanelhomeLayout = new javax.swing.GroupLayout(Panelhome);
        Panelhome.setLayout(PanelhomeLayout);
        PanelhomeLayout.setHorizontalGroup(
            PanelhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel94, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelhomeLayout.setVerticalGroup(
            PanelhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel94, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        panel_invoice1.setBackground(new java.awt.Color(84, 86, 91));

        choose_SETTINGS.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        choose_SETTINGS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        choose_SETTINGS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_settings_20px_1.png"))); // NOI18N
        choose_SETTINGS.setText("Settings");
        choose_SETTINGS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                choose_SETTINGSMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                choose_SETTINGSMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                choose_SETTINGSMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_invoice1Layout = new javax.swing.GroupLayout(panel_invoice1);
        panel_invoice1.setLayout(panel_invoice1Layout);
        panel_invoice1Layout.setHorizontalGroup(
            panel_invoice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(choose_SETTINGS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_invoice1Layout.setVerticalGroup(
            panel_invoice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(choose_SETTINGS, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
        );

        panel_invoice2.setBackground(new java.awt.Color(84, 86, 91));

        choose_SETTINGS1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        choose_SETTINGS1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        choose_SETTINGS1.setText("About Us");
        choose_SETTINGS1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                choose_SETTINGS1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                choose_SETTINGS1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                choose_SETTINGS1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_invoice2Layout = new javax.swing.GroupLayout(panel_invoice2);
        panel_invoice2.setLayout(panel_invoice2Layout);
        panel_invoice2Layout.setHorizontalGroup(
            panel_invoice2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(choose_SETTINGS1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_invoice2Layout.setVerticalGroup(
            panel_invoice2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(choose_SETTINGS1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel_chooseLayout = new javax.swing.GroupLayout(panel_choose);
        panel_choose.setLayout(panel_chooseLayout);
        panel_chooseLayout.setHorizontalGroup(
            panel_chooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_cos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_pos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_invoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_prod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_income, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Panelhome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_invoice1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_invoice2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_chooseLayout.setVerticalGroup(
            panel_chooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_chooseLayout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Panelhome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel_pos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel_cos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel_prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel_income, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel_invoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel_invoice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(panel_invoice2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel1.add(panel_choose, java.awt.BorderLayout.LINE_START);

        panel_main.setBackground(new java.awt.Color(51, 102, 255));
        panel_main.setLayout(new java.awt.CardLayout());

        home.setBackground(new java.awt.Color(54, 65, 77));
        home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel71.setBackground(new java.awt.Color(54, 65, 77));
        jPanel71.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        home_pos.setBackground(new java.awt.Color(255, 255, 255));

        jLabel102.setFont(new java.awt.Font("Bodoni MT Condensed", 1, 24)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(0, 204, 51));
        jLabel102.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_add_shopping_cart_50px.png"))); // NOI18N
        jLabel102.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLabel102.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel102MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel102MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel102MouseExited(evt);
            }
        });

        javax.swing.GroupLayout home_posLayout = new javax.swing.GroupLayout(home_pos);
        home_pos.setLayout(home_posLayout);
        home_posLayout.setHorizontalGroup(
            home_posLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel102, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        home_posLayout.setVerticalGroup(
            home_posLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home_posLayout.createSequentialGroup()
                .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        home_costumer.setBackground(new java.awt.Color(255, 255, 255));

        jLabel109.setFont(new java.awt.Font("Bodoni MT Condensed", 1, 24)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(0, 204, 51));
        jLabel109.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_parenting_50px_2.png"))); // NOI18N
        jLabel109.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLabel109.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel109MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel109MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel109MouseExited(evt);
            }
        });

        javax.swing.GroupLayout home_costumerLayout = new javax.swing.GroupLayout(home_costumer);
        home_costumer.setLayout(home_costumerLayout);
        home_costumerLayout.setHorizontalGroup(
            home_costumerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel109, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        home_costumerLayout.setVerticalGroup(
            home_costumerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home_costumerLayout.createSequentialGroup()
                .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        home_product.setBackground(new java.awt.Color(255, 255, 255));

        jLabel110.setFont(new java.awt.Font("Bodoni MT Condensed", 1, 24)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(0, 204, 51));
        jLabel110.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel110.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_product_50px.png"))); // NOI18N
        jLabel110.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLabel110.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel110MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel110MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel110MouseExited(evt);
            }
        });

        javax.swing.GroupLayout home_productLayout = new javax.swing.GroupLayout(home_product);
        home_product.setLayout(home_productLayout);
        home_productLayout.setHorizontalGroup(
            home_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel110, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        home_productLayout.setVerticalGroup(
            home_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home_productLayout.createSequentialGroup()
                .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        home_most.setBackground(new java.awt.Color(255, 255, 255));

        jLabel111.setFont(new java.awt.Font("Bodoni MT Condensed", 1, 24)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(0, 204, 51));
        jLabel111.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_shopping_bag_50px.png"))); // NOI18N
        jLabel111.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLabel111.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel111MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel111MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel111MouseExited(evt);
            }
        });

        javax.swing.GroupLayout home_mostLayout = new javax.swing.GroupLayout(home_most);
        home_most.setLayout(home_mostLayout);
        home_mostLayout.setHorizontalGroup(
            home_mostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel111, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        home_mostLayout.setVerticalGroup(
            home_mostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home_mostLayout.createSequentialGroup()
                .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        home_stock.setBackground(new java.awt.Color(255, 255, 255));

        jLabel112.setFont(new java.awt.Font("Bodoni MT Condensed", 1, 24)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(0, 204, 51));
        jLabel112.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_out_of_stock_50px.png"))); // NOI18N
        jLabel112.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLabel112.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel112MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel112MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel112MouseExited(evt);
            }
        });

        javax.swing.GroupLayout home_stockLayout = new javax.swing.GroupLayout(home_stock);
        home_stock.setLayout(home_stockLayout);
        home_stockLayout.setHorizontalGroup(
            home_stockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel112, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        home_stockLayout.setVerticalGroup(
            home_stockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home_stockLayout.createSequentialGroup()
                .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        home_remove.setBackground(new java.awt.Color(255, 255, 255));

        jLabel113.setFont(new java.awt.Font("Bodoni MT Condensed", 1, 24)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(0, 204, 51));
        jLabel113.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel113.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_delete_bin_50px.png"))); // NOI18N
        jLabel113.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLabel113.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel113MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel113MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel113MouseExited(evt);
            }
        });

        javax.swing.GroupLayout home_removeLayout = new javax.swing.GroupLayout(home_remove);
        home_remove.setLayout(home_removeLayout);
        home_removeLayout.setHorizontalGroup(
            home_removeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel113, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        home_removeLayout.setVerticalGroup(
            home_removeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home_removeLayout.createSequentialGroup()
                .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        home_income.setBackground(new java.awt.Color(255, 255, 255));

        jLabel114.setFont(new java.awt.Font("Bodoni MT Condensed", 1, 24)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(0, 204, 51));
        jLabel114.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel114.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_chart_50px.png"))); // NOI18N
        jLabel114.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLabel114.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel114MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel114MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel114MouseExited(evt);
            }
        });

        javax.swing.GroupLayout home_incomeLayout = new javax.swing.GroupLayout(home_income);
        home_income.setLayout(home_incomeLayout);
        home_incomeLayout.setHorizontalGroup(
            home_incomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel114, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        home_incomeLayout.setVerticalGroup(
            home_incomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home_incomeLayout.createSequentialGroup()
                .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        home_invoice.setBackground(new java.awt.Color(255, 255, 255));

        jLabel115.setFont(new java.awt.Font("Bodoni MT Condensed", 1, 24)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(0, 204, 51));
        jLabel115.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel115.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_invoice_50px.png"))); // NOI18N
        jLabel115.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jLabel115.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel115MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel115MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel115MouseExited(evt);
            }
        });

        javax.swing.GroupLayout home_invoiceLayout = new javax.swing.GroupLayout(home_invoice);
        home_invoice.setLayout(home_invoiceLayout);
        home_invoiceLayout.setHorizontalGroup(
            home_invoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel115, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        home_invoiceLayout.setVerticalGroup(
            home_invoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home_invoiceLayout.createSequentialGroup()
                .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel44.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Java Rice Homepage [TEST]");

        jPanel28.setBackground(new java.awt.Color(0, 0, 0));

        daTE.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        daTE.setForeground(new java.awt.Color(255, 255, 255));
        daTE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_calendar_8_20px.png"))); // NOI18N
        daTE.setText("date");

        tiME.setForeground(new java.awt.Color(255, 255, 255));
        tiME.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_clock_20px_3.png"))); // NOI18N
        tiME.setText("time");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(daTE)
                .addGap(72, 72, 72)
                .addComponent(tiME)
                .addGap(45, 45, 45))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(daTE)
                    .addComponent(tiME))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel71Layout = new javax.swing.GroupLayout(jPanel71);
        jPanel71.setLayout(jPanel71Layout);
        jPanel71Layout.setHorizontalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel71Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel71Layout.createSequentialGroup()
                        .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel71Layout.createSequentialGroup()
                                .addComponent(home_pos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(home_costumer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel71Layout.createSequentialGroup()
                                .addComponent(home_stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(home_remove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(home_income, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(home_product, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel71Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(home_invoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel71Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(home_most, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(153, Short.MAX_VALUE))
            .addComponent(jPanel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel71Layout.setVerticalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel71Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel44)
                .addGap(32, 32, 32)
                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel71Layout.createSequentialGroup()
                        .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(home_costumer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(home_product, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(home_most, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(home_income, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(home_remove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(home_invoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel71Layout.createSequentialGroup()
                        .addComponent(home_pos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(home_stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        home.add(jPanel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 870, 590));

        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_multiply_20px.png"))); // NOI18N
        jLabel56.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel56MouseClicked(evt);
            }
        });
        home.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, -1, 30));

        panel_main.add(home, "card3");

        Costumer.setBackground(new java.awt.Color(255, 255, 255));
        Costumer.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        Costumer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel2.setForeground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fname.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        fname.setForeground(new java.awt.Color(102, 102, 102));
        fname.setText("Name :");
        jPanel2.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        costumerName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        costumerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costumerNameActionPerformed(evt);
            }
        });
        jPanel2.add(costumerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 181, -1));

        lname.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        lname.setForeground(new java.awt.Color(102, 102, 102));
        lname.setText("Last name :");
        jPanel2.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        costumerLastname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel2.add(costumerLastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 181, -1));

        sex.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        sex.setForeground(new java.awt.Color(102, 102, 102));
        sex.setText("Sex :");
        jPanel2.add(sex, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        costumerSex.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel2.add(costumerSex, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, 181, -1));

        address.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        address.setForeground(new java.awt.Color(102, 102, 102));
        address.setText("Address :");
        jPanel2.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, -1, -1));

        costumerAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel2.add(costumerAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 350, 181, -1));

        costumerNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel2.add(costumerNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 390, 181, -1));

        contact.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        contact.setForeground(new java.awt.Color(102, 102, 102));
        contact.setText("Cellphone Number :");
        jPanel2.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 390, -1, -1));

        costumerEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel2.add(costumerEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 430, 181, -1));

        email.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        email.setForeground(new java.awt.Color(102, 102, 102));
        email.setText("Email Address :");
        jPanel2.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 430, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Costumer Id :");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        costumerID.setEditable(false);
        costumerID.setBackground(new java.awt.Color(255, 255, 255));
        costumerID.setAutoscrolls(false);
        costumerID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        costumerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costumerIDActionPerformed(evt);
            }
        });
        jPanel2.add(costumerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 181, -1));

        jPanel63.setBackground(new java.awt.Color(0, 0, 225));

        csearch.setBackground(new java.awt.Color(0, 0, 225));
        csearch.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        csearch.setForeground(new java.awt.Color(255, 255, 255));
        csearch.setText("Search name or last name");
        csearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        csearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                csearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                csearchKeyReleased(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_search_25px_1.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_irrigation_40px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(csearch, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(jLabel8)
                .addContainerGap(301, Short.MAX_VALUE))
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel63Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel63Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(csearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 70));

        jTable1.setBackground(new java.awt.Color(0, 0, 225));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Costumer Id.", "Name", "Last name", "Contact", "Sex", "Address", "Time", "Date", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionBackground(new java.awt.Color(230, 240, 230));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 850, 260));

        Costumer.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 850, 470));

        panel_a.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_paper_plane_30px_4.png"))); // NOI18N
        jLabel11.setText("All");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_aLayout = new javax.swing.GroupLayout(panel_a);
        panel_a.setLayout(panel_aLayout);
        panel_aLayout.setHorizontalGroup(
            panel_aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );
        panel_aLayout.setVerticalGroup(
            panel_aLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        Costumer.add(panel_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, -1, -1));

        panel_s.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_pin_30px_1.png"))); // NOI18N
        jLabel12.setText("Save");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_sLayout = new javax.swing.GroupLayout(panel_s);
        panel_s.setLayout(panel_sLayout);
        panel_sLayout.setHorizontalGroup(
            panel_sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );
        panel_sLayout.setVerticalGroup(
            panel_sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        Costumer.add(panel_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 550, -1, -1));

        panel_u.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_update_file_30px_1.png"))); // NOI18N
        jLabel13.setText("Update");
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_uLayout = new javax.swing.GroupLayout(panel_u);
        panel_u.setLayout(panel_uLayout);
        panel_uLayout.setHorizontalGroup(
            panel_uLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );
        panel_uLayout.setVerticalGroup(
            panel_uLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        Costumer.add(panel_u, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 550, -1, -1));

        panel_d.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_delete_file_30px_3.png"))); // NOI18N
        jLabel14.setText("Delete");
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel14MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_dLayout = new javax.swing.GroupLayout(panel_d);
        panel_d.setLayout(panel_dLayout);
        panel_dLayout.setHorizontalGroup(
            panel_dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );
        panel_dLayout.setVerticalGroup(
            panel_dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        Costumer.add(panel_d, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 550, -1, -1));

        panel_c.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_sync_20px.png"))); // NOI18N
        jLabel15.setText("Refresh");
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel15MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_cLayout = new javax.swing.GroupLayout(panel_c);
        panel_c.setLayout(panel_cLayout);
        panel_cLayout.setHorizontalGroup(
            panel_cLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );
        panel_cLayout.setVerticalGroup(
            panel_cLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        Costumer.add(panel_c, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 550, -1, -1));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_pie_chart_report_30px.png"))); // NOI18N
        jLabel16.setText("Report's");
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        Costumer.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 550, -1, -1));

        jPanel61.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel61Layout = new javax.swing.GroupLayout(jPanel61);
        jPanel61.setLayout(jPanel61Layout);
        jPanel61Layout.setHorizontalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        jPanel61Layout.setVerticalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        Costumer.add(jPanel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 20));

        jPanel62.setBackground(new java.awt.Color(54, 65, 77));
        jPanel62.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_parenting_20px.png"))); // NOI18N
        jLabel1.setText("Costumer Information ");

        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(jPanel62);
        jPanel62.setLayout(jPanel62Layout);
        jPanel62Layout.setHorizontalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel1)
                .addContainerGap(600, Short.MAX_VALUE))
        );
        jPanel62Layout.setVerticalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        Costumer.add(jPanel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 850, 50));

        panel_main.add(Costumer, "card3");

        POS.setBackground(new java.awt.Color(255, 255, 255));
        POS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                POSMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                POSMouseExited(evt);
            }
        });
        POS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel4MouseEntered(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setBackground(new java.awt.Color(0, 0, 0));
        jComboBox1.setEditable(true);
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default" }));
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jComboBox1MouseExited(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel4.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 145, -1));

        jLabel31.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Available Stocks :");
        jPanel4.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Select product :");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel32.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Quantity :");
        jPanel4.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        stocks.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        stocks.setForeground(new java.awt.Color(255, 255, 255));
        stocks.setText("0");
        jPanel4.add(stocks, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        jPanel9.setBackground(new java.awt.Color(230, 240, 230));
        jPanel9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jTable3.setBackground(new java.awt.Color(0, 51, 255));
        jTable3.setForeground(new java.awt.Color(255, 255, 255));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Id", "Product name", "Quantity", "Unit price", "Total price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setSelectionBackground(new java.awt.Color(255, 102, 0));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTable3MouseExited(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 600, 240));

        panel_cart.setBackground(new java.awt.Color(255, 255, 255));

        jLabel40.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 0, 204));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_shopping_cart_20px.png"))); // NOI18N
        jLabel40.setText("Add to Cart");
        jLabel40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel40MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel40MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel40MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_cartLayout = new javax.swing.GroupLayout(panel_cart);
        panel_cart.setLayout(panel_cartLayout);
        panel_cartLayout.setHorizontalGroup(
            panel_cartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_cartLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_cartLayout.setVerticalGroup(
            panel_cartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_cartLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.add(panel_cart, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 60, 150, 40));

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });
        jSpinner1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jSpinner1KeyReleased(evt);
            }
        });
        jPanel4.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 145, -1));

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));

        jLabel48.setFont(new java.awt.Font("Segoe UI Emoji", 0, 20)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Sub Total");

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0)));

        total_purchase.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        total_purchase.setForeground(new java.awt.Color(204, 0, 0));
        total_purchase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        total_purchase.setText("0.0");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(total_purchase, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(total_purchase, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel48)
                .addGap(33, 33, 33)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel48)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 590, 70));

        POS.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 590, 420));

        jPanel5.setBackground(new java.awt.Color(0, 0, 255));

        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setText("1");

        jLabel76.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_tick_box_20px_3.png"))); // NOI18N
        jLabel76.setText("Transaction No.");

        jLabel73.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_bell_20px.png"))); // NOI18N
        jLabel73.setText("0");
        jLabel73.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel73MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel76)
                .addGap(28, 28, 28)
                .addComponent(jLabel75)
                .addGap(148, 148, 148)
                .addComponent(jLabel73)
                .addContainerGap(236, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel75)
                    .addComponent(jLabel76)
                    .addComponent(jLabel73))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        POS.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 590, 20));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        avail_stocks.setForeground(new java.awt.Color(255, 255, 0));
        avail_stocks.setText("0.0");

        jLabel61.setForeground(new java.awt.Color(145, 194, 141));
        jLabel61.setText("0.0");

        jLabel62.setForeground(new java.awt.Color(145, 194, 141));
        jLabel62.setText("0.0");

        mark_p.setBackground(new java.awt.Color(145, 194, 141));
        mark_p.setForeground(new java.awt.Color(145, 194, 141));
        mark_p.setText("0.0");

        jLabel77.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(102, 102, 102));
        jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_apple_logo_20px.png"))); // NOI18N
        jLabel77.setText("Paid amount");

        paid.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        paid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        paid.setText("0.0");
        paid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        paid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                paidKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                paidKeyReleased(evt);
            }
        });

        jLabel78.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(102, 102, 102));
        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_logo_30px.png"))); // NOI18N
        jLabel78.setText("Change");

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        change.setBackground(new java.awt.Color(255, 255, 255));
        change.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        change.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        change.setText("0.0");
        change.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(change, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(change, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel77)
                .addGap(18, 18, 18)
                .addComponent(paid, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel78)
                .addGap(28, 28, 28)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(230, 230, 230)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel61)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(avail_stocks)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel62)
                        .addGap(51, 51, 51)
                        .addComponent(mark_p)
                        .addGap(111, 111, 111))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(avail_stocks)
                            .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mark_p))
                        .addGap(16, 16, 16)
                        .addComponent(jLabel61))
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(paid, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel77)
                        .addComponent(jLabel78))
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        POS.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 850, -1));

        pAy.setBackground(new java.awt.Color(0, 255, 255));
        pAy.setForeground(new java.awt.Color(255, 255, 255));

        jLabel42.setBackground(new java.awt.Color(255, 255, 255));
        jLabel42.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_tick_box_30px_1.png"))); // NOI18N
        jLabel42.setText("Done");
        jLabel42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel42MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel42MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel42MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pAyLayout = new javax.swing.GroupLayout(pAy);
        pAy.setLayout(pAyLayout);
        pAyLayout.setHorizontalGroup(
            pAyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        pAyLayout.setVerticalGroup(
            pAyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        POS.add(pAy, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 140, -1));

        rEmove.setBackground(new java.awt.Color(0, 255, 255));

        jLabel52.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_file_delete_30px.png"))); // NOI18N
        jLabel52.setText("Remove");
        jLabel52.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel52MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel52MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel52MouseExited(evt);
            }
        });

        javax.swing.GroupLayout rEmoveLayout = new javax.swing.GroupLayout(rEmove);
        rEmove.setLayout(rEmoveLayout);
        rEmoveLayout.setHorizontalGroup(
            rEmoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        rEmoveLayout.setVerticalGroup(
            rEmoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        POS.add(rEmove, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 550, 140, -1));

        rEfresh.setBackground(new java.awt.Color(0, 255, 255));

        jLabel53.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_refresh_30px.png"))); // NOI18N
        jLabel53.setText("Refresh");
        jLabel53.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel53MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel53MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel53MouseExited(evt);
            }
        });

        javax.swing.GroupLayout rEfreshLayout = new javax.swing.GroupLayout(rEfresh);
        rEfresh.setLayout(rEfreshLayout);
        rEfreshLayout.setHorizontalGroup(
            rEfreshLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel53, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        rEfreshLayout.setVerticalGroup(
            rEfreshLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        POS.add(rEfresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 550, 140, -1));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel34.setText("Total unit price :");
        jPanel8.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        t_price.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        t_price.setText("0.0");
        jPanel8.add(t_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, -1, -1));

        jLabel35.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel35.setText("Total quantity :");
        jPanel8.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        total_qty.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        total_qty.setText("0.0");
        jPanel8.add(total_qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, -1, -1));

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel7.setText("Product Id :");
        jPanel8.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        product_id.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        product_id.setText("0.0");
        jPanel8.add(product_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, -1, -1));

        jLabel33.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel33.setText("Unit price :");
        jPanel8.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        unit_price.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        unit_price.setText("0.0");
        jPanel8.add(unit_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, -1, -1));

        postime.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        postime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_clock_20px_3.png"))); // NOI18N
        postime.setText("TIME");
        jPanel8.add(postime, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        posdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_calendar_8_20px.png"))); // NOI18N
        posdate.setText("DATE");
        jPanel8.add(posdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        jPanel20.setBackground(new java.awt.Color(153, 153, 153));
        jPanel20.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 153)));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 240, 10));

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(255, 255, 255));
        jTextField2.setFont(new java.awt.Font("Bradley Hand ITC", 1, 14)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("Date & Time");
        jTextField2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel8.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 140, -1));

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(0, 51, 153)));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 260, 10));

        jLabel50.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel50.setText("Selling ID :");
        jPanel8.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        sellingID.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        sellingID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sellingID.setText("0");
        jPanel8.add(sellingID, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 30, -1));

        jLabel79.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel79.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_parenting_20px.png"))); // NOI18N
        jLabel79.setText("Costumer :");
        jPanel8.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, -1));

        jComboBox2.setBackground(new java.awt.Color(0, 0, 0));
        jComboBox2.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Regular Costumer" }));
        jPanel8.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 140, -1));

        POS.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 260, 440));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel80.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(102, 102, 102));
        jLabel80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_add_shopping_cart_20px.png"))); // NOI18N
        jLabel80.setText("Java Rice - An Interactive Food Ordering System  ");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(229, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        POS.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 30));

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel36.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel36.setText("Logged in :");

        log.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        log.setForeground(new java.awt.Color(0, 0, 204));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(log, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        POS.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 550, 260, -1));

        jPanel65.setBackground(new java.awt.Color(255, 255, 255));

        jLabel106.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel106.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel106.setText("Log Out ");
        jLabel106.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jLabel106.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel106MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel106MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel106MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel106, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel106, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
        );

        POS.add(jPanel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 580, 260, 20));

        panel_main.add(POS, "card2");

        Product.setBackground(new java.awt.Color(255, 255, 255));
        Product.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pname.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        pname.setForeground(new java.awt.Color(102, 102, 102));
        pname.setText("Product name :");
        jPanel3.add(pname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        product.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel3.add(product, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 181, -1));

        b_code.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        b_code.setForeground(new java.awt.Color(102, 102, 102));
        b_code.setText("Bar_code :");
        jPanel3.add(b_code, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        bar_code.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel3.add(bar_code, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 181, -1));

        pri.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        pri.setForeground(new java.awt.Color(102, 102, 102));
        pri.setText("Price :");
        jPanel3.add(pri, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        price.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel3.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 181, -1));

        qua.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        qua.setForeground(new java.awt.Color(102, 102, 102));
        qua.setText("Quantity :");
        jPanel3.add(qua, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, -1, -1));

        quantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel3.add(quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, 181, -1));

        mark_up.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel3.add(mark_up, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 380, 181, -1));

        m_up.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        m_up.setForeground(new java.awt.Color(102, 102, 102));
        m_up.setText("Mark up :");
        jPanel3.add(m_up, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 380, -1, -1));

        exp_date.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel3.add(exp_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 410, 181, -1));

        edate.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        edate.setForeground(new java.awt.Color(102, 102, 102));
        edate.setText("Expiration date :");
        jPanel3.add(edate, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 410, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Product Id :");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        pid.setEditable(false);
        pid.setBackground(new java.awt.Color(255, 255, 255));
        pid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pidActionPerformed(evt);
            }
        });
        jPanel3.add(pid, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 181, -1));

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 850, 50));

        jPanel59.setBackground(new java.awt.Color(0, 0, 225));

        jPanel67.setBackground(new java.awt.Color(0, 0, 204));

        product_MOST.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        product_MOST.setForeground(new java.awt.Color(255, 255, 255));
        product_MOST.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        product_MOST.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_sell_stock_20px.png"))); // NOI18N
        product_MOST.setText("Most selling product");
        product_MOST.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        product_MOST.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                product_MOSTMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                product_MOSTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                product_MOSTMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel67Layout = new javax.swing.GroupLayout(jPanel67);
        jPanel67.setLayout(jPanel67Layout);
        jPanel67Layout.setHorizontalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(product_MOST, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanel67Layout.setVerticalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(product_MOST, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel68.setBackground(new java.awt.Color(0, 0, 225));

        product_STOCKS.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        product_STOCKS.setForeground(new java.awt.Color(255, 255, 255));
        product_STOCKS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        product_STOCKS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_out_of_stock_20px_3.png"))); // NOI18N
        product_STOCKS.setText("Stocks");
        product_STOCKS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        product_STOCKS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                product_STOCKSMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                product_STOCKSMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                product_STOCKSMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel68Layout = new javax.swing.GroupLayout(jPanel68);
        jPanel68.setLayout(jPanel68Layout);
        jPanel68Layout.setHorizontalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(product_STOCKS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanel68Layout.setVerticalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(product_STOCKS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel69.setBackground(new java.awt.Color(0, 0, 225));

        product_REMOVE.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        product_REMOVE.setForeground(new java.awt.Color(255, 255, 255));
        product_REMOVE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        product_REMOVE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_delete_bin_20px.png"))); // NOI18N
        product_REMOVE.setText("Removed Items");
        product_REMOVE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        product_REMOVE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                product_REMOVEMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                product_REMOVEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                product_REMOVEMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel69Layout = new javax.swing.GroupLayout(jPanel69);
        jPanel69.setLayout(jPanel69Layout);
        jPanel69Layout.setHorizontalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(product_REMOVE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanel69Layout.setVerticalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(product_REMOVE)
        );

        jLabel101.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(255, 255, 255));
        jLabel101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_irrigation_40px.png"))); // NOI18N
        jLabel101.setToolTipText("");

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(jLabel101)
                .addGap(56, 56, 56))
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel59Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel101, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addGroup(jPanel59Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel3.add(jPanel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 70));

        jTable2.setBackground(new java.awt.Color(0, 0, 255));
        jTable2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jTable2.setForeground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Id", "Product name", "Bar code", "Price", "Quantity", "Mark up", "Expiration date", "Date", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setSelectionBackground(new java.awt.Color(230, 240, 230));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel60Layout = new javax.swing.GroupLayout(jPanel60);
        jPanel60.setLayout(jPanel60Layout);
        jPanel60Layout.setHorizontalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );
        jPanel60Layout.setVerticalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 850, 260));

        Product.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 850, 470));

        panel_all.setBackground(new java.awt.Color(255, 255, 255));

        product_ALL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        product_ALL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_paper_plane_30px_4.png"))); // NOI18N
        product_ALL.setText("All");
        product_ALL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        product_ALL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                product_ALLMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                product_ALLMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                product_ALLMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_allLayout = new javax.swing.GroupLayout(panel_all);
        panel_all.setLayout(panel_allLayout);
        panel_allLayout.setHorizontalGroup(
            panel_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(product_ALL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );
        panel_allLayout.setVerticalGroup(
            panel_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(product_ALL, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        Product.add(panel_all, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, -1, -1));

        panel_p.setBackground(new java.awt.Color(255, 255, 255));

        product_SAVE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        product_SAVE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_pin_30px_1.png"))); // NOI18N
        product_SAVE.setText("Save");
        product_SAVE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        product_SAVE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                product_SAVEMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                product_SAVEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                product_SAVEMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_pLayout = new javax.swing.GroupLayout(panel_p);
        panel_p.setLayout(panel_pLayout);
        panel_pLayout.setHorizontalGroup(
            panel_pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(product_SAVE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );
        panel_pLayout.setVerticalGroup(
            panel_pLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(product_SAVE, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        Product.add(panel_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 550, -1, -1));

        panelu.setBackground(new java.awt.Color(255, 255, 255));

        product_UPDATE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        product_UPDATE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_update_file_30px_1.png"))); // NOI18N
        product_UPDATE.setText("Update");
        product_UPDATE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        product_UPDATE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                product_UPDATEMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                product_UPDATEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                product_UPDATEMouseExited(evt);
            }
        });

        javax.swing.GroupLayout paneluLayout = new javax.swing.GroupLayout(panelu);
        panelu.setLayout(paneluLayout);
        paneluLayout.setHorizontalGroup(
            paneluLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(product_UPDATE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );
        paneluLayout.setVerticalGroup(
            paneluLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(product_UPDATE, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        Product.add(panelu, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 550, -1, -1));

        panel_del.setBackground(new java.awt.Color(255, 255, 255));

        product_DELETE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        product_DELETE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_delete_file_30px_3.png"))); // NOI18N
        product_DELETE.setText("Delete");
        product_DELETE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        product_DELETE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                product_DELETEMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                product_DELETEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                product_DELETEMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_delLayout = new javax.swing.GroupLayout(panel_del);
        panel_del.setLayout(panel_delLayout);
        panel_delLayout.setHorizontalGroup(
            panel_delLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(product_DELETE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );
        panel_delLayout.setVerticalGroup(
            panel_delLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(product_DELETE, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        Product.add(panel_del, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 550, -1, -1));

        panel_clear.setBackground(new java.awt.Color(255, 255, 255));

        product_REFRESH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        product_REFRESH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_sync_20px.png"))); // NOI18N
        product_REFRESH.setText("Refresh");
        product_REFRESH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        product_REFRESH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                product_REFRESHMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                product_REFRESHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                product_REFRESHMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_clearLayout = new javax.swing.GroupLayout(panel_clear);
        panel_clear.setLayout(panel_clearLayout);
        panel_clearLayout.setHorizontalGroup(
            panel_clearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(product_REFRESH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );
        panel_clearLayout.setVerticalGroup(
            panel_clearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(product_REFRESH, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        Product.add(panel_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 550, -1, -1));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_pie_chart_report_30px.png"))); // NOI18N
        jLabel27.setText("Report's");
        jLabel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        Product.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 550, -1, -1));

        jPanel56.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        Product.add(jPanel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 20));

        jPanel58.setBackground(new java.awt.Color(0, 204, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_product_30px_2.png"))); // NOI18N
        jLabel2.setText("Product Information");

        psearch.setBackground(new java.awt.Color(0, 204, 0));
        psearch.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        psearch.setForeground(new java.awt.Color(255, 255, 255));
        psearch.setText("Search product name");
        psearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        psearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                psearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                psearchKeyReleased(evt);
            }
        });

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_search_25px_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(psearch, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel58Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(psearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Product.add(jPanel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 850, 50));

        panel_main.add(Product, "card3");

        Selling.setBackground(new java.awt.Color(255, 255, 255));
        Selling.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel17.setBackground(new java.awt.Color(145, 194, 141));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable4.setBackground(new java.awt.Color(0, 0, 255));
        jTable4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jTable4.setForeground(new java.awt.Color(255, 255, 255));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Selling Id", "Product Id", "Product name", "Quantity", "Total income"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.setSelectionBackground(new java.awt.Color(230, 240, 230));
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(3).setHeaderValue("Quantity");
            jTable4.getColumnModel().getColumn(4).setHeaderValue("Total income");
        }

        jPanel17.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 280));

        Selling.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 850, 270));

        panel_day.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_upward_arrow_20px_1.png"))); // NOI18N
        jLabel6.setText("This Day");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_dayLayout = new javax.swing.GroupLayout(panel_day);
        panel_day.setLayout(panel_dayLayout);
        panel_dayLayout.setHorizontalGroup(
            panel_dayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        panel_dayLayout.setVerticalGroup(
            panel_dayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Selling.add(panel_day, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 160, 40));

        panel_Refresh.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_sync_20px.png"))); // NOI18N
        jLabel17.setText("Refresh");
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_RefreshLayout = new javax.swing.GroupLayout(panel_Refresh);
        panel_Refresh.setLayout(panel_RefreshLayout);
        panel_RefreshLayout.setHorizontalGroup(
            panel_RefreshLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        panel_RefreshLayout.setVerticalGroup(
            panel_RefreshLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Selling.add(panel_Refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 520, 170, 40));

        jPanel19.setBackground(new java.awt.Color(230, 240, 230));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        Selling.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 20));

        jPanel52.setBackground(new java.awt.Color(0, 204, 0));

        jLabel37.setBackground(new java.awt.Color(230, 230, 230));
        jLabel37.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_open_box_25px.png"))); // NOI18N
        jLabel37.setText("Most Selling Product");

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(539, Short.MAX_VALUE))
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        Selling.add(jPanel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 850, 50));

        jPanel53.setBackground(new java.awt.Color(0, 0, 255));

        m_search.setBackground(new java.awt.Color(0, 0, 255));
        m_search.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        m_search.setForeground(new java.awt.Color(255, 255, 255));
        m_search.setText("Enter date for monitoring");
        m_search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        m_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                m_searchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                m_searchKeyReleased(evt);
            }
        });

        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_search_25px_1.png"))); // NOI18N

        jLabel38.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_irrigation_40px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel59)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(m_search, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159)
                .addComponent(jLabel38)
                .addContainerGap(242, Short.MAX_VALUE))
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel38)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(m_search, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        Selling.add(jPanel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 850, 70));

        jPanel54.setBackground(new java.awt.Color(255, 255, 255));
        jPanel54.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel57.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(102, 102, 102));
        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_handcart_15px.png"))); // NOI18N
        jLabel57.setText("Total Items Sold");

        jPanel55.setBackground(new java.awt.Color(255, 255, 0));

        tot_quantity.setFont(new java.awt.Font("Segoe UI Emoji", 1, 16)); // NOI18N
        tot_quantity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tot_quantity.setText("0.0");

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tot_quantity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tot_quantity, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addGap(326, 590, Short.MAX_VALUE)
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel54Layout.createSequentialGroup()
                        .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel54Layout.createSequentialGroup()
                        .addComponent(jLabel57)
                        .addGap(78, 78, 78))))
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel57)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        Selling.add(jPanel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 850, -1));

        panel_main.add(Selling, "card3");

        Stock_in.setBackground(new java.awt.Color(255, 255, 255));
        Stock_in.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel18.setBackground(new java.awt.Color(0, 0, 255));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setBackground(new java.awt.Color(230, 240, 230));
        jLabel45.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_shipped_30px.png"))); // NOI18N
        jLabel45.setText("Stocks");
        jPanel18.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 150, 20));

        jLabel97.setForeground(new java.awt.Color(255, 255, 255));
        jLabel97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_bell_20px.png"))); // NOI18N
        jPanel18.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        Stock_in.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 850, 40));

        panel_UPdate.setBackground(new java.awt.Color(255, 255, 255));

        jLabel55.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_database_backup_25px.png"))); // NOI18N
        jLabel55.setText("Update Stocks");
        jLabel55.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel55.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel55MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel55MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel55MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_UPdateLayout = new javax.swing.GroupLayout(panel_UPdate);
        panel_UPdate.setLayout(panel_UPdateLayout);
        panel_UPdateLayout.setHorizontalGroup(
            panel_UPdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel55, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
        );
        panel_UPdateLayout.setVerticalGroup(
            panel_UPdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Stock_in.add(panel_UPdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, -1, -1));

        panel_REfresh.setBackground(new java.awt.Color(255, 255, 255));

        jLabel60.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_sync_20px.png"))); // NOI18N
        jLabel60.setText("Refresh");
        jLabel60.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel60MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel60MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel60MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_REfreshLayout = new javax.swing.GroupLayout(panel_REfresh);
        panel_REfresh.setLayout(panel_REfreshLayout);
        panel_REfreshLayout.setHorizontalGroup(
            panel_REfreshLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel60, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
        );
        panel_REfreshLayout.setVerticalGroup(
            panel_REfreshLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Stock_in.add(panel_REfresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, 210, -1));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        Stock_in.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 20));

        jPanel38.setBackground(new java.awt.Color(0, 204, 0));

        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_search_25px_1.png"))); // NOI18N

        jComboBox5.setBackground(new java.awt.Color(0, 0, 0));
        jComboBox5.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        jLabel96.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(255, 255, 255));
        jLabel96.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_irrigation_40px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel63)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(201, 201, 201)
                .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(264, Short.MAX_VALUE))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel63)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel96, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                .addContainerGap())
        );

        Stock_in.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 850, 70));

        jTable5.setBackground(new java.awt.Color(0, 204, 0));
        jTable5.setForeground(new java.awt.Color(255, 255, 255));
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Id", "Product name", "Available stocks "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable5.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable5);

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Stock_in.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 850, 230));

        jPanel21.setBackground(new java.awt.Color(51, 51, 51));
        jPanel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel47.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(102, 102, 102));
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_key_20px_1.png"))); // NOI18N
        jLabel47.setText("Product Id");

        jLabel58.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(102, 102, 102));
        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_out_of_stock_20px.png"))); // NOI18N
        jLabel58.setText("Stocks available");

        jLabel49.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(102, 102, 102));
        jLabel49.setText("Add Stocks");

        addd.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        addd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel40.setBackground(new java.awt.Color(153, 153, 153));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jPanel42.setBackground(new java.awt.Color(153, 153, 153));

        jLabel95.setBackground(new java.awt.Color(255, 255, 0));
        jLabel95.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel95.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel95.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel95, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel95, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ans.setForeground(new java.awt.Color(255, 255, 255));
        ans.setText("0");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47)
                    .addComponent(jLabel49))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addd, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50)
                .addComponent(jLabel58)
                .addGap(18, 18, 18)
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ans, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ans)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel47)
                                .addComponent(jLabel58))
                            .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel49))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(addd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        Stock_in.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 850, 120));

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));

        jLabel66.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_out_of_stock_20px_2.png"))); // NOI18N
        jLabel66.setText("Out of  stocks");
        jLabel66.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel66MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel66MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel66MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel66, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Stock_in.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 490, 190, 40));

        panel_main.add(Stock_in, "card3");

        Removed.setBackground(new java.awt.Color(255, 255, 255));
        Removed.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable7.setBackground(new java.awt.Color(0, 0, 255));
        jTable7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jTable7.setForeground(new java.awt.Color(255, 255, 255));
        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Remove Id", "Remove By", "Product  Id", "Product name", "Quantity", "Unit price", "Date", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable7.setSelectionBackground(new java.awt.Color(230, 240, 230));
        jTable7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable7MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTable7);
        if (jTable7.getColumnModel().getColumnCount() > 0) {
            jTable7.getColumnModel().getColumn(7).setHeaderValue("Date");
        }

        jPanel25.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 850, 280));

        jPanel45.setBackground(new java.awt.Color(0, 0, 255));

        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_search_25px_1.png"))); // NOI18N

        income_search1.setBackground(new java.awt.Color(0, 0, 255));
        income_search1.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        income_search1.setForeground(new java.awt.Color(255, 255, 255));
        income_search1.setText("Enter date for monitoring");
        income_search1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        income_search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                income_search1ActionPerformed(evt);
            }
        });
        income_search1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                income_search1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                income_search1KeyReleased(evt);
            }
        });

        jLabel105.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(255, 255, 255));
        jLabel105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_irrigation_40px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel72)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(income_search1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139)
                .addComponent(jLabel105)
                .addContainerGap(233, Short.MAX_VALUE))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(income_search1)
                            .addComponent(jLabel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel105)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel25.add(jPanel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 70));

        Removed.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 850, 340));

        panel_DAY1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_upward_arrow_20px_1.png"))); // NOI18N
        jLabel20.setText("This Day");
        jLabel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel20MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_DAY1Layout = new javax.swing.GroupLayout(panel_DAY1);
        panel_DAY1.setLayout(panel_DAY1Layout);
        panel_DAY1Layout.setHorizontalGroup(
            panel_DAY1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        panel_DAY1Layout.setVerticalGroup(
            panel_DAY1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Removed.add(panel_DAY1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 160, 40));

        panel_REFRESH1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_sync_20px.png"))); // NOI18N
        jLabel29.setText("Refresh");
        jLabel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel29MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel29MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_REFRESH1Layout = new javax.swing.GroupLayout(panel_REFRESH1);
        panel_REFRESH1.setLayout(panel_REFRESH1Layout);
        panel_REFRESH1Layout.setHorizontalGroup(
            panel_REFRESH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        panel_REFRESH1Layout.setVerticalGroup(
            panel_REFRESH1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Removed.add(panel_REFRESH1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 520, 170, 40));

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        Removed.add(jPanel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 20));

        jPanel44.setBackground(new java.awt.Color(0, 204, 51));

        jLabel69.setBackground(new java.awt.Color(230, 230, 230));
        jLabel69.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_transaction_declined_20px.png"))); // NOI18N
        jLabel69.setText("Transaction declined");

        jLabel103.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(255, 255, 255));
        jLabel103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_bell_20px.png"))); // NOI18N
        jLabel103.setText("0");

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154)
                .addComponent(jLabel103)
                .addContainerGap(386, Short.MAX_VALUE))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel103)
                    .addComponent(jLabel69))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Removed.add(jPanel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 850, 40));

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel71.setBackground(new java.awt.Color(102, 102, 102));
        jLabel71.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(102, 102, 102));
        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_handcart_15px.png"))); // NOI18N
        jLabel71.setText("Total Quantity");

        jPanel46.setBackground(new java.awt.Color(255, 255, 0));

        profit1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 16)); // NOI18N
        profit1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profit1.setText("0.0");

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profit1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profit1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap(617, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                        .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel71)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Removed.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 850, 110));

        panel_main.add(Removed, "card3");

        Income.setBackground(new java.awt.Color(255, 255, 255));
        Income.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel23.setBackground(new java.awt.Color(145, 194, 141));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable6.setBackground(new java.awt.Color(0, 0, 255));
        jTable6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jTable6.setForeground(new java.awt.Color(255, 255, 255));
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Selling Id", "Product Id", "Product name", "Quantity", "Total price", "Unit price", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable6.setSelectionBackground(new java.awt.Color(230, 240, 230));
        jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable6MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable6);

        jPanel23.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 280));

        Income.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 850, 270));

        panel_DAY.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_upward_arrow_20px_1.png"))); // NOI18N
        jLabel18.setText("This Day");
        jLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel18MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_DAYLayout = new javax.swing.GroupLayout(panel_DAY);
        panel_DAY.setLayout(panel_DAYLayout);
        panel_DAYLayout.setHorizontalGroup(
            panel_DAYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        panel_DAYLayout.setVerticalGroup(
            panel_DAYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Income.add(panel_DAY, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 160, 40));

        panel_REFRESH.setBackground(new java.awt.Color(255, 255, 255));

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_sync_20px.png"))); // NOI18N
        jLabel28.setText("Refresh");
        jLabel28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel28MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel28MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_REFRESHLayout = new javax.swing.GroupLayout(panel_REFRESH);
        panel_REFRESH.setLayout(panel_REFRESHLayout);
        panel_REFRESHLayout.setHorizontalGroup(
            panel_REFRESHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        panel_REFRESHLayout.setVerticalGroup(
            panel_REFRESHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Income.add(panel_REFRESH, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 520, 170, 40));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        Income.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 20));

        jPanel47.setBackground(new java.awt.Color(0, 204, 0));

        jLabel43.setBackground(new java.awt.Color(230, 230, 230));
        jLabel43.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_investment_portfolio_30px.png"))); // NOI18N
        jLabel43.setText("Income Monitoring");

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel43)
                .addContainerGap(593, Short.MAX_VALUE))
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Income.add(jPanel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 850, 50));

        jPanel48.setBackground(new java.awt.Color(0, 0, 255));

        income_search.setBackground(new java.awt.Color(0, 0, 255));
        income_search.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        income_search.setForeground(new java.awt.Color(255, 255, 255));
        income_search.setText("Enter date for monitoring");
        income_search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        income_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                income_searchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                income_searchKeyReleased(evt);
            }
        });

        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_search_25px_1.png"))); // NOI18N

        jLabel70.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_irrigation_40px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel68)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(income_search, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184)
                .addComponent(jLabel70)
                .addContainerGap(210, Short.MAX_VALUE))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(income_search))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Income.add(jPanel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 850, 70));

        jPanel49.setBackground(new java.awt.Color(255, 255, 255));
        jPanel49.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel49.setForeground(new java.awt.Color(255, 255, 255));

        jLabel46.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(102, 102, 102));
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_handcart_15px.png"))); // NOI18N
        jLabel46.setText("Total Sales");

        jLabel67.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(102, 102, 102));
        jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_sales_performance_20px_1.png"))); // NOI18N
        jLabel67.setText("Total profit");

        jPanel50.setBackground(new java.awt.Color(255, 255, 0));

        profit.setFont(new java.awt.Font("Segoe UI Emoji", 1, 16)); // NOI18N
        profit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profit.setText("0.0");

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profit, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
        );

        jPanel51.setBackground(new java.awt.Color(255, 255, 0));

        Total_Income.setFont(new java.awt.Font("Segoe UI Emoji", 1, 16)); // NOI18N
        Total_Income.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Total_Income.setText("0.0");

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Total_Income, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Total_Income, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap(416, Short.MAX_VALUE)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                        .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addGap(108, 108, 108)
                        .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67)
                    .addComponent(jLabel46))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Income.add(jPanel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 850, 100));

        panel_main.add(Income, "card3");

        Invoice.setBackground(new java.awt.Color(255, 255, 255));
        Invoice.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable8.setBackground(new java.awt.Color(0, 0, 255));
        jTable8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jTable8.setForeground(new java.awt.Color(255, 255, 255));
        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice Id", "User", "Costumer name", "Amount paid", "Status", "Balance", "Sub Total", "Total Quantity", "Transaction #", "Date", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable8.setSelectionBackground(new java.awt.Color(230, 240, 230));
        jTable8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable8MouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jTable8);

        jPanel30.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 850, 270));

        jPanel31.setBackground(new java.awt.Color(0, 204, 0));

        jLabel81.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(255, 255, 255));
        jLabel81.setText("Status");

        jComboBox3.setBackground(new java.awt.Color(0, 0, 0));
        jComboBox3.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Paid", "Unpaid", "Partial" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jPanel33.setBackground(new java.awt.Color(0, 0, 255));

        jLabel84.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_parenting_20px.png"))); // NOI18N
        jLabel84.setText("List of Costumer Invoice");

        jLabel93.setForeground(new java.awt.Color(255, 255, 255));
        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_bell_20px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel84)
                .addGap(181, 181, 181)
                .addComponent(jLabel93)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel84)
                    .addComponent(jLabel93))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel92.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(255, 255, 255));
        jLabel92.setText("Costumer");
        jLabel92.setToolTipText("");

        jComboBox4.setBackground(new java.awt.Color(0, 0, 0));
        jComboBox4.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        jComboBox4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jComboBox4MouseExited(evt);
            }
        });
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_irrigation_40px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel81)
                .addGap(28, 28, 28)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLabel92)
                .addGap(31, 31, 31)
                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                .addComponent(jLabel85)
                .addGap(94, 94, 94))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel81)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel92)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel85))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel30.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 120));

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));
        jPanel34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel34.setForeground(new java.awt.Color(153, 153, 153));

        jLabel83.setBackground(new java.awt.Color(255, 255, 255));
        jLabel83.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(102, 102, 102));
        jLabel83.setText("All Paid Invoice Amount");

        jLabel82.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(102, 102, 102));
        jLabel82.setText("Unpaid Invoice Amount");

        UNPAID.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        UNPAID.setForeground(new java.awt.Color(255, 0, 51));
        UNPAID.setText("0.0");

        jLabel88.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(102, 102, 102));
        jLabel88.setText("Partial Invoice Amount");

        jLabel90.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(102, 102, 102));
        jLabel90.setText("Onhand Amount");

        jPanel41.setBackground(new java.awt.Color(0, 0, 204));

        jLabel91.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(255, 255, 255));
        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel91.setText("0.0");

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel91, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel91, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PAID.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        PAID.setForeground(new java.awt.Color(0, 0, 204));
        PAID.setText("0.0");

        PARTIAL.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        PARTIAL.setForeground(new java.awt.Color(0, 204, 0));
        PARTIAL.setText("0.0");

        jLabel87.setText("Balance");

        jPanel36.setBackground(new java.awt.Color(255, 255, 51));

        paRTIAL.setForeground(new java.awt.Color(51, 51, 51));
        paRTIAL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paRTIAL.setText("0.0");

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paRTIAL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paRTIAL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel89.setText("Unpaid");

        jPanel37.setBackground(new java.awt.Color(204, 0, 0));

        unPAID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        unPAID.setText("0.0");

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(unPAID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(unPAID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        jPanel66.setBackground(new java.awt.Color(255, 255, 255));
        jPanel66.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(153, 153, 153)));

        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(jPanel66);
        jPanel66.setLayout(jPanel66Layout);
        jPanel66Layout.setHorizontalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel66Layout.setVerticalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel90)
                    .addComponent(jLabel88)
                    .addComponent(jLabel82)
                    .addComponent(jLabel83))
                .addGap(49, 49, 49)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PAID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(UNPAID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PARTIAL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel89)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel87)
                        .addGap(83, 83, 83))))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel87)
                            .addComponent(jLabel89))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 40, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel83)
                            .addComponent(PAID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UNPAID)
                            .addComponent(jLabel82, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel88)
                            .addComponent(PARTIAL, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel90, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))))
                .addContainerGap())
            .addComponent(jPanel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel30.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 850, 140));

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel30.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, -1, -1));

        Invoice.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 850, 520));

        pay_balance.setBackground(new java.awt.Color(255, 255, 255));

        jLabel86.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_apple_pay_35px.png"))); // NOI18N
        jLabel86.setText("Unpaid");
        jLabel86.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel86.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel86MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel86MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel86MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pay_balanceLayout = new javax.swing.GroupLayout(pay_balance);
        pay_balance.setLayout(pay_balanceLayout);
        pay_balanceLayout.setHorizontalGroup(
            pay_balanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pay_balanceLayout.createSequentialGroup()
                .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pay_balanceLayout.setVerticalGroup(
            pay_balanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel86, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Invoice.add(pay_balance, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 560, 130, 40));

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        Invoice.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 20));

        Total_Income2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 16)); // NOI18N
        Total_Income2.setForeground(new java.awt.Color(255, 255, 255));
        Total_Income2.setText("0.0");
        Invoice.add(Total_Income2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 540, -1, -1));

        pay_all.setBackground(new java.awt.Color(255, 255, 255));

        jLabel98.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel98.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel98.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_apple_pay_35px.png"))); // NOI18N
        jLabel98.setText("All");
        jLabel98.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel98.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel98MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel98MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel98MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pay_allLayout = new javax.swing.GroupLayout(pay_all);
        pay_all.setLayout(pay_allLayout);
        pay_allLayout.setHorizontalGroup(
            pay_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel98, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        pay_allLayout.setVerticalGroup(
            pay_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel98, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Invoice.add(pay_all, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 130, 40));

        pay_unpaid.setBackground(new java.awt.Color(255, 255, 255));

        jLabel100.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_apple_pay_35px.png"))); // NOI18N
        jLabel100.setText("Balance");
        jLabel100.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel100.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel100MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel100MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel100MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pay_unpaidLayout = new javax.swing.GroupLayout(pay_unpaid);
        pay_unpaid.setLayout(pay_unpaidLayout);
        pay_unpaidLayout.setHorizontalGroup(
            pay_unpaidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel100, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        pay_unpaidLayout.setVerticalGroup(
            pay_unpaidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel100, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Invoice.add(pay_unpaid, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 560, -1, -1));

        pay_refresh.setBackground(new java.awt.Color(255, 255, 255));

        jLabel99.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_sync_20px.png"))); // NOI18N
        jLabel99.setText("Refresh");
        jLabel99.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel99.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel99MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel99MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel99MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pay_refreshLayout = new javax.swing.GroupLayout(pay_refresh);
        pay_refresh.setLayout(pay_refreshLayout);
        pay_refreshLayout.setHorizontalGroup(
            pay_refreshLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel99, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        pay_refreshLayout.setVerticalGroup(
            pay_refreshLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel99, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Invoice.add(pay_refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 560, 130, 40));

        panel_main.add(Invoice, "card3");

        jPanel1.add(panel_main, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1136, 629));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void choose_COSTUMERMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choose_COSTUMERMouseClicked
        // TODO add your handling code here:
        OOP.glenn(Costumer, home, POS, Selling, Product, Stock_in, Income, Removed, Invoice);
    }//GEN-LAST:event_choose_COSTUMERMouseClicked

    private void csearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_csearchKeyPressed
        // TODO add your handling code here:
        if (csearch.getText().equals("Search name or last name")) {

            csearch.setText("");
        }
    }//GEN-LAST:event_csearchKeyPressed

    private void csearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_csearchKeyReleased
        // TODO add your handling code here:
        String search1 = csearch.getText();

        try {
            DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
            table.setRowCount(0);
            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("select * from tblcostumer where  FNAME like '%" + search1 + "%' or lname like '%" + search1 + "%' or cid like '%" + search1 + "%'");

            if (search1.isEmpty()) {
                data_load();
                csearch.setText("Search name or last name");
            } else {

                while (rs.next()) {

                    Object o[] = {rs.getString("CID"), rs.getString("FNAME"), rs.getString("LNAME"), rs.getString("CONTACT"), rs.getString("SEX"), rs.getString("address"), rs.getString("time"), rs.getString("date"), rs.getString("email")};
                    table.addRow(o);

                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_csearchKeyReleased

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        OOP.recolor(panel_a);
        try {
            DefaultTableModel table1 = (DefaultTableModel) jTable1.getModel();

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("select * from tblcostumer");
            table1.setRowCount(0);

            while (rs.next()) {

                Object o[] = {rs.getString("CID"), rs.getString("FNAME"), rs.getString("LNAME"), rs.getString("CONTACT"), rs.getString("SEX"), rs.getString("ADDRESS"), rs.getString("TIME"), rs.getString("DATE"), rs.getString("email")};
                table1.addRow(o);
                csearch.setText("Search name or last name");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
        // TODO add your handling code here:
        OOP.color(panel_a);
        jLabel11.setForeground(Color.orange);
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
        // TODO add your handling code here:
        OOP.recolor(panel_a);
        jLabel11.setForeground(Color.black);
    }//GEN-LAST:event_jLabel11MouseExited

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        try {

            String sql = ("insert into tblcostumer (`FNAME`,`LNAME`,`contact`,`sex`,`address`,`time`,`date`,`email`) values ('" + costumerName.getText() + "','" + costumerLastname.getText() + "','" + costumerNumber.getText() + "','" + costumerSex.getText() + "','" + costumerAddress.getText() + "','" + postime.getText() + "','" + posdate.getText() + "','" + costumerEmail.getText() + "')");
            Statement state = Home_source.mycon().createStatement();

            if (costumerName.getText().isEmpty() && costumerLastname.getText().isEmpty() && costumerNumber.getText().isEmpty() && costumerSex.getText().isEmpty() && costumerAddress.getText().isEmpty() && costumerEmail.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Invalid!!");

            } else if (!costumerID.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Costumer data already!!");

            } else {
                state.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Successfully saved..");
                OOP.clearupdate(costumerID, costumerName, costumerLastname, costumerNumber, costumerAddress, costumerSex, costumerEmail);
            }

        } catch (Exception x) {
            System.out.println(x.getMessage());
        }

        data_load();
        costumerdata();
        costumerd();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
        // TODO add your handling code here:
        OOP.color(panel_s);
        jLabel12.setForeground(Color.orange);
        if (costumerName.getText().isEmpty() && costumerLastname.getText().isEmpty() && costumerNumber.getText().isEmpty() && costumerSex.getText().isEmpty() && costumerAddress.getText().isEmpty() && costumerEmail.getText().isEmpty()) {
            OOP.empty(fname, lname, contact, sex, address, email);
        } else if (costumerName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your name");
        } else if (costumerLastname.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your Last name");
        } else if (costumerNumber.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your Contact number");
        } else if (costumerSex.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your gender");
        } else if (costumerAddress.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your address");
        } else if (costumerEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Please enter your email address");
        } else {
        }

    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
        // TODO add your handling code here:
        OOP.recolor(panel_s);
        jLabel12.setForeground(Color.black);
        OOP.settext(fname, lname, contact, sex, address, email);
    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        try {
            Statement state = Home_source.mycon().createStatement();
            if (costumerID.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Select from the box!!");
            } else {
                state.executeUpdate("update tblcostumer set  FNAME = '" + costumerName.getText() + "' , lname = '" + costumerLastname.getText() + "', contact = '" + costumerNumber.getText() + "', sex = '" + costumerSex.getText() + "', address = '" + costumerAddress.getText() + "', email = '" + costumerEmail.getText() + "' where cid = '" + costumerID.getText() + "'");
                JOptionPane.showMessageDialog(rootPane, "Successfully update!!");
                OOP.clearupdate(costumerID, costumerName, costumerLastname, costumerNumber, costumerAddress, costumerSex, costumerEmail);
                costumerID.setText("");
                csearch.setText("Search name or last name");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        data_load();
        costumerdata();
        costumerd();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void costumerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costumerIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_costumerIDActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        OOP.arraySettext(jTable1, costumerID, costumerName, costumerLastname, costumerNumber, costumerSex, costumerAddress, costumerEmail);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        // TODO add your handling code here:
        OOP.color(panel_u);
        jLabel13.setForeground(Color.orange);
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
        // TODO add your handling code here:
        OOP.recolor(panel_u);
        jLabel13.setForeground(Color.black);
    }//GEN-LAST:event_jLabel13MouseExited

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        try {
            Statement state = Home_source.mycon().createStatement();

            if (costumerID.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Select from the box!!");
            } else {
                state.executeUpdate("delete from tblcostumer where cid = '" + costumerID.getText() + "'");
                JOptionPane.showMessageDialog(null, "Delete successfully!!");
                OOP.clearupdate(costumerID, costumerName, costumerLastname, costumerNumber, costumerAddress, costumerSex, costumerEmail);
                csearch.setText("Search name or last name");
            }
        } catch (Exception x) {
            System.out.println(x.getMessage());
        }
        data_load();
        costumerdata();
        costumerd();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
        // TODO add your handling code here:
        OOP.color(panel_d);
        jLabel14.setForeground(Color.orange);
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited
        // TODO add your handling code here:
        OOP.recolor(panel_d);
        jLabel14.setForeground(Color.black);
    }//GEN-LAST:event_jLabel14MouseExited

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
        DefaultTableModel t = (DefaultTableModel) jTable1.getModel();
        t.setRowCount(0);
        OOP.clearupdate(costumerID, costumerName, costumerLastname, costumerNumber, costumerAddress, costumerSex, costumerEmail);
        csearch.setText("Search name or last name");
        data_load();
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered
        // TODO add your handling code here:
        OOP.color(panel_c);
        jLabel15.setForeground(Color.orange);
    }//GEN-LAST:event_jLabel15MouseEntered

    private void jLabel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseExited
        // TODO add your handling code here:
        jLabel15.setForeground(Color.black);
        OOP.recolor(panel_c);
    }//GEN-LAST:event_jLabel15MouseExited

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int t = jTable2.getSelectedRow();
        String p = jTable2.getValueAt(t, 0).toString();
        String pn = jTable2.getValueAt(t, 1).toString();
        String bc = jTable2.getValueAt(t, 2).toString();
        String pr = jTable2.getValueAt(t, 3).toString();
        String qty = jTable2.getValueAt(t, 4).toString();
        String mp = jTable2.getValueAt(t, 5).toString();
        String ed = jTable2.getValueAt(t, 7).toString();

        pid.setText(p);
        product.setText(pn);
        bar_code.setText(bc);
        price.setText(pr);
        mark_up.setText(mp);
        exp_date.setText(ed);
        quantity.setText(qty);
    }//GEN-LAST:event_jTable2MouseClicked

    private void pidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pidActionPerformed

    private void product_ALLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_ALLMouseClicked
        // TODO add your handling code here:
        try {
            DefaultTableModel table1 = (DefaultTableModel) jTable2.getModel();
            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("select * from tblproduct");
            table1.setRowCount(0);

            while (rs.next()) {

                Object o[] = {rs.getString("prod_id"), rs.getString("product_name"), rs.getString("bar_code"), rs.getString("price"), rs.getString("quantity"), rs.getString("mark_up"), rs.getString("exp_date"), rs.getString("date"), rs.getString("time")};
                table1.addRow(o);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_product_ALLMouseClicked

    private void product_ALLMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_ALLMouseEntered
        // TODO add your handling code here:
        OOP.color(panel_all);
        OOP.product_color1(product_ALL);
    }//GEN-LAST:event_product_ALLMouseEntered

    private void product_ALLMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_ALLMouseExited
        // TODO add your handling code here:
        OOP.recolor(panel_all);
        OOP.product_color3(product_ALL);
    }//GEN-LAST:event_product_ALLMouseExited

    private void product_SAVEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_SAVEMouseClicked
        // TODO add your handling code here:
        try {

            Statement state = Home_source.mycon().createStatement();

            if (product.getText().isEmpty() && bar_code.getText().isEmpty() && price.getText().isEmpty() && quantity.getText().isEmpty() && mark_up.getText().isEmpty() && exp_date.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Invalid!!");

            } else if (!pid.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Costumer data already!!");

            } else {
                state.executeUpdate("insert into tblproduct (`product_name`,`bar_code`,`price`,`quantity`,`mark_up`,`exp_date`,`date`,`time`) values ('" + product.getText() + "','" + bar_code.getText() + "','" + price.getText() + "','" + quantity.getText() + "','" + mark_up.getText() + "','" + exp_date.getText() + "','" + posdate.getText() + "','" + postime.getText() + "')");
                JOptionPane.showMessageDialog(null, "Successfully saved..");
                OOP.clearupdate(product, bar_code, price, mark_up, exp_date, pid, quantity);
            }

        } catch (Exception x) {
            System.out.println(x.getMessage());
        }
        data();
        cdata();
        ccdata();
    }//GEN-LAST:event_product_SAVEMouseClicked

    private void product_SAVEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_SAVEMouseEntered
        // TODO add your handling code here:
        OOP.color(panel_p);
        OOP.product_color1(product_SAVE);
        if (product.getText().isEmpty() && bar_code.getText().isEmpty() && price.getText().isEmpty() && quantity.getText().isEmpty() && mark_up.getText().isEmpty() && exp_date.getText().isEmpty()) {
            OOP.empty1(pname, b_code, pri, qua, m_up, edate);
        } else if (product.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter product name");
        } else if (bar_code.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter product bar code");
        } else if (price.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter product price");
        } else if (quantity.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter product quantity");
        } else if (mark_up.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter product mark_up price");
        } else if (exp_date.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Please enter product expiration date");
        } else {
        }
    }//GEN-LAST:event_product_SAVEMouseEntered

    private void product_SAVEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_SAVEMouseExited
        // TODO add your handling code here:
        OOP.product_color3(product_SAVE);
        OOP.recolor(panel_p);
        OOP.settext1(pname, b_code, pri, qua, m_up, edate);
    }//GEN-LAST:event_product_SAVEMouseExited

    private void product_UPDATEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_UPDATEMouseClicked
        // TODO add your handling code here:
        try {
            Statement state = Home_source.mycon().createStatement();
            if (pid.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Select from the box!!");
            } else {

                state.executeUpdate("update tblproduct set  product_name = '" + product.getText() + "' , bar_code = '" + bar_code.getText() + "', price = '" + price.getText() + "', mark_up = '" + mark_up.getText() + "', exp_date = '" + exp_date.getText() + "' where prod_id = '" + pid.getText() + "'");
                JOptionPane.showMessageDialog(rootPane, "Successfully update!!");
                OOP.clearupdate(product, bar_code, price, quantity, mark_up, exp_date, pid);
                pid.setText("");
                psearch.setText("Search product name");
                jComboBox1.setSelectedItem("select product");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        data();
        cdata();
        ccdata();
    }//GEN-LAST:event_product_UPDATEMouseClicked

    private void product_UPDATEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_UPDATEMouseEntered
        // TODO add your handling code here:
        OOP.color(panelu);
        OOP.product_color1(product_UPDATE);
    }//GEN-LAST:event_product_UPDATEMouseEntered

    private void product_UPDATEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_UPDATEMouseExited
        // TODO add your handling code here:
        OOP.recolor(panelu);
        OOP.product_color3(product_UPDATE);
    }//GEN-LAST:event_product_UPDATEMouseExited

    private void product_DELETEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_DELETEMouseClicked
        // TODO add your handling code here:
        try {

            Statement state = Home_source.mycon().createStatement();
            if (pid.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Select from the box");

            } else {
                state.executeUpdate("delete from tblproduct where prod_id = '" + pid.getText() + "'");
                JOptionPane.showMessageDialog(null, "Delete successfully!!");
                OOP.clearupdate(product, bar_code, price, mark_up, exp_date, pid, quantity);
                psearch.setText("Search product name");
            }
        } catch (Exception x) {
            System.out.println(x.getMessage());
        }
        data();
        cdata();
        ccdata();
    }//GEN-LAST:event_product_DELETEMouseClicked

    private void product_DELETEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_DELETEMouseEntered
        // TODO add your handling code here:
        OOP.color(panel_del);
        OOP.product_color1(product_DELETE);
    }//GEN-LAST:event_product_DELETEMouseEntered

    private void product_DELETEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_DELETEMouseExited
        // TODO add your handling code here:
        OOP.recolor(panel_del);
        OOP.product_color3(product_DELETE);
    }//GEN-LAST:event_product_DELETEMouseExited

    private void product_REFRESHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_REFRESHMouseClicked
        // TODO add your handling code here:
        DefaultTableModel tab = (DefaultTableModel) jTable2.getModel();
        tab.setRowCount(0);
        OOP.clearupdate(product, bar_code, price, mark_up, exp_date, pid, quantity);
        psearch.setText("Search product name");
        data();
    }//GEN-LAST:event_product_REFRESHMouseClicked

    private void product_REFRESHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_REFRESHMouseEntered
        // TODO add your handling code here:
        OOP.color(panel_clear);
        OOP.product_color1(product_REFRESH);
    }//GEN-LAST:event_product_REFRESHMouseEntered

    private void product_REFRESHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_REFRESHMouseExited
        // TODO add your handling code here:
        OOP.recolor(panel_clear);
        OOP.product_color3(product_REFRESH);
    }//GEN-LAST:event_product_REFRESHMouseExited

    private void psearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_psearchKeyPressed
        // TODO add your handling code here:
        if (psearch.getText().equals("Search product name")) {

            psearch.setText("");
        }
    }//GEN-LAST:event_psearchKeyPressed

    private void psearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_psearchKeyReleased
        // TODO add your handling code here:
        String search1 = psearch.getText();

        try {
            DefaultTableModel table = (DefaultTableModel) jTable2.getModel();
            table.setRowCount(0);
            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("select * from tblproduct where  product_name like '%" + search1 + "%' or bar_code like '%" + search1 + "%' or prod_id like '%" + search1 + "%'");

            if (search1.isEmpty()) {
                data();
                psearch.setText("Search product name");
            } else {

                while (rs.next()) {

                    Object o[] = {rs.getString("prod_id"), rs.getString("product_name"), rs.getString("bar_code"), rs.getString("price"), rs.getString("quantity"), rs.getString("mark_up"), rs.getString("exp_date"), rs.getString("date"), rs.getString("time")};
                    table.addRow(o);

                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_psearchKeyReleased

    private void choose_PRODUCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choose_PRODUCTMouseClicked
        // TODO add your handling code here:
        OOP.glenn(Product, home, POS, Selling, Costumer, Stock_in, Income, Removed, Invoice);
        data();
    }//GEN-LAST:event_choose_PRODUCTMouseClicked

    private void chooose_POSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chooose_POSMouseClicked
        // TODO add your handling code here:
        // OOP.settingDisableSliderON(PanelDisabler, goodness);

        OOP.glenn(POS, home, Costumer, Selling, Product, Stock_in, Income, Removed, Invoice);
        jComboBox2.setSelectedItem("Regular Costumer");
        jComboBox1.setSelectedItem("Select product");
    }//GEN-LAST:event_chooose_POSMouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String search = jComboBox1.getSelectedItem().toString();

        if (!sellingID.getText().equals("0")) {
            stocks.setText("0.0");
        } else {
            try {
                Statement state = Home_source.mycon().createStatement();
                ResultSet rs = state.executeQuery("select prod_id,price,product_name,mark_up,quantity  from tblproduct where product_name =  '" + search + "'");

                if (rs.next()) {

                    product_id.setText(rs.getString("prod_id"));
                    mark_p.setText(rs.getString("mark_up"));
                    avail_stocks.setText(rs.getString("quantity"));
                    unit_price.setText(rs.getString("price"));

                } else {
                }

                OOP.totalPurchase(jSpinner1, unit_price, t_price);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        // TODO add your handling code here: 

        int t = 0;
        if (avail_stocks.getText().equals("0.0")) {
            jSpinner1.setValue(t);

        } else if (!sellingID.getText().equals("0")) {
            jSpinner1.setValue(t);
            stocks.setText("0.0");
        } else {

        }
        OOP.availableStocks(jSpinner1, avail_stocks, stocks);
        OOP.totalPurchase(jSpinner1, unit_price, t_price);

        data();
    }//GEN-LAST:event_jSpinner1StateChanged

    private void jLabel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseClicked
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel) jTable3.getModel();
        int r = 0;

        if (product_id.getText().equals("0.0")) {
            JOptionPane.showMessageDialog(null, "Please select product");
        } else if (jSpinner1.getValue().equals(r)) {
            JOptionPane.showMessageDialog(null, "Please click quantity");
        } else {
            try {
                mark_up();
                Statement state = Home_source.mycon().createStatement();
                state.executeUpdate("insert into tblselling (`product_id`,`product_name`,`quantity`,`total_price`,`unit_price`,`profit`,`date`,`time`) values ('" + product_id.getText() + "','" + jComboBox1.getSelectedItem().toString() + "','" + jSpinner1.getValue().toString() + "','" + t_price.getText() + "','" + unit_price.getText() + "','" + mark_p.getText() + "','" + posdate.getText() + "','" + postime.getText() + "')");

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            try {

                Statement state = Home_source.mycon().createStatement();
                state.executeUpdate("update tblproduct set quantity = '" + stocks.getText() + "' where prod_id = '" + product_id.getText() + "'");

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            

            Vector v = new Vector();

            v.add(product_id.getText());
            v.add(jComboBox1.getSelectedItem().toString());
            v.add(jSpinner1.getValue().toString());
            v.add(unit_price.getText());
            v.add(t_price.getText());
            table.addRow(v);
            total_purchase();

            OOP.number(avail_stocks, mark_p, unit_price, t_price, product_id, stocks);
            jSpinner1.setValue(r);
            jComboBox1.setSelectedItem("Select product");
        }
        data();
        paid.setText("0.0");
        change.setText("0.0");
    }//GEN-LAST:event_jLabel40MouseClicked

    private void jSpinner1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSpinner1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jSpinner1KeyReleased

    private void jLabel40MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseEntered
        // TODO add your handling code here:
        OOP.recolor(panel_cart);
        jLabel40.setForeground(Color.green);
    }//GEN-LAST:event_jLabel40MouseEntered

    private void jLabel40MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseExited
        // TODO add your handling code here:
        OOP.color(panel_cart);
        jLabel40.setForeground(Color.blue);
    }//GEN-LAST:event_jLabel40MouseExited

    private void jLabel42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseClicked
        // TODO add your handling code here:
        if (total_qty.getText().equals("0.0")) {

        } else if (paid.getText().equals("0.0") && jComboBox2.getSelectedItem().equals("Regular Costumer")) {

        } else {
            Double tot = Double.valueOf(total_purchase.getText());
            Double p = Double.valueOf(paid.getText());

            String status = null;

            if (p.equals(0.0)) {
                status = "Unpaid";
            } else if (tot > p) {
                status = "Partial";
            } else if (tot <= p) {
                status = "Paid";
            }

            try {
                String idd = jLabel75.getText();
                Statement state = Home_source.mycon().createStatement();
                state.executeUpdate("update tblnum set value = '" + idd + "' where numid = 1");

            } catch (Exception x) {
                System.out.println(x.getMessage());
            }

            try {

                Statement state = Home_source.mycon().createStatement();
                state.executeUpdate("insert into tblinvoice (`user`,`Costumer`,`paid_amount`,`Status`,`Balance`,`sub_total`,`total_quantity`,`transaction_no`,`date`,`time`) values ('" + log.getText() + "','" + jComboBox2.getSelectedItem().toString() + "','" + paid.getText() + "','" + status + "','" + change.getText() + "','" + total_purchase.getText() + "','" + total_qty.getText() + "','" + jLabel75.getText() + "','" + posdate.getText() + "','" + postime.getText() + "')");
                jComboBox2.setSelectedItem("Regular Costumer");
            } catch (Exception x) {
                System.out.println(x.getMessage());
            }
            JOptionPane.showMessageDialog(null, "Transaction Completed..");
            paid.setText("0.0");
            total_purchase.setText("0.0");
            change.setText("0.0");
            total_qty.setText("0.0");
            DefaultTableModel table = (DefaultTableModel) jTable3.getModel();
            table.setRowCount(0);
        }
        dataLoad();
    }//GEN-LAST:event_jLabel42MouseClicked

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable4MouseClicked

    private void m_searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_m_searchKeyPressed
        // TODO add your handling code here:
        if (m_search.getText().equals("Enter date for monitoring")) {

            m_search.setText("");
        }
    }//GEN-LAST:event_m_searchKeyPressed

    private void m_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_m_searchKeyReleased
        // TODO add your handling code here:
        String m = m_search.getText();

        if (m.isEmpty()) {
            sdata();
            try {

                Statement state = Home_source.mycon().createStatement();
                ResultSet rs = state.executeQuery("SELECT sum(`total_price`), sum(`quantity`)  FROM `tblselling`");

                while (rs.next()) {
                    tot_quantity.setText(rs.getString("sum(`quantity`)"));
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            m_search.setText("Enter date for monitoring");

        } else {

            try {
                DefaultTableModel table = (DefaultTableModel) jTable4.getModel();
                table.setRowCount(0);
                Statement state = Home_source.mycon().createStatement();
                ResultSet rs = state.executeQuery("SELECT `selling_id`,`product_id`,`product_name`,sum(`quantity`),sum(`total_price`),`date` FROM `tblselling` WHERE `date` = '" + m + "' GROUP by  `product_id` order by sum(`quantity`) desc");

                while (rs.next()) {

                    Object o[] = {rs.getString("selling_id"), rs.getString("product_id"), rs.getString("product_name"), rs.getString("sum(`quantity`)"), rs.getString("sum(`total_price`)")};
                    table.addRow(o);

                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            try {

                Statement state = Home_source.mycon().createStatement();
                ResultSet rs = state.executeQuery("select sum(total_price),sum(quantity) from tblselling where date = '" + m + "'");

                while (rs.next()) {

                    tot_quantity.setText(rs.getString("sum(quantity)"));
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }
    }//GEN-LAST:event_m_searchKeyReleased

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        // TODO add your handling code here:
        Stocks stock = new Stocks();
        stock.show();
        if (!pid.getText().isEmpty()) {

            stock.Total.setText(pid.getText());
            DefaultTableModel table = (DefaultTableModel) jTable2.getModel();
            table.setRowCount(0);
        }

    }//GEN-LAST:event_jLabel27MouseClicked

    private void jComboBox1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1MouseExited

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        // TODO add your handling code here:
        int t = jTable5.getSelectedRow();
        String po = jTable5.getValueAt(t, 0).toString();
        String pno = jTable5.getValueAt(t, 2).toString();

        jLabel95.setText(po);
        jLabel5.setText(pno);
    }//GEN-LAST:event_jTable5MouseClicked

    private void jLabel55MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel55MouseClicked
        // TODO add your handling code here:
        if (jLabel95.getText().isEmpty()) {

        } else if (addd.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter number of stocks");

        } else {
            double st = Double.valueOf(addd.getText());
            double add = Double.valueOf(jLabel5.getText());
            double sum = st + add;

            ans.setText(String.valueOf(sum));
            try {
                Statement state = Home_source.mycon().createStatement();

                state.executeUpdate("update tblproduct set  quantity = '" + ans.getText() + "' where prod_id = '" + jLabel95.getText() + "'");
                JOptionPane.showMessageDialog(rootPane, "Successfully update!!");
                jLabel95.setText("");
                jLabel5.setText("");
                addd.setText("");
                ans.setText("");

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            try {

                Statement stat = Home_source.mycon().createStatement();
                ResultSet r = stat.executeQuery("SELECT count(*) FROM `tblproduct` WHERE `quantity` = '" + 0.0 + "'");

                while (r.next()) {

                    jLabel73.setText(r.getString("count(*)"));
                    jLabel97.setText(r.getString("count(*)"));

                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        stockdata();
    }//GEN-LAST:event_jLabel55MouseClicked

    private void jLabel60MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel60MouseClicked
        // TODO add your handling code here:
        jLabel95.setText("");
        jLabel5.setText("");
        addd.setText("");
        jComboBox5.setSelectedItem("Product");
        stockdata();
    }//GEN-LAST:event_jLabel60MouseClicked

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        int t = jTable3.getSelectedRow();
        String p = jTable3.getValueAt(t, 0).toString();
        String pn = jTable3.getValueAt(t, 1).toString();
        String bc = jTable3.getValueAt(t, 2).toString();
        String qty = jTable3.getValueAt(t, 4).toString();

        jLabel62.setText(bc);
        try {
            DefaultTableModel table = (DefaultTableModel) jTable5.getModel();
            table.setRowCount(0);
            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("SELECT `selling_id`,`product_id`,`unit_price`,`product_name`,`quantity` FROM `tblselling` where `product_id` = '" + p + "' and `product_name` = '" + pn + "' and `quantity` =  '" + bc + "' and `total_price`= '" + qty + "'");
            while (rs.next()) {
                sellingID.setText(rs.getString("selling_id"));
                product_id.setText(rs.getString("product_id"));
                unit_price.setText(rs.getString("unit_price"));
                jComboBox1.setSelectedItem(rs.getString("product_name"));
                total_qty.setText(rs.getString("quantity"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            DefaultTableModel table = (DefaultTableModel) jTable5.getModel();
            table.setRowCount(0);
            Statement state = Home_source.mycon().createStatement();
            ResultSet sr = state.executeQuery("SELECT `quantity`,`prod_id` FROM `tblproduct` where `prod_id` = '" + p + "'");
            while (sr.next()) {
                jLabel61.setText(sr.getString("quantity"));
                product_id.setText(sr.getString("prod_id"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        double Stock = Double.valueOf(jLabel61.getText());
        double qUantity = Double.valueOf(jLabel62.getText());

        double tOtal = Stock + qUantity;
        jLabel62.setText(String.valueOf(tOtal));

    }//GEN-LAST:event_jTable3MouseClicked

    private void jLabel52MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel52MouseClicked
        // TODO add your handling code here:         
        if (jLabel62.getText().equals("0.0")) {
        } else {
            try {
                DefaultTableModel table = (DefaultTableModel) jTable3.getModel();
                int rem = jTable3.getSelectedRow();
                Statement state = Home_source.mycon().createStatement();

                state.executeUpdate("delete from tblselling where selling_id = '" + sellingID.getText() + "'");
                state.executeUpdate("update tblproduct set `quantity` = '" + jLabel62.getText() + "' where prod_id = '" + product_id.getText() + "'");
                state.execute("insert into tblremove (`remove_by`,`product_id`,`product_name`,`quantity`,`unit_price`,`date`,`time`) values ('" + log.getText() + "','" + product_id.getText() + "','" + jComboBox1.getSelectedItem().toString() + "','" + total_qty.getText() + "','" + unit_price.getText() + "','" + posdate.getText() + "','" + postime.getText() + "')");

                table.removeRow(rem);
                total_purchase();
                sellingID.setText("0");
                jLabel62.setText("0.0");
                jLabel61.setText("0.0");
                product_id.setText("0.0");
                unit_price.setText("0.0");
                jComboBox1.setSelectedItem("select product");

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            paid.setText("0.0");
            change.setText("0.0");
        }
    }//GEN-LAST:event_jLabel52MouseClicked

    private void jTable3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseExited
        // TODO add your handling code here:            
    }//GEN-LAST:event_jTable3MouseExited

    private void jTable3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseEntered

    }//GEN-LAST:event_jTable3MouseEntered

    private void jLabel53MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel53MouseClicked
        // TODO add your handling code here:
        jTable3.clearSelection();
        sellingID.setText("0");
        product_id.setText("0.0");
        jLabel62.setText("0.0");
        jLabel61.setText("0.0");
        unit_price.setText("0.0");
        t_price.setText("0.0");
        jComboBox1.setSelectedItem("select product");
        stocks.setText("0.0");
        total_purchase();
        jComboBox2.setSelectedItem("Regular Costumer");
    }//GEN-LAST:event_jLabel53MouseClicked

    private void jLabel42MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseEntered
        // TODO add your handling code here:
        OOP.colorfull(pAy);
        jLabel42.setForeground(Color.black);
    }//GEN-LAST:event_jLabel42MouseEntered

    private void jLabel42MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseExited
        // TODO add your handling code here:\
        OOP.colorful(pAy);
        jLabel42.setForeground(Color.white);
    }//GEN-LAST:event_jLabel42MouseExited

    private void jLabel52MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel52MouseEntered
        // TODO add your handling code here:
        OOP.colorful(rEmove);
        jLabel52.setForeground(Color.black);
    }//GEN-LAST:event_jLabel52MouseEntered

    private void jLabel52MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel52MouseExited
        // TODO add your handling code here:
        OOP.colorfull(rEmove);
        jLabel52.setForeground(Color.white);
    }//GEN-LAST:event_jLabel52MouseExited

    private void jLabel53MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel53MouseEntered
        // TODO add your handling code here:
        OOP.colorful(rEfresh);
        jLabel53.setForeground(Color.black);
    }//GEN-LAST:event_jLabel53MouseEntered

    private void jLabel53MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel53MouseExited
        // TODO add your handling code here:
        OOP.colorfull(rEfresh);
        jLabel53.setForeground(Color.white);
    }//GEN-LAST:event_jLabel53MouseExited

    private void chooose_POSMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chooose_POSMouseEntered
        // TODO add your handling code here:
        OOP.recolor(panel_pos);
        OOP.choose_color1(chooose_POS);
    }//GEN-LAST:event_chooose_POSMouseEntered

    private void chooose_POSMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chooose_POSMouseExited
        // TODO add your handling code here:
        OOP.color(panel_pos);
        OOP.choose_color2(chooose_POS);
    }//GEN-LAST:event_chooose_POSMouseExited

    private void choose_COSTUMERMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choose_COSTUMERMouseEntered
        // TODO add your handling code here:
        OOP.recolor(panel_cos);
        OOP.choose_color1(choose_COSTUMER);
    }//GEN-LAST:event_choose_COSTUMERMouseEntered

    private void choose_COSTUMERMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choose_COSTUMERMouseExited
        // TODO add your handling code here:
        OOP.color(panel_cos);
        OOP.choose_color2(choose_COSTUMER);
    }//GEN-LAST:event_choose_COSTUMERMouseExited

    private void choose_PRODUCTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choose_PRODUCTMouseEntered
        // TODO add your handling code here:
        OOP.recolor(panel_prod);
        OOP.choose_color1(choose_PRODUCT);
    }//GEN-LAST:event_choose_PRODUCTMouseEntered

    private void choose_PRODUCTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choose_PRODUCTMouseExited
        // TODO add your handling code here:
        OOP.color(panel_prod);
        OOP.choose_color2(choose_PRODUCT);
    }//GEN-LAST:event_choose_PRODUCTMouseExited

    private void choose_INCOMEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choose_INCOMEMouseEntered
        // TODO add your handling code here:
        OOP.recolor(panel_income);
        OOP.choose_color1(choose_INCOME);
    }//GEN-LAST:event_choose_INCOMEMouseEntered

    private void choose_INCOMEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choose_INCOMEMouseExited
        // TODO add your handling code here:
        OOP.color(panel_income);
        OOP.choose_color2(choose_INCOME);
    }//GEN-LAST:event_choose_INCOMEMouseExited

    private void choose_INVOICEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choose_INVOICEMouseEntered
        // TODO add your handling code here:
        OOP.recolor(panel_invoice);
        OOP.choose_color1(choose_INVOICE);
    }//GEN-LAST:event_choose_INVOICEMouseEntered

    private void choose_INVOICEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choose_INVOICEMouseExited
        // TODO add your handling code here:
        OOP.color(panel_invoice);
        OOP.choose_color2(choose_INVOICE);
    }//GEN-LAST:event_choose_INVOICEMouseExited

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        try {

            DefaultTableModel table = (DefaultTableModel) jTable4.getModel();
            table.setRowCount(0);
            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("SELECT `selling_id`,`product_id`,`product_name`,sum(`quantity`),sum(`total_price`),`date` FROM `tblselling` WHERE `date` = '" + posdate.getText() + "' GROUP by  `product_id` order by sum(`quantity`) desc");

            while (rs.next()) {

                Object o[] = {rs.getString("selling_id"), rs.getString("product_id"), rs.getString("product_name"), rs.getString("sum(`quantity`)"), rs.getString("sum(`total_price`)")};
                table.addRow(o);

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("SELECT sum(`quantity`) FROM `tblselling` where date = '" + posdate.getText() + "'");

            while (rs.next()) {

                tot_quantity.setText(rs.getString("sum(`quantity`)"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        // TODO add your handling code here:
        sdata();
        try {

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("SELECT sum(`quantity`) FROM `tblselling`");

            while (rs.next()) {
                tot_quantity.setText(rs.getString("sum(`quantity`)"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        // TODO add your handling code here:
        OOP.color(panel_day);
        jLabel6.setForeground(Color.orange);
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        // TODO add your handling code here:
        OOP.recolor(panel_day);
        jLabel6.setForeground(Color.black);
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseEntered
        // TODO add your handling code here:
        OOP.color(panel_Refresh);
        jLabel17.setForeground(Color.orange);
    }//GEN-LAST:event_jLabel17MouseEntered

    private void jLabel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseExited
        // TODO add your handling code here:
        OOP.recolor(panel_Refresh);
        jLabel17.setForeground(Color.black);
    }//GEN-LAST:event_jLabel17MouseExited

    private void jLabel55MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel55MouseEntered
        // TODO add your handling code here:
        OOP.color(panel_UPdate);
        jLabel55.setForeground(Color.orange);
    }//GEN-LAST:event_jLabel55MouseEntered

    private void jLabel55MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel55MouseExited
        // TODO add your handling code here:
        OOP.recolor(panel_UPdate);
        jLabel55.setForeground(Color.black);
    }//GEN-LAST:event_jLabel55MouseExited

    private void jLabel60MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel60MouseEntered
        // TODO add your handling code here:
        OOP.color(panel_REfresh);
        jLabel60.setForeground(Color.orange);
    }//GEN-LAST:event_jLabel60MouseEntered

    private void jLabel60MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel60MouseExited
        // TODO add your handling code here:
        OOP.recolor(panel_REfresh);
        jLabel60.setForeground(Color.black);
    }//GEN-LAST:event_jLabel60MouseExited

    private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable6MouseClicked

    private void income_searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_income_searchKeyPressed
        // TODO add your handling code here:
        if (income_search.getText().equals("Enter date for monitoring")) {

            income_search.setText("");

        }

    }//GEN-LAST:event_income_searchKeyPressed

    private void income_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_income_searchKeyReleased
        // TODO add your handling code here:
        String m = income_search.getText();

        if (m.isEmpty()) {
            try {
                DefaultTableModel table1 = (DefaultTableModel) jTable6.getModel();
                table1.setRowCount(0);

                Statement state = Home_source.mycon().createStatement();
                ResultSet rs = state.executeQuery("SELECT `selling_ID`,`product_ID`,`product_name`,`quantity`,`total_price`,`unit_price`,`date` FROM `tblselling`");

                while (rs.next()) {
                    Vector r = new Vector();

                    r.add(rs.getString(1));
                    r.add(rs.getString(2));
                    r.add(rs.getString(3));
                    r.add(rs.getString(4));
                    r.add(rs.getString(5));
                    r.add(rs.getString(6));
                    r.add(rs.getString(7));
                    table1.addRow(r);
                }
            } catch (Exception x) {
                System.out.println(x.getMessage());
            }
            try {

                Statement state = Home_source.mycon().createStatement();
                ResultSet rs = state.executeQuery("SELECT sum(`profit`),sum(`total_price`) FROM `tblselling`");

                while (rs.next()) {
                    profit.setText(rs.getString("sum(`profit`)"));
                    Total_Income.setText(rs.getString("sum(`total_price`)"));
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            income_search.setText("Enter date for monitoring");
        } else {

            try {
                DefaultTableModel table = (DefaultTableModel) jTable6.getModel();
                table.setRowCount(0);
                Statement state = Home_source.mycon().createStatement();
                ResultSet rs = state.executeQuery("SELECT `selling_ID`,`product_ID`,`product_name`,`quantity`,`total_price`,`unit_price`,`date` FROM `tblselling` WHERE date = '" + m + "'");
                while (rs.next()) {
                    Object o[] = {rs.getString("selling_id"), rs.getString("product_id"), rs.getString("product_name"), rs.getString("quantity"), rs.getString("total_price"), rs.getString("unit_price"), rs.getString("date")};
                    table.addRow(o);

                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            try {

                Statement state = Home_source.mycon().createStatement();
                ResultSet rs = state.executeQuery("SELECT sum(`profit`),sum(`total_price`) FROM `tblselling` where date = '" + m + "'");

                while (rs.next()) {
                    profit.setText(rs.getString("sum(`profit`)"));
                    Total_Income.setText(rs.getString("sum(`total_price`)"));
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_income_searchKeyReleased

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        // TODO add your handling code here:
        try {
            DefaultTableModel table = (DefaultTableModel) jTable6.getModel();
            table.setRowCount(0);
            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("SELECT `selling_ID`,`product_ID`,`product_name`,`quantity`,`total_price`,`unit_price`,`date` FROM `tblselling`  where date = '" + posdate.getText() + "'");

            while (rs.next()) {
                Vector r = new Vector();

                r.add(rs.getString(1));
                r.add(rs.getString(2));
                r.add(rs.getString(3));
                r.add(rs.getString(4));
                r.add(rs.getString(5));
                r.add(rs.getString(6));
                r.add(rs.getString(7));
                table.addRow(r);
            }
        } catch (Exception x) {
            System.out.println(x.getMessage());
        }
        try {

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("SELECT sum(`profit`) FROM `tblselling` where date = '" + posdate.getText() + "'");

            while (rs.next()) {
                profit.setText(rs.getString("sum(`profit`)"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("SELECT sum(`total_price`) FROM `tblselling` where date = '" + posdate.getText() + "'");

            while (rs.next()) {
                Total_Income.setText(rs.getString("sum(`total_price`)"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseEntered
        // TODO add your handling code here:
        OOP.color(panel_DAY);
        jLabel18.setForeground(Color.orange);
    }//GEN-LAST:event_jLabel18MouseEntered

    private void jLabel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseExited
        // TODO add your handling code here:
        OOP.recolor(panel_DAY);
        jLabel18.setForeground(Color.black);
    }//GEN-LAST:event_jLabel18MouseExited

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        // TODO add your handling code here:
        try {
            DefaultTableModel table1 = (DefaultTableModel) jTable6.getModel();
            table1.setRowCount(0);

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("SELECT `selling_ID`,`product_ID`,`product_name`,`quantity`,`total_price`,`unit_price`,`date` FROM `tblselling`");

            while (rs.next()) {
                Vector r = new Vector();

                r.add(rs.getString(1));
                r.add(rs.getString(2));
                r.add(rs.getString(3));
                r.add(rs.getString(4));
                r.add(rs.getString(5));
                r.add(rs.getString(6));
                r.add(rs.getString(7));
                table1.addRow(r);
            }
        } catch (Exception x) {
            System.out.println(x.getMessage());

        }
        try {

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("SELECT sum(`profit`) FROM `tblselling`");

            while (rs.next()) {
                profit.setText(rs.getString("sum(`profit`)"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("SELECT sum(`total_price`) FROM `tblselling`");

            while (rs.next()) {
                Total_Income.setText(rs.getString("sum(`total_price`)"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jLabel28MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseEntered
        // TODO add your handling code here:
        OOP.color(panel_REFRESH);
        jLabel28.setForeground(Color.orange);
    }//GEN-LAST:event_jLabel28MouseEntered

    private void jLabel28MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseExited
        // TODO add your handling code here:
        OOP.recolor(panel_REFRESH);
        jLabel28.setForeground(Color.black);
    }//GEN-LAST:event_jLabel28MouseExited

    private void choose_INCOMEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choose_INCOMEMouseClicked
        // TODO add your handling code here:
        OOP.glenn(Income, home, POS, Product, Costumer, Selling, Stock_in, Removed, Invoice);

        try {
            DefaultTableModel table1 = (DefaultTableModel) jTable6.getModel();
            table1.setRowCount(0);

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery(" SELECT `selling_ID`,`product_ID`,`product_name`,`quantity`,`total_price`,`unit_price`,`date` FROM `tblselling` ");

            while (rs.next()) {
                Vector r = new Vector();

                r.add(rs.getString(1));
                r.add(rs.getString(2));
                r.add(rs.getString(3));
                r.add(rs.getString(4));
                r.add(rs.getString(5));
                r.add(rs.getString(6));
                r.add(rs.getString(7));
                table1.addRow(r);
            }
        } catch (Exception x) {
            System.out.println(x.getMessage());

        }
        try {

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("SELECT sum(`profit`) FROM `tblselling`");

            while (rs.next()) {
                profit.setText(rs.getString("sum(`profit`)"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("SELECT sum(`total_price`) FROM `tblselling`");

            while (rs.next()) {
                Total_Income.setText(rs.getString("sum(`total_price`)"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_choose_INCOMEMouseClicked

    private void jTable7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable7MouseClicked

    private void income_search1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_income_search1KeyPressed
        // TODO add your handling code here:
        if (income_search1.getText().equals("Enter date for monitoring")) {

            income_search1.setText("");

        }

    }//GEN-LAST:event_income_search1KeyPressed

    private void income_search1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_income_search1KeyReleased
        // TODO add your handling code here:

        if (income_search1.getText().isEmpty()) {
            try {
                DefaultTableModel table = (DefaultTableModel) jTable7.getModel();
                table.setRowCount(0);
                Statement state = Home_source.mycon().createStatement();
                ResultSet rs = state.executeQuery("select * from tblremove");

                while (rs.next()) {

                    Object o[] = {rs.getString("remove_id"), rs.getString("remove_by"), rs.getString("product_id"), rs.getString("product_name"), rs.getString("quantity"), rs.getString("unit_price"), rs.getString("date"), rs.getString("time")};
                    table.addRow(o);
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            try {

                Statement state = Home_source.mycon().createStatement();
                ResultSet rs = state.executeQuery("select count(*) from tblremove");

                while (rs.next()) {

                    jLabel103.setText(rs.getString("count(*)"));
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            try {

                Statement state = Home_source.mycon().createStatement();
                ResultSet rs = state.executeQuery("SELECT sum(`quantity`) FROM `tblremove`");

                while (rs.next()) {
                    profit1.setText(rs.getString("sum(`quantity`)"));
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            income_search1.setText("Enter date for monitoring");
        } else {
            try {
                DefaultTableModel table = (DefaultTableModel) jTable7.getModel();
                table.setRowCount(0);
                Statement state = Home_source.mycon().createStatement();
                ResultSet rs = state.executeQuery("select * from tblremove where date = '" + income_search1.getText() + "'");
                while (rs.next()) {

                    Object o[] = {rs.getString("remove_id"), rs.getString("remove_by"), rs.getString("product_id"), rs.getString("product_name"), rs.getString("quantity"), rs.getString("unit_price"), rs.getString("date"), rs.getString("time")};
                    table.addRow(o);
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            try {

                Statement state = Home_source.mycon().createStatement();
                ResultSet rs = state.executeQuery("select count(*),sum(quantity) from tblremove where date = '" + income_search1.getText() + "'");

                while (rs.next()) {

                    jLabel103.setText(rs.getString("count(*)"));
                    profit1.setText(rs.getString("sum(quantity)"));
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_income_search1KeyReleased

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        // TODO add your handling code here:
        try {
            DefaultTableModel table = (DefaultTableModel) jTable7.getModel();
            table.setRowCount(0);
            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("select * from tblremove where date = '" + posdate.getText() + "'");

            while (rs.next()) {

                Object o[] = {rs.getString("remove_id"), rs.getString("remove_by"), rs.getString("product_id"), rs.getString("product_name"), rs.getString("quantity"), rs.getString("unit_price"), rs.getString("date"), rs.getString("time")};
                table.addRow(o);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("select count(*),sum(quantity) from tblremove where date = '" + posdate.getText() + "'");

            while (rs.next()) {

                jLabel103.setText(rs.getString("count(*)"));
                profit1.setText(rs.getString("sum(quantity)"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseEntered
        // TODO add your handling code here:
        OOP.color(panel_DAY1);
        jLabel20.setForeground(Color.orange);
    }//GEN-LAST:event_jLabel20MouseEntered

    private void jLabel20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseExited
        // TODO add your handling code here:
        OOP.recolor(panel_DAY1);
        jLabel20.setForeground(Color.black);
    }//GEN-LAST:event_jLabel20MouseExited

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        // TODO add your handling code here:
        try {
            DefaultTableModel table = (DefaultTableModel) jTable7.getModel();
            table.setRowCount(0);
            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("select * from tblremove");

            while (rs.next()) {

                Object o[] = {rs.getString("remove_id"), rs.getString("remove_by"), rs.getString("product_id"), rs.getString("product_name"), rs.getString("quantity"), rs.getString("unit_price"), rs.getString("date"), rs.getString("time")};
                table.addRow(o);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("SELECT sum(`quantity`) FROM `tblremove`");

            while (rs.next()) {
                profit1.setText(rs.getString("sum(`quantity`)"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jLabel29MouseClicked

    private void jLabel29MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseEntered
        // TODO add your handling code here:
        OOP.color(panel_REFRESH1);
        jLabel29.setForeground(Color.orange);
    }//GEN-LAST:event_jLabel29MouseEntered

    private void jLabel29MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseExited
        // TODO add your handling code here:
        OOP.recolor(panel_REFRESH1);
        jLabel29.setForeground(Color.black);
    }//GEN-LAST:event_jLabel29MouseExited

    private void jPanel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4MouseEntered

    private void jLabel73MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel73MouseClicked
        // TODO add your handling code here:
        if (jLabel73.getText().equals("0")) {
        } else {
            OOP.glenn(Stock_in, home, POS, Product, Costumer, Selling, Income, Removed, Invoice);
            try {
                DefaultTableModel table = (DefaultTableModel) jTable5.getModel();
                table.setRowCount(0);
                Statement state = Home_source.mycon().createStatement();
                ResultSet rs = state.executeQuery("SELECT `prod_id`,`product_name`,`quantity` FROM `tblproduct` WHERE `quantity` = '" + 0.0 + "'");

                while (rs.next()) {

                    Object o[] = {rs.getString("prod_id"), rs.getString("product_name"), rs.getString("quantity")};
                    table.addRow(o);
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_jLabel73MouseClicked

    private void costumerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costumerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_costumerNameActionPerformed

    private void paidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paidKeyReleased
        // TODO add your handling code here:
        if (paid.getText().isEmpty()) {
            change.setText("0.0");
            paid.setText("0.0");
        } else if (total_purchase.getText().equals("0.0")) {
            paid.setText("0.0");
        } else {
            Double am = Double.valueOf(total_purchase.getText());
            Double total = Double.valueOf(paid.getText());

            Double paidd;

            paidd = total - am;

            change.setText(String.valueOf(paidd));
        }

    }//GEN-LAST:event_paidKeyReleased

    private void paidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paidKeyPressed
        // TODO add your handling code here:
        if (paid.getText().equals("0.0")) {
            paid.setText("");
        }
    }//GEN-LAST:event_paidKeyPressed

    private void jTable8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable8MouseClicked
        // TODO add your handling code here: 
    }//GEN-LAST:event_jTable8MouseClicked

    private void jLabel86MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel86MouseClicked
        // TODO add your handling code here:
        if (jComboBox4.getSelectedItem().equals("All")) {

        } else {
            Stocks Stock = new Stocks();
            String p = paRTIAL.getText();
            Stock.setVisible(true);
            String name = jComboBox4.getSelectedItem().toString();
            Stock.naME.setText(name);
            Stock.Total.setText(p);
        }

    }//GEN-LAST:event_jLabel86MouseClicked

    private void jLabel86MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel86MouseEntered
        // TODO add your handling code here:
        OOP.recolor(pay_balance);
        jLabel86.setForeground(Color.orange);
    }//GEN-LAST:event_jLabel86MouseEntered

    private void jLabel86MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel86MouseExited
        // TODO add your handling code here:
        OOP.color(pay_balance);
        jLabel86.setForeground(Color.black);
    }//GEN-LAST:event_jLabel86MouseExited

    private void choose_INVOICEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choose_INVOICEMouseClicked
        // TODO add your handling code here:
        jComboBox4.setSelectedItem("All");
        OOP.glenn(Invoice, home, POS, Product, Costumer, Selling, Stock_in, Removed, Income);
        try {
            DefaultTableModel table1 = (DefaultTableModel) jTable8.getModel();
            table1.setRowCount(0);

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery(" SELECT `invoice_id`,`user`,`Costumer`,`paid_amount`,`Status`,`Balance`,`sub_total`,`total_quantity`,`transaction_no`,`date`,`time` FROM `tblinvoice` ");

            while (rs.next()) {
                Vector r = new Vector();

                r.add(rs.getString(1));
                r.add(rs.getString(2));
                r.add(rs.getString(3));
                r.add(rs.getString(4));
                r.add(rs.getString(5));
                r.add(rs.getString(6));
                r.add(rs.getString(7));
                r.add(rs.getString(8));
                r.add(rs.getString(9));
                r.add(rs.getString(10));
                r.add(rs.getString(11));
                table1.addRow(r);
            }
        } catch (Exception x) {
            System.out.println(x.getMessage());

        }

        try {

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery(" SELECT sum(`sub_total`) FROM `tblinvoice` where status = \"paid\"");

            while (rs.next()) {
                PAID.setText(rs.getString("sum(`sub_total`)"));

            }
        } catch (Exception x) {
            System.out.println(x.getMessage());

        }

        try {

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery(" SELECT sum(`sub_total`) FROM `tblinvoice` where status = \"unpaid\"");

            while (rs.next()) {
                UNPAID.setText(rs.getString("sum(`sub_total`)"));

            }
        } catch (Exception x) {
            System.out.println(x.getMessage());

        }
        try {

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery(" SELECT sum(`paid_amount`) FROM `tblinvoice` where status = \"partial\"");

            while (rs.next()) {
                PARTIAL.setText(rs.getString("sum(`paid_amount`)"));

            }
        } catch (Exception x) {
            System.out.println(x.getMessage());

        }

        try {

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("SELECT count(*),`Balance` FROM `tblinvoice` where status = \"unpaid\"");

            while (rs.next()) {
                jLabel93.setText(rs.getString("count(*)"));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        Integer sum = Integer.valueOf(PAID.getText());
        Integer sum1 = Integer.valueOf(PARTIAL.getText());

        Integer total = sum + sum1;

        jLabel91.setText(String.valueOf(total));

        paRTIAL.setText("0.0");
        unPAID.setText("0.0");


    }//GEN-LAST:event_choose_INVOICEMouseClicked

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
        String search = jComboBox3.getSelectedItem().toString();

        if (search.equals("All")) {
            try {
                DefaultTableModel table1 = (DefaultTableModel) jTable8.getModel();
                table1.setRowCount(0);

                Statement state = Home_source.mycon().createStatement();
                ResultSet rs = state.executeQuery(" SELECT `invoice_id`,`user`,`Costumer`,`paid_amount`,`Status`,`Balance`,`sub_total`,`total_quantity`,`transaction_no`,`date`,`time` FROM `tblinvoice` ");

                while (rs.next()) {
                    Vector r = new Vector();

                    r.add(rs.getString(1));
                    r.add(rs.getString(2));
                    r.add(rs.getString(3));
                    r.add(rs.getString(4));
                    r.add(rs.getString(5));
                    r.add(rs.getString(6));
                    r.add(rs.getString(7));
                    r.add(rs.getString(8));
                    r.add(rs.getString(9));
                    r.add(rs.getString(10));
                    r.add(rs.getString(11));
                    table1.addRow(r);
                }
            } catch (Exception x) {
                System.out.println(x.getMessage());

            }

        } else {
            try {
                DefaultTableModel table1 = (DefaultTableModel) jTable8.getModel();
                table1.setRowCount(0);
                Statement state = Home_source.mycon().createStatement();
                ResultSet rs = state.executeQuery(" SELECT `invoice_id`,`user`,`Costumer`,`paid_amount`,`Status`,`Balance`,`sub_total`,`total_quantity`,`transaction_no`,`date`,`time` FROM `tblinvoice` where status = '" + search + "'");

                while (rs.next()) {
                    Vector r = new Vector();

                    r.add(rs.getString(1));
                    r.add(rs.getString(2));
                    r.add(rs.getString(3));
                    r.add(rs.getString(4));
                    r.add(rs.getString(5));
                    r.add(rs.getString(6));
                    r.add(rs.getString(7));
                    r.add(rs.getString(8));
                    r.add(rs.getString(9));
                    r.add(rs.getString(10));
                    r.add(rs.getString(11));
                    table1.addRow(r);
                }

                OOP.totalPurchase(jSpinner1, unit_price, t_price);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            Integer sum = Integer.valueOf(PAID.getText());
            Integer sum1 = Integer.valueOf(PARTIAL.getText());

            Integer total = sum + sum1;

            jLabel91.setText(String.valueOf(total));

            paRTIAL.setText("0.0");
            unPAID.setText("0.0");
        }

    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jLabel94MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel94MouseEntered
        // TODO add your handling code here:
        OOP.recolor(Panelhome);
        jLabel94.setForeground(Color.orange);
    }//GEN-LAST:event_jLabel94MouseEntered

    private void jLabel94MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel94MouseExited
        // TODO add your handling code here:
        OOP.color(Panelhome);
        jLabel94.setForeground(Color.black);
    }//GEN-LAST:event_jLabel94MouseExited

    private void jLabel94MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel94MouseClicked
        // TODO add your handling code here:
        OOP.glenn(home, POS, Costumer, Selling, Product, Stock_in, Income, Removed, Invoice);
    }//GEN-LAST:event_jLabel94MouseClicked

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
        String m = jComboBox4.getSelectedItem().toString();
        if (m.equals("")) {

            unPAID.setText("0.0");

        } else {

            try {

                Statement state = Home_source.mycon().createStatement();
                ResultSet rs = state.executeQuery("SELECT sum(`sub_total`) FROM `tblinvoice` WHERE `Costumer`  like '%" + m + "%' and `Status` = \"unpaid\"");

                while (rs.next()) {
                    unPAID.setText(rs.getString("sum(`sub_total`)"));

                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        if (m.equals("")) {
            paRTIAL.setText("0.0");
        } else {

            try {

                Statement state = Home_source.mycon().createStatement();
                ResultSet rs = state.executeQuery("SELECT sum(`Balance`),`Balance` FROM `tblinvoice` WHERE `Costumer` like '%" + m + "%' and `Status` = \"partial\"");

                while (rs.next()) {
                    paRTIAL.setText(rs.getString("sum(`balance`)"));

                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        try {
            DefaultTableModel table1 = (DefaultTableModel) jTable8.getModel();
            table1.setRowCount(0);

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery(" SELECT `invoice_id`,`user`,`Costumer`,`paid_amount`,`Status`,`Balance`,`sub_total`,`total_quantity`,`transaction_no`,`date`,`time` FROM `tblinvoice`  where costumer like '%" + m + "%' ");

            while (rs.next()) {
                Vector r = new Vector();

                r.add(rs.getString(1));
                r.add(rs.getString(2));
                r.add(rs.getString(3));
                r.add(rs.getString(4));
                r.add(rs.getString(5));
                r.add(rs.getString(6));
                r.add(rs.getString(7));
                r.add(rs.getString(8));
                r.add(rs.getString(9));
                r.add(rs.getString(10));
                r.add(rs.getString(11));
                table1.addRow(r);
            }
        } catch (Exception x) {
            System.out.println(x.getMessage());

        }
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jComboBox4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4MouseExited

    private void jLabel98MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel98MouseClicked
        // TODO add your handling code here:

        if (jComboBox4.getSelectedItem().equals("All")) {

        } else {

            Stock_bal Stock = new Stock_bal();
            Integer uno = Integer.valueOf(unPAID.getText());
            Integer dos = Integer.valueOf(paRTIAL.getText());

            Integer glenn = uno - dos;

            Stock.Total.setText(String.valueOf(glenn));

            Stock.setVisible(true);
            String name = jComboBox4.getSelectedItem().toString();
            Stock.naME.setText(name);

        }

    }//GEN-LAST:event_jLabel98MouseClicked

    private void jLabel98MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel98MouseEntered
        // TODO add your handling code here:
        OOP.recolor(pay_all);
        jLabel98.setForeground(Color.orange);
    }//GEN-LAST:event_jLabel98MouseEntered

    private void jLabel98MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel98MouseExited
        // TODO add your handling code here:
        OOP.color(pay_all);
        jLabel98.setForeground(Color.black);
    }//GEN-LAST:event_jLabel98MouseExited

    private void jLabel99MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel99MouseClicked
        // TODO add your handling code here:
        try {
            DefaultTableModel table1 = (DefaultTableModel) jTable8.getModel();
            table1.setRowCount(0);

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery(" SELECT `invoice_id`,`user`,`Costumer`,`paid_amount`,`Status`,`Balance`,`sub_total`,`total_quantity`,`transaction_no`,`date`,`time` FROM `tblinvoice` ");

            while (rs.next()) {
                Vector r = new Vector();

                r.add(rs.getString(1));
                r.add(rs.getString(2));
                r.add(rs.getString(3));
                r.add(rs.getString(4));
                r.add(rs.getString(5));
                r.add(rs.getString(6));
                r.add(rs.getString(7));
                r.add(rs.getString(8));
                r.add(rs.getString(9));
                r.add(rs.getString(10));
                r.add(rs.getString(11));
                table1.addRow(r);
            }
        } catch (Exception x) {
            System.out.println(x.getMessage());

        }

        try {

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery(" SELECT sum(`sub_total`) FROM `tblinvoice` where status = \"paid\"");

            while (rs.next()) {
                PAID.setText(rs.getString("sum(`sub_total`)"));

            }
        } catch (Exception x) {
            System.out.println(x.getMessage());

        }

        try {

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery(" SELECT sum(`sub_total`) FROM `tblinvoice` where status = \"unpaid\"");

            while (rs.next()) {
                UNPAID.setText(rs.getString("sum(`sub_total`)"));

            }
        } catch (Exception x) {
            System.out.println(x.getMessage());

        }
        try {

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery(" SELECT sum(`paid_amount`) FROM `tblinvoice` where status = \"partial\"");

            while (rs.next()) {
                PARTIAL.setText(rs.getString("sum(`paid_amount`)"));

            }
        } catch (Exception x) {
            System.out.println(x.getMessage());

        }
        Integer sum = Integer.valueOf(PAID.getText());
        Integer sum1 = Integer.valueOf(PARTIAL.getText());

        Integer total = sum + sum1;

        jLabel91.setText(String.valueOf(total));

        jComboBox4.setSelectedItem("All");
        jComboBox3.setSelectedItem("All");
        paRTIAL.setText("0.0");
        unPAID.setText("0.0");

    }//GEN-LAST:event_jLabel99MouseClicked

    private void jLabel99MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel99MouseEntered
        // TODO add your handling code here:
        OOP.recolor(pay_refresh);
        jLabel99.setForeground(Color.orange);
    }//GEN-LAST:event_jLabel99MouseEntered

    private void jLabel99MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel99MouseExited
        // TODO add your handling code here:
        OOP.color(pay_refresh);
        jLabel99.setForeground(Color.black);
    }//GEN-LAST:event_jLabel99MouseExited

    private void jLabel100MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel100MouseClicked
        // TODO add your handling code here:
        Stock_un Stocks = new Stock_un();

        if (jComboBox4.getSelectedItem().equals("All")) {

        } else {
            String p = unPAID.getText();
            Stocks.setVisible(true);
            String name = jComboBox4.getSelectedItem().toString();
            Stocks.naME.setText(name);
            Stocks.Total.setText(p);
        }

    }//GEN-LAST:event_jLabel100MouseClicked

    private void jLabel100MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel100MouseEntered
        // TODO add your handling code here:
        OOP.recolor(pay_unpaid);
        jLabel100.setForeground(Color.orange);
    }//GEN-LAST:event_jLabel100MouseEntered

    private void jLabel100MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel100MouseExited
        // TODO add your handling code here:
        OOP.color(pay_unpaid);
        jLabel100.setForeground(Color.black);
    }//GEN-LAST:event_jLabel100MouseExited

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
        String search1 = jComboBox5.getSelectedItem().toString();

        try {
            DefaultTableModel table = (DefaultTableModel) jTable5.getModel();
            table.setRowCount(0);
            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("select * from tblproduct where  product_name like '%" + search1 + "%'");

            if (search1.equals("Poduct")) {
                stockdata();
            } else {

                while (rs.next()) {

                    Object o[] = {rs.getString("prod_id"), rs.getString("product_name"), rs.getString("quantity")};
                    table.addRow(o);

                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jLabel106MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel106MouseClicked
        // TODO add your handling code here:
        Login Log = new Login();
        if (total_qty.getText().equals("0.0")) {
            Log.show();
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "One or more transaction may not completed!!");
        }
    }//GEN-LAST:event_jLabel106MouseClicked

    private void jLabel106MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel106MouseEntered
        // TODO add your handling code here:
        jLabel106.setForeground(Color.red);
    }//GEN-LAST:event_jLabel106MouseEntered

    private void jLabel106MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel106MouseExited
        // TODO add your handling code here:
        jLabel106.setForeground(Color.black);
    }//GEN-LAST:event_jLabel106MouseExited

    private void POSMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_POSMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_POSMouseEntered

    private void POSMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_POSMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_POSMouseExited

    private void jLabel66MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel66MouseClicked
        // TODO add your handling code here:
        try {
            DefaultTableModel table = (DefaultTableModel) jTable5.getModel();
            table.setRowCount(0);
            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("SELECT `prod_id`,`product_name`,`quantity` FROM `tblproduct` WHERE `quantity` = '" + 0.0 + "'");

            while (rs.next()) {

                Object o[] = {rs.getString("prod_id"), rs.getString("product_name"), rs.getString("quantity")};
                table.addRow(o);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jLabel66MouseClicked

    private void jLabel66MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel66MouseEntered
        // TODO add your handling code here:
        jLabel66.setForeground(Color.orange);
    }//GEN-LAST:event_jLabel66MouseEntered

    private void jLabel66MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel66MouseExited
        // TODO add your handling code here:
        jLabel66.setForeground(Color.black);
    }//GEN-LAST:event_jLabel66MouseExited

    private void income_search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_income_search1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_income_search1ActionPerformed

    private void product_MOSTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_MOSTMouseClicked
        // TODO add your handling code here:
        OOP.glenn(Selling, home, POS, Product, Costumer, Stock_in, Income, Removed, Invoice);
        sdata();
        try {
            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("SELECT sum(`quantity`) FROM `tblselling`");

            while (rs.next()) {
                tot_quantity.setText(rs.getString("sum(`quantity`)"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }//GEN-LAST:event_product_MOSTMouseClicked

    private void product_STOCKSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_STOCKSMouseClicked
        // TODO add your handling code here:
        OOP.glenn(Stock_in, home, POS, Product, Costumer, Selling, Income, Removed, Invoice);
        jComboBox5.setSelectedItem("Product");
        stockdata();
    }//GEN-LAST:event_product_STOCKSMouseClicked

    private void product_REMOVEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_REMOVEMouseClicked
        // TODO add your handling code here:
        OOP.glenn(Removed, home, POS, Product, Costumer, Selling, Stock_in, Invoice, Income);
        try {
            DefaultTableModel table = (DefaultTableModel) jTable7.getModel();
            table.setRowCount(0);
            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("select * from tblremove");

            while (rs.next()) {

                Object o[] = {rs.getString("remove_id"), rs.getString("remove_by"), rs.getString("product_id"), rs.getString("product_name"), rs.getString("quantity"), rs.getString("unit_price"), rs.getString("date"), rs.getString("time")};
                table.addRow(o);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("select count(*) from tblremove");

            while (rs.next()) {

                jLabel103.setText(rs.getString("count(*)"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("SELECT sum(`quantity`) FROM `tblremove`");

            while (rs.next()) {
                profit1.setText(rs.getString("sum(`quantity`)"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_product_REMOVEMouseClicked

    private void product_MOSTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_MOSTMouseEntered
        // TODO add your handling code here:
        OOP.product_color1(product_MOST);

    }//GEN-LAST:event_product_MOSTMouseEntered

    private void product_MOSTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_MOSTMouseExited
        // TODO add your handling code here:
        OOP.product_color2(product_MOST);

    }//GEN-LAST:event_product_MOSTMouseExited

    private void choose_SETTINGSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choose_SETTINGSMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_choose_SETTINGSMouseClicked

    private void choose_SETTINGSMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choose_SETTINGSMouseEntered
        // TODO add your handling code here:
        OOP.choose_color1(choose_SETTINGS);
    }//GEN-LAST:event_choose_SETTINGSMouseEntered

    private void choose_SETTINGSMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choose_SETTINGSMouseExited
        // TODO add your handling code here:
        OOP.choose_color2(choose_SETTINGS);
    }//GEN-LAST:event_choose_SETTINGSMouseExited

    private void product_STOCKSMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_STOCKSMouseEntered
        // TODO add your handling code here:
        OOP.product_color1(product_STOCKS);
    }//GEN-LAST:event_product_STOCKSMouseEntered

    private void product_STOCKSMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_STOCKSMouseExited
        // TODO add your handling code here:
        OOP.product_color2(product_STOCKS);
    }//GEN-LAST:event_product_STOCKSMouseExited

    private void product_REMOVEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_REMOVEMouseEntered
        // TODO add your handling code here:
        OOP.product_color1(product_REMOVE);
    }//GEN-LAST:event_product_REMOVEMouseEntered

    private void product_REMOVEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_REMOVEMouseExited
        // TODO add your handling code here:
        OOP.product_color2(product_REMOVE);
    }//GEN-LAST:event_product_REMOVEMouseExited

    private void choose_SETTINGS1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choose_SETTINGS1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_choose_SETTINGS1MouseClicked

    private void choose_SETTINGS1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choose_SETTINGS1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_choose_SETTINGS1MouseEntered

    private void choose_SETTINGS1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choose_SETTINGS1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_choose_SETTINGS1MouseExited

    private void jLabel56MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel56MouseClicked
        // TODO add your handling code here:
        Login Log = new Login();
        if (total_qty.getText().equals("0.0")) {
            Log.show();
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "One or more transaction may not completed!!");
        }
    }//GEN-LAST:event_jLabel56MouseClicked

    private void jLabel115MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel115MouseExited
        // TODO add your handling code here:
        OOP.home_panel2(home_invoice);
    }//GEN-LAST:event_jLabel115MouseExited

    private void jLabel115MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel115MouseEntered
        // TODO add your handling code here:
        OOP.home_panel1(home_invoice);
    }//GEN-LAST:event_jLabel115MouseEntered

    private void jLabel115MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel115MouseClicked
        // TODO add your handling code here:
        jComboBox4.setSelectedItem("All");
        OOP.glenn(Invoice, home, POS, Product, Costumer, Selling, Stock_in, Removed, Income);
        try {
            DefaultTableModel table1 = (DefaultTableModel) jTable8.getModel();
            table1.setRowCount(0);

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery(" SELECT `invoice_id`,`user`,`Costumer`,`paid_amount`,`Status`,`Balance`,`sub_total`,`total_quantity`,`transaction_no`,`date`,`time` FROM `tblinvoice` ");

            while (rs.next()) {
                Vector r = new Vector();

                r.add(rs.getString(1));
                r.add(rs.getString(2));
                r.add(rs.getString(3));
                r.add(rs.getString(4));
                r.add(rs.getString(5));
                r.add(rs.getString(6));
                r.add(rs.getString(7));
                r.add(rs.getString(8));
                r.add(rs.getString(9));
                r.add(rs.getString(10));
                r.add(rs.getString(11));
                table1.addRow(r);
            }
        } catch (Exception x) {
            System.out.println(x.getMessage());

        }

        try {

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery(" SELECT sum(`sub_total`) FROM `tblinvoice` where status = \"paid\"");

            while (rs.next()) {
                PAID.setText(rs.getString("sum(`sub_total`)"));

            }
        } catch (Exception x) {
            System.out.println(x.getMessage());

        }

        try {

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery(" SELECT sum(`sub_total`) FROM `tblinvoice` where status = \"unpaid\"");

            while (rs.next()) {
                UNPAID.setText(rs.getString("sum(`sub_total`)"));

            }
        } catch (Exception x) {
            System.out.println(x.getMessage());

        }
        try {

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery(" SELECT sum(`paid_amount`) FROM `tblinvoice` where status = \"partial\"");

            while (rs.next()) {
                PARTIAL.setText(rs.getString("sum(`paid_amount`)"));

            }
        } catch (Exception x) {
            System.out.println(x.getMessage());

        }

        try {

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("SELECT count(*),`Balance` FROM `tblinvoice` where status = \"unpaid\"");

            while (rs.next()) {
                jLabel93.setText(rs.getString("count(*)"));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        Integer sum = Integer.valueOf(PAID.getText());
        Integer sum1 = Integer.valueOf(PARTIAL.getText());

        Integer total = sum + sum1;

        jLabel91.setText(String.valueOf(total));

        paRTIAL.setText("0.0");
        unPAID.setText("0.0");
    }//GEN-LAST:event_jLabel115MouseClicked

    private void jLabel114MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel114MouseExited
        // TODO add your handling code here:
        OOP.home_panel2(home_income);
    }//GEN-LAST:event_jLabel114MouseExited

    private void jLabel114MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel114MouseEntered
        // TODO add your handling code here:
        OOP.home_panel1(home_income);
    }//GEN-LAST:event_jLabel114MouseEntered

    private void jLabel114MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel114MouseClicked
        // TODO add your handling code here:
        OOP.glenn(Income, home, POS, Product, Costumer, Selling, Stock_in, Removed, Invoice);

        try {
            DefaultTableModel table1 = (DefaultTableModel) jTable6.getModel();
            table1.setRowCount(0);

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery(" SELECT `selling_ID`,`product_ID`,`product_name`,`quantity`,`total_price`,`unit_price`,`date` FROM `tblselling` ");

            while (rs.next()) {
                Vector r = new Vector();

                r.add(rs.getString(1));
                r.add(rs.getString(2));
                r.add(rs.getString(3));
                r.add(rs.getString(4));
                r.add(rs.getString(5));
                r.add(rs.getString(6));
                r.add(rs.getString(7));
                table1.addRow(r);
            }
        } catch (Exception x) {
            System.out.println(x.getMessage());

        }
        try {

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("SELECT sum(`profit`) FROM `tblselling`");

            while (rs.next()) {
                profit.setText(rs.getString("sum(`profit`)"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("SELECT sum(`total_price`) FROM `tblselling`");

            while (rs.next()) {
                Total_Income.setText(rs.getString("sum(`total_price`)"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jLabel114MouseClicked

    private void jLabel113MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel113MouseExited
        // TODO add your handling code here:
        OOP.home_panel2(home_remove);
    }//GEN-LAST:event_jLabel113MouseExited

    private void jLabel113MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel113MouseEntered
        // TODO add your handling code here:
        OOP.home_panel1(home_remove);
    }//GEN-LAST:event_jLabel113MouseEntered

    private void jLabel113MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel113MouseClicked
        // TODO add your handling code here:
        OOP.glenn(Removed, home, POS, Product, Costumer, Selling, Stock_in, Invoice, Income);
        try {
            DefaultTableModel table = (DefaultTableModel) jTable7.getModel();
            table.setRowCount(0);
            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("select * from tblremove");

            while (rs.next()) {

                Object o[] = {rs.getString("remove_id"), rs.getString("remove_by"), rs.getString("product_id"), rs.getString("product_name"), rs.getString("quantity"), rs.getString("unit_price"), rs.getString("date"), rs.getString("time")};
                table.addRow(o);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("select count(*) from tblremove");

            while (rs.next()) {

                jLabel103.setText(rs.getString("count(*)"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {

            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("SELECT sum(`quantity`) FROM `tblremove`");

            while (rs.next()) {
                profit1.setText(rs.getString("sum(`quantity`)"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jLabel113MouseClicked

    private void jLabel112MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel112MouseExited
        // TODO add your handling code here:
        OOP.home_panel2(home_stock);
    }//GEN-LAST:event_jLabel112MouseExited

    private void jLabel112MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel112MouseEntered
        // TODO add your handling code here:
        OOP.home_panel1(home_stock);
    }//GEN-LAST:event_jLabel112MouseEntered

    private void jLabel112MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel112MouseClicked
        // TODO add your handling code here:
        OOP.glenn(Stock_in, home, POS, Product, Costumer, Selling, Income, Removed, Invoice);
        jComboBox5.setSelectedItem("Product");
        stockdata();
    }//GEN-LAST:event_jLabel112MouseClicked

    private void jLabel111MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel111MouseExited
        // TODO add your handling code here:
        OOP.home_panel2(home_most);
    }//GEN-LAST:event_jLabel111MouseExited

    private void jLabel111MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel111MouseEntered
        // TODO add your handling code here:
        OOP.home_panel1(home_most);
    }//GEN-LAST:event_jLabel111MouseEntered

    private void jLabel111MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel111MouseClicked
        // TODO add your handling code here:
        OOP.glenn(Selling, home, POS, Product, Costumer, Stock_in, Income, Removed, Invoice);
        sdata();
        try {
            Statement state = Home_source.mycon().createStatement();
            ResultSet rs = state.executeQuery("SELECT sum(`quantity`) FROM `tblselling`");

            while (rs.next()) {
                tot_quantity.setText(rs.getString("sum(`quantity`)"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }//GEN-LAST:event_jLabel111MouseClicked

    private void jLabel110MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel110MouseExited
        // TODO add your handling code here:
        OOP.home_panel2(home_product);
    }//GEN-LAST:event_jLabel110MouseExited

    private void jLabel110MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel110MouseEntered
        // TODO add your handling code here:
        OOP.home_panel1(home_product);
    }//GEN-LAST:event_jLabel110MouseEntered

    private void jLabel110MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel110MouseClicked
        // TODO add your handling code here:
        OOP.glenn(Product, home, POS, Selling, Costumer, Stock_in, Income, Removed, Invoice);
        data();
    }//GEN-LAST:event_jLabel110MouseClicked

    private void jLabel109MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel109MouseExited
        // TODO add your handling code here:
        OOP.home_panel2(home_costumer);
    }//GEN-LAST:event_jLabel109MouseExited

    private void jLabel109MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel109MouseEntered
        // TODO add your handling code here:
        OOP.home_panel1(home_costumer);
    }//GEN-LAST:event_jLabel109MouseEntered

    private void jLabel109MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel109MouseClicked
        // TODO add your handling code here:
        OOP.glenn(Costumer, home, POS, Selling, Product, Stock_in, Income, Removed, Invoice);
    }//GEN-LAST:event_jLabel109MouseClicked

    private void jLabel102MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel102MouseExited
        // TODO add your handling code here:
        OOP.home_panel2(home_pos);
    }//GEN-LAST:event_jLabel102MouseExited

    private void jLabel102MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel102MouseEntered
        // TODO add your handling code here:
        OOP.home_panel1(home_pos);
    }//GEN-LAST:event_jLabel102MouseEntered

    private void jLabel102MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel102MouseClicked
        // TODO add your handling code here:
        OOP.glenn(POS, home, Costumer, Selling, Product, Stock_in, Income, Removed, Invoice);
        jComboBox2.setSelectedItem("Regular Costumer");
        jComboBox1.setSelectedItem("Select product");
    }//GEN-LAST:event_jLabel102MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JPanel Costumer;
    private static javax.swing.JPanel Income;
    private static javax.swing.JPanel Invoice;
    public javax.swing.JLabel PAID;
    public javax.swing.JLabel PARTIAL;
    private static javax.swing.JPanel POS;
    private static javax.swing.JPanel Panelhome;
    private static javax.swing.JPanel Product;
    private static javax.swing.JPanel Removed;
    private static javax.swing.JPanel Selling;
    private static javax.swing.JPanel Stock_in;
    private static javax.swing.JLabel Total_Income;
    private static javax.swing.JLabel Total_Income2;
    public javax.swing.JLabel UNPAID;
    private static javax.swing.JTextField addd;
    private static javax.swing.JLabel address;
    private static javax.swing.JLabel ans;
    private static javax.swing.JLabel avail_stocks;
    private static javax.swing.JLabel b_code;
    private static javax.swing.JTextField bar_code;
    private static javax.swing.JLabel change;
    private static javax.swing.JLabel chooose_POS;
    private static javax.swing.JLabel choose_COSTUMER;
    private static javax.swing.JLabel choose_INCOME;
    private static javax.swing.JLabel choose_INVOICE;
    private static javax.swing.JLabel choose_PRODUCT;
    private static javax.swing.JLabel choose_SETTINGS;
    private static javax.swing.JLabel choose_SETTINGS1;
    private static javax.swing.JLabel contact;
    private static javax.swing.JTextField costumerAddress;
    private static javax.swing.JTextField costumerEmail;
    private static javax.swing.JTextField costumerID;
    private static javax.swing.JTextField costumerLastname;
    private static javax.swing.JTextField costumerName;
    private static javax.swing.JTextField costumerNumber;
    private static javax.swing.JTextField costumerSex;
    private static javax.swing.JTextField csearch;
    private static javax.swing.JLabel daTE;
    private static javax.swing.JLabel edate;
    private static javax.swing.JLabel email;
    private static javax.swing.JTextField exp_date;
    private static javax.swing.JLabel fname;
    private static javax.swing.JPanel home;
    private static javax.swing.JPanel home_costumer;
    private static javax.swing.JPanel home_income;
    private static javax.swing.JPanel home_invoice;
    private static javax.swing.JPanel home_most;
    private static javax.swing.JPanel home_pos;
    private static javax.swing.JPanel home_product;
    private static javax.swing.JPanel home_remove;
    private static javax.swing.JPanel home_stock;
    private static javax.swing.JTextField income_search;
    private static javax.swing.JTextField income_search1;
    public javax.swing.JComboBox<String> jComboBox1;
    public javax.swing.JComboBox<String> jComboBox2;
    private static javax.swing.JComboBox<String> jComboBox3;
    public javax.swing.JComboBox<String> jComboBox4;
    public javax.swing.JComboBox<String> jComboBox5;
    private static javax.swing.JLabel jLabel1;
    private static javax.swing.JLabel jLabel10;
    private static javax.swing.JLabel jLabel100;
    private static javax.swing.JLabel jLabel101;
    private static javax.swing.JLabel jLabel102;
    private static javax.swing.JLabel jLabel103;
    private static javax.swing.JLabel jLabel105;
    private static javax.swing.JLabel jLabel106;
    private static javax.swing.JLabel jLabel109;
    private static javax.swing.JLabel jLabel11;
    private static javax.swing.JLabel jLabel110;
    private static javax.swing.JLabel jLabel111;
    private static javax.swing.JLabel jLabel112;
    private static javax.swing.JLabel jLabel113;
    private static javax.swing.JLabel jLabel114;
    private static javax.swing.JLabel jLabel115;
    private static javax.swing.JLabel jLabel12;
    private static javax.swing.JLabel jLabel13;
    private static javax.swing.JLabel jLabel14;
    private static javax.swing.JLabel jLabel15;
    private static javax.swing.JLabel jLabel16;
    private static javax.swing.JLabel jLabel17;
    private static javax.swing.JLabel jLabel18;
    private static javax.swing.JLabel jLabel19;
    private static javax.swing.JLabel jLabel2;
    private static javax.swing.JLabel jLabel20;
    private static javax.swing.JLabel jLabel21;
    private static javax.swing.JLabel jLabel27;
    private static javax.swing.JLabel jLabel28;
    private static javax.swing.JLabel jLabel29;
    private static javax.swing.JLabel jLabel30;
    private static javax.swing.JLabel jLabel31;
    private static javax.swing.JLabel jLabel32;
    private static javax.swing.JLabel jLabel33;
    private static javax.swing.JLabel jLabel34;
    private static javax.swing.JLabel jLabel35;
    private static javax.swing.JLabel jLabel36;
    private static javax.swing.JLabel jLabel37;
    private static javax.swing.JLabel jLabel38;
    private static javax.swing.JLabel jLabel4;
    private static javax.swing.JLabel jLabel40;
    private static javax.swing.JLabel jLabel42;
    private static javax.swing.JLabel jLabel43;
    private static javax.swing.JLabel jLabel44;
    private static javax.swing.JLabel jLabel45;
    private static javax.swing.JLabel jLabel46;
    private static javax.swing.JLabel jLabel47;
    private static javax.swing.JLabel jLabel48;
    private static javax.swing.JLabel jLabel49;
    private static javax.swing.JLabel jLabel5;
    private static javax.swing.JLabel jLabel50;
    private static javax.swing.JLabel jLabel52;
    private static javax.swing.JLabel jLabel53;
    private static javax.swing.JLabel jLabel55;
    private static javax.swing.JLabel jLabel56;
    private static javax.swing.JLabel jLabel57;
    private static javax.swing.JLabel jLabel58;
    private static javax.swing.JLabel jLabel59;
    private static javax.swing.JLabel jLabel6;
    private static javax.swing.JLabel jLabel60;
    private static javax.swing.JLabel jLabel61;
    private static javax.swing.JLabel jLabel62;
    private static javax.swing.JLabel jLabel63;
    private static javax.swing.JLabel jLabel66;
    private static javax.swing.JLabel jLabel67;
    private static javax.swing.JLabel jLabel68;
    private static javax.swing.JLabel jLabel69;
    private static javax.swing.JLabel jLabel7;
    private static javax.swing.JLabel jLabel70;
    private static javax.swing.JLabel jLabel71;
    private static javax.swing.JLabel jLabel72;
    public javax.swing.JLabel jLabel73;
    private static javax.swing.JLabel jLabel74;
    private static javax.swing.JLabel jLabel75;
    private static javax.swing.JLabel jLabel76;
    private static javax.swing.JLabel jLabel77;
    private static javax.swing.JLabel jLabel78;
    private static javax.swing.JLabel jLabel79;
    private static javax.swing.JLabel jLabel8;
    private static javax.swing.JLabel jLabel80;
    private static javax.swing.JLabel jLabel81;
    private static javax.swing.JLabel jLabel82;
    private static javax.swing.JLabel jLabel83;
    private static javax.swing.JLabel jLabel84;
    private static javax.swing.JLabel jLabel85;
    private static javax.swing.JLabel jLabel86;
    private static javax.swing.JLabel jLabel87;
    private static javax.swing.JLabel jLabel88;
    private static javax.swing.JLabel jLabel89;
    private static javax.swing.JLabel jLabel90;
    public javax.swing.JLabel jLabel91;
    private static javax.swing.JLabel jLabel92;
    private static javax.swing.JLabel jLabel93;
    private static javax.swing.JLabel jLabel94;
    private static javax.swing.JLabel jLabel95;
    private static javax.swing.JLabel jLabel96;
    public javax.swing.JLabel jLabel97;
    private static javax.swing.JLabel jLabel98;
    private static javax.swing.JLabel jLabel99;
    private static javax.swing.JPanel jPanel1;
    private static javax.swing.JPanel jPanel10;
    private static javax.swing.JPanel jPanel11;
    private static javax.swing.JPanel jPanel12;
    private static javax.swing.JPanel jPanel13;
    private static javax.swing.JPanel jPanel14;
    private static javax.swing.JPanel jPanel15;
    private static javax.swing.JPanel jPanel16;
    private static javax.swing.JPanel jPanel17;
    private static javax.swing.JPanel jPanel18;
    private static javax.swing.JPanel jPanel19;
    private static javax.swing.JPanel jPanel2;
    private static javax.swing.JPanel jPanel20;
    private static javax.swing.JPanel jPanel21;
    private static javax.swing.JPanel jPanel22;
    private static javax.swing.JPanel jPanel23;
    private static javax.swing.JPanel jPanel24;
    private static javax.swing.JPanel jPanel25;
    private static javax.swing.JPanel jPanel26;
    private static javax.swing.JPanel jPanel27;
    private static javax.swing.JPanel jPanel28;
    private static javax.swing.JPanel jPanel29;
    private static javax.swing.JPanel jPanel3;
    private static javax.swing.JPanel jPanel30;
    private static javax.swing.JPanel jPanel31;
    private static javax.swing.JPanel jPanel32;
    private static javax.swing.JPanel jPanel33;
    private static javax.swing.JPanel jPanel34;
    private static javax.swing.JPanel jPanel35;
    private static javax.swing.JPanel jPanel36;
    private static javax.swing.JPanel jPanel37;
    private static javax.swing.JPanel jPanel38;
    private static javax.swing.JPanel jPanel39;
    private static javax.swing.JPanel jPanel4;
    private static javax.swing.JPanel jPanel40;
    private static javax.swing.JPanel jPanel41;
    private static javax.swing.JPanel jPanel42;
    private static javax.swing.JPanel jPanel43;
    private static javax.swing.JPanel jPanel44;
    private static javax.swing.JPanel jPanel45;
    private static javax.swing.JPanel jPanel46;
    private static javax.swing.JPanel jPanel47;
    private static javax.swing.JPanel jPanel48;
    private static javax.swing.JPanel jPanel49;
    private static javax.swing.JPanel jPanel5;
    private static javax.swing.JPanel jPanel50;
    private static javax.swing.JPanel jPanel51;
    private static javax.swing.JPanel jPanel52;
    private static javax.swing.JPanel jPanel53;
    private static javax.swing.JPanel jPanel54;
    private static javax.swing.JPanel jPanel55;
    private static javax.swing.JPanel jPanel56;
    private static javax.swing.JPanel jPanel57;
    private static javax.swing.JPanel jPanel58;
    private static javax.swing.JPanel jPanel59;
    private static javax.swing.JPanel jPanel6;
    private static javax.swing.JPanel jPanel60;
    private static javax.swing.JPanel jPanel61;
    private static javax.swing.JPanel jPanel62;
    private static javax.swing.JPanel jPanel63;
    private static javax.swing.JPanel jPanel64;
    private static javax.swing.JPanel jPanel65;
    private static javax.swing.JPanel jPanel66;
    private static javax.swing.JPanel jPanel67;
    private static javax.swing.JPanel jPanel68;
    private static javax.swing.JPanel jPanel69;
    private static javax.swing.JPanel jPanel7;
    private static javax.swing.JPanel jPanel71;
    private static javax.swing.JPanel jPanel8;
    private static javax.swing.JPanel jPanel9;
    private static javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JScrollPane jScrollPane3;
    private static javax.swing.JScrollPane jScrollPane4;
    private static javax.swing.JScrollPane jScrollPane5;
    private static javax.swing.JScrollPane jScrollPane6;
    private static javax.swing.JScrollPane jScrollPane7;
    private static javax.swing.JScrollPane jScrollPane8;
    private static javax.swing.JSpinner jSpinner1;
    private static javax.swing.JTable jTable1;
    public javax.swing.JTable jTable2;
    private static javax.swing.JTable jTable3;
    private static javax.swing.JTable jTable4;
    private static javax.swing.JTable jTable5;
    private static javax.swing.JTable jTable6;
    private static javax.swing.JTable jTable7;
    private static javax.swing.JTable jTable8;
    private static javax.swing.JTextField jTextField2;
    private static javax.swing.JLabel lname;
    public javax.swing.JLabel log;
    private static javax.swing.JTextField m_search;
    private static javax.swing.JLabel m_up;
    private static javax.swing.JLabel mark_p;
    private static javax.swing.JTextField mark_up;
    private static javax.swing.JPanel pAy;
    private static javax.swing.JLabel paRTIAL;
    private static javax.swing.JTextField paid;
    private static javax.swing.JPanel panel_DAY;
    private static javax.swing.JPanel panel_DAY1;
    private static javax.swing.JPanel panel_REFRESH;
    private static javax.swing.JPanel panel_REFRESH1;
    private static javax.swing.JPanel panel_REfresh;
    private static javax.swing.JPanel panel_Refresh;
    private static javax.swing.JPanel panel_UPdate;
    private static javax.swing.JPanel panel_a;
    private static javax.swing.JPanel panel_all;
    private static javax.swing.JPanel panel_c;
    private static javax.swing.JPanel panel_cart;
    private static javax.swing.JPanel panel_choose;
    private static javax.swing.JPanel panel_clear;
    private static javax.swing.JPanel panel_cos;
    private static javax.swing.JPanel panel_d;
    private static javax.swing.JPanel panel_day;
    private static javax.swing.JPanel panel_del;
    private static javax.swing.JPanel panel_income;
    private static javax.swing.JPanel panel_invoice;
    private static javax.swing.JPanel panel_invoice1;
    private static javax.swing.JPanel panel_invoice2;
    private static javax.swing.JPanel panel_main;
    private static javax.swing.JPanel panel_p;
    private static javax.swing.JPanel panel_pos;
    private static javax.swing.JPanel panel_prod;
    private static javax.swing.JPanel panel_s;
    private static javax.swing.JPanel panel_u;
    private static javax.swing.JPanel panelu;
    private static javax.swing.JPanel pay_all;
    private static javax.swing.JPanel pay_balance;
    private static javax.swing.JPanel pay_refresh;
    private static javax.swing.JPanel pay_unpaid;
    private static javax.swing.JTextField pid;
    private static javax.swing.JLabel pname;
    private static javax.swing.JLabel posdate;
    private static javax.swing.JLabel postime;
    private static javax.swing.JLabel pri;
    private static javax.swing.JTextField price;
    private static javax.swing.JTextField product;
    private static javax.swing.JLabel product_ALL;
    private static javax.swing.JLabel product_DELETE;
    private static javax.swing.JLabel product_MOST;
    private static javax.swing.JLabel product_REFRESH;
    private static javax.swing.JLabel product_REMOVE;
    private static javax.swing.JLabel product_SAVE;
    private static javax.swing.JLabel product_STOCKS;
    private static javax.swing.JLabel product_UPDATE;
    private static javax.swing.JLabel product_id;
    private static javax.swing.JLabel profit;
    private static javax.swing.JLabel profit1;
    private static javax.swing.JTextField psearch;
    private static javax.swing.JLabel qua;
    public javax.swing.JTextField quantity;
    private static javax.swing.JPanel rEfresh;
    private static javax.swing.JPanel rEmove;
    private static javax.swing.JLabel sellingID;
    private static javax.swing.JLabel sex;
    private static javax.swing.JLabel stocks;
    private static javax.swing.JLabel t_price;
    private static javax.swing.JLabel tiME;
    private static javax.swing.JLabel tot_quantity;
    private static javax.swing.JLabel total_purchase;
    private static javax.swing.JLabel total_qty;
    private static javax.swing.JLabel unPAID;
    private static javax.swing.JLabel unit_price;
    // End of variables declaration//GEN-END:variables
}
