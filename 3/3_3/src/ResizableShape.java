import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Created with IntelliJ IDEA.
 * User: vieno
 * Date: 12/06/27
 * Time: 18:26
 * To change this template use File | Settings | File Templates.
 */
public interface ResizableShape extends Shape {
    public abstract void setSize (int w, int h);
    public abstract void setPosition(int x, int y);
    public abstract double getX();
    public abstract double getY();
    public int getOriginX();
    public int getOriginY();
}
