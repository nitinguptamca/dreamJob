package billionaire.nitin.kumar.gupta.CtCI6thEdition1.Ch15ThreadsandLocks.IntroductionLocks;

import billionaire.nitin.kumar.gupta.CtCI6thEdition1.CtCILibrary.AssortedMethods;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyClass extends Thread {
    public int delta = 0;
    private NoLockATM noLockATM;
    private LockedATM lockedATM;
    private Lock completionLock;

    public MyClass(NoLockATM atm1, LockedATM atm2) {
        noLockATM = atm1;
        lockedATM = atm2;
        completionLock = new ReentrantLock();
    }

    public void run() {
        completionLock.lock();
        int[] operations = AssortedMethods.randomArray(20, -50, 50);
        for (int op : operations) {
            delta += op;
            if (op < 0) {
                int val = op * -1;
                noLockATM.withdraw(val);
                lockedATM.withdraw(val);
            } else {
                noLockATM.deposit(op);
                lockedATM.deposit(op);
            }
        }
        completionLock.unlock();
    }

    public void waitUntilDone() {
        completionLock.lock();
        completionLock.unlock();
    }
}
