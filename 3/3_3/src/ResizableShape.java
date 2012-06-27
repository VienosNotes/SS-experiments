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

    /*
    Shape s;

    public ResizableShape (Shape s) {
        this.s = s;
    }

    @Override
    public Rectangle getBounds() {
        return s.getBounds();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Rectangle2D getBounds2D() {
        return s.getBounds2D();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean contains(double v, double v1) {
        return s.contains(v, v1);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean contains(Point2D point2D) {
        return s.contains(point2D);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean intersects(double v, double v1, double v2, double v3) {
        return s.intersects(v, v1, v2, v3);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean intersects(Rectangle2D rectangle2D) {
        return s.intersects(rectangle2D);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean contains(double v, double v1, double v2, double v3) {
        return s.contains(v, v1, v2, v3);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean contains(Rectangle2D rectangle2D) {
        return s.contains(rectangle2D);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public PathIterator getPathIterator(AffineTransform affineTransform) {
        return s.getPathIterator(affineTransform);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public PathIterator getPathIterator(AffineTransform affineTransform, double v) {
        return s.getPathIterator(affineTransform, v);  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setSize(int w, int h) {
        if (s instanceof Polygon) {
            Polygon p = (Polygon) s;
            Rectangle bound = this.getBounds();
            int x = bound.x;
            int y = bound.y;
            //int w = bound.width;
            //int h = bound.height;
            int vertex = p.npoints;

            int[] vert_x = new int[vertex];
            int[] vert_y = new int[vertex];

            for (int i = 0; i < vertex; ++i) {
                vert_x[i] = (int) ((x + w/2) + ((double)(h/2) * Math.cos(((double)2 * Math.PI) * i / (double)(vertex))));
                vert_y[i] = (int) ((y + h/2) + ((double)(h/2) * Math.sin(((double)2 * Math.PI) * i / (double)(vertex))));
            }

            p.xpoints = vert_x;
            p.ypoints = vert_y;
        }
    }

    */


    public abstract void setSize (int w, int h);
    public abstract double getX();
    public abstract double getY();

}
