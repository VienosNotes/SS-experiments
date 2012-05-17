import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Created with IntelliJ IDEA.
 * User: vieno
 * Date: 12/05/16
 * Time: 18:23
 * To change this template use File | Settings | File Templates.
 */
public class MotionListener extends MouseAdapter implements MouseMotionListener {

    private final MainForm mf;
    private MyDrawing current;

    public MotionListener(MainForm mf) {
        this.mf = mf;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        current = new MyOval.Builder(e.getX(),e.getY()).size(1,1).build();
        mf.canvas.draws.add(current);
        System.out.println(e.getX() + "," + e.getY() + "," + " at pressed");
        mf.canvas.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        try {
            current.setSize(-current.getX() + e.getX(),  -current.getY() + e.getY());
            System.out.println(e.getX() + "," + e.getY() + "," + " at dragged");
        } catch(Exception ex) {
            System.out.println(current.toString() + ex + " at Dtagged");
        }
        mf.canvas.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
