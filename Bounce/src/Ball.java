import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class Ball {
    int x, y;
    int diameter = 20;
    int xVelocity, yVelocity;
    Color color;

    public Ball() {
        Random rand = new Random();
        x = rand.nextInt(800 - diameter);
        y = rand.nextInt(600 - diameter);
        xVelocity = rand.nextInt(10) + 1;
        yVelocity = rand.nextInt(10) + 1;
        color = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
    }

    public synchronized void move(int width, int height) {
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