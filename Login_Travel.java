package travel.management.systrm;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login_Travel extends JFrame implements ActionListener {
    JButton login,signup,password;
    //java textField
    JTextField tfusername,tfpassword;
    Login_Travel(){
        setSize(900,400);
        setLocation(350,200);
        setLayout(null);
        //change the background colar of frame
        getContentPane().setBackground(Color.WHITE);

        //Divide frame into two part
        //Object of JPanel->it help to divide the frame to two parts
        //JPanel p1->it is for left side
        JPanel p1=new JPanel();
        p1.setBackground(new Color(131,191,233));
        p1.setBounds(0,0,400,400);
        p1.setLayout(null);
        add(p1);

        //add image above panel/frame1
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons_Travels/login.png"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(100,120,200,200);
        p1.add(image);

        //object of right side panel->JPanel p2
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,30,450,300);
        add(p2);

        //Adding text
        //JLable->It's main work to add text
        //text for username
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(60,20,100,25);
        lblusername.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        p2.add(lblusername);
        //ADDING TEXT FIELD FOR USERNAME
        tfusername=new JTextField();
        tfusername.setBounds(60,60,300,30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);

        //text for password
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(60,110,100,25);
        lblpassword.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        p2.add(lblpassword);
        //ADDING TEXT FIELD FOR Password
        tfpassword=new JTextField();
        tfpassword.setBounds(60,150,300,30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);

        //Buttons
        //login
        login=new JButton("Login");
        login.setBounds(60,200,130,30);
        //Background color for button
        login.setBackground(new Color(133,193,233));
        //Button name color
        login.setForeground(Color.white);
        login.setBorder(new LineBorder(new Color(133, 193, 233)));
        login.addActionListener(this);
        p2.add(login);

        //Signup
        signup=new JButton("Signup");
        signup.setBounds(230,200,130,30);
        //Background color for button
        signup.setBackground(new Color(133,193,233));
        //Button name color
        signup.setForeground(Color.white);
        signup.setBorder(new LineBorder(new Color(133, 193, 233)));
        signup.addActionListener(this);
        p2.add(signup);

        //Forget Password
        password=new JButton("Forget Password");
        password.setBounds(130,250,130,30);
        //Background color for button
        password.setBackground(new Color(133,193,233));
        //Button name color
        password.setForeground(Color.white);
        password.setBorder(new LineBorder(new Color(133, 193, 233)));
        password.addActionListener(this);
        p2.add(password);


        //adding text in front of Forget password
        JLabel text=new JLabel("Trouble in Login...");
        text.setBounds(300,250,150,20);
        text.setForeground(Color.RED);
        p2.add(text);




        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
          if (ae.getSource()==login){
              try{
                  String username=tfusername.getText();
                  String pass=tfpassword.getText();

                  //Add query from sql
                  String query="select * from account where username='"+username+"' AND password='"+pass+"'";
                  //object of conn class
                  Conn c=new Conn();
                  ResultSet rs=c.s.executeQuery(query);
                  //while loop for exsecting
                  if(rs.next()){
                      setVisible(false);
                      new Loading_Travel(username);
                  }else{
                      JOptionPane.showMessageDialog(null,"Incorrect Detail");
                  }
              } catch (Exception e) {
                  e.printStackTrace();
              }

          } else if (ae.getSource()==signup) {
                 setVisible(false);
                 new Signup();
          }else {
              setVisible(false);
              new ForgetPassword();
          }
    }

    public static void main(String[] args) {
        new Login_Travel();
    }
}
