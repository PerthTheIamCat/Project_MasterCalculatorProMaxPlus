public class RunProject {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CreateMainGUI();
            }
        });
    }
}