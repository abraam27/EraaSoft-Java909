import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        try {
            File file = new File("test.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
