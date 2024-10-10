package ejer2_hilos;

class Counter {
    int count = 0;

    public void increment() {
        count += 1000;
    }

    public int getCount() {
        return count;
    }
}

class MyThread extends Thread {
    Counter counter;

    public MyThread(Counter counter) {
        this.counter = counter;
    }


    public void run() {
        counter.increment();
    }
}

public class Simple1 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        MyThread[] threads = new MyThread[5];

        for (int i = 0; i < 5; i++) {
            threads[i] = new MyThread(counter);
            threads[i].start();
        }

        for (int i = 0; i < 5; i++) {
            threads[i].join();
        }

        System.out.println("Valor final del contador: " + counter.getCount());
    }
}

