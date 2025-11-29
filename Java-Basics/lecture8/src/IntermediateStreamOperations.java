import java.util.*;
import java.util.stream.*;

public class IntermediateStreamOperations {
    
    public static void runExamples() {
        List<Integer> numbers = DataProvider.getNumbers();
        List<String> names = DataProvider.getNames();
        
        System.out.println("\n\n=== INTERMEDIATE STREAM TASKS ===\n");
        
        // 6. Count strings longer than 5 characters
        System.out.println("6. Count of names longer than 5 characters:");
        long longNames = names.stream()
            .filter(Objects::nonNull)
            .filter(n -> n.length() > 5)
            .count();
        System.out.println(longNames);
        
        // 7. Find first element matching condition
        System.out.println("\n7. First number greater than 7:");
        Optional<Integer> firstGreaterThan7 = numbers.stream()
            .filter(n -> n > 7)
            .findFirst();
        System.out.println(firstGreaterThan7.orElse(null));
        
        // 8. Check if any divisible by 5
        System.out.println("\n8. Any number divisible by 5:");
        boolean anyDivisibleBy5 = numbers.stream()
            .anyMatch(n -> n % 5 == 0);
        System.out.println(anyDivisibleBy5);
        
        // 9. Collect into Set
        System.out.println("\n9. Numbers as Set:");
        Set<Integer> numberSet = numbers.stream()
            .collect(Collectors.toSet());
        System.out.println(numberSet);
        
        // 10. Skip first 3 elements
        System.out.println("\n10. Numbers after skipping first 3:");
        List<Integer> skipped = numbers.stream()
            .skip(3)
            .toList();
        System.out.println(skipped);
    }
}