package billionaire.nitin.kumar.gupta.CtCI6thEdition1.Ch15ThreadsandLocks.IntroductionB;

public class ExampleB {
    public static void main(String args[]) {
        ThreadExample instance = new ThreadExample();
        instance.start();

        while (instance.count != 5) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }
    }
}
