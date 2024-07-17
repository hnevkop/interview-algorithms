package other;

/**
 * Description: Each thread runs a separate block of code:
 *
 * <p>Thread 1: Acquires lock1 (synchronized block). Sleeps for 100 milliseconds (simulates some
 * processing). Tries to acquire lock2 (deadlock occurs here).
 *
 * <p>Thread 2: Acquires lock2 (synchronized block). Sleeps for 100 milliseconds. Tries to acquire
 * lock1 (deadlock occurs here).
 *
 * <p>OUTPUT:
 * Thread 1: Acquired lock1
 * Thread 2: Acquired lock2
 * Thread 1: Waiting for lock2
 * Thread 2: Waiting for lock1
 */
public class DeadlockExample {
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(DeadlockExample::method1);
        Thread thread2 = new Thread(DeadlockExample::method2);

        thread1.start();
        thread2.start();
    }

    public static void method1() {
        synchronized (lock1) {
            System.out.println("Thread 1: Acquired lock1");
            sleep();
            System.out.println("Thread 1: Waiting for lock2");
            synchronized (lock2) {
                System.out.println("Thread 1: Acquired lock2");
            }
        }
    }

    public static void method2() {
        synchronized (lock2) {
            System.out.println("Thread 2: Acquired lock2");
            sleep();
            System.out.println("Thread 2: Waiting for lock1");
            synchronized (lock1) {
                System.out.println("Thread 2: Acquired lock1");
            }
        }
    }

    public static void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
