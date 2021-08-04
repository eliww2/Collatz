import java.awt.*;

public abstract class AppObject {
    protected int x, y;

    public AppObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public AppObject() {}

    public abstract void update();

    public abstract void draw(Graphics graphics);

    public int getX() { return x; }

    public int getY() { return y; }

    public void setX(int x) { this.x = x; }

    public void setY(int y) { this.y = y; }
}
