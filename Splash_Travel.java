package travel.management.systrm;

import javax.swing.*;
import java.awt.*;

public class Splash_Travel extends JFrame implements Runnable {
    //Declaring Thr ead
    Thread thread;
    //Constructor->code written in constructor
    Splash_Travel(){
        //image uploard
        //classLoader.getSystemResours-Libreary
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons_Travels/FrontPage.png"));
        Image i2=i1.getImage().getScaledInstance(1100,500,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);


        //setSize(1200,600);
        //setLocation(200,100);
        setVisible(true);
        //using of thread concept
        //object creation of thread
        thread=new Thread(this);
        //calling of start
        thread.start();
    }

    public static void main(String[] args) {
        //object of a class
        Splash_Travel frame=new Splash_Travel();
        //Dinamically setting frmae
        //for automatically changing size and location of frame->use for loop
        //for handing movement of frame we use
        int x=1;
        for (int i=1;i<=500;i+=6,x+=7){
            frame.setSize(i+x,i);
            frame.setLocation(750-(x+i)/2,400-(i/2));
            try {
              Thread.sleep(2);
            } catch (Exception e) {}

        }

    }
    //Inherting the Runnable class
    @Override
    public void run() {
        try {
            Thread.sleep(7000);
            new Login_Travel();
            setVisible(false);
        } catch (Exception e) {}
        }
    }

