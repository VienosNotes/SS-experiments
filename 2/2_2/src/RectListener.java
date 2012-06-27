import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/**
 * Created with IntelliJ IDEA.
 * User: vieno
 * Date: 12/05/18
 * Time: 11:58
 * To change this template use File | Settings | File Templates.
 */
public class RectListener extends MotionListener implements ActionListener {
    public RectListener(MainForm mf) {
        super(mf);
    }


    @Override
    public void mousePressed(MouseEvent e) {
        current = new MyRectangle.Builder(e.getX(), e.getY()).shadow(mf.shadow.getState()).size(1, 1).build();
        mf.canvas.draws.add(current);
    }




}
