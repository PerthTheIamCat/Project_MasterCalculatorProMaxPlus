import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AreaRectangle extends JPanel{
    private Font font = new Font("IBM Plex Mono", Font.BOLD, 20);
    private Color bgColor = new Color(240, 240, 240);
    private Color txtColor = Color.BLACK;
    private JTextField wTextField, hTextField;
    private JLabel title, answer, widht, height, pic;
    private JButton calButton;
    private String[] scale = {"mm", "cm", "m"};
    private JComboBox<String> scaleBox;
    private ImageIcon whiteRec, darkRec;

    public AreaRectangle () {
        // setting panel
        setBackground(bgColor);
        setLayout(new FlowLayout());

        // Load all picture
        whiteRec = new ImageIcon(new ImageIcon("allPic/white-rec.png").getImage().getScaledInstance(175, 87, Image.SCALE_DEFAULT));
        darkRec = new ImageIcon(new ImageIcon("allPic/dark-rec.png").getImage().getScaledInstance(175, 87, Image.SCALE_DEFAULT));

        // setting all Label
        title = new JLabel("\"Rectangle Area\"");
        title.setFont(font);
        title.setForeground(txtColor);
        title.setPreferredSize(new Dimension(500, 50));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        pic = new JLabel(darkRec);
        pic.setPreferredSize(new Dimension(500, 100));
        pic.setHorizontalAlignment(SwingConstants.CENTER);

        widht = new JLabel("widht");
        widht.setForeground(txtColor);
        widht.setFont(font);

        height = new JLabel("height");
        height.setForeground(txtColor);
        height.setFont(font);

        answer = new JLabel();
        answer.setForeground(txtColor);
        answer.setFont(font);
        answer.setPreferredSize(new Dimension(500, 50));
        answer.setHorizontalAlignment(SwingConstants.CENTER);

        // setting TextField : Width, Height
        wTextField = new JTextField(8);
        wTextField.setFont(font);
        wTextField.setPreferredSize(new Dimension(100, 35));
        wTextField.setBackground(bgColor);
        wTextField.addActionListener(e ->{
            hTextField.requestFocus();
        });
        hTextField = new JTextField(8);
        hTextField.setFont(font);
        hTextField.setPreferredSize(new Dimension(100, 35));
        hTextField.setBackground(bgColor);
        hTextField.addActionListener(new ButtonHandler());

        // setting Combobox
        scaleBox = new JComboBox<String>(scale);
        scaleBox.setFont(font);
        scaleBox.setBackground(bgColor);

        // setting calculate button
        calButton = new JButton("Calculate");
        calButton.setFont(font);
        calButton.setBackground(bgColor);
        calButton.addActionListener(new ButtonHandler());

        // add all component
        add(title);
        add(pic);
        add(widht);
        add(wTextField);
        add(height);
        add(hTextField);
        add(scaleBox);
        add(calButton);
        add(answer);
        
    }
    // Method Setting Theme
    public void setTheme(int mode) {
        if (mode == 0) {
            bgColor = new Color(240, 240, 240);
            txtColor = Color.BLACK;
            update(mode);
        } else {
            bgColor = new Color(64, 64, 64);
            txtColor = new Color(240,255,255);
            update(mode);
        }
    }
    public void update(int mode) {
        if (mode == 0) {
            pic.setIcon(darkRec);
        } else {
            pic.setIcon(whiteRec);
        }
        setBackground(bgColor);
        title.setForeground(txtColor);
        widht.setForeground(txtColor);
        height.setForeground(txtColor);
        wTextField.setBackground(bgColor);
        wTextField.setForeground(txtColor);
        hTextField.setBackground(bgColor);
        hTextField.setForeground(txtColor);
        scaleBox.setBackground(bgColor);
        scaleBox.setForeground(txtColor);
        calButton.setBackground(bgColor);
        calButton.setForeground(txtColor);
        answer.setForeground(txtColor);
    }

    /* Inner Class for Create ButtonHanlder */
    public class ButtonHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double ans, w, h;
                w = Double.parseDouble(wTextField.getText());
                h = Double.parseDouble(hTextField.getText());
                ans = (w * h);
                answer.setText(String.format("Area = %.2f ", ans) + scaleBox.getSelectedItem() + "^2");
                
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(AreaRectangle.this, "Please Enter Only Interger Number Or Decimal Number Only", "Error : ERR-004", 2);
            }
        }
    }
}
