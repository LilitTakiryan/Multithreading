package Sum;

public class SecondSum implements Runnable {
    int sLocalNumber; // number
    long sSum;

    public SecondSum(int sLocalNumber) {
        this.sLocalNumber = sLocalNumber;
    }

    public long getsSum() {
        return sSum;
    }

    public void setsSum(long sSum) {
        this.sSum = sSum;
    }

    @Override
    public void run() {
        int first = sLocalNumber/2;
        int last = sLocalNumber;

        try {
            sSum = ((long) first * (last + (first+1)) / 2);
            setsSum(sSum);
            System.out.println("Sum of number between " + first + " and " + last + " is " + sSum);
            Thread.sleep(2000);
        } catch (NumberFormatException | InterruptedException e) {
            e.getStackTrace();
        }
        long start = System.currentTimeMillis();
        System.out.println("T2 Processing time: " + (System.currentTimeMillis() - start / 1000));
        System.out.println("Thread name: " + Thread.currentThread().getName());
    }

 /*   public static void main(String[] args) {
       SecondSum secondSum = new SecondSum(100);
        Thread thread = new Thread(secondSum);
        thread.start();
    }
*/
}
