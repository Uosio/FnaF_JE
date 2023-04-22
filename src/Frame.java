import java.awt.BorderLayout;

import javax.swing.*;

public class Frame extends JFrame{
    
    public static int width = 1024;
    public static int height = 720;

    
    Frame(){
        ImageIcon icon = new ImageIcon("res/images/logo.png");
        this.setIconImage(icon.getImage());

        this.setTitle("Five nights at Freddy Java Edition");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.setSize(width, height);
        
    }
}