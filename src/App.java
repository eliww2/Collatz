import java.awt.*;
import java.awt.image.BufferStrategy;

public class App extends Canvas implements Runnable {

    public static final int WIDTH = 1280, HEIGHT = WIDTH * 3 / 4;

    public static final Stroke WIDE_STROKE = new BasicStroke(3);
    public static final Stroke THIN_STROKE = new BasicStroke(1);

    private boolean running;
    private Thread thread;
    private Handler handler;

    public App(){
        new Window(WIDTH, HEIGHT, "Collatz", this);
        handler = new Handler();
        handler.addObject(new Graph());
        handler.addObject(new CollatzSequence(27));
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                update();
                delta--;
            }
            if (running) { draw(); }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void update() { handler.update(); }

    private void draw() {
        BufferStrategy bufferStrategy = this.getBufferStrategy();
        if (bufferStrategy == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics graphics = bufferStrategy.getDrawGraphics();

        //graphics.setColor(Color.WHITE);
        //graphics.fillRect(0, 0, WIDTH, HEIGHT);
        graphics.setColor(Color.BLACK);

        handler.draw(graphics);

        graphics.dispose();
        bufferStrategy.show();
    }

    public static void main(String[] args) { new App(); }
}
