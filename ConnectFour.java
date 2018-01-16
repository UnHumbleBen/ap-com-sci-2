import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.*;
/*
class CircleComponent extends JComponent {
public void paintComponent(Graphics g) {
Graphics2D g2 = (Graphics2D) g;
Ellipse2D.Double circle = new Ellipse2D.Double(250,250,50,150);
g2.draw(circle);
}
}
 */

class RectangleComponent extends JComponent {
    public void paintComponent(Graphics g) {
        final int ROWS = 6;
        final int COLUMNS = 7;
        final int RADIUS = 50;
        final int BOX_WIDTH = 2*RADIUS * COLUMNS;
        final int BOX_HEIGHT = 2* RADIUS * ROWS;
        
        Graphics2D g2 = (Graphics2D) g;
        Rectangle box = new Rectangle(0,0,BOX_WIDTH,BOX_HEIGHT);
        g2.setColor(Color.BLUE);
        g2.fill(box);
        g2.draw(box);
        
        Ellipse2D.Double[][] circles = new Ellipse2D.Double[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                g2.setColor(Color.WHITE);
                Ellipse2D.Double circle = new Ellipse2D.Double(2*j*RADIUS + RADIUS/2,2*i*RADIUS + RADIUS/2,RADIUS,RADIUS);
                g2.fill(circle);
                g2.draw(circle);
            }
        }
    }
}

public class ConnectFour {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1000,1000);
        frame.setTitle("Connect Four");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RectangleComponent myBox = new RectangleComponent();
        frame.add(myBox);
        frame.setVisible(true);
    }
}