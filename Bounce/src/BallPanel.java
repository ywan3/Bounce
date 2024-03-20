import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;


class BallPanel extends JPanel {
    private ArrayList<Ball> balls = new ArrayList<>();
    private final int BALL_COUNT = 10;

    public BallPanel() {
        setBackground(new Color(173, 216, 230)); 
        for (int i = 0; i < BALL_COUNT; i++) {
            Ball ball = new Ball();
            balls.add(ball);
            BallThread ballThread = new BallThread(ball, this);
            ballThread.start();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        for (Ball ball : balls) {
            ball.draw(g);
        }
    }
}

