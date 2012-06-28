import java.awt.event.*;

/**
 * Created by IntelliJ IDEA.
 * User: vieno
 * Date: 12/06/29
 * Time: 7:15
 * To change this template use File | Settings | File Templates.
 */
public class SelectListener extends MouseAdapter implements MouseMotionListener, ActionListener {
    protected final MainForm mf;

    public SelectListener(MainForm mf) {
        this.mf = mf;
    }

    public void mousePressed(MouseEvent e) {
        mf.canvas.med.select(e.getX(), e.getY());
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
