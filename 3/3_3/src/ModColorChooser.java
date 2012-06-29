import javax.swing.*;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: vieno
 * Date: 12/06/29
 * Time: 13:47
 * To change this template use File | Settings | File Templates.
 */
public class ModColorChooser implements ActionListener {

    private final Modifier m;
    private JLabel l;
    private Color c;

    public ModColorChooser(Modifier m, JLabel l, Color c) {
        this.m = m;
        this.c = c;
        this.l = l;
    }
    
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JColorChooser chooser = new JColorChooser();
        chooser.getSelectionModel().addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e){
                changeColor(e);
            }
        });
        JFrame frame = new JFrame("Color Chooser");
        frame.add(chooser, BorderLayout.CENTER);
        frame.setSize(new Dimension(300,300));
        frame.setVisible(true);
    }

    public void changeColor(ChangeEvent e){
        ColorSelectionModel model = (ColorSelectionModel)e.getSource();
        Color newColor = model.getSelectedColor();
        if (l.getText().equals("LINE")) {
            m.lineColor = newColor;
            m.lcLabel.setForeground(newColor);
        } else {
            m.fillColor = newColor;
            m.fcLabel.setForeground(newColor);
        }

        m.repaint();
    }

}
