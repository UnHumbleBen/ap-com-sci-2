import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;

class Prey {
    Random random = new Random(); 
    private int xPos = random.nextInt(300);
    private int yPos = random.nextInt(300);
    protected int diameter;

    private int xVel = random.nextInt(9) + 1;
    private int yVel = random.nextInt(9) + 1;

    protected boolean isRight = true;
    protected boolean isDown = true;

    public Prey(int newDiameter) {
        diameter = newDiameter;
    }

    public boolean isRight() {
        return isRight;
    }

    public boolean isDown() {
        return isDown;
    }

    public int getX() {
        return xPos;
    }

    public void setX(int newX) {
        xPos = newX;
    }

    public void setY(int newY) {
        yPos = newY;
    }

    public int getXVel() {
        return xVel;
    }

    public int getYVel() {
        return yVel;
    }

    public void setXVel(int newXVel) {
        xVel = newXVel;
    }

    public void setYVel(int newYVel) {
        yVel = newYVel;
    }

    public int getY() {
        return yPos;
    }

    public int getDiameter() {
        return diameter;
    }

    public void xCollision() {
        isRight = !isRight;
        xVel = random.nextInt(9)+1;
        if (!isRight) {
            xVel = -1*xVel;
            xPos = 400-diameter;
        }
        else {
            xPos = 0;
        }
    }

    public void yCollision() {
        isDown = !isDown;
        yVel = random.nextInt(9)+1;
        if (!isDown) {
            yVel = -1*yVel;
            yPos = 400-diameter;
        }
        else {
            yPos = 0;
        }
    }

    public void move() {
        xPos += xVel;
        yPos += yVel;
    }

    public void setIsRight(boolean newIsRight) {
        isRight = newIsRight;
    }

    public void setIsDown(boolean newIsDown) {
        isDown = newIsDown;
    }
}

class Predator extends Prey{
    public Predator(int newDiameter) {
        super(newDiameter);
    }

    public void eats(Prey p) {
        if (diameter < 400) {
            //System.out.println("Eat");
            //System.out.println("Position before eating: (" + getX() + "," + getY() + ")");
            //System.out.println("Center Position before eating: (" + ((getX() + getDiameter()/2)) + "," + (getY() + getDiameter()/2) + ")");
            //int x1 = getX() + getDiameter()/2;
            //int y1 = getY() + getDiameter()/2;
            diameter += p.getDiameter();
            setX(getX() - p.getDiameter()/2);
            setY(getY() - p.getDiameter()/2);
            //int x2 = getX() + getDiameter()/2;
            //int y2 = getY() + getDiameter()/2;
            //System.out.println("Position after eating: (" + getX() + "," + getY() + ")");
            //System.out.println("Center Position after eating: (" + ((getX() + getDiameter()/2)) + "," + (getY() + getDiameter()/2) + ")");
            //System.out.println("Center differennce before and after: (" + (x2 - x1) + "," + (y2 - y1) + ")");  

            if (getX() <= 0) {
                setX(0);
                isRight = false;
                System.out.println("left wall");
            }
            if (getX() >= 400 - diameter) {
                setX(400 - diameter);
                isRight = true;
                System.out.println("right wall");
            }
            if (getY() <= 0) {
                setY(0);
                isDown = false;
                System.out.println("up wall");
            }
            if (getY() >= 400 - diameter) {
                setY(400 - diameter);
                isDown = true;
                System.out.println("down wall");
            } 

            if (diameter > 400) diameter = 400;
        }
    }
}

