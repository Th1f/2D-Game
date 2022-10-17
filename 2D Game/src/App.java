import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Game");

        Panel panel = new Panel();
        window.add(panel);
        window.pack();
        

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        panel.startGameThread();
    }
}
