package billionaire.nitin.kumar.gupta.CtCI6thEdition1.Ch15ThreadsandLocks.IntroductionSynchronizedBlocks;

public class MyObject {
    public void foo(String name) {
        synchronized (this) {
            try {
                System.out.println("Thread " + name + ".foo(): starting");
                Thread.sleep(3000);
                System.out.println("Thread " + name + ".foo(): ending");
            } catch (InterruptedException exc) {
                System.out.println("Thread " + name + ": interrupted.");
            }
        }
    }
}
