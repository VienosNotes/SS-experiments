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
    private final int vertex;

    /**
     * regular constructor
     * @param vertex number of vertex
     */
    public MyRegPolygon(int vertex) {
        this.vertex = vertex;
    }

    @Override
    public void draw(Graphics g) {
        int[] vert_x = new int[vertex];
        int[] vert_y = new int[vertex];

        for (int i = 0; i < vertex; ++i) {
            vert_x[i] = (int) (((double)h/2) * Math.cos(((double)2 * Math.PI) / (vertex * i)));
            vert_y[i] = (int) (((double)h/2) * Math.sin(((double)2 * Math.PI) / (vertex * i)));
        }

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(this.fillColor);
        g2.drawPolygon(vert_x, vert_y, vertex);


    }
}
