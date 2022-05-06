package billionaire.nitin.kumar.gupta.learnJava.functionalInterfaces;

import billionaire.nitin.kumar.gupta.learnJava.data.Student;
import billionaire.nitin.kumar.gupta.learnJava.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateAndConsumerExample {

    static Predicate<Student> p1 = (s) -> s.getGradeLevel() >= 3;

    static Predicate<Student> p2 = (s) -> s.getGpa() >= 3.9;

    BiConsumer<String, List<String>> studentBiConsumer = (name, activities) -> System.out.println(name + " : " + activities);

    Consumer<Student> studentConsumer = (student) -> {

        if (p1.and(p2).test(student)) {
            studentBiConsumer.accept(student.getName(), student.getActivities());
        }
    };

    Consumer<Student> studentConsumer1 = ((student) -> {

        if (p1.and(p2).test(student)) {
            studentBiConsumer.accept(student.getName(), student.getActivities());
        }
    });

    public static void main(String[] args) {

        List<Student> studentList = StudentDataBase.getAllStudents();

        new PredicateAndConsumerExample().printNameandActivities(studentList);

    }

    public void printNameandActivities(List<Student> studentList) {

        studentList.forEach(studentConsumer);

    }
}
