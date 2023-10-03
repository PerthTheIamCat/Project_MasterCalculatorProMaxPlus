import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;

public class BasicCalculator extends JPanel{
    /*  Attribute : Global Variable */
    private Color bgColor = new Color(240, 240, 240);
    private Color txtColor = Color.BLACK;
    private ArrayList<JLabel> historyLog = new ArrayList<>();
    private JPanel calculatorPanel, buttonPanel, blankPanel1, blankPanel2;
    private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, minus, plus, divider, multiple, equal, delete, clear, point, history;
    private JLabel info, title, current;
    private JTextField textField = new JTextField(20);
    private Font font = new Font("IBM Plex Mono", Font.BOLD, 20);
    private int opLog;  // 1 = "+"   , 2 = "-"   , 3 = "*"   , 4 = "/"
    private int temp = 0;   // 0 = false    1 = true
    private double input1;
    private double input2;
    
    /*  Constructor : to Create basicCalculator */
    public BasicCalculator(){

        // Setting Panel Layout
        setLayout(new BorderLayout());
        calculatorPanel = new JPanel(new FlowLayout());
        buttonPanel = new JPanel(new GridLayout(5, 4));
 
        // Setting theme Panel
        calculatorPanel.setBackground(bgColor);
        buttonPanel.setBackground(bgColor);
        
        // Button : Number
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b0 = new JButton("0");

        // Button : Operater
        minus = new JButton("-");
        plus = new JButton("+");
        divider = new JButton("/");
        multiple = new JButton("*");
        equal = new JButton("=");

        // Button : More Additional Function
        delete = new JButton("Delete");
        clear = new JButton("Clear");
        point = new JButton(".");
        history = new JButton(new ImageIcon(new ImageIcon("allPic/dark-history-icon.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));

        // Edit each button for decoration
        b0.setFont(font);   b0.setBackground(bgColor);  b0.setForeground(txtColor);
        b1.setFont(font);   b1.setBackground(bgColor);  b1.setForeground(txtColor);
        b2.setFont(font);   b2.setBackground(bgColor);  b2.setForeground(txtColor);
        b3.setFont(font);   b3.setBackground(bgColor);  b3.setForeground(txtColor);
        b4.setFont(font);   b4.setBackground(bgColor);  b4.setForeground(txtColor);
        b5.setFont(font);   b5.setBackground(bgColor);  b5.setForeground(txtColor);
        b6.setFont(font);   b6.setBackground(bgColor);  b6.setForeground(txtColor);
        b7.setFont(font);   b7.setBackground(bgColor);  b7.setForeground(txtColor);
        b8.setFont(font);   b8.setBackground(bgColor);  b8.setForeground(txtColor);
        b9.setFont(font);   b9.setBackground(bgColor);  b9.setForeground(txtColor);
        minus.setFont(font);    minus.setBackground(bgColor);       minus.setForeground(txtColor);
        plus.setFont(font);     plus.setBackground(bgColor);        plus.setForeground(txtColor);
        divider.setFont(font);  divider.setBackground(bgColor);     divider.setForeground(txtColor);
        multiple.setFont(font); multiple.setBackground(bgColor);    multiple.setForeground(txtColor);
        equal.setFont(font);    equal.setBackground(bgColor);       equal.setForeground(txtColor);
        delete.setFont(font);   delete.setBackground(bgColor);      delete.setForeground(txtColor);
        clear.setFont(font);    clear.setBackground(bgColor);       clear.setForeground(txtColor);
        point.setFont(font);    point.setBackground(bgColor);       point.setForeground(txtColor);
        history.setBackground(bgColor);

        // Add Button to buttonPanel in order
        blankPanel1 = new JPanel();
        blankPanel2 = new JPanel();
        blankPanel1.setBackground(bgColor);
        blankPanel2.setBackground(bgColor);
        buttonPanel.add(blankPanel1);
        buttonPanel.add(blankPanel2);
        buttonPanel.add(delete);
        buttonPanel.add(clear);
        buttonPanel.add(b7);
        buttonPanel.add(b8);
        buttonPanel.add(b9);
        buttonPanel.add(divider);
        buttonPanel.add(b4);
        buttonPanel.add(b5);
        buttonPanel.add(b6);
        buttonPanel.add(multiple);
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
        buttonPanel.add(minus);
        buttonPanel.add(b0);
        buttonPanel.add(point);
        buttonPanel.add(equal);
        buttonPanel.add(plus);

        // Create Lable of Title for decoration
        title = new JLabel("\"Just Basic Calculator\"");
        title.setFont(font);
        title.setPreferredSize(new Dimension(400, 50));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        // Create new Lable for show current calculation
        current = new JLabel();
        current.setFont(font);
        current.setPreferredSize(new Dimension(400, 50));
        current.setHorizontalAlignment(SwingConstants.CENTER);

        // Create new Lable for show more Information
        info = new JLabel("BETA-TEST: For this version , The Calculator might have limited ability or have some bug");
        info.setFont(new Font("Roboto", Font.PLAIN, 11));
        info.setPreferredSize(new Dimension(450, 100));
 
        // Add buttonPanel to calculaterPanel && Add some blank pane for decoration
        calculatorPanel.add(title);
        calculatorPanel.add(textField);
        calculatorPanel.add(history);
        calculatorPanel.add(current);
        calculatorPanel.add(buttonPanel);
        calculatorPanel.add(info);
        
        // Setting textField
        textField.setPreferredSize(new Dimension(50, 50));
        textField.setFont(font);
        

        // Add allPanel to main Panel
        add(calculatorPanel, BorderLayout.CENTER);


        /*  Assign ButtonHandler for each Button */
        // Create ButtonHandler
        NumberButtonHandler numHandler = new NumberButtonHandler();
        OperaterButtonHandler opHandler = new OperaterButtonHandler();
        ClearButtonHandler clearHandler = new ClearButtonHandler();
        EqualButtonHandler eqHandler = new EqualButtonHandler();
        DeleteButtonHandler delHandler = new DeleteButtonHandler();
        HistoryButtonHandler hisHandler = new HistoryButtonHandler();
        // Assigning Event Handler for each button
        b0.addActionListener(numHandler);
        b1.addActionListener(numHandler);
        b2.addActionListener(numHandler);
        b3.addActionListener(numHandler);
        b4.addActionListener(numHandler);
        b5.addActionListener(numHandler);
        b6.addActionListener(numHandler);
        b7.addActionListener(numHandler);
        b8.addActionListener(numHandler);
        b9.addActionListener(numHandler);
        divider.addActionListener(opHandler);
        point.addActionListener(numHandler);
        plus.addActionListener(opHandler);
        minus.addActionListener(opHandler);
        multiple.addActionListener(opHandler);
        clear.addActionListener(clearHandler);
        equal.addActionListener(eqHandler);
        textField.addActionListener(eqHandler);
        delete.addActionListener(delHandler);
        history.addActionListener(hisHandler);
    }
    // Method Setting Theme
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
    // Method Update for updating theme
    public void update() {
        calculatorPanel.setBackground(bgColor);
        buttonPanel.setBackground(bgColor);
        buttonPanel.setForeground(bgColor);
        b0.setBackground(bgColor);  b0.setForeground(txtColor);
        b1.setBackground(bgColor);  b1.setForeground(txtColor);
        b2.setBackground(bgColor);  b2.setForeground(txtColor);
        b3.setBackground(bgColor);  b3.setForeground(txtColor);
        b4.setBackground(bgColor);  b4.setForeground(txtColor);
        b5.setBackground(bgColor);  b5.setForeground(txtColor);
        b6.setBackground(bgColor);  b6.setForeground(txtColor);
        b7.setBackground(bgColor);  b7.setForeground(txtColor);
        b8.setBackground(bgColor);  b8.setForeground(txtColor);
        b9.setBackground(bgColor);  b9.setForeground(txtColor);
        minus.setBackground(bgColor);       minus.setForeground(txtColor);
        plus.setBackground(bgColor);        plus.setForeground(txtColor);
        divider.setBackground(bgColor);     divider.setForeground(txtColor);
        multiple.setBackground(bgColor);    multiple.setForeground(txtColor);
        delete.setBackground(bgColor);      delete.setForeground(txtColor);
        clear.setBackground(bgColor);       clear.setForeground(txtColor);
        point.setBackground(bgColor);       point.setForeground(txtColor);
        equal.setBackground(bgColor);       equal.setForeground(txtColor);
        title.setForeground(txtColor);
        info.setForeground(txtColor);
        current.setForeground(txtColor);
        blankPanel1.setBackground(bgColor);
        blankPanel2.setBackground(bgColor);
        history.setBackground(bgColor);
        textField.setBackground(bgColor);
        textField.setForeground(txtColor);
        if (bgColor.equals(new Color(64, 64, 64))) {
            history.setIcon(new ImageIcon(new ImageIcon("allPic/white-history-icon.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
        } else {
            history.setIcon(new ImageIcon(new ImageIcon("allPic/dark-history-icon.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
        }
    }

    /*  InnerClass for Create each ButtonHandler */
    class NumberButtonHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // Add number to textField
            textField.setText(textField.getText() + e.getActionCommand());
            current.setText(current.getText() + e.getActionCommand());
        }
    }
    class OperaterButtonHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // set input number to input1 from textField in Double
            try {
                if (temp == 0) {
                    input1 = Double.parseDouble(textField.getText());
                    textField.setText("");
                    current.setText(current.getText() + e.getActionCommand());
                    temp = 1;
                    switch (e.getActionCommand()) {
                        case "+":
                            opLog = 1;
                            break;
                        case "-":
                            opLog = 2;
                            break;
                        case "*":
                            opLog = 3;
                            break;
                        case "/":
                            opLog = 4;
                            break;
                        default:
                            break;
                    }
                } else {
                    JOptionPane.showMessageDialog(BasicCalculator.this,"Sorry I can't do that! \nFor -BETA-TEST- I can calculate only one operation", "Error : ERR-001", 2);
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(BasicCalculator.this, "Please Enter some number before add -OPERATOR-", "Error : ERR-003", 2);
            }
        }
    }
    class ClearButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textField.setText("");
            current.setText("");
            temp = 0;
            input1 = 0;
            input2 = 0;
        }
    }
    class EqualButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                input2 = Double.parseDouble(textField.getText());
                double ans = 0;
                switch (opLog) {
                    case 1:
                        ans = input1 + input2;
                        break;
                    case 2:
                        ans = input1 - input2;
                        break;
                    case 3:
                        ans = input1 * input2;
                        break;
                    case 4:
                        if (input2 == 0) {
                            JOptionPane.showMessageDialog(BasicCalculator.this, "Can't divide by 0", "Error : EER-008", 2);
                        }
                        ans = input1 / input2;
                        break;
                    default:
                        break;
                }
                textField.setText("" + ans);
                current.setText(current.getText() + e.getActionCommand() + ans);
                historyLog.add(new JLabel(current.getText()));
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(BasicCalculator.this, "Please Enter Interger Number Or Decimal Number Only", "Error : EER-004", 2);
            }
        }
    }
    class DeleteButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                textField.setText(textField.getText(0, textField.getText().length()-1));
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(BasicCalculator.this, "There Nothing to Delete!", "Error : ERR-002", 2);
            }
        }
    }
    class HistoryButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            HistoryInternalPane historyInternalPane = new HistoryInternalPane();
            add(historyInternalPane);
        }
    }
    class HistoryInternalPane extends JInternalFrame {
        // Attribute : Global Variable
        private JLabel showHis;
        private int count = 0;

        // Contructor : to Create HistoryInternalPane
        public HistoryInternalPane() {
            // Setting InternalPane
            super("History", false, true, false, false);
            setBackground(bgColor);
            setLayout(new FlowLayout());
            setSize(100, 100);
            setLocation(50, 50);
            setVisible(true);

            // Set CalculatorPanel Visible to False to make Internalpane show
            calculatorPanel.setVisible(false);

            // Loop for showing history
            for (JLabel temp : historyLog) {
                count++;
                showHis = new JLabel(Integer.toString(count) + " : " + temp.getText());
                showHis.setFont(font);
                showHis.setPreferredSize(new Dimension(400, 25));
                showHis.setForeground(txtColor);
                add(showHis);
            }

            // Add InternalFrameListener for when closing the frame set CalculaterPanel visible to true 
            addInternalFrameListener(new InternalFrameAdapter() {
                @Override
                public void internalFrameClosing(InternalFrameEvent e) {
                    calculatorPanel.setVisible(true);
                }
            });
        }
    }
}
