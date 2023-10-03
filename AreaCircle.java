import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AreaCircle extends JPanel{
    private JTextField radiusTextField;
    private JButton calButton;
    private JLabel title, answer, pic, radiusLabel;
    private String[] scale = {"mm", "cm", "m"};
    private JComboBox<String> scaleBox;
    private Font font = new Font("IBM Plex Mono", Font.BOLD, 20);
    private Color bgColor = new Color(240, 240, 240);
    private Color txtColor = Color.BLACK;
    private ImageIcon whiteCircle, darkCircle;


    public AreaCircle() {
        // Load all picture
        darkCircle = new ImageIcon(new ImageIcon("allPic/dark-circle.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        whiteCircle = new ImageIcon(new ImageIcon("allPic/white-circle.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));

        // setting panel
        setLayout(new FlowLayout());
        setBackground(bgColor);

        // setting title lable
        title = new JLabel("\"Square Area\"");
        title.setFont(font);
        title.setForeground(txtColor);
        title.setPreferredSize(new Dimension(400, 50));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        // setting picture to label
        pic = new JLabel(darkCircle);
        pic.setPreferredSize(new Dimension(500,160));
        pic.setHorizontalAlignment(SwingConstants.CENTER);

        // setting Label "Side"
        radiusLabel = new JLabel("radius");
        radiusLabel.setFont(font);
        radiusLabel.setForeground(txtColor);
        radiusLabel.setPreferredSize(new Dimension(80, 50));

        // setting TextField
        radiusTextField = new JTextField(15);
        radiusTextField.setFont(font);
        radiusTextField.setBackground(bgColor);
        radiusTextField.setForeground(txtColor);
        radiusTextField.setPreferredSize(new Dimension(100,40));
        radiusTextField.addActionListener(new ButtonHandler());

        // setting Combobox for each scale : mm, cm, m
        scaleBox = new JComboBox<String>(scale);
        scaleBox.setFont(font);

        // setting Calculate Button
        calButton = new JButton("Calculate");
        calButton.setFont(font);
        calButton.addActionListener(new ButtonHandler());

        // setting Answer Label
        answer = new JLabel();
        answer.setFont(font);
        answer.setPreferredSize(new Dimension(500,40));
        answer.setHorizontalAlignment(SwingConstants.CENTER);

        // Add all component to panel
        add(title);
        add(pic);
        add(radiusLabel);
        add(radiusTextField);
        add(scaleBox);
        add(calButton);
        add(answer);

        // setting defalte theme
        setBackground(bgColor);
    }
    /* Inner Class for Create ButtonHanlder */
    public class ButtonHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double ans, radius;
                radius = Double.parseDouble(radiusTextField.getText());
                ans = Math.PI * (radius * radius);
                answer.setText(String.format("Area = %.2f ", ans) + scaleBox.getSelectedItem() + "^2");
                
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(AreaCircle.this, "Please Enter Only Interger Number Or Decimal Number Only", "Error : ERR-004", 2);
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
            bgColor = new Color(64, 64, 64);
            txtColor = new Color(240,255,255);
            update(mode);
        }
    }
    public void update(int mode) {
        if (mode == 0) {
            pic.setIcon(darkCircle);
        } else {
            pic.setIcon(whiteCircle);
        }
        setBackground(bgColor);
        title.setForeground(txtColor);
        radiusLabel.setForeground(txtColor);
        radiusTextField.setBackground(bgColor);
        radiusTextField.setForeground(txtColor);
        scaleBox.setBackground(bgColor);
        scaleBox.setForeground(txtColor);
        calButton.setBackground(bgColor);
        calButton.setForeground(txtColor);
        answer.setForeground(txtColor);
    }
}
