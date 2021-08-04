import java.awt.*;
import java.util.LinkedList;

public class Handler {
    LinkedList<AppObject> object = new LinkedList<AppObject>();

    public void update() {
        for (int i = 0; i < object.size(); i++) {
            AppObject tempObject = object.get(i);

            tempObject.update();
        }
    }

    public void draw(Graphics graphics) {
        for (int i = 0; i < object.size(); i++) {
            AppObject tempObject = object.get(i);

            tempObject.draw(graphics);
        }
    }

    public void addObject(AppObject object) {
        this.object.add(object);
    }

    public void removeObject(AppObject object) {
        this.object.remove(object);
    }
}
