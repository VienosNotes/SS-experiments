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
    public MainForm() {
        super("My Painter");

        JPanel jp = new JPanel(new BorderLayout());
        getContentPane().add(jp);

        MyCanvas canvas = new MyCanvas();
        jp.add(BorderLayout.CENTER, canvas);
        setSize(new Dimension(360, 240));
        setVisible(true);
    }

    public static void main(String[] argv) {
        new MainForm();
    }
}

class MyCanvas extends JPanel {
    public MyCanvas() {
        setBackground(Color.white);
    }

}