import java.awt.*;

public class Graph extends AppObject {

    private final static int HORIZONTAL_SPACES = 10;
    public static final int GRAPH_X_START = App.WIDTH / 8;
    public static final int GRAPH_Y_START = App.HEIGHT - (App.WIDTH / 8) - 50;

    public Graph() {}

    @Override
    public void update() {}

    @Override
    public void draw(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics.setColor(Color.BLACK);

        graphics2D.setStroke(App.WIDE_STROKE);
        graphics.drawLine(GRAPH_X_START, GRAPH_Y_START, GRAPH_X_START, 0);
        graphics.drawLine(GRAPH_X_START, GRAPH_Y_START, App.WIDTH, GRAPH_Y_START);
       //graphics.drawRect(0, 0, App.WIDTH - 23, App.HEIGHT - 58);

        graphics2D.setStroke(App.THIN_STROKE);
        for (int i = 0; i < HORIZONTAL_SPACES; i++) {
            int height = (GRAPH_Y_START * i) / HORIZONTAL_SPACES;
            graphics.drawLine(GRAPH_X_START, height, App.WIDTH, height);
        }
    }

}
