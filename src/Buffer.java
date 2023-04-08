import java.util.Queue;
public class Buffer {
    private final Queue<Integer> numbers;
    private static final int MaxPlayers = 10;
    public Buffer(Queue<Integer> numbers) {
        this.numbers = numbers;
    }

    public synchronized void addNumber(int number) throws InterruptedException {
        while (numbers.size() >= MaxPlayers) {
            wait();
        }
        numbers.offer(number);
        System.out.println("Produciendo: " + number);
        notifyAll();
    }
    public synchronized int removeNumber() throws InterruptedException {
        while (numbers.isEmpty()) {
            wait();
        }
        int number = numbers.poll();
        notifyAll();
        return number;
    }

}
