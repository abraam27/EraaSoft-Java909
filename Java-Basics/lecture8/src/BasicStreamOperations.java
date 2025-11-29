import java.util.*;

public class BasicStreamOperations {
    
    public static void runExamples() {
        List<Integer> numbers = DataProvider.getNumbers();
        List<String> names = DataProvider.getNames();
        
        System.out.println("=== BASIC STREAM OPERATIONS ===\n");
        
        // 1. Filter even numbers
        System.out.println("1. Even numbers:");
        List<Integer> evenNumbers = numbers.stream()
            .filter(n -> n % 2 == 0)
            .toList();
        System.out.println(evenNumbers);
        
        // 2. Names starting with 'A'
        System.out.println("\n2. Names starting with 'A':");
        List<String> namesWithA = names.stream()
            .filter(Objects::nonNull)
            .filter(n -> n.startsWith("A"))
            .toList();
        System.out.println(namesWithA);
        
        // 3. Convert to uppercase
        System.out.println("\n3. All names in uppercase:");
        List<String> upperNames = names.stream()
            .filter(Objects::nonNull)
            .filter(n -> !n.isEmpty())
            .map(String::toUpperCase)
            .toList();
        System.out.println(upperNames);
        
        // 4. Sort descending
        System.out.println("\n4. Numbers sorted descending:");
        List<Integer> sortedDesc = numbers.stream()
            .sorted(Comparator.reverseOrder())
            .toList();
        System.out.println(sortedDesc);
        
        // 5. Remove duplicates
        System.out.println("\n5. Unique numbers:");
        List<Integer> uniqueNumbers = numbers.stream()
            .distinct()
            .toList();
        System.out.println(uniqueNumbers);
    }
}