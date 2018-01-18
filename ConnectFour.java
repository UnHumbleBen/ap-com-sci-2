import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.*;
public class ConnectFour extends JComponent {
    static Graphics g2;
    final static int ROWS = 6;
    final static int COLUMNS = 7;
    final int DIAMETER = 50;
    final int BOX_WIDTH = 2*DIAMETER * COLUMNS;
    final int BOX_HEIGHT =  2*DIAMETER * ROWS;
    public static Ellipse2D.Double[][] circles = new Ellipse2D.Double[ROWS][COLUMNS];
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle box = new Rectangle(0,0,BOX_WIDTH,BOX_HEIGHT);
        g2.setColor(Color.BLUE);
        g2.fill(box);
        g2.draw(box);

        //Ellipse2D.Double[][] circles = new Ellipse2D.Double[ROWS][COLUMNS]
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                g2.setColor(Color.WHITE);
                Ellipse2D.Double circle = new Ellipse2D.Double(2*j*DIAMETER + DIAMETER/2,2*i*DIAMETER + DIAMETER/2,DIAMETER,DIAMETER);
                circles[i][j] = circle;
                g2.fill(circle);
                g2.draw(circle);
            }
        }
    }

    public static void colorCircle(Graphics g, Ellipse2D.Double circle) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.YELLOW);
        g2.fill(circle);
        g2.draw(circle);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(750,650);
        frame.setTitle("Connect Four");
        ConnectFour myBox = new ConnectFour();
        class MouseClickListener implements MouseListener {
            public void mousePressed(MouseEvent event){}

            public void mouseExited(MouseEvent event){}

            public void mouseEntered(MouseEvent event){}

            public void mouseReleased(MouseEvent event){}

            public void mouseClicked(MouseEvent event) {
                int x = event.getX(); //returns x coordinate mouse clicked locaction
                int y = event.getY(); //returns y coordinate
                int row = y/100;
                int column = x/100;
                colorCircle(g2, circles[row][column]);
            }
        }
        MouseClickListener listener = new MouseClickListener();
        myBox.addMouseListener(listener);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(myBox);
        frame.setVisible(true);
    }
}