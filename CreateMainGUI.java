import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CreateMainGUI extends JFrame{
    // Attribute : Global variable
    private JMenuBar menuBar;
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private Font font = new Font("IBM Plex Mono", Font.BOLD, 15);

    // Constructor : To CreateMainGUI
    public CreateMainGUI() {
        // Create and Setting JFrame
        super("Super Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocation(getWidth()/2,getHeight()/2);
        setResizable(false);
        setVisible(true);

        // Create MainPanel and CardLayout
        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        // Create Component that contain in mainPanel
        BasicCalculator basicCalculator = new BasicCalculator();
        mainPanel.add(basicCalculator, "panel 1");
        BMICalculator bmiCalculator = new BMICalculator();
        mainPanel.add(bmiCalculator, "panel 2");
        AreaCalculator areaCalculator = new AreaCalculator();
        mainPanel.add(areaCalculator, "panel 3");
        BinaryConverter binaryConverter = new BinaryConverter();
        mainPanel.add(binaryConverter, "panel 4");

        // Create Menubar
        menuBar = new JMenuBar();

        // Create and Setting Menu
        JMenu menu = new JMenu("Menu");
        JMenu theme = new JMenu("Setting");
        JMenu about = new JMenu("About");
        JMenu version = new JMenu("Version");

        menu.setFont(font);
        theme.setFont(font);
        about.setFont(font);
        version.setFont(font);

        // Create MenuItem
        JMenuItem bsCal = new JMenuItem("Basic Calculator");    // Basic Calculator
        JMenuItem bmiCal = new JMenuItem("BMI Calculator");     // BMi Calculator
        JMenuItem areaCal = new JMenuItem("Area Calculator");   // Area Calculator
        JMenuItem byteCon = new JMenuItem("Binary Converter");  // Binary Converter
        JMenuItem lMode = new JMenuItem("Light Mode");          // Light Mode
        JMenuItem dMode = new JMenuItem("Dark Mode");           // Dark Mode
        JMenuItem thisVer = new JMenuItem("this Version");      // this Version info
        JMenuItem verLog = new JMenuItem("Version Log");        // Version Log info
        JMenuItem help = new JMenuItem("Help");                 // Help info

        /* Setting MenuItem */
        // Item 1 : Basic Calculator
        bsCal.setFont(font);
        bsCal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "panel 1");
            }
        });
        
        // Item 2 : BMI Calculator
        bmiCal.setFont(font);
        bmiCal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "panel 2");
            }
        });

        // Item 3 : Light Mode
        lMode.setFont(font);
        lMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                basicCalculator.setTheme(0);
                bmiCalculator.setTheme(0);
                areaCalculator.setTheme(0);
                binaryConverter.setTheme(0);
                menuBar.setBackground(new Color(240, 240, 240));
                
            }
        });

        // Item 4 : Dark Mode
        dMode.setFont(font);
        dMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                basicCalculator.setTheme(1);
                bmiCalculator.setTheme(1);
                areaCalculator.setTheme(1);
                binaryConverter.setTheme(1);
                menuBar.setBackground(Color.WHITE);
            }
        });

        // Item 5 : This Version info
        thisVer.setFont(font);
        thisVer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(CreateMainGUI.this, "Now are lastest\n\"Version: 0.5.2\"", "This Version", 1);
            }
        });

        // Item 6 : Version Log info
        verLog.setFont(font);
        verLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String log = (
                    "13/03/2566 version: 0.1.0  : New Program ! >> Basic Calculator & New function >> History.\n" +
                    "14/03/2566 version: 0.1.1  : Fix bug in Basic Calculater and have some error detection.\n" +
                    "15/03/2566 version: 0.2.0  : New Function! >> Chang Theme Color : Light / Dark Mode.\n" +
                    "15/03/2566 Version: 0.2.1  : Hot Fix ! HistoryButton Glitch - Duplicate Number Glitch & Fix some bug & Show more Error Message.\n" +
                    "15/03/2566 Version: 0.3.0  : New Program! >> BMI Calculator.\n" +
                    "15/03/2566 Version; 0.3.1  : Update ! >> Add \"About Button\"\n" +
                    "01/04/2566 Version: 0.4.1  : New Program ! >> Area Calculator: Can find area of Squre & Rectangle & Triangle & circle.\n" +
                    "02/04/2566 Version: 0.4.2  : Update ! >> Improve performance for Area Calculator & bug fixed.\n" +
                    "02/04/2566 Version: 0.5.1  : New Program ! >> Binary Converter.\n" +
                    "03/04/2566 Version: 0.5.2  : Fix more bug and Improve Help Button."
                );
                JOptionPane.showMessageDialog(CreateMainGUI.this, log, "Version Log", 1);
            }
        });

        // Item 7 : Help info
        help.setFont(font);
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (basicCalculator.isShowing()) {          // for basic calculator
                    JOptionPane.showMessageDialog(CreateMainGUI.this, "This Program Is In BETA Version!! :  May have limited ability\nInfomation : The Calculater Can calculate 'just' simple equation \n\nKey binding\n1-9 : Number\nclear : delete everything\ndelete : delete one step\n+ - * / : An Operator\n = : get answer\nhistory button : for seeing previous answer", "Help for Basic Calculator", 1);
                } else if (bmiCalculator.isShowing()) {     // for bmi Calculator
                    JOptionPane.showMessageDialog(CreateMainGUI.this, "BMI Calculator\nStep How To :\n1.Enter height and weight\n2.Then hit calculate button\n\nMeasurement :\nBMI < 18.5 is underweiht/too thin\nBMI 18.60-22.90 is normal(healthy) / suitable weight\nBMI 22.91-24.90 is Overweight / Obesity Grade 1\nBMI 24.91-29.90 is Overweight / Obesity Grade 2\nBMI > 29.91 is Overweight / Obesity Grade 3", "Help for BMI Calculator", 1);
                } else if (areaCalculator.isShowing()) {    // for area calculator
                    JOptionPane.showMessageDialog(CreateMainGUI.this, "Area Calculator\nStep How to :\n1.Enter number that recommended\n2.Hit Calculate Button\n3.hit home button for go back to home page\n\nContains :\n-Squre Area formula : side^2\n-Rectrangle Area formula : widht*height\n-Triagle Area formula : base*height\n-Circle Area formular : PI*radius^2", "Help for Area Calculator", 1);
                } else {
                    JOptionPane.showMessageDialog(CreateMainGUI.this, "Binary Converter\nStep How to :\n1.Select BASE that you want to convert to\n2.Enter Number and hit convert button\n\ntip : this program can convert Binary, Decimal, Octal, Hexadecima and other base number\nBUT! in this version has been limited", "Help for Binary Converter", 1);
                }
            }
        });
        // Item 8 : Area Calculator
        areaCal.setFont(font);
        areaCal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "panel 3");
            }
        });
        // Item 9 : Binary Converter
        byteCon.setFont(font);
        byteCon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "panel 4");
            }
        });

        // Add Item to menu
        menu.add(bsCal);
        menu.add(bmiCal);
        menu.add(areaCal);
        menu.add(byteCon);

        // Add Version to About
        about.add(version);
        about.add(help);

        // Add Item to Version
        version.add(thisVer);
        version.add(verLog);

        // Add Light / Dark Mode to Theme 
        theme.add(lMode);
        theme.add(dMode);

        // Add Menu to MenuBar
        menuBar.add(menu);
        menuBar.add(theme);
        menuBar.add(about);
    
        // Set Menubar to JFrame and Add mainPanel to JFrame
        setJMenuBar(menuBar);
        add(mainPanel, BorderLayout.CENTER);
    }
}
