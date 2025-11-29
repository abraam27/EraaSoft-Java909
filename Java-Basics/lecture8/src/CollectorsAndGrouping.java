import java.util.*;
import java.util.stream.*;

public class CollectorsAndGrouping {
    
    public static void runExamples() {
        List<Integer> numbers = DataProvider.getNumbers();
        List<String> names = DataProvider.getNames();
        List<Student> students = DataProvider.getStudents();
        List<Employee> employees = DataProvider.getEmployees();
        
        System.out.println("\n\n=== COLLECTORS & GROUPING ===\n");
        
        // 16. Group students by department
        System.out.println("16. Students grouped by department:");
        Map<String, List<Student>> byDepartment = students.stream()
            .collect(Collectors.groupingBy(Student::getDepartment));
        byDepartment.forEach((dept, list) -> {
            System.out.println(dept + ": " + list);
        });
        
        // 17. Partition numbers into even/odd
        System.out.println("\n17. Numbers partitioned into even/odd:");
        Map<Boolean, List<Integer>> evenOdd = numbers.stream()
            .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Even: " + evenOdd.get(true));
        System.out.println("Odd: " + evenOdd.get(false));
        
        // 18. Comma-separated string
        System.out.println("\n18. Names as comma-separated string:");
        String joined = names.stream()
            .filter(Objects::nonNull)
            .filter(n -> !n.isEmpty())
            .collect(Collectors.joining(", "));
        System.out.println(joined);
        
        // 19. Group employees by age and count
        System.out.println("\n19. Employee count by age:");
        Map<Integer, Long> countByAge = employees.stream()
            .collect(Collectors.groupingBy(Employee::getAge, Collectors.counting()));
        System.out.println(countByAge);
        
        // 20. Average salary per department
        System.out.println("\n20. Average salary by department:");
        Map<String, Double> avgSalaryByDept = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)
            ));
        avgSalaryByDept.forEach((dept, avg) -> 
            System.out.printf("%s: EGP %.2f\n", dept, avg));
    }
}