
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class which adds a button label and textfield to the selectOrder frame. Also
 * has an action listener and will set up the snowflakeWindow frame when the
 * user interacts.
 *
 * @author Ben,
 */
public class showSnowflake extends JPanel implements ActionListener {
    public static int order;
    public JLabel jlabel;
    public JButton jbutton;
    public JTextField jtext;
    JFrame snowflakeWindow = new JFrame();

    /**
     * Method which builds the selectOrder jframe, also adds an event listener for
     * whenever the submit button is pressed
     */
    public showSnowflake() {
        JLabel jlabel = new JLabel("order: ");
        JTextField jtext = new JTextField();
        JButton jbutton = new JButton("submit");
        jlabel.setBounds(30, 35, 100, 100);
        jbutton.setBounds(180, 60, 70, 50);
        jtext.setBounds(80, 60, 100, 50);
        jtext.setEditable(true);
        jbutton.addActionListener(new ActionListener() {
            /**
             * Event handler which will open a new frame and show the snowflake when event
             * is triggered.
             * 
             * @param e The event which is being listened for.
             */
            public void actionPerformed(ActionEvent e) {
                snowflakeWindow.setVisible(false);
                snowflakeWindow.dispose();
                snowflakeWindow = new JFrame();
                String orderSelected = jtext.getText();
                try {
                    order = Integer.parseInt(orderSelected);
                } catch (Exception ex) {
                    System.err.println("Error: Order must be a number ");
                    return;
                }
                snowflakeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                snowflakeWindow.setBounds(0, 0, 650, 678);
                snowflakeWindow.setLocationRelativeTo(null);
                snowflakeWindow.getContentPane().add(new kochSnowflake(getOrder()));
                snowflakeWindow.setVisible(true);
                snowflakeWindow.repaint();
            }
        });
        this.add(jlabel);
        this.add(jbutton);
        this.add(jtext);
        setVisible(true);
        setLayout(null);

    }

    public void actionPerformed(ActionEvent e) {
    }

    /**
     * Method which gets the order entered by the user.
     *
     * @return the order entered.
     */
    public static int getOrder() {
        return order;
    }

}
