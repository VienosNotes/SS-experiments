import java.awt.event.ActionEvent;

/**
 * Created by IntelliJ IDEA.
 * User: vieno
 * Date: 12/06/29
 * Time: 12:56
 * To change this template use File | Settings | File Templates.
 */
public class DeleteListener extends SelectListener {
    public DeleteListener(MainForm mf) {
        super(mf);
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        mf.canvas.med.delete();
        mf.canvas.repaint();
    }
}
