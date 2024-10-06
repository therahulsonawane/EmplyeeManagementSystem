
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Splash extends JFrame implements ActionListener {

    Splash() {

        //background color for the splash screen
        getContentPane().setBackground(Color.white);
        setLayout(null); //avoid using default layout

        //adding hte heding for the splash screen
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(180, 5, 1200, 80);
        heading.setFont(new Font("Arial", Font.PLAIN, 60));
        heading.setForeground(Color.red);
        add(heading);

        //adding the image for the splash screen
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        image.setBounds(60, 90, 1200, 750);

        //Adding button to the screen
        JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(500, 550, 200, 50);
        clickhere.setBackground(Color.green);
        clickhere.setForeground(Color.black);
        clickhere.addActionListener(this);
        image.add(clickhere);

        //size of the splash screen
        setSize(1336, 800);
        setVisible(true);
        setLocation(80, 10);

//infinite while loop for aading flicker animation to the heading
        while (true) {

            heading.setVisible(false);
            try {
                Thread.sleep(500); //to add delay the visibility of the hedianig
            } catch (Exception e) {
                // TODO: handle exception
            }

            heading.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new Splash();
    }
}
