import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BinaryConverter extends JPanel{
    private Font font = new Font("IBM Plex Mono", Font.BOLD, 20);
    private Color bgColor = new Color(240, 240, 240);
    private Color txtColor = Color.BLACK;
    private JLabel title, bgImage1, bgImage2, toLabel, enterNumhere, answer;
    private JPanel mainPanel, bgPanel1, bgPanel2;
    private String[] base = {"BIN [2]", "OCT [8]", "DEC [10]", "HEX [16]"};
    private JComboBox<String> before, after;
    private JTextField input;
    private JButton converButton;
    private ImageIcon whiteBGIcon, darkBGIcon;

    public BinaryConverter () {
        // Set Layout
        setLayout(new BorderLayout());

        // Load Picture
        whiteBGIcon = new ImageIcon(new ImageIcon("allPic/whiteBinary.gif").getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT));
        darkBGIcon = new ImageIcon(new ImageIcon("allPic/darkBinary.gif").getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT));

        // Setting Background
        bgPanel1 = new JPanel();
        bgPanel1.setBackground(txtColor);
        bgImage1 = new JLabel(whiteBGIcon);
        bgImage1.setPreferredSize(new Dimension(50, 500));
        bgPanel1.add(bgImage1);

        bgPanel2 = new JPanel();
        bgPanel2.setBackground(txtColor);
        bgImage2 = new JLabel(whiteBGIcon);
        bgImage2.setPreferredSize(new Dimension(50, 500));
        bgPanel2.add(bgImage2);

        // Create mainPanel
        mainPanel = new JPanel();
        mainPanel.setBackground(bgColor);

        // Setting Title
        title = new JLabel("\"Binary Converter\"");
        title.setPreferredSize(new Dimension(250,50));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(font);
        title.setForeground(txtColor);
        mainPanel.add(title);

        // Setting Combobox
        before = new JComboBox<String>(base);
        before.setFont(font);
        before.setBackground(bgColor);
        before.setPreferredSize(new Dimension(130,50));
        
        after = new JComboBox<String>(base);
        after.setFont(font);
        after.setBackground(bgColor);
        after.setPreferredSize(new Dimension(130,50));

        // Setting Label
        toLabel = new JLabel("to");
        toLabel.setFont(font);
        toLabel.setForeground(txtColor);
        toLabel.setHorizontalAlignment(SwingConstants.CENTER);

        enterNumhere = new JLabel("\\/ Enter Integer Here \\/");
        enterNumhere.setFont(font);
        enterNumhere.setForeground(txtColor);
        enterNumhere.setPreferredSize(new Dimension(300, 60));
        enterNumhere.setHorizontalAlignment(SwingConstants.CENTER);

        answer = new JLabel();
        answer.setFont(font);
        answer.setForeground(txtColor);
        answer.setPreferredSize(new Dimension(500, 50));
        answer.setHorizontalAlignment(SwingConstants.CENTER);

        // Setting TextField
        input = new JTextField(18);
        input.setFont(font);
        input.setBackground(bgColor);
        input.setForeground(txtColor);
        input.setPreferredSize(new Dimension(200,50));

        // Setting Button
        converButton = new JButton("Convert");
        converButton.setFont(font);
        converButton.setBackground(bgColor);
        converButton.setForeground(txtColor);

        // Add all component to main panel
        mainPanel.add(before);
        mainPanel.add(toLabel);
        mainPanel.add(after);
        mainPanel.add(enterNumhere);
        mainPanel.add(input);
        mainPanel.add(converButton);
        mainPanel.add(answer);

        // Add all comconent to this panel
        add(bgPanel1,BorderLayout.EAST);
        add(bgPanel2,BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);

        // Add ActionListener to button and TextField
        EventHandler eventHandler = new EventHandler();
        input.addActionListener(eventHandler);
        converButton.addActionListener(eventHandler);
    }
    /**
     * InnerClass for Create EventHandler
     */
    public class EventHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String inputString = input.getText();
                int inputBase;
                if (before.getSelectedItem().toString().contains("2")) {
                    inputBase = 2;
                } else if (before.getSelectedItem().toString().contains("8")) {
                    inputBase = 8;
                } else if (before.getSelectedItem().toString().contains("10")) {
                    inputBase = 10;
                } else {
                    inputBase = 16;
                }
                int dec = Integer.parseInt(inputString, inputBase);
                String outputString;
                int outputBase;
                if (after.getSelectedItem().toString().contains("2")) {
                    outputBase = 2;
                } else if (after.getSelectedItem().toString().contains("4")) {
                    outputBase = 4;
                } else if (after.getSelectedItem().toString().contains("10")) {
                    outputBase = 10;
                } else {
                    outputBase = 16;
                }

                
                outputString = Integer.toString(dec, outputBase);
                answer.setText(after.getSelectedItem().toString() + " ->> " + outputString);
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(BinaryConverter.this, "Wrong base Integer !! Please Enter integer in correct base", "Error : ERR-007", 2);
            }
        }
    }
    // Method Setting Theme
    public void setTheme(int mode) {
        if (mode == 0) {
            bgColor = new Color(240, 240, 240);
            txtColor = Color.BLACK;
            update(mode);
        } else {
            bgColor = new Color(0, 0, 75);
            txtColor = new Color(240,255,255);
            update(mode);
        }
    }
    public void update(int mode) {
        if (mode == 0) {
            bgImage1.setIcon(whiteBGIcon);
            bgImage2.setIcon(whiteBGIcon);
            bgPanel1.setBackground(txtColor);
            bgPanel2.setBackground(txtColor);
        } else {
            bgImage1.setIcon(darkBGIcon);
            bgImage2.setIcon(darkBGIcon);
            bgPanel1.setBackground(bgColor);
            bgPanel2.setBackground(bgColor);
        }
        title.setForeground(txtColor);
        mainPanel.setBackground(bgColor);
        before.setBackground(bgColor);
        before.setForeground(txtColor);
        after.setBackground(bgColor);
        after.setForeground(txtColor);
        enterNumhere.setForeground(txtColor);
        input.setBackground(bgColor);
        input.setForeground(txtColor);
        converButton.setBackground(bgColor);
        converButton.setForeground(txtColor);
        answer.setForeground(txtColor);
        toLabel.setForeground(txtColor);
    }
}