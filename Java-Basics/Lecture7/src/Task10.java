import java.io.FileReader;
import java.io.IOException;

public class Task10 {

    static void readFile() throws IOException {
        FileReader fr = new FileReader("data.txt");
        fr.read();
        fr.close();
    }

    public static void main(String[] args) {
        try {
            readFile();
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }
}
