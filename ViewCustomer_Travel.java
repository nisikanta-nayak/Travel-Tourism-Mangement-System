package travel.management.systrm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewCustomer_Travel extends JFrame implements ActionListener {
    JButton back;
    ViewCustomer_Travel(String username){
         //set size and location of frame
        setBounds(450,180,870,625);
        //set Background color of Frame
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //make text labels
        //username
        JLabel lblusername=new JLabel("username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

        //username->value come from database we we left empty
        JLabel labelusername=new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);

        //ID
        JLabel lblid=new JLabel("ID");
        lblid.setBounds(30,110,150,25);
        add(lblid);

        //ID->value come from database we we left empty
        JLabel labelid=new JLabel();
        labelid.setBounds(220,110,150,25);
        add(labelid);


        //ID number
        JLabel lblnumber=new JLabel("Number");
        lblnumber.setBounds(30,170,150,25);
        add(lblnumber);

        //IDnumber->value come from database we we left empty
        JLabel labelnumber=new JLabel();
        labelnumber.setBounds(220,170,150,25);
        add(labelnumber);


        //Name
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(30,230,150,25);
        add(lblname);

        //Name->value come from database we we left empty
        JLabel labelname=new JLabel();
        labelname.setBounds(220,230,150,25);
        add(labelname);

        //Gender
        JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(30,290,150,25);
        add(lblgender);

        //Gender->value come from database we we left empty
        JLabel labelgender=new JLabel();
        labelgender.setBounds(220,290,150,25);
        add(labelgender);

        //Country
        JLabel lblcountry=new JLabel("country");
        lblcountry.setBounds(500,50,150,25);
        add(lblcountry);

        //Country->value come from database we we left empty
        JLabel labelcountry=new JLabel();
        labelcountry.setBounds(690,50,150,25);
        add(labelcountry);

        //address
        JLabel lbladdress=new JLabel("Address");
        lbladdress.setBounds(500,110,150,25);
        add(lbladdress);

        //address->value come from database we we left empty
        JLabel labeladdress=new JLabel();
        labeladdress.setBounds(690,110,150,25);
        add(labeladdress);

        //Phone
        JLabel lblphone=new JLabel("Phone");
        lblphone.setBounds(500,170,150,25);
        add(lblphone);

        //phone->value come from database we we left empty
        JLabel labelphone=new JLabel();
        labelphone.setBounds(690,170,150,25);
        add(labelphone);

        //email
        JLabel lblemail=new JLabel("Email");
        lblemail.setBounds(500,230,150,25);
        add(lblemail);

        //email->value come from database we we left empty
        JLabel labelemail=new JLabel();
        labelemail.setBounds(690,230,150,25);
        add(labelemail);

        //buttons
        //back
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(350,350,100,25);
        back.addActionListener(this);
        add(back);

        //Upload image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons_Travels/viewall.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(20,400,600,200);
        add(image);
//        copying same image
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("Icons_Travels/viewall.jpg"));
        Image i5=i4.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel  image2=new JLabel(i6);
        image2.setBounds(600,400,600,200);
        add(image2);

        //connect to Mysql
        try {
            Conn conn=new Conn();
            String query="select * from customer where username = '"+username+"'";
            ResultSet rs=conn.s.executeQuery(query);
            while (rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labeladdress.setText(rs.getString("address"));
                labelphone.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));

            }

        }catch (Exception ae){

        }


        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);

    }

    public static void main(String[] args) {
        new ViewCustomer_Travel("");
    }
}
