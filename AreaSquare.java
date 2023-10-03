import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AreaSquare extends JPanel{
    private JTextField lengthTextField;
    private JButton calButton;
    private JLabel title, answer, pic, sideLabel;
    private String[] scale = {"mm", "cm", "m"};
    private JComboBox<String> scaleBox;
    private Font font = new Font("IBM Plex Mono", Font.BOLD, 20);
    private Color bgColor = new Color(240, 240, 240);
    private Color txtColor = Color.BLACK;
    private ImageIcon whiteSqure, darkSqure;

    public AreaSquare() {
        // Load all picture
        darkSqure = new ImageIcon(new ImageIcon("allPic/dark-Squre.png").getImage().getScaledInstance(175, 150, Image.SCALE_DEFAULT));
        whiteSqure = new ImageIcon(new ImageIcon("allPic/white-Squre.png").getImage().getScaledInstance(175, 150, Image.SCALE_DEFAULT));

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
        pic = new JLabel(darkSqure);
        pic.setPreferredSize(new Dimension(500,160));
        pic.setHorizontalAlignment(SwingConstants.CENTER);

        // setting Label "Side"
        sideLabel = new JLabel("side");
        sideLabel.setFont(font);
        sideLabel.setForeground(txtColor);
        sideLabel.setPreferredSize(new Dimension(50, 50));

        // setting TextField
        lengthTextField = new JTextField(15);
        lengthTextField.setFont(font);
        lengthTextField.setBackground(bgColor);
        lengthTextField.setForeground(txtColor);
        lengthTextField.setPreferredSize(new Dimension(100,40));
        lengthTextField.addActionListener(new ButtonHandler());

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
        add(sideLabel);
        add(lengthTextField);
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
                double ans, side;
                side = Double.parseDouble(lengthTextField.getText());
                ans = (side * side);
                answer.setText(String.format("Area = %.2f ", ans) + scaleBox.getSelectedItem() + "^2");
                
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(AreaSquare.this, "Please Enter Only Interger Number Or Decimal Number Only", "Error : ERR-004", 2);
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
            pic.setIcon(darkSqure);
        } else {
            pic.setIcon(whiteSqure);
        }
        setBackground(bgColor);
        title.setForeground(txtColor);
        sideLabel.setForeground(txtColor);
        lengthTextField.setBackground(bgColor);
        lengthTextField.setForeground(txtColor);
        scaleBox.setBackground(bgColor);
        scaleBox.setForeground(txtColor);
        calButton.setBackground(bgColor);
        calButton.setForeground(txtColor);
        answer.setForeground(txtColor);
    }
}
