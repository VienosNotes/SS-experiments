import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

/**
 * Created by IntelliJ IDEA.
 * User: vieno
 * Date: 12/06/29
 * Time: 12:33
 * To change this template use File | Settings | File Templates.
 */
public class CopyListener extends SelectListener {

    public CopyListener(MainForm mf) {
        super(mf);
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        mf.canvas.med.copy();
    }
}
