import java.util.*;
import java.util.stream.*;

public class AdvancedStreamOperations {
    
    public static void runExamples() {
        List<Integer> numbers = DataProvider.getNumbers();
        List<String> names = DataProvider.getNames();
        List<Student> students = DataProvider.getStudents();
        List<Employee> employees = DataProvider.getEmployees();
        
        System.out.println("\n\n=== ADVANCED OPERATIONS ===\n");
        
        // 26. Sort employees by salary then name
        System.out.println("26. Employees sorted by salary, then name:");
        employees.stream()
            .sorted(Comparator.comparingDouble(Employee::getSalary)
                    .thenComparing(Employee::getName))
            .forEach(System.out::println);
        
        // 27. Second highest number
        System.out.println("\n27. Second highest number:");
        Integer secondHighest = numbers.stream()
            .distinct()
            .sorted(Comparator.reverseOrder())
            .skip(1)
            .findFirst()
            .orElse(null);
        System.out.println(secondHighest);
        
        // 28. Find duplicates
        System.out.println("\n28. Duplicate numbers:");
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = numbers.stream()
            .filter(n -> !seen.add(n))
            .collect(Collectors.toSet());
        System.out.println(duplicates);
        
        // 29. Remove null or empty strings
        System.out.println("\n29. Valid names only:");
        List<String> validNames = names.stream()
            .filter(s -> s != null && !s.isBlank())
            .toList();
        System.out.println(validNames);
        
        // 30. Partition students pass/fail (pass >= 60)
        System.out.println("\n30. Students partitioned by pass/fail (pass >= 60):");
        Map<Boolean, List<Student>> passFail = students.stream()
            .collect(Collectors.partitioningBy(s -> s.getGrade() >= 60));
        System.out.println("PASS: " + passFail.get(true));
        System.out.println("FAIL: " + passFail.get(false));
    }
}
