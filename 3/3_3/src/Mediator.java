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
    public ArrayList<ShapeWithContext> shapes = new ArrayList<ShapeWithContext>();
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

    public void drawAll (Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        for(ShapeWithContext d : shapes) {
            ShapeWithContext.Context ctx = d.getCtx();
            if (ctx == null) {
                System.out.println("ctx is null!");
                return;
            }

            if (d.isWithShade()) {
                ResizableShape shadow = d.shapeClone();
                shadow.setPosition(10,10);
                g2.setColor(Color.BLACK);
                g2.fill(shadow);
            }

            g2.setColor(ctx.getFillColor());
            g2.fill(d.shape);
            g2.setColor(ctx.getLineColor());
            g2.setStroke(ctx.getStroke());
            g2.draw(d.shape);

        }
    }
}
