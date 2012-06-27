import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: vieno
 * Date: 12/05/18
 * Time: 3:00
 * To change this template use File | Settings | File Templates.
 *
 * Class for drawing regular-polygon
 */
public class RegPolygon extends Polygon implements ResizableShape {


    /**
     * number of vertex
     */
    //private int vertex;

    /*
    public static class Builder extends MyDrawing.Builder {
        private int vertex;
        public Builder(int x, int y) {
            super(x, y);
        }

        public RegPolygon build() {
            return new RegPolygon(this);
        }

        public Builder vertex(int v) {
            this.vertex = v;
            return this;
        }
    }
    */

    /**
     * regular constructor
     * @param vertex number of vertex
     */
    public RegPolygon(int x, int y, int vertex) {
        super();
        this.npoints = vertex;
        int[] initX = new int[vertex];
        int[] initY = new int[vertex];
        for (int i = 0; i < vertex; ++i){
            initX[i] = x;
            initY[i] = y;
        }

        this.xpoints = initX;
        this.ypoints = initY;
    }

    public void setSize (int w, int h) {

        Rectangle bound = this.getBounds();
        int x = bound.x;
        int y = bound.y;

        int[] vert_x = new int[npoints];
        int[] vert_y = new int[npoints];

        for (int i = 0; i < npoints; ++i) {
            vert_x[i] = (int) ((x + w/2) + ((double)(h/2) * Math.cos(((double)2 * Math.PI) * i / (double)(npoints))));
            vert_y[i] = (int) ((y + h/2) + ((double)(h/2) * Math.sin(((double)2 * Math.PI) * i / (double)(npoints))));
        }

        this.xpoints = vert_x;
        this.ypoints = vert_y;
    }

    public double getX()  {
        return this.getBounds().x;
    }

    public double getY() {
        return this.getBounds().y;
    }
}
