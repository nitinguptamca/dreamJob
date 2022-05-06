package billionaire.nitin.kumar.gupta.java8;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrectiseJava8 {
    public static void main1(String[] args) {
        List<Integer> l1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> l2 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> l3 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<List<Integer>> lists = Arrays.asList(l1, l2, l3);
        Optional<Integer> maxVal = l3.stream().reduce(Integer::max);

        IntStream.range(0, l1.size())
                .reduce((a, b) -> l1.get(a) < l1.get(b) ? b : a)
                .ifPresent(ix -> System.out.println("Index " + ix + ", value " + l1.get(ix)));

        int sss = lists.stream().mapToInt(List::size).max().getAsInt();
        System.out.println(sss);
        List ddddd = lists.stream().max(Comparator.comparing(List::size)).get();
        lists.stream().map(List::size).max(Comparator.naturalOrder()).get();
        Optional<List<Integer>> list = lists.stream().reduce((a, b) -> a.size() > b.size() ? a : b);
        int sss11 = lists.stream().mapToInt(x -> x.size()).max().getAsInt();


    }

    public static void main(String[] args) {
        List<Person> persons = new LinkedList<>();
        Map<String, List<Person>> mapOfMostPopulatedCity = persons.stream()
                .collect(Collectors.groupingBy(Person::getCity))
                .entrySet()
                .stream()
                .max(Comparator.comparingInt(e -> e.getValue().size()))
                .map(e -> Collections.singletonMap(e.getKey(), e.getValue()))
                .orElseThrow(IllegalArgumentException::new);

        Map<String, List<Person>> resultMap = new HashMap<>();
        persons.stream()
                .collect(Collectors.groupingBy(Person::getCity)) //group by city gives Map<String,List<Person>>
                .entrySet()
                .stream()
                .max(Comparator.comparingInt(value -> value.getValue().size())) // return the Optional<Entry<String, List<Person>>>
                .ifPresent(entry -> resultMap.put(entry.getKey(), entry.getValue()));


    }
}
