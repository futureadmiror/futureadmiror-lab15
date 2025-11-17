import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EnigmaFrame extends JFrame {

    private JTextField process;
    private JTextField input;
    private JTextField output;

    
    private JComboBox<Integer> inner;
    private JComboBox<Integer> middle;
    private JComboBox<Integer> out;
    private JButton encrypt;
    private JButton decrypt;


    private final Integer[] units = {
        1, 2, 3, 4, 5
    };

    public EnigmaFrame() {
        super();

        
       
        
        inner = new JComboBox<>(units); //dropdown options of from/to
        middle = new JComboBox<>(units); //dropdown options of from/to
        out   = new JComboBox<>(units);
        process = new JTextField("", 5);
        encrypt = new JButton("Encryt");
        decrypt = new JButton("Decrypt");
        input = new JTextField("", 5);
        output = new JTextField("", 5);
        output.setEditable(false);
        // Create panel with flow layout and add GUI elements
        JPanel dpanel = new JPanel(new FlowLayout()); 
        dpanel.add(new JLabel("Inner: "));
        dpanel.add(inner, BorderLayout.NORTH);
         dpanel.add(new JLabel("Middle: "));
        dpanel.add(middle, BorderLayout.NORTH);
        dpanel.add(new JLabel("Out: "));
        dpanel.add(out, BorderLayout.NORTH);
        dpanel.add(new JLabel("Initial Positions: "));
        dpanel.add(process, BorderLayout.NORTH);
        dpanel.add(encrypt, BorderLayout.NORTH);
        dpanel.add(decrypt, BorderLayout.NORTH);
        dpanel.add(input, BorderLayout.CENTER);
        dpanel.add(output, BorderLayout.SOUTH);
        //add the same action listener for all
        // CoverterActionListener a = new CoverterActionListener();
        
            
        
        this.add(dpanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    //use a private, inner class to handle events
    // private class CoverterActionListener implements ActionListener {

    //      public void actionPerformed(ActionEvent e) {

    //          //get the index selected in the comboboxes
    //          int fIdx = fromUnits.getSelectedIndex();
    //          int tIdx = toUnits.getSelectedIndex();

    //          //retrieve the from value as a double
    //          double fVal = Double.parseDouble(fromValue.getText());

    //          //first convert from value to feet and then divde by the
    //          //convert to units
    //          double tVal = (fVal * cfact[fIdx]) / cfact[tIdx];
              
    //          //round to 3 decimal places
    //          tVal = Math.round(tVal * 1000.0) / 1000.0;
             
    //          toValue.setText("" + tVal); //set the toValue text field
    //      }
    // }

    public static void main(String args[]) {
        EnigmaFrame u = new EnigmaFrame();
        u.setVisible(true);
    }
}