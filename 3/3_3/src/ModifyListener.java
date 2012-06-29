import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: vieno
 * Date: 12/06/29
 * Time: 13:01
 * To change this template use File | Settings | File Templates.
 */
public class ModifyListener extends SelectListener {
    public ModifyListener(MainForm mf) {
        super(mf);
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        if (mf.mod != null || mf.canvas.med.getSelectedShape() == null) {
            return;
        }
        mf.mod = new Modifier(mf);
    }
}
