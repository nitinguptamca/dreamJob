package billionaire.nitin.kumar.gupta.CtCI6thEdition1.Ch08RecursionandDynamicProgramming.Q8_06_Towers_of_Hanoi;

import java.util.Stack;

public class Tower {
    public String name;
    private Stack<Integer> disks = new Stack<Integer>();

    public void add(int d) {
        if (!disks.isEmpty() && disks.peek() <= d) {
            System.out.println("Error placing disk " + d);
        } else {
            disks.push(d);
        }
    }

    public void moveTopTo(Tower t) {
        int top = disks.pop();
        t.add(top);
    }

    public void print() {
        System.out.println("Contents of Tower " + name + ": " + disks.toString());
    }

    public void moveDisks(int quantity, Tower destination, Tower buffer) {
        if (quantity <= 0) return;

        moveDisks(quantity - 1, buffer, destination);
        System.out.println("Move " + disks.peek() + " from " + this.name + " to " + destination.name);
        moveTopTo(destination);
        buffer.moveDisks(quantity - 1, destination, this);
    }
}
