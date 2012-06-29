import java.awt.event.ActionEvent;

/**
 * Created by IntelliJ IDEA.
 * User: vieno
 * Date: 12/06/29
 * Time: 12:41
 * To change this template use File | Settings | File Templates.
 */
public class CutListener extends SelectListener {
    public CutListener(MainForm mf) {
        super(mf);
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        mf.canvas.med.cut();
        mf.canvas.repaint();
    }
}
