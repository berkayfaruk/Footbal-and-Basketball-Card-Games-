
import javax.swing.JFrame;


public class Test {
    public static void main(String[] args) throws java.io.IOException {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        /*JLabel arkaPlan = new JLabel(new ImageIcon(ImageIO.read(new File("Arkaplan.jpg"))));
       frame.setContentPane(arkaPlan);*/
        Main oyun = new Main(frame);
        oyun.ekranOlustur();
    }
}
