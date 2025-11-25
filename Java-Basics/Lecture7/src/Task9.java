public class Task9 {

    static void methodA() throws Exception {
        throw new Exception("Error from methodA");
    }

    static void methodB() throws Exception {
        methodA();
    }

    public static void main(String[] args) {
        try {
            methodB();
        } catch (Exception e) {
            System.out.println("Caught in main: " + e.getMessage());
        }
    }
}
