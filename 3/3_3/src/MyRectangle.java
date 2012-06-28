import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: vieno
 * Date: 12/04/18
 * Time: 21:30
 * To change this template use File | Settings | File Templates.
 */
public class MyRectangle extends Rectangle implements ResizableShape {
    public final int originX;
    public final int originY;

    public MyRectangle(int x, int y){
        super(x, y, 0, 0);
        originX = x;
        originY = y;
        System.out.println("called");
    }

    public void setSize(int w, int h) {
        System.out.printf("%d,%d%n", w, h);
        if (w >= 0 && h >= 0) {
            this.setBounds((int)this.getX(), (int)this.getY(), w, h);
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
}
