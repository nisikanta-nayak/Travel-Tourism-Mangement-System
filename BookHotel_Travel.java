package travel.management.systrm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookHotel_Travel extends JFrame implements ActionListener {
     //For DropDown
        Choice chotel,cac,cfood;
        JTextField tfpersons,tfdays;
        JLabel labelusername,labelid,labelnumber,labelphone,labelprice;
        //Buttons
        JButton checkprice,bookpackage,back;
        //passing string value
        String username;
    BookHotel_Travel(String username){
            this.username=username;
            //set Size and Location
            setBounds(350,200,1100,600);
            setLayout(null);
            //change color of panel
            getContentPane() .setBackground(Color.WHITE);

            //Heading
            JLabel text=new JLabel("BOOK HOTELS");
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

            //Select hotel
            JLabel lblhotel=new JLabel("Select Hotel");
            lblhotel.setFont(new Font("Tahoma",Font.PLAIN,16));
            lblhotel.setBounds(40,110,120,20);
            add(lblhotel);

            //for package choose from drop down
            chotel=new Choice();
            chotel.setBounds(250,110,200,20);
            add(chotel);

            try {
               Conn c=new Conn();
               ResultSet rs=c.s.executeQuery("select * from hotel");
               while (rs.next()){
                   chotel.add(rs.getString("name"));
               }
            } catch (Exception e) {
                e.printStackTrace();
            }


            //Number of person
            JLabel lblperson=new JLabel("Total Persons");
            lblperson.setBounds(40,150,150,25);
            lblperson.setFont(new Font("Tahoma",Font.PLAIN,16));
            add(lblperson);

            //textfield
            tfpersons=new JTextField("1");
            tfpersons.setBounds(250,150,200,25);
            add(tfpersons);

           //Number of days
           JLabel lbldays=new JLabel("No of Days");
           lbldays.setBounds(40,190,150,25);
           lbldays.setFont(new Font("Tahoma",Font.PLAIN,16));
           add(lbldays);

           //textfield
            tfdays=new JTextField("1");
            tfdays.setBounds(250,190,200,25);
            add(tfdays);

           //AC/NON-AC
           JLabel lblac=new JLabel("AC/NON-AC");
           lblac.setBounds(40,230,150,25);
           lblac.setFont(new Font("Tahoma",Font.PLAIN,16));
           add(lblac);

          //for ac/non-ac choose from drop down
          cac=new Choice();
          cac.add("AC");
          cac.add("Non-AC");
          cac.setBounds(250,230,200,20);
          add(cac);

         //Food
         JLabel lblfood=new JLabel("Food Included");
         lblfood.setBounds(40,270,150,25);
         lblfood.setFont(new Font("Tahoma",Font.PLAIN,16));
         add(lblfood);

         //for Food choose from drop down
         cfood=new Choice();
         cfood.add("Yes");
         cfood.add("No");
         cfood.setBounds(250,270,200,20);
         add(cfood);


        //Id
            JLabel lblid=new JLabel("ID");
            lblid.setBounds(40,310,150,20);
            lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
            add(lblid);

            //labelId->value come from database we we left empty
            labelid=new JLabel();
            labelid.setBounds(250,310,200,25);
            add(labelid);

            //Id Number
            JLabel lblnumber=new JLabel("ID Number");
            lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
            lblnumber.setBounds(40,350,150,25);
            add(lblnumber);

            //Id Number->value come from database we we left empty
            labelnumber=new JLabel();
            labelnumber.setBounds(250,350,150,25);
            add(labelnumber);


            //Phone
            JLabel lblphone=new JLabel("Phone");
            lblphone.setBounds(40,390,150,20);
            lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
            add(lblphone);

            //labelphone->value come from database we we left empty
            labelphone=new JLabel();
            labelphone.setBounds(250,390,200,25);
            add(labelphone);

            //Total Price
            JLabel lbltotal=new JLabel("Total Price");
            lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
            lbltotal.setBounds(40,430,150,25);
            add(lbltotal);

            //total price->value come from database we we left empty
            labelprice=new JLabel();
            labelprice.setBounds(250,430,150,25);
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
            checkprice.setBounds(60,490,120,25);
            checkprice.addActionListener(this);
            add(checkprice);

            //Book Package
            bookpackage=new JButton("Book Hotel");
            bookpackage.setBackground(Color.BLACK);
            bookpackage.setForeground(Color.WHITE);
            bookpackage.setBounds(200,490,120,25);
            bookpackage.addActionListener(this);
            add(bookpackage);

            //back
            back=new JButton("Back");
            back.setBackground(Color.BLACK);
            back.setForeground(Color.WHITE);
            back.setBounds(340,490,120,25);
            back.addActionListener(this);
            add(back);

            //upload Image
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons_Travels/book.jpg"));
            Image i2= i1.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
            ImageIcon i3=new ImageIcon(i2);
            JLabel image=new JLabel(i3);
            image.setBounds(500,50,600,400);
            add(image);


            setVisible(true);

        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource()==checkprice){
                try {
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery("select * from hotel where name='"+chotel.getSelectedItem()+"'");
                while (rs.next()){
                    int cost=Integer.parseInt(rs.getString("costperperson"));
                    int food=Integer.parseInt(rs.getString("foodincluded"));
                    int ac=Integer.parseInt(rs.getString("acroom"));

                    int persons=Integer.parseInt(tfpersons.getText());
                    int days=Integer.parseInt(tfdays.getText());

                    String acselected=cac.getSelectedItem();
                    String foodselected=cfood.getSelectedItem();

                    if(persons * days >0){
                        int total=0;
                        //using tenary operator
                        total  +=acselected.equals("AC")?ac:0;
                        total +=foodselected.equals("Yes")?food:0;
                        total +=cost;

                        total=total*persons*days;
                        labelprice.setText("Rs"+total);
                    }else{
                        JOptionPane.showMessageDialog(null,"Please Enter the valid number");
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
              }
            } else if (ae.getSource()==bookpackage) {
                try{
                    Conn c=new Conn();
                    c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"','"+chotel.getSelectedItem()+"','"+tfpersons.getText()+"','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"') ");

                    JOptionPane.showMessageDialog(null,"Hotel Booked Successfully");
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }else{
                setVisible(false);

            }

        }

        public static void main(String[] args) {
            new BookHotel_Travel("Nisikanta");
        }
    }

