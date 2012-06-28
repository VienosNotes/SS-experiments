import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/**
 * Created with IntelliJ IDEA.
 * User: vieno
 * Date: 12/05/18
 * Time: 12:42
 * To change this template use File | Settings | File Templates.
 */

public class PolyListener extends DrawListener implements ActionListener {
    private final int vertex;
    public PolyListener(MainForm mf, int vertex) {
        super(mf);
        this.vertex = vertex;
    }


    @Override
    public void mousePressed(MouseEvent e) {
        current = new RegPolygon(e.getX(), e.getY(), vertex);
        ShapeWithContext s = new ShapeWithContext(current);
        s.setWithShade(mf.shadow.getState());
        mf.canvas.med.shapes.add(s);

    }
    @Override
    public void mouseDragged(MouseEvent e) {
        try {
            current.setSize(-current.getOriginX() + e.getX(), -current.getOriginY() + e.getY());

        } catch(Exception ex) {
            ex.printStackTrace();
        }
        mf.canvas.repaint();
    }



}
