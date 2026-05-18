package travel.management.systrm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Signup extends JFrame implements ActionListener {
    JButton create,back;
    JTextField tfname,tfusername,tfpassword,tfanswer;
    Choice security;
    Signup(){
        //setBounds->it can also be used as setSize and setLocation
        setBounds(350,250,900,360);
        //set Frame background color
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //make a panel
        //left side panel
        JPanel p1=new JPanel();
        p1.setBackground(new Color(133,193,233));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);

        //add text and textfield
        //text(username)
        JLabel lblusername=new JLabel("Username");
        lblusername.setFont(new Font("Tahoma",Font.BOLD,14));
        lblusername.setBounds(50,20,125,25);
        p1.add(lblusername);
        //TextField(username)
        tfusername=new JTextField();
        tfusername.setBounds(190,20,180,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        //text(name)
        JLabel lblname=new JLabel("Name");
        lblname.setFont(new Font("Tahoma",Font.BOLD,14));
        lblname.setBounds(50,60,125,25);
        p1.add(lblname);
        //TextField(name)
        tfname=new JTextField();
        tfname.setBounds(190,60,180,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        //text(Password)
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setFont(new Font("Tahoma",Font.BOLD,14));
        lblpassword.setBounds(50,100,125,25);
        p1.add(lblpassword);
        //TextField(Password)
        tfpassword=new JTextField();
        tfpassword.setBounds(190,100,180,25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);

        //text(Security Question)
        JLabel lblsecurity=new JLabel("Security Question");
        lblsecurity.setFont(new Font("Tahoma",Font.BOLD,14));
        lblsecurity.setBounds(50,140,125,25);
        p1.add(lblsecurity);
        //Choice(Security question)->it is used for dropdown box
        security=new Choice();
        security.add("Fav Character From the Boys");
        security.add("Favorite Marvel Character");
        security.add("Your Lucky Number");
        security.add("Your Childhood superhero ");
        security.setBounds(190,140,180,25);
        p1.add(security);

        //text(Security Answer)
        JLabel lblanswer=new JLabel("Security Answer");
        lblanswer.setFont(new Font("Tahoma",Font.BOLD,14));
        lblanswer.setBounds(50,180,125,25);
        p1.add(lblanswer);
        //TextField(Security Answer)
        tfanswer=new JTextField();
        tfanswer.setBounds(190,180,180,25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);

        //Buttons
        //Create
        create=new JButton("Create");
        create.setBackground(Color.WHITE);
        create.setForeground(new Color(133,193,233));
        create.setFont(new Font("Tahoma",Font.BOLD,14));
        create.setBounds(80,250,100,30);
        create.addActionListener(this);
        p1.add(create);

        //Back
        back=new JButton("Back");
        back.setBackground(Color.white);
        back.setForeground(new Color(133,193,233));
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.setBounds(250,250,100,30);
        back.addActionListener(this);
        p1.add(back);

        //upload Image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons_Travels/signup.png"));
        Image i2=i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(580,50,250,250);
        add(image);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==create){
            //get values
            //getText()->used to get value
            String username=tfusername.getText();
            String name=tfname.getText();
            String password=tfpassword.getText();
            String question=security.getSelectedItem();
            String answer=tfanswer.getText();

            String query="insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
            try {
                Conn c=new Conn();
                //c->object name of Conn
                //s->Statement Variable of  Conn Class
                c.s.executeUpdate(query);

                //for showing popp
                JOptionPane.showMessageDialog(null,"Account Created sucessfully");
                setVisible(false);
                new Login_Travel();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else if (ae.getSource()==back) {
            setVisible(false);
            new Login_Travel();
        }

    }

    public static void main(String[] args) {
        new Signup();

    }
}
