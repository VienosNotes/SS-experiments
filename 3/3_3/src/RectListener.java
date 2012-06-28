import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/**
 * Created with IntelliJ IDEA.
 * User: vieno
 * Date: 12/05/18
 * Time: 11:58
 * To change this template use File | Settings | File Templates.
 */
public class RectListener extends DrawListener implements ActionListener {
    public RectListener(MainForm mf) {
        super(mf);
    }


    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        current = new MyRectangle(e.getX(), e.getY());
        ShapeWithContext s = new ShapeWithContext(current);
        s.setWithShade(mf.shadow.getState());
        mf.canvas.med.shapes.add(s);
    }




}
