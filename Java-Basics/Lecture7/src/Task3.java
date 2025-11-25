public class Task3 {

    static void printUpper(String text) {
        try {
            System.out.println(text.toUpperCase());
        } catch (NullPointerException e) {
            System.out.println("Error: Cannot call method on null!");
        }
    }

    public static void main(String[] args) {
        printUpper(null);
    }
}
