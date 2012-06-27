import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

/**
 * Created with IntelliJ IDEA.
 * User: vieno
 * Date: 12/05/18
 * Time: 12:42
 * To change this template use File | Settings | File Templates.
 */

public class PolyListener extends MotionListener implements ActionListener {
    private final int vertex;
    public PolyListener(MainForm mf, int vertex) {
        super(mf);
        this.vertex = vertex;
    }


    @Override
    public void mousePressed(MouseEvent e) {
        current = new RegPolygon(e.getX(), e.getY(), vertex);
        mf.canvas.med.shapes.add(new ShapeWithContext(current));
    }



    }
