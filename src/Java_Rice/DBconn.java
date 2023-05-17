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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;

public class DBconn {

    public void glenn(JPanel start, JPanel start1, JPanel start2, JPanel start3, JPanel start4, JPanel start5, JPanel start6, JPanel start7, JPanel start8) {
        start.setVisible(true);
        start1.setVisible(false);
        start2.setVisible(false);
        start3.setVisible(false);
        start4.setVisible(false);
        start5.setVisible(false);
        start6.setVisible(false);
        start7.setVisible(false);
        start8.setVisible(false);

    }

    public void setcolor(JPanel panel) {
        panel.setBackground(new Color(14, 18, 14));

    }

    public void resetcolor(JPanel panel1) {
        panel1.setBackground(new Color(0, 0, 0));

    }

    public void colorful(JPanel panel1) {
        panel1.setBackground(new Color(0, 255, 255));

    }

    public void colorfull(JPanel panel1) {
        panel1.setBackground(new Color(20, 255, 255));

    }
    //Home Background

    public void home_panel1(JPanel panel1) {
        panel1.setBackground(new Color(240, 240, 240));
    }

    public void home_panel2(JPanel panel1) {
        panel1.setBackground(Color.white);
    }

    //Product foreground
    public void product_color1(JLabel label1) {
        label1.setForeground(Color.orange);
    }

    public void product_color2(JLabel label2) {
        label2.setForeground(Color.white);
    }

    public void product_color3(JLabel label3) {
        label3.setForeground(Color.black);
    }
    //Choose foreground

    public void choose_color1(JLabel label1) {
        label1.setForeground(Color.orange);
    }

    public void choose_color2(JLabel label2) {
        label2.setForeground(Color.black);
    }
    // Choose background color

    public void recolor(JPanel panel1) {
        panel1.setBackground(new Color(250, 255, 255));

    }

    public void color(JPanel panel1) {
        panel1.setBackground(new Color(255, 255, 255));
    }

    public void empty(JLabel label, JLabel label1, JLabel label2, JLabel label3, JLabel label4, JLabel label5) {

        label.setText("Enter Firstname :");
        label1.setText("Enter Lastname :");
        label2.setText("Enter contact :");
        label3.setText("Enter sex :");
        label4.setText("Enter address :");
        label5.setText("Enter Email Address :");
    }

    public void settext(JLabel label, JLabel label1, JLabel label2, JLabel label3, JLabel label4, JLabel label5) {
        label.setText("Name :");
        label1.setText("Last name :");
        label2.setText("Contact :");
        label3.setText("Sex :");
        label4.setText("Address :");
        label5.setText("Email Address :");

    }

    public void clear(JTextField text1, JTextField text2, JTextField text3, JTextField text4, JTextField text5, JTextField text6) {
        text1.setText("");
        text2.setText("");
        text3.setText("");
        text4.setText("");
        text5.setText("");
        text5.setText("");

    }

    public void clearupdate(JTextField text1, JTextField text2, JTextField text3, JTextField text4, JTextField text5, JTextField text6, JTextField text7) {
        text1.setText("");
        text2.setText("");
        text3.setText("");
        text4.setText("");
        text5.setText("");
        text6.setText("");
        text7.setText("");

    }

    public void empty(JTextField empty1, JTextField empty2, JTextField empty3, JTextField empty4, JTextField empty5, JTextField empty6, JTextField empty7) {
        empty1.getText();
        empty2.getText();
        empty3.getText();
        empty4.getText();
        empty5.getText();
        empty6.getText();
        empty7.getText();
    }

    public void settext1(JLabel label, JLabel label1, JLabel label2, JLabel label3, JLabel label4, JLabel label5) {
        label.setText("Product :");
        label1.setText("Bar_code :");
        label2.setText("Price :");
        label3.setText("Quantity :");
        label4.setText("Mark up :");
        label5.setText("Expiration date :");

    }

    public void empty1(JLabel label, JLabel label1, JLabel label2, JLabel label3, JLabel label4, JLabel label5) {

        label.setText("Enter product name :");
        label1.setText("Enter product bar code :");
        label2.setText("Enter product price :");
        label3.setText("Enter product quantity :");
        label4.setText("Enter mark up price :");
        label5.setText("Enter Expiration date :");
    }
    //Mysql Coonection

    public static Connection mycon() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java-rice", "root", "Namias99");
            return con;

        } catch (ClassNotFoundException | SQLException x) {
            System.out.println(x);
            return null;
        }
    }

    public void number(JLabel num1, JLabel num2, JLabel num3, JLabel num4, JLabel num5, JLabel num6) {
        num1.setText("0.0");
        num2.setText("0.0");
        num3.setText("0.0");
        num4.setText("0.0");
        num5.setText("0.0");
        num6.setText("0.0");

    }

    public void totalPurchase(JSpinner label, JLabel label2, JLabel label3) {
        double q = Double.parseDouble(label.getValue().toString());
        double a = Double.parseDouble(label2.getText());

        double ans = q * a;

        label3.setText(String.valueOf(ans));
    }

    public void availableStocks(JSpinner label, JLabel label2, JLabel label3) {
        double qty = Double.valueOf(label.getValue().toString());
        double pric = Double.valueOf(label2.getText());

        double totl = pric - qty;

        label3.setText(String.valueOf(totl));
    }

        //Getting data from costumer information
    public void arraySettext(JTable table, JTextField setText, JTextField setText1, JTextField setText2, JTextField setText3, JTextField setText4, JTextField setText5, JTextField setText6) {
        
        
        int r = table.getSelectedRow();

        String[] Array = {table.getValueAt(r, 0).toString(), table.getValueAt(r, 1).toString(), table.getValueAt(r, 2).toString(), table.getValueAt(r, 3).toString(), table.getValueAt(r, 4).toString(), table.getValueAt(r, 5).toString(), table.getValueAt(r, 8).toString()};

        setText.setText(Array[0]);
        setText1.setText(Array[1]);
        setText2.setText(Array[2]);
        setText3.setText(Array[3]);
        setText4.setText(Array[4]);
        setText5.setText(Array[5]);
        setText6.setText(Array[6]);
        
    }

 public void settingDisableSliderON(JPanel PanelDisabler, int goodness){
        if(goodness == 0){
            PanelDisabler.setSize(1220, 0);
            Thread th = new Thread(){
                @Override
                public void run(){
                    try{
                        for(int i = 0; i < 770; i++){
                            PanelDisabler.setSize(1220, i);
                        }
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    };
                    PanelDisabler.setBackground(new Color(0,0,0,0.6f));
                                    }
            };th.start();
            }
            
    }

}
