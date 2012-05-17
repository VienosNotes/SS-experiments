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


    MyCanvas canvas = new MyCanvas();


    public MainForm() {
        super("My Painter");
        MotionListener listener = new MotionListener(this);

        JPanel jp = new JPanel(new BorderLayout());
        getContentPane().add(jp);
        addMouseMotionListener(listener);
        addMouseListener(listener);
        jp.add(BorderLayout.CENTER, canvas);
        setSize(new Dimension(360, 240));
        setVisible(true);

        canvas.draws.add(new MyRectangle.Builder(20, 40).size(40,40).fillColor(Color.RED).lineColor(Color.GREEN).build());
        canvas.draws.add(new MyRectangle.Builder(120, 140).size(80,80).fillColor(Color.BLUE).lineColor(Color.ORANGE).build());
        canvas.draws.add(new MyOval.Builder(20, 80).size(80,40).fillColor(Color.ORANGE).lineColor(Color.MAGENTA).lineWidth(5).build());
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

    public MyCanvas() {
        setBackground(Color.white);
    }

    @Override public void paint(Graphics g) {
        super.paint(g);
        for(MyDrawing d : draws) {
            //System.out.println(d instanceof MyRectangle);
            d.draw(g);
            //System.out.println(d.fillColor);
        }
    }
}