public class Task12 {
    public static void main(String[] args) {

        try {
            try {
                int result = 10 / 0;
            } catch (ArithmeticException inner) {
                System.out.println("Inner catch: ArithmeticException handled.");
                throw inner;  // rethrow to outer
            }

        } catch (ArithmeticException outer) {
            System.out.println("Outer catch: Exception re-caught.");
        }
    }
}
