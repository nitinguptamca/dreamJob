package billionaire.nitin.kumar.gupta.threading.printNoInSequence;

class PrintSequenceRunnable10 implements Runnable {

    static int number = 1;
    static Object lock = new Object();
    public int PRINT_NUMBERS_UPTO = 100;
    int remainder;

    public PrintSequenceRunnable10(int remainder) {
        this.remainder = remainder;
    }

    @Override
    public void run() {
        while (number < PRINT_NUMBERS_UPTO - 1) {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "    " + number + "    " + remainder + "     " + number % 10);
                while (number % 10 != remainder) { // wait for numbers other than remainder
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

public class Print10ThreadsSequentially100NumberMain {

    public static void main(String[] args) {

        PrintSequenceRunnable10 runnable1 = new PrintSequenceRunnable10(1);
        PrintSequenceRunnable10 runnable2 = new PrintSequenceRunnable10(2);
        PrintSequenceRunnable10 runnable3 = new PrintSequenceRunnable10(3);
        PrintSequenceRunnable10 runnable4 = new PrintSequenceRunnable10(4);
        PrintSequenceRunnable10 runnable5 = new PrintSequenceRunnable10(5);
        PrintSequenceRunnable10 runnable6 = new PrintSequenceRunnable10(6);
        PrintSequenceRunnable10 runnable7 = new PrintSequenceRunnable10(7);
        PrintSequenceRunnable10 runnable8 = new PrintSequenceRunnable10(8);
        PrintSequenceRunnable10 runnable9 = new PrintSequenceRunnable10(9);
        PrintSequenceRunnable10 runnable10 = new PrintSequenceRunnable10(0);

        Thread t1 = new Thread(runnable1, "T1");
        Thread t2 = new Thread(runnable2, "T2");
        Thread t3 = new Thread(runnable3, "T3");
        Thread t4 = new Thread(runnable4, "T4");
        Thread t5 = new Thread(runnable5, "T5");
        Thread t6 = new Thread(runnable6, "T6");
        Thread t7 = new Thread(runnable7, "T7");
        Thread t8 = new Thread(runnable8, "T8");
        Thread t9 = new Thread(runnable9, "T9");
        Thread t10 = new Thread(runnable10, "T10");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
    }
}