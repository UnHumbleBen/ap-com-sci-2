import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JFrame;

class RectangleComponent extends JComponent {
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        Rectangle box = new Rectangle(35,40,50,150);
        g2.draw(box);
        
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
    }
}