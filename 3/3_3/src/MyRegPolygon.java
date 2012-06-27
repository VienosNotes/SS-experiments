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
public class MyRegPolygon extends MyDrawing {

    /**
     * number of vertex
     */
    private int vertex;

    public static class Builder extends MyDrawing.Builder {
        private int vertex;
        public Builder(int x, int y) {
            super(x, y);
        }

        public MyRegPolygon build() {
            return new MyRegPolygon(this);
        }

        public Builder vertex(int v) {
            this.vertex = v;
            return this;
        }
    }

    public MyRegPolygon(Builder b) {
        super(b);
        this.vertex = b.vertex;
    }

    /**
     * regular constructor
     * @param vertex number of vertex
     */
    public MyRegPolygon(int vertex) {
        this.vertex = vertex;
    }

    @Override
    public void drawShape(Graphics g) {
        int[] vert_x = new int[vertex];
        int[] vert_y = new int[vertex];

        for (int i = 0; i < vertex; ++i) {
            vert_x[i] = (int) ((x + w/2) + ((double)(h/2) * Math.cos(((double)2 * Math.PI) * i / (double)(vertex))));
            vert_y[i] = (int) ((y + h/2) + ((double)(h/2) * Math.sin(((double)2 * Math.PI) * i / (double)(vertex))));
        }

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(this.getLineWidth()));
        g2.setColor(lineColor);
        g2.drawPolygon(vert_x, vert_y, vertex);
        g2.setColor(fillColor);
        g2.fillPolygon(vert_x, vert_y, vertex);

    }

    @Override
    public MyRegPolygon clone() {
        MyRegPolygon c = (MyRegPolygon) new Builder(x,y).vertex(vertex).size(w,h).fillColor(fillColor).lineColor(lineColor).lineWidth(lineWidth).build();
        return c;
    }
}
