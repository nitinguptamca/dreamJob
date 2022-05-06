package billionaire.nitin.kumar.gupta.learnJava;

import billionaire.nitin.kumar.gupta.learnJava.data.Student;
import billionaire.nitin.kumar.gupta.learnJava.data.StudentDataBase;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Main {

    BinaryOperator<List<String>> binaryOperator = (a, b) -> {
        System.out.println("input 1 : " + a + "input 2 : " + b);
        return a;
    };

    public static void main(String[] args) {

        new Main().listToMap();

        LocalTime localTime = LocalTime.of(23, 59);
        LocalTime localTime1 = LocalTime.of(00, 59);
        System.out.println(localTime.compareTo(localTime1));
        System.out.println(localTime1.compareTo(localTime));

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.getHour());

    }

    public void listToMap() {

        Map<String, List<String>> result1 = StudentDataBase.getAllStudents().stream().collect(
                Collectors.toMap(Student::getName, Student::getActivities, binaryOperator));
        System.out.println("Result 1 : " + result1);

    }
}