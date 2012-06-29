import java.awt.*;
import java.awt.geom.Ellipse2D;

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
        private BasicStroke st = new BasicStroke();
        private Color lineColor = Color.BLACK;
        private Color fillColor = Color.WHITE;
        private int lineWidth = 1;

        public BasicStroke getStroke() {
            if (st == null) {
                st = new BasicStroke(lineWidth);
            }

            return st;
        }

        public void setStroke(BasicStroke st) {
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

        @Override
        public Context clone() {
            Context c = new Context();
            BasicStroke st = this.getStroke();
            c.setStroke(new BasicStroke(st.getLineWidth(), st.getEndCap(),  st.getLineJoin(),
                    st.getMiterLimit(), st.getDashArray(),st.getDashPhase()));
            return c;
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
    
    public ResizableShape shapeClone(){
        if (this.shape instanceof MyRectangle) {
            MyRectangle s = (MyRectangle)this.shape;
            return (ResizableShape) s.clone();
        } else if (this.shape instanceof MyOval) {
            MyOval s = (MyOval)this.shape;
            return (ResizableShape) s.clone();
        } else if (this.shape instanceof RegPolygon) {
            RegPolygon s = (RegPolygon)this.shape;
            return (ResizableShape)s.clone();
        } else {
            return null;
        }
    }

    @Override
    public ShapeWithContext clone () {
        ShapeWithContext s = new ShapeWithContext(this.shapeClone());
        Context c = ctx.clone();
        s.withShade = withShade;
        s.selected = selected;
        return s;
    }

}
