import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AreaCalculator extends JPanel{
    private AreaSquare areaSquare = new AreaSquare();
    private AreaRectangle areaRectangle = new AreaRectangle();
    private AreaTriangle areaTriangle = new AreaTriangle();
    private AreaCircle areaCircle = new AreaCircle();
    private JPanel homePanel, mainPanel, hbPanel;
    private JButton homeButton, goSqureButton, goRecButton, goTriButton, goCircleButton;
    private JLabel title;
    private Font font = new Font("IBM Plex Mono", Font.BOLD, 20);
    private Color bgColor = new Color(240, 240, 240);
    private Color txtColor = Color.BLACK;
    private ImageIcon darkHomeIcon, darkSqureIcon, darkRecIcon, darkTriIcon, darkCircleIcon;
    private ImageIcon whiteHomeIcon, whiteSqureIcon, whiteRecIcon, whiteTriIcon, whiteCircleIcon;

    public AreaCalculator() {
        // setting default
        setBackground(bgColor);
        setLayout(new BorderLayout());

        // Load All ImageIcon
        darkHomeIcon = new ImageIcon(new ImageIcon("allPic/dark-home.png").getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
        darkSqureIcon = new ImageIcon(new ImageIcon("allPic/dark-icon-squre.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        darkRecIcon = new ImageIcon(new ImageIcon("allPic/dark-icon-rec.png").getImage().getScaledInstance(150, 75, Image.SCALE_DEFAULT));
        darkTriIcon = new ImageIcon(new ImageIcon("allPic/dark-icon-tri.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        darkCircleIcon = new ImageIcon(new ImageIcon("allPic/dark-icon-circle.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        whiteHomeIcon = new ImageIcon(new ImageIcon("allPic/white-home.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        whiteSqureIcon = new ImageIcon(new ImageIcon("allPic/white-icon-squre.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        whiteRecIcon = new ImageIcon(new ImageIcon("allPic/white-icon-rec.png").getImage().getScaledInstance(150, 75, Image.SCALE_DEFAULT));
        whiteTriIcon = new ImageIcon(new ImageIcon("allPic/white-icon-tri.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        whiteCircleIcon = new ImageIcon(new ImageIcon("allPic/white-icon-circle.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));

        // Create title
        title = new JLabel("\"Area Calculator\"");
        title.setFont(font);
        title.setForeground(txtColor);
        title.setPreferredSize(new Dimension(450, 40));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        // Create Home Button
        hbPanel = new JPanel();
        homeButton = new JButton(darkHomeIcon);
        homeButton.setPreferredSize(new Dimension(40, 40));
        hbPanel.add(homeButton);
        add(hbPanel, BorderLayout.NORTH);

        // Create Home Panel
        CardLayout cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        add(mainPanel,  BorderLayout.CENTER);

        // Create go Button for each Mode
        goSqureButton = new JButton(darkSqureIcon);
        goRecButton = new JButton(darkRecIcon);
        goRecButton.setPreferredSize(new Dimension(185, 160));
        goTriButton = new JButton(darkTriIcon);
        goCircleButton = new JButton(darkCircleIcon);

        // Edit each button for Decoration
        goSqureButton.setBackground(bgColor);
        goRecButton.setBackground(bgColor);
        goTriButton.setBackground(bgColor);
        goCircleButton.setBackground(bgColor);
        homeButton.setBackground(bgColor);

        // Create Home Panel
        homePanel = new JPanel();
        homePanel.add(title);
        homePanel.add(goSqureButton);
        homePanel.add(goRecButton);
        homePanel.add(goTriButton);
        homePanel.add(goCircleButton);

        // Add all component to mainPanel
        mainPanel.add(homePanel, "home");
        mainPanel.add(areaSquare, "panel 1");
        mainPanel.add(areaRectangle, "panel 2");
        mainPanel.add(areaTriangle, "panel 3");
        mainPanel.add(areaCircle, "panel 4");

        // Set event Handler for each button
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "home");
            }
        });
        goSqureButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "panel 1");
            }
        });
        goRecButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "panel 2");
            }
        });
        goTriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "panel 3");
            }
        });
        goCircleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "panel 4");
            }
        });
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
    // Update Theme
    public void update(int mode) {
        if (mode == 0) {
            homeButton.setIcon(darkHomeIcon);
            goSqureButton.setIcon(darkSqureIcon);
            goRecButton.setIcon(darkRecIcon);
            goTriButton.setIcon(darkTriIcon);
            goCircleButton.setIcon(darkCircleIcon);
        } else {
            homeButton.setIcon(whiteHomeIcon);
            goSqureButton.setIcon(whiteSqureIcon);
            goRecButton.setIcon(whiteRecIcon);
            goTriButton.setIcon(whiteTriIcon);
            goCircleButton.setIcon(whiteCircleIcon);
        }
        areaSquare.setTheme(mode);
        areaRectangle.setTheme(mode);
        areaTriangle.setTheme(mode);
        areaCircle.setTheme(mode);
        setBackground(bgColor);
        mainPanel.setBackground(bgColor);
        homePanel.setBackground(bgColor);
        hbPanel.setBackground(bgColor);
        goSqureButton.setBackground(bgColor);
        goRecButton.setBackground(bgColor);
        goTriButton.setBackground(bgColor);
        goCircleButton.setBackground(bgColor);
        homeButton.setBackground(bgColor);
        title.setForeground(txtColor);
    }
}