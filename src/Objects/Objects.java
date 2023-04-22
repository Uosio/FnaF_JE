package Objects;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Objects{

    static public class Button extends JButton{
        public Button(String text, int size, ActionListener l){
            setText(text);
            setFocusable(false);
            setFont(new Font("FreeMono", Font.PLAIN, size));
            setForeground(Color.WHITE);
            setBackground(Color.DARK_GRAY);
            setBorder(BorderFactory.createEmptyBorder());
            addActionListener(l);
        }
    }

    static public class Text extends JLabel{
        public Text(String text, int size, Color color){
            setText(text);
            setForeground(color);
            setFont(new Font("FreeMono", Font.BOLD, size));
        }
    }

    static public class Panel extends JPanel{
        public Panel(LayoutManager layout, Color color){
            setBackground(Color.BLACK);
            setLayout(new FlowLayout());
        }
    }
}