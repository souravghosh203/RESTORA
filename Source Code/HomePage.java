import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;


public class HomePage extends javax.swing.JFrame {

    
    public HomePage() {
        setTitle("Home Page");
         setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        setDateTime();
    }
    