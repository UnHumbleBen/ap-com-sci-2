import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.*;
class GridComponent extends JComponent {
    boolean isYellow = true;
    
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
                Circle test = new Circle(i,j); // pretend this works
                if (!test.filled) {
                    g2.setColor(Color.WHITE);   
                }
                else if(isYellow) {
                    g2.setColor(Color.YELLOW); 
                    !isYellow;
                }
                else {
                    g2.setColor(Color.RED); 
                    !isYellow;
                }
                
                g2.setColor(Color.WHITE);
                Ellipse2D.Double circle = new Ellipse2D.Double(2*j*DIAMETER + DIAMETER/2,2*i*DIAMETER + DIAMETER/2,DIAMETER,DIAMETER);
                circles[i][j] = circle;
                g2.fill(circle);
                g2.draw(circle);
            }
        }
    }
}
class Circle {
    private boolean filled = false;
    private int row;
    private int column;
    
    public Circle(int r, int c) {
        row = r;
        column = c;
    }
    
    public boolean isFilled() {
        return filled;   
    }
    
    public 
}
public class ConnectFourLunch {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(750,650);
        frame.setTitle("Connect Four");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridComponent myBox = new GridComponent();
        class MouseClickListener implements MouseListener {
            public void mousePressed(MouseEvent event){}
            public void mouseExited(MouseEvent event){}
            public void mouseEntered(MouseEvent event){}
            public void mouseReleased(MouseEvent event){}
            public void mouseClicked(MouseEvent event) {
                int x = event.getX(); //returns x coordinate mouse clicked locaction
                int y = event.getY(); //returns y coordinate
                
            }
        }
        frame.add(myBox);
        frame.setVisible(true);
    }
}
