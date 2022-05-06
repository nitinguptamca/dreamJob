package billionaire.nitin.kumar.gupta.arrayProbkems;

public class ReverseArrayInt {
    public static void main(String[] args) {
        //reverse int value 12345 -->> 54321
        int value = 12345;
        System.out.println(reverseInt(value));
    }

    public static int reverseInt(int value) {
        int remainder = 0;
        int reversed = 0;
        while (value > 0) {
            remainder = value % 10;
            value = value / 10;
            reversed = reversed * 10 + remainder;
        }
        return reversed;
    }
}
