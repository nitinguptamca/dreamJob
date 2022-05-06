package billionaire.nitin.kumar.gupta.CtCI6thEdition1.Ch15ThreadsandLocks.Q15_06_Synchronized_Methods;

public class MyThread extends Thread {
    public String name;
    public String firstMethod;
    private Foo foo;

    public MyThread(Foo f, String nm, String fM) {
        foo = f;
        name = nm;
        firstMethod = fM;
    }

    public void run() {
        if (firstMethod.equals("A")) {
            foo.methodA(name);
        } else {
            foo.methodB(name);
        }
    }
}
