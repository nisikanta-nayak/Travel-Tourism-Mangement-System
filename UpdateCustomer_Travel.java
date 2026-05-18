package travel.management.systrm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCustomer_Travel extends JFrame implements ActionListener{
        //as data is already in data base so we use JLable
        JLabel labelusername,labelname;
        //for user Input
        JTextField tfnumber,tfcountry,tfaddress,tfemail,tfphone,tfid,tfgender;

        JButton add,back;
        UpdateCustomer_Travel(String username){
            //set frame size and location of frame
            setBounds(500,200,850,550);
            //set frame layout null
            setLayout(null);
            //set Frame Color
            getContentPane().setBackground(Color.white);

            //Text(Heading)
            JLabel text=new JLabel("Update Customer Details");
            text.setBounds(50,0,300,25);
            text.setFont(new Font("Tahoma",Font.PLAIN,20));
            add(text);

            //text(username)
            JLabel lblusername=new JLabel("Username");
            lblusername.setBounds(30,50,150,25);
            add(lblusername);

            //text(username)->it help to fatch value from server
            //already exit so we have taken Jlabel insted of JTextField
            //it's not eidiable
            labelusername=new JLabel();
            labelusername.setBounds(220,50,150,25);
            add(labelusername);

            //text(ID)
            JLabel lblid=new JLabel("ID");
            lblid.setBounds(30,90,150,25);
            add(lblid);


            //textfield(ID number)->user input
            tfid=new JTextField();
            tfid.setBounds(220,90,150,25);
            add(tfid);

            //text(ID Number)
            JLabel lblnumber=new JLabel("Number");
            lblnumber.setBounds(30,130,150,25);
            add(lblnumber);

            //textfield(ID number)->user input
            tfnumber=new JTextField();
            tfnumber.setBounds(220,130,150,25);
            add(tfnumber);

            //text(name)
            JLabel lblname=new JLabel("Name");
            lblname.setBounds(30,170,150,25);
            add(lblname);

            //text(name)->it help to fatch value from server
            //already exit so we have taken Jlabel insted of JTextField
            //it's not editable
            labelname=new JLabel();
            labelname.setBounds(220,170,150,25);
            add(labelname);

            //text(Gender)
            JLabel lblgender=new JLabel("Gender");
            lblgender.setBounds(30,210,150,25);
            add(lblgender);

            //textfield(Gender)->user input
            tfgender=new JTextField();
            tfgender.setBounds(220,210,150,25);
            add(tfgender);


            //text(Country)
            JLabel lblcountry=new JLabel("Country");
            lblcountry.setBounds(30,250,150,25);
            add(lblcountry);

            //textfield(Country)->user input
            tfcountry=new JTextField();
            tfcountry.setBounds(220,250,150,25);
            add(tfcountry);

            //text(Address)
            JLabel lbladdress=new JLabel("Address");
            lbladdress.setBounds(30,290,150,25);
            add(lbladdress);

            //textfield(Address)->user input
            tfaddress=new JTextField();
            tfaddress.setBounds(220,290,150,25);
            add(tfaddress);

            //text(Phone)
            JLabel lblphone=new JLabel("Phone");
            lblphone.setBounds(30,330,150,25);
            add(lblphone);

            //textfield(Phone)->user input
            tfphone=new JTextField();
            tfphone.setBounds(220,330,150,25);
            add(tfphone);

            //text(Email)
            JLabel lblemail=new JLabel("Email");
            lblemail.setBounds(30,370,150,25);
            add(lblemail);

            //textfield(Email)->user input
            tfemail=new JTextField();
            tfemail.setBounds(220,370,150,25);
            add(tfemail);

            //Button
            //add
            add=new JButton("Update");
            add.setBackground(Color.BLACK);
            add.setForeground(Color.WHITE);
            add.setBounds(70,430,100,25);
            add.addActionListener(this);
            add(add);
            //Back
            back=new JButton("Back");
            back.setBackground(Color.BLACK);
            back.setForeground(Color.WHITE);
            back.setBounds(220,430,100,25);
            back.addActionListener(this);
            add(back);

            //Upload image
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons_Travels/update.png"));
            Image i2=i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
            ImageIcon i3=new ImageIcon(i2);
            JLabel image=new JLabel(i3);
            image.setBounds(400,100,450,300);
            add(image);

            //get username and name from mysql
            //as frame open it will work so I was doing inside constructur
            try {
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery("select * from customer where username = '"+username+"'");
                while(rs.next()){
                    labelusername.setText(rs.getString("username"));
                    labelname.setText(rs.getString("name"));
                    tfid.setText(rs.getString("id"));
                    tfnumber.setText(rs.getString("number"));
                    tfgender.setText(rs.getString("gender"));
                    tfcountry.setText(rs.getString("country"));
                    tfaddress.setText(rs.getString("address"));
                    tfphone.setText(rs.getString("phone"));
                    tfemail.setText(rs.getString("email"));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


            /// make set visible
            setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource()==add){
                String username=labelusername.getText();
                String id=tfid.getText();
                String number=tfnumber.getText();
                String name=labelname.getText();
                String gender=tfgender.getText();
                String country=tfcountry.getText();
                String address=tfaddress.getText();
                String phone=tfphone.getText();
                String email=tfemail.getText();

                try {
                    Conn c= new Conn();
                    String query="update customer set username='"+username+"',id='"+id+"',number='"+number+"',name='"+name+"',gender='"+gender+"',country='"+country+"',address='"+address+"',phone='"+phone+"',email='"+email+"'";
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null,"Customer Details Updated Sucessfully");
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                setVisible(false);
            }

        }

        public static void main(String[] args) {
            new UpdateCustomer_Travel("");
        }
    }


