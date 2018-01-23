import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;

class GridComponent extends JComponent {
    boolean isYellowTurn = false; //initalizes players turns for coloring purposes
    boolean isGameOver= false; // is true when a player wins
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
                else if(!test.isColorDecided()) { // sets color for a circle which has just been filled AND determines if game is won
                    g2.setColor(Color.YELLOW);
                    test.ColorDecided(); //finalizes color for a circle
                    // default color is yellow
                    if (!isYellowTurn) {
                        g2.setColor(Color.RED);
                        test.setRed(); // changes to color to red on red player turn
                    }
                    isGameOver(test);
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

    public void isGameOver(Circle test)  {
        int i = test.getRow();
        int j = test.getColumn();

        //checks vertical win condition
        if(i <= ROWS - 4) {
            for (int k = i+1; k < i+4; k++) {
                if(circles[k][j].isYellow() != test.isYellow()) {
                    break;
                }
                if (k == i+3) isGameOver = true;
            }
        }

        // horizontal win condition
        int streak = 0; 
        for (int k = 0; k < COLUMNS-1; k++) {
            if (circles[i][k].isFilled() && circles[i][k+1].isFilled() && circles[i][k].isYellow() == circles[i][k+1].isYellow()) {
                streak++;
            } else streak = 0;
            if (streak == 3) isGameOver = true;
        }

        // diagonal (going in upward righward direction) win condition
        ArrayList<Circle> diagonalUpRight = new ArrayList<>(); 
        diagonalUpRight.add(circles[i][j]);
        int dRow = i-1;
        int dColumn = j+1;
        // adds everything above the new circle
        while (dRow >= 0 && dColumn <= 6) {
            diagonalUpRight.add(circles[dRow][dColumn]);
            dRow--;
            dColumn++;
        }
        // adds everything below the new circle
        dRow = i+1;
        dColumn = j-1;
        while (dRow <= 5 && dColumn >= 0) {
            diagonalUpRight.add(0, circles[dRow][dColumn]);
            dRow++;
            dColumn--;
        }
        if (diagonalUpRight.size() >= 4) {
            streak = 0; // same streak variable used in horizontal win condition
            for (int k = 0; k < diagonalUpRight.size()-1; k++) {
                Circle current = diagonalUpRight.get(k);
                Circle next = diagonalUpRight.get(k+1);
                if(current.isFilled() && next.isFilled() && current.isYellow() == next.isYellow()) {
                    streak++;
                } else streak = 0;
                if (streak == 3) isGameOver = true;
            }
        }

        // diagonal upward leftware direction win condition
        ArrayList<Circle> diagonalUpLeft = new ArrayList<>(); 
        diagonalUpLeft.add(circles[i][j]);
        int dlRow = i-1;
        int dlColumn = j-1;
        // adds everything above the new circle
        while (dlRow >= 0 && dlColumn >= 0) {
            diagonalUpLeft.add(circles[dlRow][dlColumn]);
            dlRow--;
            dlColumn--;
        }
        // adds everything below the new circle
        dlRow = i+1;
        dlColumn = j+1;
        while (dlRow <= 5 && dlColumn <= 6) {
            diagonalUpLeft.add(0, circles[dlRow][dlColumn]);
            dlRow++;
            dlColumn++;
        }
        if (diagonalUpLeft.size() >= 4) {
            streak = 0; // same streak variable used in horizontal win condition
            for (int k = 0; k < diagonalUpLeft.size()-1; k++) {
                Circle current = diagonalUpLeft.get(k);
                Circle next = diagonalUpLeft.get(k+1);
                if(current.isFilled() && next.isFilled() && current.isYellow() == next.isYellow()) {
                    streak++;
                } else streak = 0;
                if (streak == 3) isGameOver = true;
            }
        }
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

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
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

public class ConnectFour {
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
                if (!C4.isGameOver) {
                    boolean newOneAdded = false; // equals true if new circle is colored 
                    int x = event.getX()/(2*C4.DIAMETER); //to find column 

                    if (x < C4.BOX_WIDTH/100) {
                        //colors lowest empty circle 
                        for (int i = C4.ROWS - 1; i >= 0; i--) {// starts at bottom of array, moves up
                            if(!C4.getCircles(i,x).isFilled()) {
                                C4.getCircles(i,x).setFilled();
                                newOneAdded = true;
                                break;
                            }
                        }
                    }

                    // only redraws if a new circle is colored (avoids double turn)
                    if (newOneAdded) {
                        C4.repaint(); //calls paint Component (draws next frame)
                    }
                }
            }
        }
        MouseClickListener listener = new MouseClickListener();
        C4.addMouseListener(listener);

        frame.add(C4);
        frame.setVisible(true);
    }
}