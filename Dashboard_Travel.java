package travel.management.systrm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard_Travel extends JFrame implements ActionListener {
     String username;
     //Add buttons
    JButton addPersonalDetails,viewPersonalDetails,updatePersonalDetails,deletePersonalDetails,checkpackages,bookpackage,viewpackage,viewhotels,bookhotels,viewBookedHotels,destinations,payments,calculators,notepad,about;
    Dashboard_Travel(String username){
        this.username=username;
         //Create Frame using setBound
        //setBounds(0,0,1600,1000);
        //if you don't know screen size so
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        //make 1st panel(top)
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1600,65);
        add(p1);

        //upload logoImage in p1 panel
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons_Travels/dashboard.png"));
        Image i2=i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel icon=new JLabel(i3);
        icon.setBounds(5,0,70,70);
        p1.add(icon);

        //text in p1 panel
        JLabel heading=new JLabel("Dashboard");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(heading);

        //make 2nd panel(p2)->which on left side screen
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,900);
        add(p2);

        //Buttons
        //ADD PERSONAL DETAILS
        addPersonalDetails=new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0,0,300,50);
        addPersonalDetails.setBackground(new Color(0,0,102));
        addPersonalDetails.setForeground(Color.WHITE);
        addPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        //set margin of button
        addPersonalDetails.setMargin(new Insets(0,0,0,60));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);

        //UPDATE PERSONAL DETAILS
        updatePersonalDetails=new JButton("Update Personal Details ");
        updatePersonalDetails.setBounds(0,50,300,50);
        updatePersonalDetails.setBackground(new Color(0,0,102));
        updatePersonalDetails.setForeground(Color.WHITE);
        updatePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        //set margin of button
        updatePersonalDetails.setMargin(new Insets(0,0,0,30));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);

        //VIEW PERSONAL DETAILS
        viewPersonalDetails=new JButton("View Details ");
        viewPersonalDetails.setBounds(0,100,300,50);
        viewPersonalDetails.setBackground(new Color(0,0,102));
        viewPersonalDetails.setForeground(Color.WHITE);
        viewPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        //set margin of button
        viewPersonalDetails.setMargin(new Insets(0,0,0,130));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);

        //DELETE PERSONAL DETAILS
        deletePersonalDetails=new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0,150,300,50);
        deletePersonalDetails.setBackground(new Color(0,0,102));
        deletePersonalDetails.setForeground(Color.WHITE);
        deletePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        //set margin of button
        deletePersonalDetails.setMargin(new Insets(0,0,0,40));
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails);

        //Check Packages DETAILS
        checkpackages=new JButton("Check Package");
        checkpackages.setBounds(0,200,300,50);
        checkpackages.setBackground(new Color(0,0,102));
        checkpackages.setForeground(Color.WHITE);
        checkpackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        //set margin of button
        checkpackages.setMargin(new Insets(0,0,0,110));
        checkpackages.addActionListener(this);
        p2.add(checkpackages);

        //Book Packages DETAILS
        bookpackage=new JButton("Book Package");
        bookpackage.setBounds(0,250,300,50);
        bookpackage.setBackground(new Color(0,0,102));
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setFont(new Font("Tahoma",Font.PLAIN,20));
        //set margin of button
        bookpackage.setMargin(new Insets(0,0,0,120));
        bookpackage.addActionListener(this);
        p2.add(bookpackage);

        //view Packages DETAILS
        viewpackage=new JButton("View Package");
        viewpackage.setBounds(0,300,300,50);
        viewpackage.setBackground(new Color(0,0,102));
        viewpackage.setForeground(Color.WHITE);
        viewpackage.setFont(new Font("Tahoma",Font.PLAIN,20));
        //set margin of button
        viewpackage.setMargin(new Insets(0,0,0,120));
        viewpackage.addActionListener(this);
        p2.add(viewpackage);

        //View Hotels DETAILS
        viewhotels=new JButton("View Hotels");
        viewhotels.setBounds(0,350,350,50);
        viewhotels.setBackground(new Color(0,0,102));
        viewhotels.setForeground(Color.WHITE);
        viewhotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        //set margin of button
        viewhotels.setMargin(new Insets(0,0,0,180));
        viewhotels.addActionListener(this);
        p2.add(viewhotels);

        //Book Hotels DETAILS
        bookhotels=new JButton("Book Hotels");
        bookhotels.setBounds(0,400,350,50);
        bookhotels.setBackground(new Color(0,0,102));
        bookhotels.setForeground(Color.WHITE);
        bookhotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        //set margin of button
        bookhotels.setMargin(new Insets(0,0,0,180));
        bookhotels.addActionListener(this);
        p2.add(bookhotels);

        //Book Hotels DETAILS
        viewBookedHotels=new JButton("View Book Hotels");
        viewBookedHotels.setBounds(0,450,350,50);
        viewBookedHotels.setBackground(new Color(0,0,102));
        viewBookedHotels.setForeground(Color.WHITE);
        viewBookedHotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        //set margin of button
        viewBookedHotels.setMargin(new Insets(0,0,0,130));
        viewBookedHotels.addActionListener(this);
        p2.add(viewBookedHotels);

        //Destinations
        destinations=new JButton("Destinations");
        destinations.setBounds(0,500,350,50);
        destinations.setBackground(new Color(0,0,102));
        destinations.setForeground(Color.WHITE);
        destinations.setFont(new Font("Tahoma",Font.PLAIN,20));
        //set margin of button
        destinations.setMargin(new Insets(0,0,0,170));
        destinations.addActionListener(this);
        p2.add(destinations);

        //Payments
        payments=new JButton("Payments");
        payments.setBounds(0,550,350,50);
        payments.setBackground(new Color(0,0,102));
        payments.setForeground(Color.WHITE);
        payments.setFont(new Font("Tahoma",Font.PLAIN,20));
        //set margin of button
        payments.setMargin(new Insets(0,0,0,190));
        payments.addActionListener(this);
        p2.add(payments);

        //Calculator
        calculators=new JButton("Calculators");
        calculators.setBounds(0,600,350,50);
        calculators.setBackground(new Color(0,0,102));
        calculators.setForeground(Color.WHITE);
        calculators.setFont(new Font("Tahoma",Font.PLAIN,20));
        //set margin of button
        calculators.setMargin(new Insets(0,0,0,170));
        calculators.addActionListener(this);
        p2.add(calculators);

        //Notepad
        notepad=new JButton("Notepad");
        notepad.setBounds(0,650,350,50);
        notepad.setBackground(new Color(0,0,102));
        notepad.setForeground(Color.WHITE);
        notepad.setFont(new Font("Tahoma",Font.PLAIN,20));
        //set margin of button
        notepad.setMargin(new Insets(0,0,0,190));
        notepad.addActionListener(this);
        p2.add(notepad);

        //About
        about=new JButton("About");
        about.setBounds(0,700,350,50);
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Tahoma",Font.PLAIN,20));
        //set margin of button
        about.setMargin(new Insets(0,0,0,200));
        about.addActionListener(this);
        p2.add(about);

         //Frame work
        //Upload image in frame
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("Icons_Travels/home.jpg"));
        Image i5=i4.getImage().getScaledInstance(1650,1000,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image=new JLabel(i6);
        image.setBounds(0,0,1650,1000);
        add(image);

        //Text(Heading)
        JLabel text=new JLabel("Travel and Toursim Mangement system");
        text.setBounds(400,70,1200,70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Railway",Font.PLAIN,55));
        image.add(text);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==addPersonalDetails){
            new AddCustomer_Travel(username);
        } else if (ae.getSource()==viewPersonalDetails) {
            new ViewCustomer_Travel(username);
        } else if (ae.getSource()==updatePersonalDetails) {
            new UpdateCustomer_Travel(username);
        } else if (ae.getSource()==checkpackages) {
            new CheckPackage_Travel();
        } else if (ae.getSource()==bookpackage) {
            new BookPackage_Travel(username);
        } else if (ae.getSource()==viewpackage) {
            new ViewPackage_Travel(username);
        } else if (ae.getSource()==viewhotels) {
            new CheckHotels_Travel();
        } else if (ae.getSource()==destinations) {
            new Destinations();
        } else if (ae.getSource()==bookhotels) {
            new BookHotel_Travel(username);
        } else if (ae.getSource()==viewBookedHotels) {
            new ViewBookedHotel_Travel(username);
        } else if (ae.getSource()==payments) {
            new Payment();
        } else if (ae.getSource()==calculators) {
            //for opening calculator from system
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource()==notepad) {
            //for opening notepad from system
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource()==about) {
              new About_Travel();
        } else if (ae.getSource()==deletePersonalDetails) {
            new DeleteCustomer_Travel(username);
        }

    }

    public static void main(String[] args) {

        new Dashboard_Travel("");
    }
}
