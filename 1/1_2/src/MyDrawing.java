/**
 * Created by IntelliJ IDEA.
 * User: vieno
 * Date: 12/04/18
 * Time: 20:50
 * To change this template use File | Settings | File Templates.
 */
import java.awt.*;

/**
 * Abstract class for Shapes
 */
public abstract class MyDrawing {
    protected int x, y, h, w;
    protected Color lineColor, fillColor;
    protected int lineWidth;

    /**
     * Builder for SomeShape extends MyDrawing
     * usage:
     *   SomeShape s = new SomeShape.Builder(x, y).someSettingFoo(20).someSettingBar(Color.RED).build();
     */
    public abstract static class Builder {
        private final int x;
        private final int y;

        private int w = 10, h = 10;
        private Color line, fill;
        private int lw;

        /**
         * Make Builder object for building some instance extends MyDrawing
         * @param x horizontal position of the upper-left of this layer
         * @param y vertical position of the upper-left of this layer
         */
        public Builder(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /**
         * Set layer size with this Builder object
         * @param w width of this layer
         * @param h height of this layer
         * @return this own Builder object which size was set
         */
        public Builder size(int w, int h) {
            this.w = w;
            this.h = h;
            return this;
        }

        /**
         * Set the edge color of this shape
         * @param c edge color of this shape
         * @return this own Builder object which color was set
         */
        public Builder lineColor(Color c) {
            line = c;
            return this;
        }

        /**
         * Set the area color of this shape
         * @param c area color of this shape
         * @return this own Builder object which color was set
         */
        public Builder fillColor(Color c) {
            fill = c;
            return this;
        }

        /**
         * Set the width of edge of this shape
         * @param i width of edge
         * @return this own Builder object which width of edge set
         */
        public Builder lineWidth(int i) {
            lw = i;
            return this;
        }

        public abstract MyDrawing build();
    }

    /**
     * Make some instance extends MyDrawing with Builder pattern
     * @param b Builder object with settings of shape
     */
    protected MyDrawing(Builder b) {

        if (b.w > 0 && b.h > 0) {
            this.x = b.x;
            this.y = b.y;
            this.w = b.w;
            this.h = b.h;
        } else {
           throw new IllegalArgumentException("something is wrong with size");
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

    protected MyDrawing() { /* do nothing */ }

    /**
     * Draw this shape on the Display
     * @param g target Graphic object to draw
     */
    public abstract void draw(Graphics g);

    /**
     * Move shape with difference
     * @param dx horizontal difference to move
     * @param dy vertical difference to move
     */
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    /**
     * Move shape with absolute position
     * @param x x coordinate to move
     * @param y y coordinate to move
     */
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get location of this shape
     * @return Array of [x, y] coordinates
     */
    public int[] getLocation(){
        return new int[]{this.x, this.y};
    }

    /**
     * Set the size of this layer
     * @param w width of layer
     * @param h height of layer
     */
    public void setSize(int w, int h) {
        this.w = w;
        this.h = h;
    }

    /**
     * Get the size of this layer
     * @return Array of [width, height] of this layer
     */
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
