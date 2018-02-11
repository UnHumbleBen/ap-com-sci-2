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

    private boolean isRight = true;
    private boolean isDown = true;

    public Prey(int newDiameter) {
        diameter = newDiameter;
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

}

class Predator extends Prey{
    public Predator(int newDiameter) {
        super(newDiameter);
    }

    public void eats(Prey p) {
        System.out.println("Eat");
        System.out.println("Position before eating: (" + getX() + "," + getY() + ")");
        System.out.println("Center Position before eating: (" + ((getX() + getDiameter()/2)) + "," + (getY() + getDiameter()/2) + ")");
        int x1 = getX();
        int x2 = getY();
        diameter += p.getDiameter();
        setX(getX() - p.getDiameter()/2);
        setY(getY() - p.getDiameter()/2);
        System.out.println("Position after eating: (" + getX() + "," + getY() + ")");
        System.out.println("Center Position after eating: (" + ((getX() + getDiameter()/2)) + "," + (getY() + getDiameter()/2) + ")");
        System.out.println("Center differennce before and after: (" + (getX() - x1) + "," + (getY() -x2 ) + ")");  
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
            Ellipse2D.Double newPrey = new Ellipse2D.Double(p.getX(), p.getY(), p.getDiameter(), p.getDiameter());
            p.move();
            Ellipse2D.Double newPredator = new Ellipse2D.Double(p.getX(), p.getY(), p.getDiameter(), p.getDiameter());
            g2.fill(newPredator);
            g2.draw(newPredator);
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
                    Prey newPrey = new Prey(10); 
                    myAgario.preys.add(newPrey);
                } 

                if (x >= 410 && x <= 460 && y >= 260 && y <= 310) {
                    Predator newPredator = new Predator(50);
                    myAgario.predators.add(newPredator);
                }
                
                if (x >= 410 && x <= 460 && y >= 200 && y <= 230) {
                    myAgario.resetAll();
                }
            }
        }
        MouseClickListener listener = new MouseClickListener();
        myAgario.addMouseListener(listener);

        frame.add(myAgario);
        while (true) {
            Thread.sleep(50);
            myAgario.repaint();
            frame.setVisible(true);
        }
    }
}
