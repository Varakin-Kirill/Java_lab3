import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;
import java.io.File;

public class lab3File {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        try {
            File file = new File("file.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                stack.push(line);
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileWriter writer = new FileWriter("file.txt", false)) {
            // запись всей строки
            System.out.println("строки в обратном порядке: ");
            while (stack.empty() != true) {
                String str = stack.pop();
                writer.write(str + "\n");
                System.out.println(str);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}