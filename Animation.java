import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;


class Bubble extends JComponent{
    private int x = 0;
    private int y = 0;
    private boolean right = true;
    private boolean down = true;
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(x,y,50,50);
        Rectangle back = new Rectangle(0,0,500,500);
        if (right) {
            x += 50;
            //y += 50;
        }
        else {
            x -= 50;
            //y -= 50;
        }
        
        if (down) {
            y += 40;
        }
        else {
            y -= 40;
        }
        if (x >= 450 || x <= 0) right = !right;
        if (y >= 450 || y <= 0) down = !down;
        g2.draw(back);
        g2.draw(circle);
    }
}
public class Animation
{
    public static void main(String[] args) throws InterruptedException{
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setTitle("Smiley");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Bubble myBox = new Bubble();
        frame.add(myBox);
        while (true) {
            Thread.sleep(500);
            myBox.repaint();
            frame.setVisible(true);
        }
        
        //frame.setVisible(true);
    }
}
