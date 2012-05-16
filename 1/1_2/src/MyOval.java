import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: vieno
 * Date: 12/05/14
 * Time: 17:47
 * To change this template use File | Settings | File Templates.
 */
public class MyOval extends MyDrawing {
     public MyOval(int x, int y){
        super();
        this.setLocation(x, y);
    }

    public static class Builder extends MyDrawing.Builder {
        public Builder(int x, int y) {
            super(x, y);
        }

        public MyOval build() {
            return new MyOval(this);
        }

    }

    @Override
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
        g2.setColor(this.getFillColor());
        g2.fillOval(x, y, w, h);
        g2.setColor(this.getLineColor());
        g2.drawOval(x, y, w, h);
    }

    @Override
    public String toString() {
        return "Oval:" + x + y + w + h;
    }

    protected MyOval(Builder b) {
        super(b);
    }
}
