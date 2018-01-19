import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;

public class Circle1 extends JComponent {
    private int xCoord = 0;
    private int yCoord = 0;

    public Circle1() {
        xCoord = 0;
        yCoord = 0;
    }
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(xCoord,yCoord,100,100);
        g2.draw(circle);
    }

    public void moveTo(int x, int y) {
        xCoord = x;
        yCoord = y;
        repaint(); //calls paint Component method again
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800,1000);
        Circle1 myLittleCircle = new Circle1();
        class MouseClickListener implements MouseListener {
            public void mousePressed(MouseEvent event){}
            public void mouseExited(MouseEvent event){}
            public void mouseEntered(MouseEvent event){}
            public void mouseReleased(MouseEvent event){}
            public void mouseClicked(MouseEvent event) {
                int x = event.getX(); //returns x coordinate mouse clicked locaction
                int y = event.getY(); //returns y coordinate
                myLittleCircle.moveTo(x,y);
            }
        }
        
        MouseClickListener listener = new MouseClickListener();
        myLittleCircle.addMouseListener(listener);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(myLittleCircle);
        frame.setVisible(true);
    }
}