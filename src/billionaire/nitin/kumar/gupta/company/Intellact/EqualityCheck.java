package billionaire.nitin.kumar.gupta.company.Intellact;

public class EqualityCheck {
    public static void main(String[] args) {

        String s = "java";
        Object o = s;
        if (o.equals(s)) {
            System.out.println("A");
        } else {
            System.out.println("B");
        }
        if (s.equals(o)) {
            System.out.println("C");
        } else {
            System.out.println("D");
        }

    }

}
