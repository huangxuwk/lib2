package src.com.jd.leetcode.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Interupt implements Runnable {
    private static final Lock lock = new ReentrantLock();
    private volatile int selected;

    public Interupt(int select) {
        this.selected = select;
    }
    @Override
    public void run() {
        if (selected == 0) {
            try {
                lock.lockInterruptibly();
                for (int i = 0; i < 1000; i++) {
                }
                lock.unlock();
            } catch (InterruptedException e) {
                System.out.println("线程一说：我不想等了");
            }
        } else if (selected == 1) {
            try {
                lock.lockInterruptibly();
                Thread.sleep(1000);
                lock.unlock();
                System.out.println("线程二说： 锁我用完了");
            } catch (InterruptedException e) {
            }

        }
    }

    public static void main(String[] args) {
        Thread one = new Thread(new Interupt(0));
        Thread two = new Thread(new Interupt(1));
        two.start();
        one.start();
        one.interrupt();
    }

}
