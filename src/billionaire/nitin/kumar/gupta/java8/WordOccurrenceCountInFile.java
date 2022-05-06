package billionaire.nitin.kumar.gupta.java8;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordOccurrenceCountInFile {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/billionaire/nitin/kumar/gupta/java8/Person.java");
        List<String> dontest1 = Files.lines(path).collect(Collectors.toList());
        String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        String[] words = contents.split("[\\P{L}]+");

        List<Map.Entry<String, Long>> testing = null;
        Map<String, Long> eeee = Arrays
                .stream(words)
                .filter(str -> str.length() > 0)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<String ,Long> sss = new HashMap<>();
        Optional<Map.Entry<String, Long>> maxEntry = eeee.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue));

        maxEntry.orElseThrow(() -> new NoSuchElementException());
    }
    public static void main12(String[] args) throws IOException {
        Path path = Paths.get("src/get/job/in/best/organization/challenge/GetLargestPalindromeInStringChallenge.java");
        Stream<String> data = Files.lines(path);
        Stream<String> sepData = data.flatMap(line -> Arrays.stream(line.split(" ")));
        Map<String, Long> wordsCound = sepData.map(words -> words.replaceAll("[^a-zA-z]", "").toLowerCase().trim())
                .filter(str -> str.length() > 0)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        wordsCound.entrySet().stream().iterator().forEachRemaining(wor -> {
            System.out.println(wor.getKey() + "  " + wor.getValue());
        });

        /*Map<String, Integer> sdfsdfs = sepData.map(words -> words.replaceAll("[^a-zA-z]", "").toLowerCase().trim())
                .filter(str -> str.length() > 0)
                .collect(Collectors.toMap(w -> w, w -> 1, Integer::sum));*/


        Optional<Map.Entry<String, Long>> ssss = wordsCound.entrySet().stream().sorted(Comparator.comparingLong(wordsC -> wordsC.getValue()))
                .findFirst();
        System.out.println("********************************");
        ssss.ifPresent(ss -> {
            System.out.println(ss.getKey() + "  " + ss.getValue());
        });

        Map.Entry<String, Long> mostFreequentWord1 = wordsCound.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(new AbstractMap.SimpleEntry<>("Invalid", 0l));

        System.out.println(mostFreequentWord1.getKey() + +mostFreequentWord1.getValue());

        wordsCound.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(s -> {
                    System.out.println(s.getKey() + "  " + s.getValue());
                });

    }

}
