package com.demo.jvm;

/**
 * JVM调优
 * 死锁代码
 */
public class TestDeadLock {

    public void run() {

        MyThread mt = new MyThread();
        new Thread(mt, "张三").start();
        new Thread(mt, "李四").start();

    }

    public static void main(String[] args) {
        new TestDeadLock().run();
    }

    class MyThread implements Runnable {

        private Object o1 = new Object();
        private Object o2 = new Object();

        private boolean flag = false;

        public void run() {
            if (flag) {
                flag = false;
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + "have o1");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o2) {
                        System.out.println(Thread.currentThread().getName() + "have o2");
                    }
                }
            } else {
                flag = true;
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + "have o2");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o1) {
                        System.out.println(Thread.currentThread().getName() + "have o1");
                    }
                }
            }
        }
    }


}