class Micro extends JComponent {
    ArrayList<Prey> preys = new ArrayList<>();
    ArrayList<Predator> predators = new ArrayList<>();
    private final int frameWidth = 400;
    private final int frameHeight = 400;
    public void paintComponent(Graphics g) {
        Random random = new Random(); 
        Graphics2D g2 = (Graphics2D) g;
        Rectangle frame = new Rectangle(0,0, frameWidth, frameHeight);
        g2.draw(frame);
        g2.setColor(Color.RED);
        Rectangle redButton = new Rectangle(frameWidth + 10, frameHeight/2 + 60, 50, 50);
        g2.draw(redButton);
        g2.fill(redButton);

        g2.setColor(Color.BLUE);
        Rectangle blueButton = new Rectangle(frameWidth + 10, frameHeight/2 - 60, 50, 50);
        g2.draw(blueButton);
        g2.fill(blueButton);

        g2.setColor(Color.GREEN);
        Rectangle greenButton = new Rectangle(frameWidth + 10, frameHeight/2, 50, 30);
        g2.draw(greenButton);
        g2.fill(greenButton);

        for (int i = 0; i < predators.size(); i++) {
            Predator predator = predators.get(i);
            int leftBound = predator.getX();
            int rightBound = predator.getX() + predator.getDiameter();
            int topBound = predator.getY();
            int bottomBound = predator.getY() + predator.getDiameter();
            for (int j = 0; j < preys.size(); j++) {
                Prey prey = preys.get(j);
                int preyX = prey.getX();
                int preyY = prey.getY();
                int preyDiameter = prey.getDiameter();

                //preyCollision(predator,prey);
                if (preyX >= leftBound && preyX <= rightBound - preyDiameter && preyY >= topBound && preyY <= bottomBound - preyDiameter) {
                    predator.eats(prey);
                    preys.remove(prey); 
                }
            }

            for (int k = 0; k < predators.size(); k++) {
                Predator predator2 = predators.get(k);
                int predator2X = predator2.getX();
                int predator2Y = predator2.getY();
                int predator2D = predator2.getDiameter();

                //preyCollision(predator,predator2);
                if (predator2X >= leftBound && predator2X <= rightBound - predator2D && predator2Y >= topBound && predator2Y <= bottomBound - predator2D) {
                    if (predator.getDiameter() > predator2D) {
                        predator.eats(predator2);
                        predators.remove(predator2); 
                    }
                    else if(predator.getDiameter() < predator2D) {
                        predator2.eats(predator);
                        predators.remove(predator);
                    }
                }
            }
        }

        for (Prey p : preys) {
            g2.setColor(Color.BLUE);
            if (p.getX() <= 0 || p.getX() >= frameWidth - p.getDiameter()) {
                p.xCollision();
            }
            if (p.getY() <= 0 || p.getY() >= frameHeight - p.getDiameter()) {
                p.yCollision();
            }
            Ellipse2D.Double newPrey = new Ellipse2D.Double(p.getX(), p.getY(), p.getDiameter(), p.getDiameter());
            p.move();

            g2.fill(newPrey);
            g2.draw(newPrey);
        }

        for (Predator p : predators) {
            g2.setColor(Color.RED);
            if (p.getX() <= 0 || p.getX() >= frameWidth - p.getDiameter()) {
                p.xCollision();
            }
            if (p.getY() <= 0 || p.getY() >= frameHeight - p.getDiameter()) {
                p.yCollision();
            }
            Ellipse2D.Double newPredator = new Ellipse2D.Double(p.getX(), p.getY(), p.getDiameter(), p.getDiameter());
            p.move();
            g2.fill(newPredator);
            g2.draw(newPredator);
        }
    }

    public void preyCollision (Prey a, Prey b) {
        int aLeftBound = a.getX();
        int aRightBound = a.getX() + a.getDiameter();
        int aTopBound = a.getY();
        int aBottomBound = a.getY() + a.getDiameter();

        int bX = b.getX();
        int bY = b.getY();
        if (bX >= aLeftBound && bX >= aRightBound && bY >= aTopBound && bY <= aBottomBound) {
            boolean aTempIsRight = a.isRight();
            boolean aTempIsDown = a.isDown();
            int aXVel = a.getXVel();
            int aYVel = b.getYVel();

            a.setXVel(b.getXVel());
            a.setYVel(b.getYVel());
            a.setIsRight(b.isRight());
            a.setIsDown(b.isDown());

            b.setXVel(aXVel);
            b.setYVel(aYVel);
            b.setIsRight(aTempIsRight);
            b.setIsDown(aTempIsDown);
        }
    }

    public void resetAll() {
        preys.clear();
        predators.clear();
    }
}

public class Agario
{
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame();
        frame.setSize(515,500);
        frame.setTitle("Agario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Micro myAgario = new Micro();
        frame.add(myAgario);

        class MouseClickListener implements MouseListener {
            public void mousePressed(MouseEvent event){}

            public void mouseExited(MouseEvent event){}

            public void mouseEntered(MouseEvent event){}

            public void mouseReleased(MouseEvent event){}

            public void mouseClicked(MouseEvent event) {
                int x = event.getX();
                int y = event.getY();

                if (x >= 410 && x <= 460 && y >= 140 && y <= 190) {
                    for (int i = 0; i < 1; i++) {
                        Prey newPrey = new Prey(10); 
                        myAgario.preys.add(newPrey);
                    }

                } 

                if (x >= 410 && x <= 460 && y >= 260 && y <= 310) {
                    for (int i = 0; i < 1; i++) {
                        Predator newPredator = new Predator(50);
                        myAgario.predators.add(newPredator);
                    }
                }

                if (x >= 410 && x <= 460 && y >= 200 && y <= 230) {
                    myAgario.resetAll();
                }
            }
        }
        MouseClickListener listener = new MouseClickListener();
        myAgario.addMouseListener(listener);

        frame.add(myAgario);
        do {
            Thread.sleep(50);
            myAgario.repaint();
            frame.setVisible(true);
        }
        while (true);
    }
}
