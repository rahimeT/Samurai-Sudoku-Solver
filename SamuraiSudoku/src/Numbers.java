import java.io.*;
import java.util.ArrayList;
public class Numbers {
    int temp = 0;
    ArrayList<String> number = new ArrayList<String>();
    public Numbers() {
        File file = new File("C:\\Users\\Rahime\\IdeaProjects\\SamuraiSudoku\\box.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = null;
        int c = 0;
        while (true) {
            try {
                if (!((line = reader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < line.length(); i++) {
                char current = line.charAt(i);
                String toInt = "  ";
                if (current == '*') {
                    toInt = "*";
                } else toInt = current + "";
                number.add(c, toInt);
                temp++;
            }
        }
    }
}
