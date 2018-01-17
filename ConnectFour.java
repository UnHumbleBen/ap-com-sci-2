import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;

class GridComponent extends JComponent {
    public void paintComponent(Graphics g) {
        final int ROWS = 6;
        final int COLUMNS = 7;
        final int DIAMETER = 50;
        final int BOX_WIDTH = 2*DIAMETER * COLUMNS;
        final int BOX_HEIGHT =  2*DIAMETER * ROWS;
        
        Graphics2D g2 = (Graphics2D) g;
        Rectangle box = new Rectangle(0,0,BOX_WIDTH,BOX_HEIGHT);
        g2.setColor(Color.BLUE);
        g2.fill(box);
        g2.draw(box);
        
        Ellipse2D.Double[][] circles = new Ellipse2D.Double[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                g2.setColor(Color.WHITE);
                Ellipse2D.Double circle = new Ellipse2D.Double(2* j*DIAMETER + DIAMETER/2,2* i*DIAMETER + DIAMETER/2,DIAMETER,DIAMETER);
                circles[i][j] = circle;
                g2.fill(circle);
                g2.draw(circle);
            }
        }
        
    }
}

public class ConnectFour {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(750,650);
        frame.setTitle("Connect Four");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridComponent myBox = new GridComponent();
        frame.add(myBox);
        frame.setVisible(true);
    }
}