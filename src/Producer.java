import java.util.Random;
public class Producer implements Runnable {
    private final Buffer buffer;
    private static final int MaxNumbers = 75;
    private static final Random random = new Random();

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 1; i <= MaxNumbers; i++) {
            try {
                buffer.addNumber(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(random.nextInt(2000) + 1000); // Intervalo de tiempo 1 a 3 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
