class BallThread extends Thread {
    private Ball ball;
    private BallPanel panel;

    public BallThread(Ball ball, BallPanel panel) {
        this.ball = ball;
        this.panel = panel;
    }

    @Override
    public void run() {
        while (true) {
            ball.move(panel.getWidth(), panel.getHeight());
            panel.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }
}
