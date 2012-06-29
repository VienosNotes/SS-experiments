import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: vieno
 * Date: 12/06/29
 * Time: 14:12
 * To change this template use File | Settings | File Templates.
 */
public class ModApplyListener implements ActionListener{
    private Modifier m;

    public ModApplyListener(Modifier m) {
        this.m = m;
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ShapeWithContext s = m.mf.canvas.med.getSelectedShape();
        ShapeWithContext.Context ctx = s.getCtx();
        ctx.setFillColor(m.fillColor);
        System.out.println(m.fillColor);
        ctx.setLineColor(m.lineColor);
        ctx.setLineWidth(new Integer(m.lineWidth.getText()));
        ctx.setStroke(new BasicStroke(ctx.getLineWidth()));
        s.setWithShade(m.shadow.getState());
        m.mf.canvas.repaint();
    }
}
