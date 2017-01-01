import java.util.ArrayList;
import java.util.List;

/**
 * Created by Filip on 2016-12-29.
 */
public class checked extends Thread {

    static List<Long> Primes = new ArrayList<>();
    static List<Long> realPrimes = new ArrayList<>();

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

    public static void main(String[] args) {

        (new main()).start();

        for(int i = 0; i < 100000; i++) {
            if(newIsPrime(i)) {
                System.out.println(i);
            }
        }
        System.out.println(minutes + ":" + seconds + ":" + milliseconds);
        for(int i = 0; i < 100000; i++) {
            if(isPrime(i)) {
                System.out.println(i);
            }
        }
        System.out.println("Checking if all primes are valid.");
        if(allValid(Primes, realPrimes)) {
            System.out.println("All are valid.");
        } else {
            System.out.println("They are not valid, the algorithm is not working as intended.");
        }

    }
    static boolean allValid(List<Long> primes, List<Long> realprimes) {
        for(int i = 1; i < primes.size(); i++) {
            if(!primes.equals(realprimes)) {
                return false;
            }
        }
        return true;
    }
    static boolean isPrime(long a) {
        if(a == 2)
            return true;
        if(a == 1)
            return false;
        if(a % 2 == 0)
            return false;
        for(long i = 3; i < a/2; i++) {
            if(a % i == 0) {
                return false;
            }
        }
        realPrimes.add(a);
        return true;
    }

    static boolean newIsPrime(long a) {
        if(a == 2)
            return true;
        if(a == 1)
            return false;
        if(a % 2 == 0)
            return false;
        for(long i : Primes) {
            long w = i;
            if(i < Math.sqrt(a) || i < 1000 && i < a/2) {
                if(a % i == 0) {
                    return false;
                }
            }
        }
        Primes.add(a);
        return true;
    }
}
