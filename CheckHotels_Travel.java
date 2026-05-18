package travel.management.systrm;

import javax.swing.*;
import java.awt.*;

public class CheckHotels_Travel extends JFrame implements Runnable{
    //object of thread class
    Thread t1;
    //making array for Jlabel
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    //make objective of Jlabel Array
    JLabel[] label=new JLabel[]{l1,l2,l3,l4,l5,l6,l7,l8,l9,l10};
    JLabel caption,caption1;

    @Override
    public void run() {
        //for giving name to my hotels I have use string
        String[] text=new String[]{"JW Marriott Hotel","Madarin Oriental Hotel","Four Seasion Hotel","Raddison Blue Hotel","Classio Hotel","The Bay Club Hotel","Hotel Toshli","The Taj Hotel","Happy Morning Motel","River View Hotel"};
        String[] text1=new String[]{"CostPerPerson-1500,FoodIncluded-2000,AcRoom-1000","CostPerPerson-2500,FoodIncluded-1900,AcRoom-1200","CostPerPerson-2000,FoodIncluded-1700,AcRoom-1300","CostPerPerson-3400,FoodIncluded-1700,AcRoom-1000","CostPerPerson-4500,FoodIncluded-2000,AcRoom-1500","CostPerPerson-2600,FoodIncluded-1700,AcRoom-1500","CostPerPerson-6500,FoodIncluded-3000,AcRoom-1600","CostPerPerson-4800,FoodIncluded-2900,AcRoom-1290","CostPerPerson-1500,FoodIncluded-1000,AcRoom-800","CostPerPerson-2400,FoodIncluded-1000,AcRoom-1600"};

        try {
            //for lebaling 10 labels we have make a loop for slide show
            for (int i=0;i<=9;i++){
                label[i].setVisible(true);
                caption1.setText(text1[i]);
                caption.setText(text[i]);
                Thread.sleep(2500);
                label[i].setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    CheckHotels_Travel(){
        //make a frame
        setBounds(500,200,800,600);

        //declaring caption
        //inserting caption for Inserting heading to hotels
        caption=new JLabel();
        caption.setBounds(20,500,1000,70);
        caption.setFont(new Font("Tahoma", Font.BOLD,40));
        caption.setForeground(Color.WHITE);
        add(caption);

        //inserting caption for Inserting heading to hotels
        caption1=new JLabel();
        caption1.setBounds(20,460,800,70);
        caption1.setFont(new Font("Tahoma", Font.BOLD,20));
        caption1.setForeground(Color.WHITE);
        add(caption1);


        //By This my all hotel image will come to the screen
        //making object for ImageIcon class
        ImageIcon i1=null,i2=null,i3=null,i4=null,i5=null,i6=null,i7=null,i8=null,i9=null,i10=null;
        //making array to store value of image
        ImageIcon[] image=new ImageIcon[] {i1,i2,i3,i4,i5,i6,i7,i8,i9,i10};

        //making object for ImageIcon class
        Image j1=null,j2=null,j3=null,j4=null,j5=null,j6=null,j7=null,j8=null,j9=null,j10=null;
        //making array to store value of image
        Image[] jimage=new Image[] {j1,j2,j3,j4,j5,j6,j7,j8,j9,j10};


        //making object for ImageIcon class
        ImageIcon k1=null,k2=null,k3=null,k4=null,k5=null,k6=null,k7=null,k8=null,k9=null,k10=null;
        //making array to store value of image
        ImageIcon[] kimage=new ImageIcon[] {k1,k2,k3,k4,k5,k6,k7,k8,k9,k10};


        //Dinamically setting Image using loop
        for (int i=0;i<=9;i++) {
            image[i] = new ImageIcon(ClassLoader.getSystemResource("Icons_Travels/hotel"+(i+1)+".jpg"));
            jimage[i] = image[i].getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
            kimage[i] = new ImageIcon(jimage[i]);
            label[i] = new JLabel(kimage[i]);
            label[i].setBounds(0, 0, 800, 600);
            add(label[i]);
        }

        //object of thread class
        t1=new Thread(this);
        t1.start();

        setVisible(true);

    }


    public static void main(String[] args) {
        new CheckHotels_Travel();
    }
}
