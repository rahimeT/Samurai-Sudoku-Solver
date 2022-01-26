import javax.swing.*;
import java.io.IOException;
public class Main extends JFrame {


    public static void main(String args[]){
        try {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    try {
                        new Main();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            System.out.println("error in main ");
        }

    }
    JFrame frame = new JFrame();
    public Main() throws IOException {
        frame.setTitle("SAMURAİ SUDOKU SOLVER");
        frame.add(new Squares());
        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}