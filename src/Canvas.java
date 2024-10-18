import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * .
 * @author Alexander Pham, Harbir Deo, Felix Yap
 *
 */
public class Canvas extends JPanel {

    private static final long serialVersionUID = 1L;

    private Rectangle rectangleArray[] = new Rectangle[Main.getArrayMax()];

    private int index;

    Color newColour = new Color(93, 118, 213); //change to whatever values for colours



    private final int rectangleWidth = 35;
    private final int rectanglePadding = 10;
    private final int rectangleMuliplierSize = 3;
    private final int rectanglePositionY = 550;


    @Override
    protected void paintComponent(Graphics graphics) {

        Graphics2D graphics2D = (Graphics2D) graphics;

        for (index = 0; index < Main.getArrayMax(); index++) {
            rectangleArray[index].rectangleDraw(graphics2D);
        }
    }

    //highlighting and fading
    /**
     * .
     * @param array
     *.
     * @param index1
     * .
     * @param index2
     * .
     * @param colour
     * .
     */
    public Canvas(int[] array, int index1, int index2, Color colour) {

        for (index = 0; index < Main.getArrayMax(); index++) {

            if (index != index1 && index != index2) {

                rectangleArray[index] = new Rectangle((index * (rectangleWidth + rectanglePadding) + 10),
                        rectanglePositionY - (array[index] * 3), rectangleWidth, array[index] * rectangleMuliplierSize,
                        newColour);

            } else {

                rectangleArray[index] = new Rectangle((index * (rectangleWidth + rectanglePadding) + 10),
                        rectanglePositionY - (array[index] * 3),
                        rectangleWidth, array[index] * rectangleMuliplierSize, colour);

            }

        }

    }

    //initial and final
    /**
     * .
     * @param array
     * .
     */
    public Canvas(int array[]) {

        for (index = 0; index < Main.getArrayMax(); index++) {
            rectangleArray[index] = new Rectangle((index * (rectangleWidth + rectanglePadding)) + 10,
                    rectanglePositionY - (array[index] * 3),
                    rectangleWidth, array[index] * rectangleMuliplierSize, newColour);
        }

    }

}
