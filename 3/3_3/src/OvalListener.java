import java.awt.event.MouseEvent;

/**
 * Created with IntelliJ IDEA.
 * User: vieno
 * Date: 12/05/18
 * Time: 12:02
 * To change this template use File | Settings | File Templates.
 */
public class OvalListener extends DrawListener {
    public OvalListener(MainForm mf) {
        super(mf);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        current = new MyOval(e.getX(), e.getY());
        ShapeWithContext s = new ShapeWithContext(current);
        s.setWithShade(mf.shadow.getState());
        mf.canvas.med.shapes.add(s);
    }


}
