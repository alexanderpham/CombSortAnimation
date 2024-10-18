import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 * .
 * @author Alexander Pham, Harbir Deo, Felix Yap
 *
 */
public class Rectangle {

    int coordinateX;
    int coordinateY;
    int height;
    int width;
    Color colour;

    /**
     * .
     */
    public Rectangle(int positionX, int positionY, int wide, int tall, Color colour) {

        this.coordinateX = positionX;
        this.coordinateY = positionY;
        this.width = wide;
        this.height = tall;
        this.colour = colour;

    }

    /**
     * .
     * @param graphics
     * .
     */
    public void rectangleDraw(Graphics2D graphics) {

        Rectangle2D.Double rectangle = new Rectangle2D.Double(coordinateX, coordinateY ,width, height);

        graphics.setColor(colour);

        graphics.fill(rectangle);

    }

}
