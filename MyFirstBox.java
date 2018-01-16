import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;

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
        Graphics2D g2 = (Graphics2D) g;
        Rectangle box = new Rectangle(50,50,50,150);
        g2.setColor(Color.ORANGE);
        g2.draw(box);
        g2.setColor(Color.RED);
        g2.fill(box);
        g2.drawString("My first rectangle", 50,20); 
        Ellipse2D.Double circle = new Ellipse2D.Double(250,250,50,150);
        g2.draw(circle);
    }
}

public class MyFirstBox {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setTitle("Smiley");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RectangleComponent myBox = new RectangleComponent();
        frame.add(myBox);
        frame.setVisible(true);
        //CircleComponent myCircle = new CircleComponent();
        //frame.add(myCircle);
        //frame.setVisible(true);
    }
}