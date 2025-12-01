import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EnigmaFrame extends JFrame {

    private JTextField process;
    private JTextArea input;
    private JTextArea output;

    
    private JComboBox<String> inner;
    private JComboBox<String> middle;
    private JComboBox<String> out;
    private JButton encrypt;
    private JButton decrypt;


    private final String[] units = {
        "1","2", "3", "4", "5"
    };

    public EnigmaFrame() {
        super();

        
       
        
        inner = new JComboBox<String>(units); //dropdown options of from/to
        middle = new JComboBox<String>(units); //dropdown options of from/to
        out   = new JComboBox<String>(units);
        process = new JTextField("", 5);
        encrypt = new JButton("Encryt");
        decrypt = new JButton("Decrypt");
        input = new JTextArea( 5, 55);
        output = new JTextArea( 5, 55);
        input.setPreferredSize(new Dimension(200, 100));
        output.setPreferredSize(new Dimension(200, 100));
        output.setEditable(false);
        // Create panel with flow layout and add GUI elements
        JPanel tpanel = new JPanel(new BorderLayout()); 
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
        JPanel rpanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
        rpanel.add(new JLabel("Input   "));
        rpanel.add(input);
        JPanel lpanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
        lpanel.add(new JLabel("Output"));
        lpanel.add(output);
        //add the same action listener for all
        CoverterActionListener a = new CoverterActionListener();
        encrypt.addActionListener(a);
        decrypt.addActionListener(a);
        
        tpanel.add(dpanel, BorderLayout.NORTH);
        tpanel.add(rpanel, BorderLayout.CENTER);
        tpanel.add(lpanel, BorderLayout.SOUTH);   
        
       this.add(tpanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }


    private class CoverterActionListener implements ActionListener {

         public void actionPerformed(ActionEvent e) {

            String in  = String.valueOf(inner.getSelectedIndex() + 1);
            String mid = String.valueOf(middle.getSelectedIndex() + 1);
            String ou  = String.valueOf(out.getSelectedIndex() + 1);
            String pros = process.getText();
            String inpu = input.getText();
            String[] input;
            String cmd = e.getActionCommand();
            if (cmd.equals("Encryt")) {
             input = new String[] {in, mid, ou, pros, "encrypt", inpu};
            
            }
            else{
             input = new String[] {in, mid, ou, pros, "decrypt", inpu};
            
            }
            String result = Comms.run(input);
            output.setText(result);
         }
    }

}