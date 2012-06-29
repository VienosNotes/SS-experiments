import java.awt.*;
import java.awt.geom.Area;
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
        selected = null;
        for (ShapeWithContext s: shapes) {
            s.setSelected(false);
        }
        
        for (ShapeWithContext s: shapes) {
            if (new Area(s.getShape()).contains(x, y)) {
                System.out.println("selected!");
                s.setSelected(true);
                selected = s;
                //return;
            }
        }


    }

    /**
     * return the shape selected now
     * @return selected Shape object
     */
    public ResizableShape getSelectedShape () {
        if (selected != null) {
            return selected.getShape();
        } else {
            return null;
        }
    }

    public void foreFront () {
        shapes.add(0, shapes.remove(shapes.indexOf(selected)));
    }

    public void drawAll (Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle bound = null;

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
            
            if (d.isSelected()) {
                bound = new Area(d.shape).getBounds();
            }

            g2.setColor(ctx.getFillColor());
            g2.fill(d.shape);
            g2.setColor(ctx.getLineColor());
            g2.setStroke(ctx.getStroke());
            g2.draw(d.shape);

        }

        if (selected != null) {
            g2.setColor(Color.RED);
            g2.draw(bound);
        }
    }
}
