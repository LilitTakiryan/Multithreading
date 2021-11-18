//Java Program That counts sum of the numbers from 1 to 10000000 using single thread

package Sum;

import java.math.BigDecimal;

public class Sum implements Runnable {
    static int number;

    public Sum(int number) {
        Sum.number = number;
    }

    public static void main(String[] args) {
        int number=10000000;
        Sum sum = new Sum(number);
        Thread single = new Thread(sum);
        single.setName("Single");
        single.start();
        System.out.println(Thread.currentThread().getName());
        System.out.println("Number of active threads: " + Thread.activeCount());
    }

    @Override
    public void run() {
        int first = 1;
        int last = number;
        long sum;
        //n(n + 1)/2
        try {
            sum = ((long) last * (last + first)) / 2;
            System.out.println("Sum of number between " + first + " and " + last + " is " + sum);
            Thread.sleep(1000);
        } catch (NumberFormatException | InterruptedException e) {
            e.getStackTrace();
        }
        long start = System.currentTimeMillis();
        System.out.println("Processing time: " + (System.currentTimeMillis() - start / 1000));
        System.out.println("Thread name: " + Thread.currentThread().getName());
    }
}
