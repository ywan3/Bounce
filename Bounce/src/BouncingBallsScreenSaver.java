import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

// Main class to run the screen saver
public class BouncingBallsScreenSaver {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Balls Screen Saver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        BallPanel ballPanel = new BallPanel();
        frame.add(ballPanel);
        frame.setVisible(true);

        Timer timer = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ballPanel.moveBalls();
            }
        });

        timer.start();
    }
}

// BallPanel class where the balls are drawn and moved
class BallPanel extends JPanel {
    private ArrayList<Ball> balls = new ArrayList<>();
    private final int BALL_COUNT = 10;

    public BallPanel() {
        for (int i = 0; i < BALL_COUNT; i++) {
            balls.add(new Ball());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ball ball : balls) {
            ball.draw(g);
        }
    }

    public void moveBalls() {
        for (Ball ball : balls) {
            ball.move(this.getWidth(), this.getHeight());
        }
        repaint();
    }
}

// Ball class represents a single ball
class Ball {
    private int x, y;
    private int diameter = 20;
    private int xVelocity, yVelocity;
    private Color color;

    public Ball() {
        Random rand = new Random();
        x = rand.nextInt(800 - diameter);
        y = rand.nextInt(600 - diameter);
        xVelocity = rand.nextInt(10) + 1;
        yVelocity = rand.nextInt(10) + 1;
        color = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
    }

    public void move(int width, int height) {
        x += xVelocity;
        y += yVelocity;

        if (x < 0 || x + diameter > width) {
            xVelocity = -xVelocity;
        }
        if (y < 0 || y + diameter > height) {
            yVelocity = -yVelocity;
        }
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, diameter, diameter);
    }
}
