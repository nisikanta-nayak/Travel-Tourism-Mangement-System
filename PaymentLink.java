package travel.management.systrm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentLink extends JFrame implements ActionListener {

    PaymentLink(){
        //set frame
        setBounds(500,200,800,600);

        JEditorPane pane=new JEditorPane();
        pane.setEditable(false);
       //for setting url of paytm
        try{
           pane.setPage("http://paytm.com/rent-payment");
        } catch (Exception e) {
           pane.setContentType("text/html");
           pane.setText("<html>Could not load,Error 404</html>");
        }
        //For adding Sceoll bar
        JScrollPane sp=new JScrollPane(pane);
        getContentPane().add(sp);

        //we have to make a button
        JButton back=new JButton("Back");
        back.setBounds(610,20,80,40);
        back.addActionListener(this);
        pane.add(back);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
         setVisible(false);
         new Payment();
    }

    public static void main(String[] args) {
        new PaymentLink();
    }
}
