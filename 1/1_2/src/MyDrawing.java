/**
 * Created by IntelliJ IDEA.
 * User: vieno
 * Date: 12/04/18
 * Time: 20:50
 * To change this template use File | Settings | File Templates.
 */
import java.awt.*;

public class MyDrawing {
    private int x, y, h, w;
    private Color lineColor, fillColor;
    private int lineWidth;

    public MyDrawing() {
        x = y = 0;
        w = h = 40;
        lineColor = Color.black;
        fillColor = Color.white;
        lineWidth = 1;
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
