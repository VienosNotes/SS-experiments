import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: vieno
 * Date: 12/04/18
 * Time: 20:49
 * To change this template use File | Settings | File Templates.
 */
public class MainForm extends JFrame {

    public MyCanvas canvas = new MyCanvas(this);
    public Checkbox shadow;

    public MainForm() {
        super("My Painter");
        DrawListener listener = new RectListener(this);

        JPanel jp = new JPanel(new BorderLayout());

        getContentPane().add(jp);

        canvas.addMouseMotionListener(listener);
        canvas.addMouseListener(listener);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        Button rectButton = new Button("Rectangle");
        rectButton.addActionListener(new RectListener(this));
        buttonPanel.add(rectButton);

        Button ovalButton = new Button("Oval");
        ovalButton.addActionListener(new OvalListener(this));
        buttonPanel.add(ovalButton);

        Button heptButton = new Button("Hept");
        heptButton.addActionListener(new PolyListener(this, 7));
        buttonPanel.add(heptButton);

        Button decaButton = new Button("Deca");
        decaButton.addActionListener(new PolyListener(this, 10));
        buttonPanel.add(decaButton);
        
        Button selectButton = new Button("Select");
        selectButton.addActionListener(new SelectListener(this));
        buttonPanel.add(selectButton);

        JPanel underPanel = new JPanel(new FlowLayout());
        shadow = new Checkbox("shadow");
        underPanel.add(shadow);
        shadow.setVisible(true);
        
        Button copyButton = new Button("Copy");
        copyButton.addActionListener(new CopyListener(this));
        underPanel.add(copyButton);
        
        Button cutButton = new Button("Cut");
        cutButton.addActionListener(new CutListener(this));
        underPanel.add(cutButton);
        
        Button pasteButton = new Button("Paste");
        pasteButton.addActionListener(new PasteListener(this));
        underPanel.add(pasteButton);

        jp.add(BorderLayout.NORTH, buttonPanel);
        jp.add(BorderLayout.CENTER, canvas);
        jp.add(BorderLayout.SOUTH, underPanel);
        setSize(new Dimension(480, 360));
        setVisible(true);
        this.repaint();
    }

    public static void main (String[] args) {
        MainForm mf = new MainForm();
    }

}

class MyCanvas extends JPanel {

    /**
     * ArrayList which contains all shapes
     */
    public Mediator med = new Mediator();
    private final MainForm mf;

    public MyCanvas(MainForm mf) {
        setBackground(Color.white);
        this.mf = mf;
    }

    @Override public void paint(Graphics g) {
        super.paint(g);
        med.drawAll(g);
    }
}