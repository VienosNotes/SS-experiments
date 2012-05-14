/**
 * Created by IntelliJ IDEA.
 * User: vieno
 * Date: 12/04/18
 * Time: 20:50
 * To change this template use File | Settings | File Templates.
 */
import java.awt.*;

public class MyDrawing {
    protected int x, y, h, w;
    protected Color lineColor, fillColor;
    protected int lineWidth;

    public static class Builder {
        private final int x;
        private final int y;

        private int w = 10, h = 10;
        private Color line, fill;
        private int lw;

        public Builder(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Builder size(int w, int h) {
            this.w = w;
            this.h = h;
            return this;
        }

        public Builder lineColor(Color c) {
            line = c;
            return this;
        }

        public Builder fillColor(Color c) {
            fill = c;
            return this;
        }

        public Builder lineWidth(int i) {
            lw = i;
            return this;
        }

        public MyDrawing build() {
            return new MyDrawing(this);
        }
    }

    protected MyDrawing(Builder b) {
        //MyDrawing md = new MyDrawing();
        if (b.w > 0 && b.h > 0) {
            this.x = b.x;
            this.y = b.y;
            this.w = b.w;
            this.h = b.h;
        } else {
            this.w = 20;
            this.h = 40;
        }

        if (b.line == null) {
            this.lineColor = Color.BLACK;
        } else {
            this.lineColor = b.line;
        }

        if (b.fill == null) {
            this.fillColor = Color.WHITE;
        } else {
            this.fillColor = b.fill;
        }

        if (b.lw == 0) {
            this.lineWidth = 1;
        } else {
            this.lineWidth = b.lw;
        }
    }

    protected MyDrawing() {

    }

    public void draw(Graphics g) {

    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] getLocation(){
        return new int[]{this.x, this.y};
    }
    
    public void setSize(int w, int h) {
        this.w = w;
        this.h = h;
    }
    
    public int[] getSize() {
        return new int[]{this.w, this.h};
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public int getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(int lineWidth) {
        this.lineWidth = lineWidth;
    }
}
