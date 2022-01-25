import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
public class GUI extends JFrame
{
    private static final int FRAME_WIDTH = 250;
    private static final int FRAME_HEIGHT = 200;
    private File userData;
    static int ownerField;
    static int platformField;
    static JTextField userNameField;
    static JPasswordField passwordField;
    String[] options = new String[] {"Exit","PlayStation", "Xbox", "Nintendo Switch"};
    public GUI() throws FileNotFoundException
    {
        createComponents();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    private void createComponents() throws FileNotFoundException
    {
        ownerField = JOptionPane.showConfirmDialog(null,"Are you owner?\n " +
                "Click yes to log in","Check Owner", JOptionPane.YES_NO_OPTION);
        userNameField = new JTextField(10);
        passwordField = new JPasswordField(10);
        JLabel ownerLabel = new JLabel("Owner");
        JLabel userNameLabel = new JLabel("User Name");
        JLabel passwordLabel = new JLabel("Password");
        JButton loginButton = new JButton("Login");
        JButton exitButton = new JButton("Exit");
        JPanel panel = new JPanel();

        if (ownerField == JOptionPane.NO_OPTION) {
            platformField = JOptionPane.showOptionDialog(null,"Choose platform","Welcome to our store",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            if (platformField == JOptionPane.YES_NO_CANCEL_OPTION){
                Runnable r = new Runnable() {

                    public void run() {
                        new PS_Interface().createUI();

                    }
                };

                EventQueue.invokeLater(r);
            } else if (platformField == JOptionPane.CANCEL_OPTION){
                Runnable r = new Runnable() {

                    public void run() {
                        new Xbox_Interface().createUI();
                    }
                };

                EventQueue.invokeLater(r);
            } else if (platformField == JOptionPane.QUESTION_MESSAGE){
                Runnable r = new Runnable() {

                    public void run() {
                        new Nintendo_Interface().createUI();
                    }
                };

                EventQueue.invokeLater(r);
            }
        } else {
        panel.add(userNameField);
        panel.add(userNameLabel);
        panel.add(passwordField);
        panel.add(passwordLabel);
        panel.add(loginButton);
        panel.add(exitButton);
        add(panel);
        ActionListener exitListener = new ClickListener1();
        ActionListener loginListener = new ClickListener2();
        exitButton.addActionListener(exitListener);
        loginButton.addActionListener(loginListener);}
    }
    public static class ClickListener1 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            System.exit(0);
        }
    }
    public static class ClickListener2 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            int count = 0;
            File f = new File("admin.csv");
            String userNameInput = userNameField.getText();
            String passwordInput = passwordField.getText();
            try {
                BufferedReader br = new BufferedReader(new FileReader("admin.csv"));
                String line = "";
                String username = null;
                String passwd = null;
                while ((line = br.readLine()) != null)
                {
                    String[] record = line.split(",");    // use comma as separator
                    username = record[0];
                    passwd = record[1];
                    if (userNameInput.equals(username) && passwordInput.equals(passwd))
                    {
                        count += 1;
                    }

                }
                if (count > 0)
                {
                    JOptionPane.showMessageDialog(null,
                            "Login Successful", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,
                            "Invalid Username / Password Combo", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null,
                        "User Database Not Found", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}