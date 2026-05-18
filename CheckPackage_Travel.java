package travel.management.systrm;

import javax.swing.*;
import java.awt.*;

public class CheckPackage_Travel extends JFrame {
    CheckPackage_Travel(){
        //set size and location of frame
        setBounds(450,200,900,600);

       // getContentPane().setBackground(Color.GRAY);

        //make data dinamic
        //String name{values}
        String[] package1={"GOLD PACKAGE","6 Days and 7 Nights","Airport Assistance","Half Day City Tour","Daily Buffet","Soft and Hard Drinks Free","Full Day 3 Island Cruise","English Speaking Guide","BOOK PACKAGE","SUMMER/WINTER SPECIAL","Price-15000/-","package1.jpg"};
        String[] package2={"SILVER PACKAGE","5 Days 6 Nights","Toll Free","Entrance Free Tickets","Meet and Greet at Airport","Welcome Drinks on Arrivals","Night Safari","Cruise With Dinner","BOOK NOW","WINTER SPECIAL","Price-12000/-","package2.jpg"};
        String[] package3={"BRONZE PACKAGE","3 Dyas 4 Nights","Only Free Room Assistance","Free Gamming Zone Access","River Rafting","Free Soft Drinks","Daily Buffet","BBQ Dinner","BOOK NOW","SUMMER SPECIAL","Price-8500/-","package3.jpg"};


        //for making tab we use JTabbedPane
        JTabbedPane tab=new JTabbedPane();
        //add panel with tab
        //join pannel objective with createPackage
        JPanel p1=createPackage(package1);
        tab.addTab("Package 1",null,p1);

        JPanel p2=createPackage(package2);
        tab.addTab("Package 2",null,p2);

        JPanel p3=createPackage(package3);
        tab.addTab("Package 3",null,p3);

        add(tab);



        setVisible(true);
    }
    //For panel making
    public JPanel createPackage(String[] pack){

        //make panel p1(top)->showing package button\
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.yellow);

        //add text inside panel(Package name)
        JLabel l1=new JLabel(pack[0]);
        l1.setBounds(50,5,300,30);
        l1.setForeground(new Color(0,222,255));
        l1.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(l1);

        //add text inside panel(Package Features)
        //how many days
        JLabel l2=new JLabel(pack[1]);
        l2.setBounds(30,60,300,30);
        l2.setForeground(Color.red);
        l2.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l2);


        //add text inside panel(Package Features)
        //Airport Assistance
        JLabel l3=new JLabel(pack[2]);
        l3.setBounds(30,110,300,30);
        l3.setForeground(Color.BLUE);
        l3.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l3);

        //add text inside panel(Package Features)
        //Half Day City Tour
        JLabel l4=new JLabel(pack[3]);
        l4.setBounds(30,160,300,30);
        l4.setForeground(Color.RED);
        l4.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l4);

        //add text inside panel(Package Features)
        //Daily Buffet
        JLabel l5=new JLabel(pack[4]);
        l5.setBounds(30,210,300,30);
        l5.setForeground(Color.BLUE);
        l5.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l5);

        //add text inside panel(Package Features)
        //Welcomes Drinks on Arrivals
        JLabel l6=new JLabel(pack[5]);
        l6.setBounds(30,260,300,30);
        l6.setForeground(Color.RED);
        l6.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l6);

        //add text inside panel(Package Features)
        //Airport Assistance
        JLabel l7=new JLabel(pack[6]);
        l7.setBounds(30,310,300,30);
        l7.setForeground(Color.BLUE);
        l7.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l7);

        //add text inside panel(Package Features)
        //English Speaking Guide
        JLabel l8=new JLabel(pack[7]);
        l8.setBounds(30,360,300,30);
        l8.setForeground(Color.RED);
        l8.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l8);

        //add text inside panel(Package Features)
        //Book Now
        JLabel l9=new JLabel(pack[8]);
        l9.setBounds(60,430,300,30);
        l9.setForeground(Color.BLACK);
        l9.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l9);

        //add text inside panel(Package Features)
        //Summwer/Winter Special
        JLabel l10=new JLabel(pack[9]);
        l10.setBounds(80,480,300,30);
        l10.setForeground(Color.MAGENTA);
        l10.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l10);

        //add text inside panel(Package Features)
        //English Speaking Guide
        JLabel l11=new JLabel(pack[10]);
        l11.setBounds(500,480,300,30);
        l11.setForeground(Color.CYAN);
        l11.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l11);

        //add Image in Package
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons_Travels/"+pack[11]));
        Image i2= i1.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l12=new JLabel(i3);
        l12.setBounds(350,20,500,400);
        p1.add(l12);

        return p1;

    }
    public static void main(String[] args) {
        new CheckPackage_Travel();
    }
}
