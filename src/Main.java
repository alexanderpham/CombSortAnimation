import java.awt.Color;

import javax.swing.JFrame;


/**
 * .
 * @author Alexander Pham, Harbir Deo, Felix Yap
 *
 */
public class Main {


    static JFrame frame = new JFrame();
    static final int frameTime = 250;
    static final int height = 800;
    static final int width = 1280;
    static final int arrayMax = 15;
    static final int maxNumber = 150;
    static int array[] = new int[arrayMax];
    static Canvas animation;



    /**
     *  .
     * @param args
     * .
     */
    public static void main(String[] args) {

        for (int i = 0; i < arrayMax; i++) {

            array[i] = generateRandomNumber(maxNumber);

            System.out.print(array[i] + " ");

        }

        initialDraw();
        sort(array);
        finalDraw();

    }

    /**
     * .
     * @param maxNum
     * .
     * @return
     * .
     */
    private static int generateRandomNumber(int maxNum) {

        double rand = Math.random() * maxNumber + 1;

        return (int)rand;
    }

    /**
     * .
     * @return
     *.
     */
    public static int getArrayMax() {
        return arrayMax;
    }

    private static void initialDraw() {

        animation = new Canvas(array);
        frame.setSize(width, height);
        frame.setTitle("Comb Sort Animation");
        frame.add(animation);
        frame.repaint();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

    }

    private static void finalDraw() {

        frame.remove(animation);
        animation = new Canvas(array);
        frame.setSize(width,height);
        frame.setTitle("Comb Sort Animation");
        frame.add(animation);
        frame.repaint();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

    }

    private static void highlightsDrawing(int index1, int index2) {

        try {

            Thread.sleep(frameTime);

        } catch (InterruptedException exception) {

            exception.printStackTrace();

        }

        frame.remove(animation);

        Color highlight = new Color(100, 185, 118); // highlight color for rectangles that will be swapped

        animation = new Canvas(array, index1, index2, highlight);

        frame.add(animation);
        frame.repaint();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    private static void fadeOutDraw(int index1, int index2) {

        Color fading;

        for (int i = 0; i <= 5; i++) {

            try {

                Thread.sleep(frameTime / 5);

            } catch (InterruptedException exception) {

                exception.printStackTrace();

            }

            frame.remove(animation);
            fading = new Color(234, 53, 116, 255 - i * 51);
            animation = new Canvas(array, index1, index2, fading);
            frame.add(animation);
            frame.repaint();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

        }

    }

    private static void fadeInDraw(int index1, int index2) {

        Color fading;

        for (int i = 0; i <= 5; i++) {

            try {

                Thread.sleep(frameTime / 5);

            } catch (InterruptedException exception) {

                exception.printStackTrace();

            }

            frame.remove(animation);
            fading = new Color(255, 255, 0, 0 + i * 51);
            animation = new Canvas(array, index1, index2, fading);
            frame.add(animation);
            frame.repaint();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

        }

    }

    private static int gapUpdate(int gap)
    {
        // Shrink gap by Shrink factor
        gap = (gap * 10) / 13;

        if (gap < 1) {

            return 1;

        }

        return gap;
    }

    private static void sort(int arr[])
    {
        int size = arr.length;

        // initialize gap
        int gap = size;

        // Initialize swapped as true to make sure that
        // loop runs
        boolean swapped = true;

        // Keep running while gap is more than 1 and last
        // iteration caused a swap
        while (gap != 1 || swapped == true)
        {
            // Find next gap
            gap = gapUpdate(gap);

            // Initialize swapped as false so that we can
            // check if swap happened or not
            swapped = false;

            // Compare all elements with current gap
            for (int i = 0; i < size - gap; i++)
            {
                highlightsDrawing(i, i + gap);

                if (arr[i] > arr[i + gap])
                {
                    //drawSwap
                    // fade animations, switch heights
                    // Swap arr[i] and arr[i+gap]
                    fadeOutDraw(i, i + gap);

                    int temp = arr[i];

                    arr[i] = arr[i + gap];

                    arr[i + gap] = temp;

                    fadeInDraw(i, i + gap);

                    // Set swapped
                    swapped = true;
                }
            }
        }
    }

}
