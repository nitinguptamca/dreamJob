package billionaire.nitin.kumar.gupta.learnJava.methodreferences;

import billionaire.nitin.kumar.gupta.learnJava.data.Student;

import java.util.function.Supplier;

public class SupplierMethodReferenceExample {

    Supplier<Student> studentSupplier = Student::new;

    public static void main(String[] args) {

        System.out.println();

    }
}
