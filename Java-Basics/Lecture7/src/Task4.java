import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter index (0–4): ");
            int index = sc.nextInt();

            System.out.println("Value = " + arr[index]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        }
    }
}
