package billionaire.nitin.kumar.gupta.learnJava.functionalInterfaces;

import billionaire.nitin.kumar.gupta.learnJava.data.Student;
import billionaire.nitin.kumar.gupta.learnJava.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionStudentExample {

    static Function<List<Student>, Map<String, Double>> function = (students -> {

        Map<String, Double> studentGradeMap = new HashMap<>();
        students.forEach((student -> {

            if (PredicateStudentExample.p1.test(student)) {
                studentGradeMap.put(student.getName(), student.getGpa());
            }
        }));

        return studentGradeMap;

    });

    public static void main(String[] args) {

        System.out.println(function.apply(StudentDataBase.getAllStudents()));

    }
}
