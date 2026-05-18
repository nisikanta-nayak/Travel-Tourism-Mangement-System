package travel.management.systrm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewPackage_Travel extends JFrame implements ActionListener {
    JButton back;
    ViewPackage_Travel(String username){
        //set size and location of frame
        setBounds(450,200,900,450);
        //set Background color of Frame
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //Heading
        JLabel text=new JLabel("View Package Details");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(60,0,300,30);
        add(text);

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
        JLabel lblid=new JLabel("Package");
        lblid.setBounds(30,90,150,25);
        add(lblid);

        //ID->value come from database we we left empty
        JLabel labelpackage=new JLabel();
        labelpackage.setBounds(220,90,150,25);
        add(labelpackage);


        //ID number
        JLabel lblnumber=new JLabel("Total Persons");
        lblnumber.setBounds(30,130,150,25);
        add(lblnumber);

        //IDnumber->value come from database we we left empty
        JLabel labelpersons=new JLabel();
        labelpersons.setBounds(220,130,150,25);
        add(labelpersons);


        //Name
        JLabel lblname=new JLabel("ID");
        lblname.setBounds(30,170,150,25);
        add(lblname);

        //Name->value come from database we we left empty
        JLabel labelid=new JLabel();
        labelid.setBounds(220,170,150,25);
        add(labelid);

        //Gender
        JLabel lblgender=new JLabel("ID Number");
        lblgender.setBounds(30,210,150,25);
        add(lblgender);

        //Gender->value come from database we we left empty
        JLabel labelnumber=new JLabel();
        labelnumber.setBounds(220,210,150,25);
        add(labelnumber);

        //Country
        JLabel lblcountry=new JLabel("Phone");
        lblcountry.setBounds(30,250,150,25);
        add(lblcountry);

        //Country->value come from database we we left empty
        JLabel labelphone=new JLabel();
        labelphone.setBounds(220,250,150,25);
        add(labelphone);

        //address
        JLabel lbladdress=new JLabel("Price");
        lbladdress.setBounds(30,290,150,25);
        add(lbladdress);

        //address->value come from database we we left empty
        JLabel labelprice=new JLabel();
        labelprice.setBounds(220,290,150,25);
        add(labelprice);


        //buttons
        //back
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(130,360,100,25);
        back.addActionListener(this);
        add(back);

        //Upload image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons_Travels/bookedDetails.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(450,20,500,400);
        add(image);

        //connect to Mysql
        try {
            Conn conn=new Conn();
            String query="select * from bookpackage where username = '"+username+"'";
            ResultSet rs=conn.s.executeQuery(query);
            while (rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelpackage.setText(rs.getString("package"));
                labelprice.setText(rs.getString("price"));
                labelphone.setText(rs.getString("phone"));
                labelpersons.setText(rs.getString("person"));

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
        new ViewPackage_Travel("");
    }
}
