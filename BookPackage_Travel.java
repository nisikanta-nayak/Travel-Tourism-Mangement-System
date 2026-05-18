package travel.management.systrm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BookPackage_Travel extends JFrame implements ActionListener {
    //For DropDown
    Choice cpackage;
    JTextField tfpersons;
    JLabel labelusername,labelid,labelnumber,labelphone,labelprice;
    //Buttons
    JButton checkprice,bookpackage,back;
    //passing string value
    String username;
    BookPackage_Travel(String username){
        this.username=username;
        //set Size and Location
        setBounds(350,200,1100,500);
        setLayout(null);
        //change color of panel
        getContentPane() .setBackground(Color.WHITE);

        //Heading
        JLabel text=new JLabel("BOOK PACKAGE");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);

        //make text labels
        //username
        JLabel lblusername=new JLabel("username");
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblusername.setBounds(40,70,100,20);
        add(lblusername);

        //username->value come from database we we left empty
        labelusername=new JLabel();
        labelusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelusername.setBounds(250,70,200,20);
        add(labelusername);

        //Select Package
        JLabel lblpackage=new JLabel("Select Package");
        lblpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblpackage.setBounds(40,110,120,20);
        add(lblpackage);

       //for package choose from drop down
        cpackage=new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250,110,200,20);
        add(cpackage);


        //Number of person
        JLabel lblperson=new JLabel("Total Persons");
        lblperson.setBounds(40,150,150,25);
        lblperson.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblperson);

        //textfield
        tfpersons=new JTextField("1");
        tfpersons.setBounds(250,150,200,25);
        add(tfpersons);

        //Id
        JLabel lblid=new JLabel("ID");
        lblid.setBounds(40,190,150,20);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblid);

        //labelId->value come from database we we left empty
        labelid=new JLabel();
        labelid.setBounds(250,190,200,25);
        add(labelid);

        //Id Number
        JLabel lblnumber=new JLabel("ID Number");
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblnumber.setBounds(40,230,150,25);
        add(lblnumber);

        //Id Number->value come from database we we left empty
        labelnumber=new JLabel();
        labelnumber.setBounds(250,230,150,25);
        add(labelnumber);


        //Phone
        JLabel lblphone=new JLabel("Phone");
        lblphone.setBounds(40,270,150,20);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblphone);

        //labelphone->value come from database we we left empty
        labelphone=new JLabel();
        labelphone.setBounds(250,270,200,25);
        add(labelphone);

        //Total Price
        JLabel lbltotal=new JLabel("Total Price");
        lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbltotal.setBounds(40,310,150,25);
        add(lbltotal);

        //Id Number->value come from database we we left empty
        labelprice=new JLabel();
        labelprice.setBounds(250,310,150,25);
        add(labelprice);


        //connect to Mysql
        try {
            Conn conn=new Conn();
            String query="select * from customer where username = '"+username+"'";
            ResultSet rs=conn.s.executeQuery(query);
            while (rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));

            }

        }catch (Exception ae){
            ae.printStackTrace();
        }
        //Buuton
        //Checkprice
        checkprice=new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60,380,120,25);
        checkprice.addActionListener(this);
        add(checkprice);

        //Book Package
        bookpackage=new JButton("Book Package");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200,380,120,25);
        bookpackage.addActionListener(this);
        add(bookpackage);

        //back
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340,380,120,25);
        back.addActionListener(this);
        add(back);

        //upload Image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons_Travels/bookpackage.jpg"));
        Image i2= i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(550,50,500,300);
        add(image);


        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==checkprice){
            String pack=cpackage.getSelectedItem().trim();
            int cost = 0;
            if (pack.equalsIgnoreCase("Gold Package")){
                 cost += 15000;
            } else if (pack.equalsIgnoreCase("Silver Package")) {
                cost += 12000;
            }else{
                cost += 8500;
            }
            int persons=Integer.parseInt(tfpersons.getText().trim());
            cost *=persons;
            labelprice.setText("Rs"+cost);
        } else if (ae.getSource()==bookpackage) {
            try{
               Conn c=new Conn();
               c.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"','"+cpackage.getSelectedItem()+"','"+tfpersons.getText()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"') ");

               JOptionPane.showMessageDialog(null,"Package Booked Successfully");
               setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else{
            setVisible(false);

        }

    }

    public static void main(String[] args) {
        new BookPackage_Travel("");
    }
}
