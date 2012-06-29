import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by IntelliJ IDEA.
 * User: vieno
 * Date: 12/06/29
 * Time: 13:03
 * To change this template use File | Settings | File Templates.
 */
public class Modifier extends JFrame {

    public JComboBox<JLabel> jc;
    public JLabel lcLabel = new JLabel("LINE");
    public JLabel fcLabel = new JLabel("FILL");
    public Color lineColor;
    public Color fillColor;
    public BasicStroke bs;
    public MainForm mf;
    public JTextPane lineWidth;
    public Checkbox shadow = new Checkbox("Shadow");

    class ModifyWindowListener extends WindowAdapter {
        public MainForm mf;

        public ModifyWindowListener(MainForm mf) {
            this.mf = mf;
        }

        @Override
        public void windowClosing(WindowEvent e) {
            mf.mod = null;
        }
    }

    public Modifier(MainForm mf) {
        this.mf = mf;
        this.lineColor = mf.canvas.med.getSelectedShape().getCtx().getLineColor();
        this.fillColor = mf.canvas.med.getSelectedShape().getCtx().getFillColor();
        this.lineWidth = new JTextPane();
        lineWidth.setText("" + mf.canvas.med.getSelectedShape().getCtx().getLineWidth());

        JPanel jp = new JPanel(new BorderLayout());
        getContentPane().add(jp);

        JPanel lineColorModify = new JPanel();
        JPanel fillColorModify = new JPanel();

        Button lcolor = new Button("Line Color");
        lcolor.addActionListener(new ModColorChooser(this, lcLabel, lineColor));
        lineColorModify.add(lcolor);
        lineColorModify.add(new JLabel("Sample:"));
        lcLabel.setForeground(lineColor);
        lineColorModify.add(lcLabel);
        
        Button fcolor = new Button("Fill Color");
        fcolor.addActionListener(new ModColorChooser(this, fcLabel, fillColor));
        fillColorModify.add(fcolor);
        fillColorModify.add(new JLabel("Sample:"));
        fcLabel.setForeground(fillColor);
        fillColorModify.add(fcLabel);

        JPanel opButton = new JPanel();
        Button applyButton = new Button("Apply");
        applyButton.addActionListener(new ModApplyListener(this));

        opButton.add(applyButton);

        JPanel color = new JPanel(new BorderLayout());
        color.add(BorderLayout.NORTH, lineColorModify);
        color.add(BorderLayout.CENTER, fillColorModify);

        JPanel widthPanel = new JPanel();
        widthPanel.add(new JLabel("Line Width: "));
        widthPanel.add(BorderLayout.NORTH, lineWidth);

        shadow.setState(mf.canvas.med.getSelectedShape().isWithShade());
        widthPanel.add(BorderLayout.SOUTH, shadow);
        
        jp.add(BorderLayout.NORTH, color);
        jp.add(BorderLayout.CENTER, widthPanel);
        jp.add(BorderLayout.SOUTH, opButton);

        setSize(new Dimension(320, 240));
        setVisible(true);
        this.repaint();

        addWindowListener(new ModifyWindowListener(mf));

    }
}
