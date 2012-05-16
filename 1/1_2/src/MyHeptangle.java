import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: vieno
 * Date: 12/05/16
 * Time: 14:29
 * To change this template use File | Settings | File Templates.
 */
public class MyHeptangle extends MyDrawing {

    private int[] vert_x = new int[7];
    private int[] vert_y = new int[7];

    public static class Builder extends MyDrawing.Builder {
        private int[] vert_x;
        private int[] vert_y;


        public Builder(int x, int y) {
            super(x, y);
        }

        /**
         * Set 7 vertexes to define heptangle
         * @param vert_x Array of the x coordinate of vertexes
         * @param vert_y Array of the y coordinate of vertexes
         * @return this own Builder object which vertexes were set
         */
        public Builder setVertex (int[] vert_x, int[] vert_y) {
            this.vert_x = vert_x;
            this.vert_y = vert_y;
            return this;
        }

        @Override
        public MyDrawing build() {
            if (vert_x.length == 7 && vert_y.length == 7) {
                return new MyHeptangle(this);
            }
            else {
                throw new IllegalArgumentException("there must be 7 vertexes");
            }
        }
    }

    public MyHeptangle(Builder b) {
        super(b);
        this.vert_x = b.vert_x;
        this.vert_y = b.vert_y;
    }

    @Override
    public void draw(Graphics g) {

    }
}
