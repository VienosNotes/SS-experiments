import java.awt.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: vieno
 * Date: 12/06/27
 * Time: 16:55
 * To change this template use File | Settings | File Templates.
 */
public class Mediator {
    private ArrayList<ShapeWithContext> shapes = new ArrayList<ShapeWithContext>();
    private Stroke st;
    private Color c;
    private ShapeWithContext selected;

    /**
     * Select the shape top of the coordinate
     * @param x x-coordinate
     * @param y y-coordinate
     */
    public void select (int x, int y) {
        for (ShapeWithContext s: shapes) {
            if (s.getShape().contains(x, y)) {
                s.setSelected(true);
                selected = s;
                return;
            }
        }
    }

    /**
     * return the shape selected now
     * @return selected Shape object
     */
    public Shape getSelectedShape () {
        return selected.getShape();
    }

    public void foreFront () {
        shapes.add(0, shapes.remove(shapes.indexOf(selected)));
    }
}
