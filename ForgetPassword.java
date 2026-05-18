package travel.management.systrm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ForgetPassword extends JFrame implements ActionListener {
    //textfield
    JTextField tfusername,tfname,tfquestion,tfanswer,tfpassword;
    //button
    JButton search,retrieve,back;
    ForgetPassword(){
        //To use set size and set Location of frame
        setBounds(350,200,850,380);
        //for setting background color of frame
        getContentPane().setBackground(Color.white);
        setLayout(null);

        //upload image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons_Travels/forgotpassword.jpg"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(580,70,200,200);
        add(image);

        //Divide the Frame into 2 panel
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,500,280);
        add(p1);

        //text and textField
        //text(username)
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(40,20,100,25);
        lblusername.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lblusername);
        //textfield(username)
        tfusername=new JTextField();
        tfusername.setBounds(220,20,150,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        //Button(search)->to search as username
        search=new JButton("Search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setBounds(380,20,100,25);
        search.addActionListener(this);
        p1.add(search);

        //text(name)
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(40,60,100,25);
        lblname.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lblname);
        //textfield(name)
        tfname=new JTextField();
        tfname.setBounds(220,60,150,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        //text(Security Question)
        JLabel lblquestion=new JLabel("Security Question");
        lblquestion.setBounds(40,100,150,25);
        lblquestion.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lblquestion);
        //textfield(security Question)
        tfquestion=new JTextField();
        tfquestion.setBounds(220,100,150,25);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);

        //text(Security Answer)
        JLabel lblanswer=new JLabel("Security Answer");
        lblanswer.setBounds(40,140,150,25);
        lblanswer.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lblanswer);
        //textfield(Security Answer)
        tfanswer=new JTextField();
        tfanswer.setBounds(220,140,150,25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);

        //Button(retrieve)->to password retive
        retrieve=new JButton("Retrieve");
        retrieve.setBackground(Color.GRAY);
        retrieve.setForeground(Color.WHITE);
        retrieve.setBounds(380,140,100,25);
        retrieve.addActionListener(this);
        p1.add(retrieve);

        //password
        //text(password)
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(40,180,150,25);
        lblpassword.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lblpassword);
        //textfield(password)
        tfpassword=new JTextField();
        tfpassword.setBounds(220,180,150,25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);

        //Button(back)
        back=new JButton("Back");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.setBounds(150,230,100,25);
        back.addActionListener(this);
        p1.add(back);



        setVisible(true);
    }
    //perform action of button
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==search){
            try {
                String query="select * from account where username='"+tfusername.getText()+"'";
                Conn c=new Conn();

                ResultSet rs=c.s.executeQuery(query);
                //make a loop for getting result
                while (rs.next()){
                    tfname.setText(rs.getString("name"));
                    tfquestion.setText(rs.getString("security"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource()==retrieve) {
            try {
                String query="select * from account where answer='"+tfanswer.getText()+"' AND username='"+tfusername.getText()+"'";
                Conn c=new Conn();

                ResultSet rs=c.s.executeQuery(query);
                //make a loop for getting result
                while (rs.next()) {
                    tfpassword.setText(rs.getString("password"));
                }
            } catch (Exception e) {
                e.printStackTrace();

            }
            
        }else {
            setVisible(false);
            new Login_Travel();
        }

    }

    public static void main(String[] args) {
        new ForgetPassword();
    }
}
