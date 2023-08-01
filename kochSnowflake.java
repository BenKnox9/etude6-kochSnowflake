
import javax.swing.*;
import java.awt.*;

/**
 * Class which draws a koch snowflake recursively based on the order entered by
 * the user.
 *
 * @author Ben Knox
 */
public class kochSnowflake extends JPanel {
    public static int order;

    public static void main(String[] a) {
        JFrame selectOrder = new JFrame();
        selectOrder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        selectOrder.setBounds(0, 0, 300, 200);
        selectOrder.add(new showSnowflake());
        selectOrder.setVisible(true);

    }

    kochSnowflake(int o) {
        this.order = o;
    }

    /**
     * Method which gets the initial order, calls the snowflake() method and draws
     * each line of the initial traingle
     *
     * @param g Graphics
     */
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        try {
            order = getOrder();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        Dimension d = this.getSize();
        snowflake(g2D, order, d);
    }

    /**
     * Method which sends the recursiveKoch() method the coordinates for the inital
     * traingle using proportions of the current screen size, also sends the order
     * param and the g2D param.
     * 
     *
     * @param g2D   Used to paint the lines
     * @param order Order which is entered by the user
     * @param d     Gets the dimensions (x, y) of the panel
     */
    public static void snowflake(Graphics2D g2D, int order, Dimension d) {
        /*
         * Both based on getHeight so that the triangle stays equilateral no matter what
         * dimensions the frame holds
         */
        int height = (int) d.getHeight();
        int width = (int) d.getHeight();

        /* ratio of side length to height of triangle is 1 : sqrt(3)/2 */
        int topHeight = (int) ((4 * (height / 6)) - (Math.sqrt(3) / 2) * (10 * (width / 16)));

        /* Bottom line of triangle */
        recursiveKoch(3 * (width / 16), 4 * (height / 6), 13 * (width / 16),
                4 * (height / 6), order, g2D);

        /* Left line of triangle */
        recursiveKoch(width / 2, topHeight, 3 * (width / 16), 4 * (height / 6), order, g2D);

        /* Right line of triangle */
        recursiveKoch(13 * (width / 16), 4 * (height / 6), width / 2, topHeight, order, g2D);

    }

    /**
     * Method which recursively draws each line, when the order is higher than one
     * the line is split into three segments and the middle segment is turned into
     * an equalateral triangle with the base missing. Recursive calls will be
     * repeated on each line including the new ones created until order is reduced
     * to 1. Once the order is 1 the line will be drawn.
     * 
     * @param x1    The beginning x coordinate of the line.
     * @param y1    The beginning y coordinate of the line.
     * @param x2    The end x coordinate of the line.
     * @param y2    The end y coordinate of the line.
     * @param order The current order of the snowflake.
     * @param g2d   The graphics2D context used for drawing the lines.
     * 
     */

    public static int count = 1;

    public static void recursiveKoch(double x1, double y1, double x2, double y2, int order, Graphics2D g2D) {
        if (order == 1) {
            g2D.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        } else {
            double p2x, p2y, p3x, p3y, p4x, p4y;
            // end of first third (or segment)
            p2x = (x1 * 2 + x2) / 3;
            p2y = (y1 * 2 + y2) / 3;

            // start of last third (or segment)
            p4x = (x1 + x2 * 2) / 3;
            p4y = (y1 + y2 * 2) / 3;

            // top of new triangle
            p3x = (p2x + p4x) / 2 + (p2y - p4y) * (Math.sqrt(3) / 2);
            p3y = (p2y + p4y) / 2 + (p4x - p2x) * (Math.sqrt(3) / 2);

            // line 1
            recursiveKoch(x1, y1, p2x, p2y, order - 1, g2D);
            // line 2
            recursiveKoch(p2x, p2y, p3x, p3y, order - 1, g2D);
            // line 3
            recursiveKoch(p3x, p3y, p4x, p4y, order - 1, g2D);
            // line 4
            recursiveKoch(p4x, p4y, x2, y2, order - 1, g2D);
        }

    }

    /**
     * Method which gets the order entered by the user.
     *
     * @return the order entered.
     */
    public int getOrder() {
        return order;
    }

}
