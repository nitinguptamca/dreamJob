package billionaire.nitin.kumar.gupta.threading.printNoInSequence;

class PrintSequenceRunnable2 implements Runnable {

    static int number = 1;
    static Object lock = new Object();
    public int PRINT_NUMBERS_UPTO = 10;
    int remainder;

    public PrintSequenceRunnable2(int remainder) {
        this.remainder = remainder;
    }

    @Override
    public void run() {
        while (number < PRINT_NUMBERS_UPTO - 1) {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "  " + number + "  " + remainder);
                while (number % 2 != remainder) { // wait for numbers other than remainder
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

public class Print2ThreadsSequentially10NumberMain {

    public static void main(String[] args) {

        PrintSequenceRunnable2 runnable1 = new PrintSequenceRunnable2(1);
        PrintSequenceRunnable2 runnable2 = new PrintSequenceRunnable2(0);

        Thread t1 = new Thread(runnable1, "T1");
        Thread t2 = new Thread(runnable2, "T2");

        t1.start();
        t2.start();
    }
}