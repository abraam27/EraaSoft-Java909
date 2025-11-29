import java.util.*;
import java.util.stream.*;

public class OptionalMapFlatMap {

    public static void runExamples() {
        List<String> names = DataProvider.getNames();
        List<List<String>> nestedWords = DataProvider.getNestedWords();

        System.out.println("\n\n=== OPTIONAL, MAP, FLATMAP ===\n");

        // 21. Flatten list of lists
        System.out.println("21. Flattened nested words:");
        List<String> flattened = nestedWords.stream()
                .flatMap(List::stream)
                .toList();
        System.out.println(flattened);

        // 22. Extract unique characters
        System.out.println("\n22. Unique characters from all names:");
        Set<Character> uniqueChars = names.stream()
                .filter(Objects::nonNull)
                .filter(n -> !n.isEmpty())
                .flatMapToInt(String::chars)
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
        System.out.println(uniqueChars);

        // 23. Filter non-empty Optionals
        System.out.println("\n23. Non-empty optional names:");
        List<Optional<String>> optionalNames = Arrays.asList(
                Optional.of("Ali"), Optional.empty(), Optional.of("Mona"), Optional.empty());
        List<String> nonEmptyOptionals = optionalNames.stream()
                .flatMap(Optional::stream)
                .toList();
        System.out.println(nonEmptyOptionals);

        // 24. Map strings to lengths
        System.out.println("\n24. Name lengths:");
        List<Integer> nameLengths = names.stream()
                .filter(Objects::nonNull)
                .filter(n -> !n.isEmpty())
                .map(String::length)
                .toList();
        System.out.println(nameLengths);

        // 25. Uppercase words starting with 'A'
        System.out.println("\n25. Uppercase names starting with 'A':");
        List<String> upperA = names.stream()
                .filter(Objects::nonNull)
                .filter(n -> n.startsWith("A"))
                .map(String::toUpperCase)
                .toList();
        System.out.println(upperA);
    }
}