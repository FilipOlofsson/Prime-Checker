import java.util.ArrayList;
import java.util.List;

/**
 * Created by Filip on 2016-12-29.
 */
public class slim extends Thread {

    static List<Long> Primes = new ArrayList<>();

    static int milliseconds = 0;
    static int seconds = 0;
    static int minutes = 0;

    boolean running = true;

    public void run() {
        while(running) {
            try {
                if(milliseconds == 100) {
                    seconds++;
                    milliseconds = 0;
                } else if(seconds == 60) {
                    minutes++;
                    seconds = 0;
                }
                milliseconds++;
                Thread.sleep(10);
            } catch(Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        (new main()).start();

        for(int i = 1; i < 1000000; i++) {
            isPrime(i);
        }
        System.out.println(minutes + ":" + seconds + ":" + milliseconds);
        Thread.sleep(3000);
        for(long i : Primes) {
            System.out.println(i);
        }
    }
    static boolean isPrime(long a) {
        if(a == 2)
            return true;
        if(a == 1)
            return false;
        if(a % 2 == 0)
            return false;
        for(long i : Primes) {
            long w = i;
            if(i < 1000 && i < a/2) {
                if(a % i == 0) {
                    return false;
                }
            } else if(i < Math.sqrt(a)) {
                if(a % i == 0) {
                    return false;
                }
            }
        }
        Primes.add(a);
        return true;
    }
}
