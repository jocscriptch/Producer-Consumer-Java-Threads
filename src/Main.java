import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> numbers = new LinkedList<>();
        Buffer buffer = new Buffer(numbers);
        Thread producerThread = new Thread(new Producer(buffer));

        Consumer[] consumers = new Consumer[10];
        Thread[] consumerThreads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            consumers[i] = new Consumer(buffer, "Jugador " + (i + 1));
            consumerThreads[i] = new Thread(consumers[i]);
        }
        producerThread.start();
        for (Thread thread : consumerThreads) {
            thread.start();
        }
    }
}