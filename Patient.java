import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.net.*;
import javax.swing.*;

public class Patient extends Applet implements ActionListener
{

static String userid="system", password = "tiger";
static String url = "jdbc:odbc:dsn1";
static Statement stmt;
static Connection con;
static JPanel panelimg;
static JFrame frame;

String ward;
String days;
String fname;
String lname;
String rcpt;
String other;
static JPanel panel1;
static JPanel panel2;
static JPanel panel3;
static JPanel panel4;


JButton submitBtn;
JButton exitBtn;
JButton nextBtn;
int dialogtype = JOptionPane.PLAIN_MESSAGE;
String dialogmessage;
String dialogs;
JLabel nameLbl;
JLabel tnameLbl;
JLabel fnameLbl;
JLabel lnameLbl;
JLabel wardLbl;
JLabel daysLbl;
JLabel rcptLbl;
JLabel otherLbl;
JLabel nameLbimg;
JLabel pnoLbl;
static JTextField fnameTxt;
static JTextField lnameTxt;
static JTextField wardTxt;
static JTextField daysTxt;
static JTextField rcptTxt;
static JTextField otherTxt;
static JTextField pnoTxt;

public Patient()
{


panel1 = new JPanel();
panel1.setLayout(new FlowLayout());
nameLbl = new JLabel("Patient Admission Form");

panel2 = new JPanel();

panel2.setLayout(new FlowLayout());
tnameLbl = new JLabel("");
panel3=new JPanel();
panel3.setLayout(new GridLayout(7,2));
fnameLbl=new JLabel("first name  :");
fnameTxt=new JTextField(10);
lnameLbl = new JLabel("Last name :");
lnameTxt = new JTextField(10);

wardLbl = new JLabel("Address :");

wardTxt = new JTextField(10);


daysLbl=new JLabel("Age :");
daysTxt=new JTextField(10);

otherLbl=new JLabel("Sex :");
otherTxt=new JTextField(10);

rcptLbl=new JLabel("Blood Group  :");
rcptTxt=new JTextField(10);

pnoLbl=new JLabel("Patient_no :");
pnoTxt=new JTextField(10);

panel4=new JPanel();
panel4.setLayout(new FlowLayout());
panelimg=new JPanel();
	panelimg.setLayout(new FlowLayout());
	nameLbimg=new JLabel("",new ImageIcon("patient.jpg"),JLabel.CENTER);


submitBtn = new JButton("Submit");

submitBtn.addActionListener(this);
exitBtn = new JButton("Exit");

exitBtn.addActionListener(this);
nextBtn = new JButton("next");

nextBtn.addActionListener(this);
panel1.add(nameLbl);
panel1.setOpaque(true);
panel2.add(tnameLbl);
panel2.setOpaque(true);
panelimg.add(nameLbimg);
panelimg.setOpaque(true);
panel3.add(rcptLbl);
panel3.add(rcptTxt);
panel3.add(fnameLbl);
panel3.add(fnameTxt);
panel3.add(lnameLbl);
panel3.add(lnameTxt);
panel3.add(wardLbl);
panel3.add(wardTxt);
panel3.add(daysLbl);
panel3.add(daysTxt);
panel3.add(otherLbl);
panel3.add(otherTxt);
panel3.add(pnoLbl);
panel3.add(pnoTxt);


panel3.setOpaque(true);
panel4.add(submitBtn);
panel4.add(exitBtn);
panel4.setOpaque(true);
panel4.add(nextBtn);
panel4.setOpaque(true);

frame = new JFrame(" Patient Admission Form");
frame.setSize(550,550);
Container pane = frame.getContentPane();
pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

pane.add(panel1);
pane.add(panelimg);
pane.add(panel2);
pane.add(panel3);
pane.add(panel4);
frame.setVisible(true);

}



public static Connection getConnection()
{

try {
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	//Class.forName("myDriver.ClassName"); ?

} catch(java.lang.ClassNotFoundException e) {
System.err.print("ClassNotFoundException: ");
System.err.println(e.getMessage());
}

try {
con = DriverManager.getConnection(url,
userid, password);

} catch(SQLException ex) {
System.err.println("SQLException: " + ex.getMessage());
}

return con;
}


public void actionPerformed(ActionEvent event)
{
Object source = event.getSource();
if(source.equals(submitBtn))
{
submit();

}
else if(source.equals(exitBtn))
{
System.exit(0);
}
if(source.equals(nextBtn))
{
frame.setVisible(false);
JOptionPane.showMessageDialog(null,"Patient Consults a Physician");

Physician m1=new Physician();

}

}




public void submit()
{
Connection con = getConnection();


String insertString1;

insertString1 = "insert into patient values('"+rcptTxt.getText().trim()+"','"+ fnameTxt.getText().trim()+ " ','" + lnameTxt.getText().trim()+"','"+wardTxt.getText().trim()+"','"+daysTxt.getText().trim()+"','"+otherTxt.getText().trim()+"','"+daysTxt.getText().trim()+"')";


try {
stmt = con.createStatement();

stmt.executeUpdate(insertString1);
stmt.close();
con.close();

} catch(SQLException ex) {
System.err.println("SQLException: " + ex.getMessage());
JOptionPane.showMessageDialog(null,"INVALID INPUT");
}


JOptionPane.showMessageDialog(null,"Patient Registered Succesfully");
}

public static void main(String[] args)
{


Patient frame1 = new Patient();



}



}

