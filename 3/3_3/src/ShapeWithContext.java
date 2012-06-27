import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: vieno
 * Date: 12/06/27
 * Time: 17:07
 * To change this template use File | Settings | File Templates.
 */
public class ShapeWithContext {
    public ResizableShape shape;
    private boolean withShade;
    private Context ctx = new Context();
    private boolean selected;

    public class Context {
        private Stroke st = new BasicStroke();
        private Color lineColor = Color.BLACK;
        private Color fillColor = Color.WHITE;
        private int lineWidth = 1;

        public Stroke getStroke() {
            if (st == null) {
                st = new BasicStroke(lineWidth);
            }

            return st;
        }

        public void setStroke(Stroke st) {
            this.st = st;
        }

        public Color getLineColor() {
            return lineColor;
        }

        public void setLineColor(Color lineColor) {
            this.lineColor = lineColor;
        }

        public Color getFillColor() {
            return fillColor;
        }

        public void setFillColor(Color fillColor) {
            this.fillColor = fillColor;
        }

        public int getLineWidth() {
            return lineWidth;
        }

        public void setLineWidth(int lineWidth) {
            this.lineWidth = lineWidth;
        }
    }

    public ShapeWithContext (ResizableShape s) {
        this.shape = s;
    }

    public ResizableShape getShape() {
        return shape;
    }

    public void setShape(ResizableShape shape) {
        this.shape = shape;
    }

    public boolean isWithShade() {
        return withShade;
    }

    public void setWithShade(boolean withShade) {
        this.withShade = withShade;
    }

    public Context getCtx() {
        return ctx;
    }

    public void setCtx(Context ctx) {
        this.ctx = ctx;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}
