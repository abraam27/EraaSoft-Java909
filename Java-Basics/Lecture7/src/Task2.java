import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a number: ");
            String numStr = sc.nextLine();

            int num = Integer.parseInt(numStr);
            System.out.println("Converted number = " + num);

        } catch (NumberFormatException e) {
            System.out.println("Invalid number format!");
        }
    }
}
