import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;

class Bubble extends JComponent{
    final private int startY = 100;
    private int x1 = 100;
    private int y1 = startY;
    private int x2 = 50;
    private int y2 = startY;
    private int x3 = 0;
    private int y3 = startY;
    private int armX = x2;
    private boolean right1 = true; //head
    private boolean right2 = true; //body
    private boolean right3 = true;  //legs
    final private int legWidth = 20;
    final private int armWidth = 10;
    final private int portalW = 15;
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        Rectangle back = new Rectangle(0,0,500,500);
        g2.fill(back);
        
        g2.setColor(Color.GREEN);
        Ellipse2D.Double portal1 = new Ellipse2D.Double(0,startY - 30 ,portalW,120);
        Ellipse2D.Double portal2 = new Ellipse2D.Double(500-portalW,startY - 30 ,portalW,120);
        Ellipse2D.Double portal3 = new Ellipse2D.Double(500-portalW,450 - startY - 30 ,portalW,120);
        Ellipse2D.Double portal4 = new Ellipse2D.Double(0,450 - startY - 30 ,portalW,120);
        g2.fill(portal1);
        g2.fill(portal2);
        g2.fill(portal3);
        g2.fill(portal4);
        
        g2.setColor(Color.WHITE);
        Ellipse2D.Double circle = new Ellipse2D.Double(x1,y1,50,50);
        g2.fill(circle);
        
        g2.setColor(Color.BLUE);
        Ellipse2D.Double eye1 = new Ellipse2D.Double(x1 + 20, y1 + 16, 10, 10);
        Ellipse2D.Double eye2 = new Ellipse2D.Double(x1 + 20,y1 + 33 , 10, 10);
        g2.fill(eye1);
        g2.fill(eye2);
        
        g2.setColor(Color.YELLOW);
        Rectangle body = new Rectangle(x2,y2,50,50);
        Rectangle leg1 = new Rectangle(x3,y3, 50, legWidth);
        Rectangle leg2 = new Rectangle(x3,y3 + 50 - legWidth, 50, legWidth);
        Rectangle arm1 = new Rectangle(armX,y2 - armWidth, 40, armWidth);
        Rectangle arm2 = new Rectangle(armX,y2 + 50, 40, armWidth);
        g2.fill(body);
        g2.fill(leg1);
        g2.fill(leg2);
        g2.fill(arm1);
        g2.fill(arm2);
        
        g2.setColor(Color.BLACK);
        if (right1) {
            x1 += 50;
            y1 = startY;

        }
        else {
            x1 -= 50;
            y1 = 450 - startY;
        }

        if (right2) {
            x2 += 50;
            y2 = startY;

            armX = x2 + 10;

        }
        else {
            x2 -= 50;
            y2 = 450 - startY;
            armX = x2;
        }

        if (right3) {
            x3 += 50;
            y3 = startY;

        }
        else {
            x3 -= 50;
            y3 = 450 - startY;
        }

        if (x1 > 450 || x1 < 0) {
            right1 = !right1;
        }
        if (x2 > 450 || x2 < 0) right2 = !right2;
        if (x3 > 450 || x3 < 0) right3 = !right3;

        g2.draw(back);
        g2.draw(portal1);
        g2.draw(portal2);
        g2.draw(portal3);
        g2.draw(portal4);
        g2.draw(body);
        g2.draw(arm1);
        g2.draw(arm2);
        g2.draw(leg1);
        g2.draw(leg2);
        g2.draw(circle);
        g2.draw(eye1);
        g2.draw(eye2);
    }
}
public class MovingVehicle
{
    public static void main(String[] args) throws InterruptedException{
        JFrame frame = new JFrame();
        frame.setSize(515,500);
        frame.setTitle("Portal man");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Bubble myBox = new Bubble();
        frame.add(myBox);
        while (true) {
            Thread.sleep(500);
            myBox.repaint();
            frame.setVisible(true);
        }

    }
}
