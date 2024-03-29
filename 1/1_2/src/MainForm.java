import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: vieno
 * Date: 12/04/18
 * Time: 20:49
 * To change this template use File | Settings | File Templates.
 */
public class MainForm extends JFrame {

    public MyCanvas canvas = new MyCanvas(this);

    public MainForm() {
        super("My Painter");

        JPanel jp = new JPanel(new BorderLayout());

        getContentPane().add(jp);

        jp.add(BorderLayout.CENTER, canvas);
        setSize(new Dimension(480, 360));
        setVisible(true);
        this.repaint();
        canvas.draws.add(new MyRegPolygon.Builder(200, 200).vertex(7).size(40, 40).build());
        canvas.draws.add(new MyRectangle.Builder(0, 0).size(40,40).fillColor(Color.RED).lineColor(Color.GREEN).build());
        canvas.draws.add(new MyOval.Builder(20, 80).size(80,40).fillColor(Color.ORANGE).lineColor(Color.MAGENTA).lineWidth(5).build());
        canvas.draws.add(new MyRegPolygon.Builder(300, 100).vertex(10).size(160,160).build());
    }

    public static void main (String[] args) {
        MainForm mf = new MainForm();
    }

}

class MyCanvas extends JPanel {

    /**
     * ArrayList which contains all shapes
     */
    public ArrayList<MyDrawing> draws = new ArrayList<MyDrawing>();
    private final MainForm mf;

    public MyCanvas(MainForm mf) {
        setBackground(Color.white);
        this.mf = mf;
    }

    @Override public void paint(Graphics g) {
        super.paint(g);
        for(MyDrawing d : draws) {
            d.draw(g);
            repaint();
        }
    }
}