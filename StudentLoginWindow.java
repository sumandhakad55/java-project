import java.awt.*;
import javax.swing.*;

public class StudentLoginWindow{
    public static void main(String[] args) {
     JFrame frame=new JFrame("Portal Aunthentication");
     frame.setSize(400,260);
     frame.setLayout(new BorderLayout(10,10));
     JLabel header=new JLabel("Student Information System",JLabel.CENTER);

     header.setFont(new Font("Arial",Font.BOLD,16));
     frame.add(header,BorderLayout.NORTH);

     JPanel center=new JPanel();
     center.setLayout(new GridLayout(3,2,8,8));
     center.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

     //Row 1
        center.add(new JLabel("Registration No:"));
        center.add(new JTextField("2026-MCA-"));

        // Row 2
        center.add(new JLabel("Security PIN:"));
        center.add(new JPasswordField());

        // Row 3
        center.add(new JLabel("Remember Device:"));
        center.add(new JCheckBox("Yes"));

        frame.add(center, BorderLayout.CENTER);

        // South Panel
        JPanel south = new JPanel();
        south.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton reset = new JButton("Reset");
        JButton login = new JButton("Login");

        reset.setEnabled(false);
        login.setEnabled(false);


        south.add(reset);
        south.add(login);

        frame.add(south, BorderLayout.SOUTH);

        // Center window on screen
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}



     

      
    