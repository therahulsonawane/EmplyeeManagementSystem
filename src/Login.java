
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    JTextField tfusername, tfpassword;

    Login() {

        getContentPane().setBackground(Color.white);
        setLayout(null);
        //adding label for username
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 30);
        add(lblusername);

        //adding text field for username
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 200, 30);
        add(tfusername);

        //adding label for password
        JLabel lblpassword = new JLabel("Username");
        lblpassword.setBounds(40, 70, 100, 30);
        add(lblpassword);

        //adding text field for password
        tfpassword = new JTextField();
        tfpassword.setBounds(150, 70, 200, 30);
        add(tfpassword);

        //adding button to the Login Form
        JButton clickhere = new JButton("LOGIN");
        clickhere.setBounds(150, 140, 200, 30);
        clickhere.setBackground(Color.black);
        clickhere.setForeground(Color.white);
        clickhere.addActionListener(this);
        add(clickhere);

        //addding image to login page
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        image.setBounds(350, 0, 200, 200);

        setSize(600, 250);
        setLocation(450, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            conn c = new conn();
            String query = "select * from login where username = '" + username + "' and password = '" + password + "'";

            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                setVisible(false);
                new home();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }

}
