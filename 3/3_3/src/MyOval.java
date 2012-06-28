import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created with IntelliJ IDEA.
 * User: vieno
 * Date: 12/05/14
 * Time: 17:47
 * To change this template use File | Settings | File Templates.
 */
public class MyOval extends Ellipse2D.Double implements ResizableShape {
    public final int originX;
    public final int originY;

    public MyOval(int x, int y){
        super(x, y, 0, 0);
        originX = x;
        originY = y;
        System.out.println("called");
    }

    public void setSize(int w, int h) {
        System.out.printf("%d,%d%n", w, h);
        if (w >= 0 && h >= 0) {
            this.setBounds(this.getOriginX(), this.getOriginY(), w, h);
        } else if (w < 0 && h > 0) {
            this.setBounds(this.getOriginX() + w, this.getOriginY(), -w, h);
        } else if (w > 0 && h < 0) {
            this.setBounds((int)this.getX(), this.getOriginY() + h, w, -h);
        } else {
            this.setBounds(this.getOriginX() + w, this.getOriginY() + h, -w, -h);
        }
    }

    @Override
    public void setPosition(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public int getOriginX() {
        return originX;
    }

    public int getOriginY() {
        return originY;
    }

    public void setBounds(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
