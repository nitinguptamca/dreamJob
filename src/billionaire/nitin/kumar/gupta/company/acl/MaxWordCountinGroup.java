package billionaire.nitin.kumar.gupta.company.acl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toMap;

public class MaxWordCountinGroup {

    public static void main21(String[] args) {
        String str = "nitin. sachin Raji. sachin Raji nitin . Raji nitin raja rahim . " +
                "raja nitin . Raji nitin nitin kumar gupta.rakhs .nitin. sachin Raji.";
        /**
         * Problem statement is . first we parse the based on . dot seperator. then we
         * get group like [nitin , sachin Raji, sachin Raji nitin , Raji nitin raja
         * rahim , raja nitin ] Then which group contain maximum elements like in above
         * group bigger group "Raji nitin raja rahim " count is 4. and ans is groupis
         * [Raji nitin nitin kumar gupta.rakhs] count is 6.
         */
        /// Map<String ,Long> ssss=
        //Stream<String>  test	=null;


        Integer maxCount = Arrays
                .stream(str.split("\\."))
                .map(word -> new SimpleEntry<>(word, word.split(" ").length))
                .max(Entry.comparingByValue())
                .get().getValue();

        System.out.println("maxCount -->" + maxCount);

        Integer value = Arrays.stream(str.split("\\."))////.distinct()
                .map(word -> new SimpleEntry<>(word, word.split(" ").length)).max(Entry.comparingByValue()).get()
                .getValue();

        System.out.println("Value" + value);
        //solution2

        //

        /// ssss.forEach((key ,value ) ->System.out.println("key "+key +" value
        /// "+value));

    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/billionaire/nitin/kumar/gupta/company/TechMahendra/FunctionalInterfaceConceptCheck.java");

        Stream<String> fullfle = Files.lines(Paths.get("src/billionaire/nitin/kumar/gupta/company/TechMahendra/FunctionalInterfaceConceptCheck.java"));


        Map<String, Long> wordCount51 = Files
                .lines(path)
                .flatMap(line -> Arrays.stream(line.trim().split(" ")))
                .map(word -> word.replaceAll("[^a-zA-Z]", "")
                        .toLowerCase()
                        .trim())
                .filter(word -> word.length() > 0)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        //Spliterator<String>   test=fullfle.spliterator().trySplit();
        //	Files.lines(Paths.get("src/company/TechMahendra/FunctionalInterfaceConceptCheck.java"))
        //	.flatMap(linesss -> Arrays.stream(linesss.trim().split(" ")))
        //.map(word ->word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim()).filter(sss ->sss.length()>0)
        //	.map(word -> new SimpleEntry<>(word ,1)).collect(Collectors.groupingBy(Function.identity() ,Collectors.counting() , ));

        //String[] stringArray = fullfle.toArray(String[]::new);
        ////String[] stringArray1 = fullfle.toArray(size -> new String[size]);
        //Stream<String> ssss=Files.lines(path).flatMap(line -> Arrays.stream(line.trim().split(" ")));
        Map<String, Integer> wordCount = Files.lines(path).flatMap(line -> Arrays.stream(line.trim().split(" ")))
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim()).filter(word -> word.length() > 0)
                .map(word -> new SimpleEntry<>(word, 1)).sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
                .reduce(new LinkedHashMap<>(), (acc, entry) -> {
                    acc.put(entry.getKey(), acc.compute(entry.getKey(), (k, v) -> v == null ? 1 : v + 1));
                    return acc;
                }, (m1, m2) -> m1);

        /// wordCount.forEach((k, v) -> System.out.println(String.format("%s ==>> %d",
        /// k, v)));
        /// solution 2
        Map<String, Integer> wordCount2 = Files.lines(path).flatMap(line -> Arrays.stream(line.trim().split(" ")))
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim()).filter(word -> word.length() > 0)
                .map(word -> new SimpleEntry<>(word, 1))
                .collect(toMap(e -> e.getKey(), e -> e.getValue(), (v1, v2) -> v1 + v2));

        /// wordCount2.forEach((k, v) -> System.out.println(String.format("%s ==>> %d",
        /// k, v)));

        /// solution3

        Map<String, Long> wordCount3 = Files.lines(path).flatMap(line -> Arrays.stream(line.trim().split(" ")))
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim()).filter(word -> word.length() > 0)
                .map(word -> new SimpleEntry<>(word, 1))
                .collect(Collectors.groupingBy(SimpleEntry::getKey, Collectors.counting()));

        /// wordCount3.forEach((k, v) -> System.out.println(String.format("%s ==>> %d",
        /// k, v)));

        Map<String, Integer> wordCount4 = Files.lines(path).flatMap(line -> Arrays.stream(line.trim().split(" ")))
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim()).filter(word -> word.length() > 0)
                .map(word -> new SimpleEntry<>(word, 1))
                .collect(Collectors.groupingBy(SimpleEntry::getKey, summingInt(e -> 1)));
        // solution 4
        Map<String, Long> wordCount5 = Files.lines(path).flatMap(line -> Arrays.stream(line.trim().split(" ")))
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim()).filter(word -> word.length() > 0)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        wordCount5.forEach((k, v) -> System.out.println(String.format("%s ====>> %d", k, v)));
        /// I add how to sort the map by value:
        LinkedHashMap<String, Long> countByWordSorted = wordCount5.entrySet().stream()
                .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (v1, v2) -> {
                    throw new IllegalStateException();
                }, LinkedHashMap::new));
        ///Find most frequent item in collection

        String mostFrequentWoed = wordCount5.entrySet().stream()
                .max(Comparator.comparing(Entry::getValue))
                .map(Entry::getKey)
                .orElse(null);
        System.out.println(mostFrequentWoed);


    }

}
