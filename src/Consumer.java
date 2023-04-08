import java.util.Random;
public class Consumer  implements Runnable {
    private final Buffer buffer;
    private final String name;
    private static final Random random = new Random();

    public Consumer(Buffer buffer, String name) {
        this.buffer = buffer;
        this.name = name;
    }

    public void run() {
        while (true) {
            try {
                int number = buffer.removeNumber();
                System.out.println(name + " consume: " + number);
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
