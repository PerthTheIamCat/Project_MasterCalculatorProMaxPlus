import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BMICalculator extends JPanel{
    // Attribute : Global Variable
    private Color bgColor = new Color(240, 240, 240);
    private Color txtColor = Color.BLACK;
    private JTextField height = new JTextField(15);
    private JTextField weight = new JTextField(15);
    private JLabel wLabel, hLabel, kgLabel, mLabel, info, bmi, title, std;
    private JButton calculateButton = new JButton("Calculate");
    private Font font = new Font("IBM Plex Mono", Font.BOLD, 20);
    private double ans;

    public BMICalculator () {
        // Setting mainPanel
        setLayout(new FlowLayout());
        setVisible(true);
        
        // Setting Title Lable
        title = new JLabel("\"BMI Calculator\"");
        title.setFont(font);
        title.setForeground(txtColor);
        title.setPreferredSize(new Dimension(500, 50));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        // Setting Information Lable : wLable, hLabel, kgLabel, mLabel, bmi, title, std
        wLabel = new JLabel("Weight");
        wLabel.setFont(font);
        wLabel.setForeground(txtColor);
        wLabel.setPreferredSize(new Dimension(80, 50));

        hLabel = new JLabel("Height");
        hLabel.setFont(font);
        hLabel.setForeground(txtColor);
        hLabel.setPreferredSize(new Dimension(80, 50));

        kgLabel = new JLabel("kg.");
        kgLabel.setFont(font);
        kgLabel.setForeground(txtColor);
        kgLabel.setPreferredSize(new Dimension(80, 50));

        mLabel = new JLabel("cm.");
        mLabel.setFont(font);
        mLabel.setForeground(txtColor);
        mLabel.setPreferredSize(new Dimension(80, 50));

        bmi = new JLabel();
        bmi.setFont(font);
        bmi.setForeground(txtColor);
        bmi.setPreferredSize(new Dimension(500, 50));
        bmi.setHorizontalAlignment(SwingConstants.CENTER);

        info = new JLabel("|| BMI = Weight / Height^2 ||");
        info.setFont(font);
        info.setForeground(txtColor);
        info.setPreferredSize(new Dimension(500, 50));
        info.setHorizontalAlignment(SwingConstants.CENTER);

        std = new JLabel();
        std.setFont(font);
        std.setForeground(txtColor);
        std.setPreferredSize(new Dimension(500, 50));
        std.setHorizontalAlignment(SwingConstants.CENTER);

        // Setting Each textField
        height.setFont(font);
        height.setPreferredSize(new Dimension(500, 50));
        height.setBackground(bgColor);
        height.setForeground(txtColor);

        weight.setFont(font);
        weight.setPreferredSize(new Dimension(500, 50));
        weight.setBackground(bgColor);
        weight.setForeground(txtColor);

        // Setting Button
        calculateButton.setHorizontalAlignment(SwingConstants.CENTER);
        calculateButton.setFont(font);
        calculateButton.setForeground(txtColor);
        calculateButton.setBackground(bgColor);

        // Set ButtonHandler for The Calculation
        CalButtonHandler calButton = new CalButtonHandler();
        calculateButton.addActionListener(calButton);
        weight.addActionListener(calButton);
        height.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weight.requestFocus();
            }
        });

        // Add all component to mainPanel
        add(title);
        add(hLabel);
        add(height);
        add(mLabel);
        add(wLabel);
        add(weight);
        add(kgLabel);
        add(calculateButton);
        add(info);
        add(bmi);
        add(std);
    }
    // Method setTheme for Changing Theme Color
    public void setTheme(int mode) {
        if (mode == 0) {
            bgColor = new Color(240, 240, 240);
            txtColor = Color.BLACK;
            update();
        } else {
            bgColor = new Color(64, 64, 64);
            txtColor = new Color(240,255,255);
            update();
        }
    }
    public void update() {
        setBackground(bgColor);
        title.setForeground(txtColor);
        hLabel.setForeground(txtColor);
        height.setBackground(bgColor);
        height.setForeground(txtColor);
        mLabel.setForeground(txtColor);
        wLabel.setForeground(txtColor);
        weight.setBackground(bgColor);
        weight.setForeground(txtColor);
        kgLabel.setForeground(txtColor);
        bmi.setForeground(txtColor);
        calculateButton.setForeground(txtColor);
        calculateButton.setBackground(bgColor);
        info.setForeground(txtColor);
        std.setForeground(txtColor);
    }
    /* Inner Class : For Create Event Handler */
    class CalButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double w = Double.parseDouble(weight.getText());
                double h = Double.parseDouble(height.getText()) / 100;
                ans = w / (h * h);
                bmi.setText("BMI = " + ans);
                if (ans <= 18.5) {
                    std.setText("too thin / underweight");
                    repaint();
                } else if (ans <= 22.90) {
                    std.setText("normal(healthy) / suitable weight");
                    repaint();
                } else if (ans <= 24.90) {
                    std.setText("Overweight / Obesity Grade 1");
                    repaint();
                } else if (ans <= 29.90) {
                    std.setText("Obese / Obesity Grade 2");
                    repaint();
                } else {
                    std.setText("Obese / Obesity Grade 3");
                    repaint();
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(BMICalculator.this, "Please Enter Height and Weight in Integer or Decimal Number","Error : ERR-005", 2);
            }
        }
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (ans == 0) {
            g.setColor(txtColor);
            g.drawOval(getWidth()/2, getHeight()-50, 20, 20);
        } else if (ans <= 18.5) {
            g.setColor(Color.RED);
            g.fillOval(getWidth()/2, getHeight()-50, 20, 20);
        } else if (ans <= 22.90) {
            g.setColor(Color.GREEN);
            g.fillOval(getWidth()/2, getHeight()-50, 20, 20);
        } else if (ans <= 24.90) {
            g.setColor(Color.YELLOW);
            g.fillOval(getWidth()/2, getHeight()-50, 20, 20);
        } else if (ans <= 29.90) {
            g.setColor(Color.ORANGE);
            g.fillOval(getWidth()/2, getHeight()-50, 20, 20);
        } else {
            g.setColor(Color.RED);
            g.fillOval(getWidth()/2, getHeight()-50, 20, 20);
        }
    }
}
