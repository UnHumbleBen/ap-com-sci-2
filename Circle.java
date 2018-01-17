import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;

public class Circle extends JComponent {
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(0,0,100,100);
        g2.draw(circle);
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800,1000);
        Circle myLittleCircle = new Circle();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(myLittleCircle);
        frame.setVisible(true);
    }
}
