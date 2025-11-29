import java.util.*;

public class NumericStreamOperations {
    
    public static void runExamples() {
        List<Integer> numbers = DataProvider.getNumbers();
        
        System.out.println("\n\n=== NUMERIC STREAMS & REDUCTIONS ===\n");
        
        // 11. Sum using reduce
        System.out.println("11. Sum of all numbers:");
        int sum = numbers.stream()
            .reduce(0, Integer::sum);
        System.out.println(sum);
        
        // 12. Max and Min
        System.out.println("\n12. Maximum and Minimum:");
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        Optional<Integer> min = numbers.stream().min(Integer::compareTo);
        System.out.println("Max: " + max.orElse(null));
        System.out.println("Min: " + min.orElse(null));
        
        // 13. Average
        System.out.println("\n13. Average of numbers:");
        OptionalDouble average = numbers.stream()
            .mapToInt(Integer::intValue)
            .average();
        System.out.println(average.orElse(0.0));
        
        // 14. Multiply all together
        System.out.println("\n14. Product of all positive numbers:");
        int product = numbers.stream()
            .filter(n -> n > 0)
            .reduce(1, (a, b) -> a * b);
        System.out.println(product);
        
        // 15. Count positive numbers
        System.out.println("\n15. Count of positive numbers:");
        long positiveCount = numbers.stream()
            .filter(n -> n > 0)
            .count();
        System.out.println(positiveCount);
    }
}
