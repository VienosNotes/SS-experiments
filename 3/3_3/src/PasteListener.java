import java.awt.event.ActionEvent;

/**
 * Created by IntelliJ IDEA.
 * User: vieno
 * Date: 12/06/29
 * Time: 12:37
 * To change this template use File | Settings | File Templates.
 */
public class PasteListener extends SelectListener {
    public PasteListener(MainForm mf) {
        super(mf);
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        mf.canvas.med.paste();
        mf.canvas.repaint();
    }
}
