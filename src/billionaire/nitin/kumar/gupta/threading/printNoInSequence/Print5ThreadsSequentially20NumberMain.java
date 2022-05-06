package billionaire.nitin.kumar.gupta.threading.printNoInSequence;

class PrintSequenceRunnable1 implements Runnable {

    static int number = 1;
    static Object lock = new Object();
    public int PRINT_NUMBERS_UPTO = 20;
    int remainder;

    public PrintSequenceRunnable1(int remainder) {
        this.remainder = remainder;
    }

    @Override
    public void run() {
        while (number < PRINT_NUMBERS_UPTO - 1) {
            synchronized (lock) {
                ///System.out.println(Thread.currentThread().getName()  +"  "+number +"  "+ remainder);
                while (number % 5 != remainder) { // wait for numbers other than remainder
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + number);
                number++;
                lock.notifyAll();
            }
        }
    }
}

public class Print5ThreadsSequentially20NumberMain {

    public static void main(String[] args) {

        PrintSequenceRunnable10 runnable1 = new PrintSequenceRunnable10(1);
        PrintSequenceRunnable10 runnable2 = new PrintSequenceRunnable10(2);
        PrintSequenceRunnable10 runnable3 = new PrintSequenceRunnable10(3);
        PrintSequenceRunnable10 runnable4 = new PrintSequenceRunnable10(4);
        PrintSequenceRunnable10 runnable5 = new PrintSequenceRunnable10(0);

        Thread t1 = new Thread(runnable1, "T1");
        Thread t2 = new Thread(runnable2, "T2");
        Thread t3 = new Thread(runnable3, "T3");
        Thread t4 = new Thread(runnable4, "T4");
        Thread t5 = new Thread(runnable5, "T5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}