import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.*;
class GridComponent extends JComponent {
    boolean isYellowTurn = false; //initalizes players turns for coloring purposes

    //dimensions for box
    final int ROWS = 6;
    final int COLUMNS = 7;
    final int DIAMETER = 50;
    final int BOX_WIDTH = 2*DIAMETER * COLUMNS;
    final int BOX_HEIGHT =  2*DIAMETER * ROWS;

    //set up array of circle to keep track of status (filled or not filled/ color/ etc.)
    public Circle[][] circles = new Circle[ROWS][COLUMNS];
    public void createCircles() {
        for (int k = 0; k < ROWS; k++) {
            for (int l = 0; l < COLUMNS; l++) {
                circles[k][l] = new Circle(k,l);
            }
        }
    }

    // returns a specific circle (given a row and column) (Used in paint component)
    public  Circle getCircles(int r, int c) {
        return circles[r][c];
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        //draws and fills box
        Rectangle box = new Rectangle(0,0,BOX_WIDTH,BOX_HEIGHT);
        g2.setColor(Color.BLUE);
        g2.fill(box);
        g2.draw(box);

        //draws and fills circles
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                Circle test = circles[i][j];
                if (!test.isFilled()) {// for empty circles
                    g2.setColor(Color.WHITE);   
                }
                else if(!test.isColorDecided()) { // when user click on circle
                    g2.setColor(Color.YELLOW);
                    test.ColorDecided(); //finalizes color for a circle
                    // default color is yellow
                    if (!isYellowTurn) {
                        g2.setColor(Color.RED);
                        test.setRed(); // changes to color to red on red player turn
                    }
                }
                else { // for already decided(finalized) circles
                    g2.setColor(Color.YELLOW); //default color is yellow
                    if(!test.isYellow()) {// for red circles
                        g2.setColor(Color.RED);
                    }
                }
                Ellipse2D.Double circle = new Ellipse2D.Double(2*j*DIAMETER + DIAMETER/2,2*i*DIAMETER + DIAMETER/2,DIAMETER,DIAMETER);
                g2.fill(circle);
                g2.draw(circle);
            }
        }

        isYellowTurn = !isYellowTurn; // switch player's turn (for coloring purpose)
    }
}

//Circle class keeps track of position, vacancy, and color of a specific circle
class Circle {
    private boolean filled = false; // true if circle is already colored yellow or red
    private boolean isColorDecided = false; //true if circle color had already decided in an earlier turn
    private boolean isYellow = true; //default color is yellow
    private int row; // row in the board
    private int column; // column in the board

    public Circle(int r, int c) {// constructs circles given position (used in createCircles())
        row = r;
        column = c;
    }

    public boolean isFilled() {
        return filled;   
    }

    public void setFilled() {
        filled = true;
    }
    // sets color to red (instead of the default yellow)
    public void setRed() {
        isYellow = false;
    }

    public boolean isYellow() {
        return isYellow;
    }

    public boolean isColorDecided() {
        return isColorDecided;
    }

    // prevents color from changing
    public void ColorDecided() {
        isColorDecided = true;
    }
}

public class ConnectFourSaver {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(750,650);
        frame.setTitle("Connect Four");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridComponent C4 = new GridComponent(); //initalizes the board
        C4.createCircles(); // creates circle classes 

        class MouseClickListener implements MouseListener {
            public void mousePressed(MouseEvent event){}

            public void mouseExited(MouseEvent event){}

            public void mouseEntered(MouseEvent event){}

            public void mouseReleased(MouseEvent event){}

            public void mouseClicked(MouseEvent event) {
                int x = event.getX()/100; //to find column 
                
                //colors lowest empty circle 
                for (int i = C4.ROWS - 1; i >= 0; i--) {// starts at bottom of array, moves up
                    if(!C4.getCircles(i,x).isFilled()) {
                        C4.getCircles(i,x).setFilled();
                        break;
                    }
                }
                
                C4.repaint(); //calls paint Component (draws next frame)
            }
        }
        MouseClickListener listener = new MouseClickListener();
        C4.addMouseListener(listener);

        frame.add(C4);
        frame.setVisible(true);
    }
}