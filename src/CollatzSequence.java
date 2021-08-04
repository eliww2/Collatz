import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class CollatzSequence extends AppObject {

    private final List<Integer> collatzSequence = new ArrayList();
    private final int sequenceLength, maxInt;
    private final double horizontalAvailable;

    public CollatzSequence(int initialInt) {
        //TODO: Only allow positive integers
        int currentNumber = initialInt, max = initialInt;
        while(true) {
            collatzSequence.add(currentNumber);
            if (currentNumber != 1) {
                currentNumber = collatzNextNumber(currentNumber);
                if (currentNumber > max) max = currentNumber;
            } else break;
        }
        sequenceLength = collatzSequence.size();
        maxInt = max;
        horizontalAvailable = (App.WIDTH - Graph.GRAPH_X_START - 100);
    }

    public static int collatzNextNumber(int collatzNumber) {
        if (collatzNumber % 2 == 0) {
            return collatzNumber / 2;
        }
        return (3 * collatzNumber) + 1;
    }

    public int getSequenceLength() { return sequenceLength; }

    public int getMaxInt() { return maxInt; }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics graphics) {

        int leftStart = Graph.GRAPH_X_START + 50;

        double pixelsPerNode = horizontalAvailable / sequenceLength;
        int nodeDiameter = (int) (pixelsPerNode * 0.9);
        if (nodeDiameter > 50) nodeDiameter = 50;

        double verticalAvailable = Graph.GRAPH_Y_START - nodeDiameter;
        double pixelsPerInteger = verticalAvailable / maxInt;

        graphics.setColor(Color.blue);

        for (int i = 0; i < sequenceLength; i++) {
            int nodeX = (int) (leftStart + (i * pixelsPerNode));
            int nodeY = (int) (verticalAvailable - (pixelsPerInteger * collatzSequence.get(i)));
            graphics.fillOval(nodeX, nodeY, nodeDiameter, nodeDiameter);
        }
    }
}
