import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: vieno
 * Date: 12/04/18
 * Time: 21:30
 * To change this template use File | Settings | File Templates.
 */
public class MyRectangle extends MyDrawing {
    public MyRectangle(int x, int y){
        super();
        this.setLocation(x, y);
    }

    public void draw(Graphics g) {
        int x = getX();
        int y = getY();
        int w = getW();
        int h = getH();

        if (w < 0) {
            x += w;
            w *= -1;
        }
        
        if (h < 0) {
            y += h;
            h *= -1;
        }
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(this.getLineWidth()));
        g2.setColor(this.getLineColor());
        g2.fillRect(x,y,w,h);
        g2.setColor(this.getLineColor());
        g2.drawRect(x,y,w,h);
    }
    
}
