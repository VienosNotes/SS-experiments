import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;

/**
 * Created with IntelliJ IDEA.
 * User: vieno
 * Date: 12/05/16
 * Time: 18:23
 * To change this template use File | Settings | File Templates.
 */
public class MotionListener extends MouseAdapter implements MouseMotionListener, ActionListener{

    protected final MainForm mf;
    protected MyDrawing current;
    protected Boolean shadow;

    public MotionListener(MainForm mf) {
        this.mf = mf;
    }

    @Override
    public void mousePressed(MouseEvent e) {

        mf.canvas.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        try {
            current.setSize(-current.getX() + e.getX(),  -current.getY() + e.getY());
        } catch(Exception ex) {
            System.out.println(current.toString() + ex + " with Dragged");
        }
        mf.canvas.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        mf.canvas.removeMouseListener(mf.canvas.getMouseListeners()[0]);
        mf.canvas.removeMouseMotionListener(mf.canvas.getMouseMotionListeners()[0]);
        mf.canvas.addMouseListener(this);
        mf.canvas.addMouseMotionListener(this);
    }

}
