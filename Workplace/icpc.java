import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

class redbag extends Thread {
    public static int totalprice;
    private static final ReentrantLock lock = new ReentrantLock();

    redbag(int _totalprice) {
        totalprice = _totalprice;
    }

    int get_money() {
        Random v = new Random();
        int get = v.nextInt(0, totalprice);
        if (totalprice > get) {
            System.out.println(getName() + " " + totalprice + " " + get);
            totalprice -= get;
            return get;
        }
        return get_money();
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            lock.lock();
            try {
                get_money();
            } finally {
                lock.unlock();
            }
        }
    }
}

// public class Main {
// public static void main(String[] args) throws InterruptedException {
// redbag person1 = new redbag(0);
// redbag person2 = new redbag(100);

// person1.start();
// person2.start();
// }
// }