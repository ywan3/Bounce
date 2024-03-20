import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

class BallPanel extends JPanel {
    private ArrayList<Ball> balls = new ArrayList<>();
    private final int BALL_COUNT = 10;
    private Image backgroundImage;

    public BallPanel() {
        try {
            backgroundImage = ImageIO.read(new File("./wallpaper.jpg"));
            System.out.println(backgroundImage);
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        }

        for (Ball ball : balls) {
            ball.draw(g);
        }
    }
}
