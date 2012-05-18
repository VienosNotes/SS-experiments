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
        //jp.setLayout(new FlowLayout());

        getContentPane().add(jp);

        canvas.addMouseMotionListener(listener);
        canvas.addMouseListener(listener);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        Button rectButton = new Button("Rectangle");
        buttonPanel.add(rectButton);

        JPanel checkPanel = new JPanel(new FlowLayout());
        Checkbox shadow = new Checkbox("Shadow");
        checkPanel.add(shadow);

        jp.add(BorderLayout.NORTH, buttonPanel);
        jp.add(BorderLayout.CENTER, canvas);
        jp.add(BorderLayout.SOUTH, checkPanel);
        setSize(new Dimension(480, 360));
        setVisible(true);

        canvas.draws.add(new MyRectangle.Builder(0, 0).size(40,40).fillColor(Color.RED).lineColor(Color.GREEN).build());
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