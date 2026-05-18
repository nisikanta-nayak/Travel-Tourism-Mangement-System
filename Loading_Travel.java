package travel.management.systrm;

import javax.swing.*;
import java.awt.*;

public class Loading_Travel extends JFrame implements Runnable{
    //Globally Declare
    Thread t;
    JProgressBar bar;
    String username;
    Loading_Travel(String username){
        this.username=username;
        //object of thread class
        t=new Thread(this);

        //setFrame size and location
        setBounds(500,200,650,400);
        //set frame color
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //Add Heading during loading
        JLabel text=new JLabel("Travel and Tourism Application");
        text.setBounds(50,20,600,40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Railway",Font.BOLD,35));
        add(text);

        //Add ProgressBar
        bar=new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);

        //text(Please Loading)
        JLabel loading=new JLabel("loading,please wait...");
        loading.setBounds(230,130,200,40);
        loading.setForeground(Color.RED);
        loading.setFont(new Font("Railway",Font.BOLD,16));
        add(loading);

        //text(username)
        JLabel lblusername=new JLabel("Welcome" + username);
        lblusername.setBounds(20,300,400,40);
        lblusername.setFont(new Font("Railway",Font.BOLD,16));
        lblusername.setForeground(Color.RED);
        add(lblusername);

        //calling thread class
        t.start();
        setVisible(true);
    }

    @Override
    public void run() {
        try {
           //make a loop for progressBar
            for (int i=1;i<=101;i++){
                int max=bar.getMaximum();//maximum value
                int value=bar.getValue();

                if(value<max){
                    bar.setValue(bar.getValue()+1);
                }else{
                    setVisible(false);
                    new Dashboard_Travel(username);
                }
                Thread.sleep(20);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Loading_Travel(" ");

    }
}
