public class Task6 {
    public static void main(String[] args) {
        try {
            String x = null;
            System.out.println(x.length()); // NullPointerException

            int a = 10 / 0; // ArithmeticException

        } catch (NullPointerException e) {
            System.out.println("Null pointer error!");
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic error!");
        }
    }
}
