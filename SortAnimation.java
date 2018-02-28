import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;

class Component extends JComponent {
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g; 
    }
}

public class SortAnimation {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1000,1000);
        frame.setTitle("Benjamin Lee");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Component mySort = new Component();
        frame.add(mySort);
        frame.setVisible(true);
    }
}
