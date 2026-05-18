package travel.management.systrm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewBookedHotel_Travel extends JFrame implements ActionListener{
        JButton back;
    ViewBookedHotel_Travel(String username){
            //set size and location of frame
            setBounds(400,200,1000,600);
            //set Background color of Frame
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);

            //Heading
            JLabel text=new JLabel("View BOOKED Hotel Details");
            text.setFont(new Font("Tahoma",Font.BOLD,20));
            text.setBounds(60,0,400,30);
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
            JLabel lblname=new JLabel("Hotel Name");
            lblname.setBounds(30,90,150,25);
            add(lblname);

            //ID->value come from database we we left empty
            JLabel labelname=new JLabel();
            labelname.setBounds(220,90,150,25);
            add(labelname);


            //total persons
            JLabel lblperson=new JLabel("Total Persons");
            lblperson.setBounds(30,130,150,25);
            add(lblperson);

            //IDnumber->value come from database we we left empty
            JLabel labelpersons=new JLabel();
            labelpersons.setBounds(220,130,150,25);
            add(labelpersons);

        //Total Days
        JLabel lbldays=new JLabel("Total Days");
        lbldays.setBounds(30,170,150,25);
        add(lbldays);

        //labeldays->value come from database we we left empty
        JLabel labeldays=new JLabel();
        labeldays.setBounds(220,170,150,25);
        add(labeldays);

        //AC/NON-AC
        JLabel lblac=new JLabel("AC/NON-AC");
        lblac.setBounds(30,210,150,25);
        add(lblac);

        //labelac->value come from database we we left empty
        JLabel labelac=new JLabel();
        labelac.setBounds(220,210,150,25);
        add(labelac);

        //Food Included
        JLabel lblfood=new JLabel("Food Included?");
        lblfood.setBounds(30,250,150,25);
        add(lblfood);

        //Food Included->value come from database we we left empty
        JLabel labelfood=new JLabel();
        labelfood.setBounds(220,250,150,25);
        add(labelfood);


            //ID
            JLabel lblid=new JLabel("ID");
            lblid.setBounds(30,290,150,25);
            add(lblid);

            //Id->value come from database we we left empty
            JLabel labelid=new JLabel();
            labelid.setBounds(220,290,150,25);
            add(labelid);

            //Id Number
            JLabel lblnumber=new JLabel("ID Number");
            lblnumber.setBounds(30,330,150,25);
            add(lblnumber);

            //Id number->value come from database we we left empty
            JLabel labelnumber=new JLabel();
            labelnumber.setBounds(220,330,150,25);
            add(labelnumber);

            //Phone
            JLabel lblphone=new JLabel("Phone");
            lblphone.setBounds(30,370,150,25);
            add(lblphone);

            //Phone->value come from database we we left empty
            JLabel labelphone=new JLabel();
            labelphone.setBounds(220,370,150,25);
            add(labelphone);

            //Total cost
            JLabel lblprice=new JLabel("Total Cost");
            lblprice.setBounds(30,410,150,25);
            add(lblprice);

            //Total Cost->value come from database we we left empty
            JLabel labelprice=new JLabel();
            labelprice.setBounds(220,410,150,25);
            add(labelprice);


            //buttons
            //back
            back=new JButton("Back");
            back.setBackground(Color.BLACK);
            back.setForeground(Color.white);
            back.setBounds(130,460,100,25);
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
                String query="select * from bookhotel where username = '"+username+"'";
                ResultSet rs=conn.s.executeQuery(query);
                while (rs.next()){
                    labelusername.setText(rs.getString("username"));
                    labelid.setText(rs.getString("id"));
                    labelnumber.setText(rs.getString("number"));
                    labelname.setText(rs.getString("name"));
                    labelprice.setText(rs.getString("price"));
                    labelphone.setText(rs.getString("phone"));
                    labelpersons.setText(rs.getString("persons"));
                    labelfood.setText(rs.getString("food"));
                    labelac.setText(rs.getString("ac"));
                    labeldays.setText(rs.getString("days"));

                }

            }catch (Exception ae){

            }


            setVisible(true);

        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            setVisible(false);

        }

        public static void main(String[] args)
        {
            new ViewBookedHotel_Travel("");
        }
    }


