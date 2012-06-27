import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;

import java.awt.event.MouseEvent;

/**
 * Created with IntelliJ IDEA.
 * User: vieno
 * Date: 12/05/18
 * Time: 12:02
 * To change this template use File | Settings | File Templates.
 */
public class OvalListener extends MotionListener {
    public OvalListener(MainForm mf) {
        super(mf);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        current = new MyOval.Builder(e.getX(), e.getY()).shadow(mf.shadow.getState()).size(1, 1).build();
        mf.canvas.draws.add(current);
    }
}
