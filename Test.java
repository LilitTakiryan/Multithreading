/*Write Java Program That counts sum of the numbers from 1 to 10000000  **   MutiThread (with 2 threads)*/
package Sum;
public class Test {
    public static void main(String[] args) throws InterruptedException {
        int number = 1000000;
            FirstSum firstSum = new FirstSum(number);
            Thread T1 = new Thread(firstSum);
            T1.setName("T1");
            T1.start();

            SecondSum secondSum = new SecondSum(number);
            Thread T2 = new Thread(secondSum);
            T2.setName("T2");
            T2.start();

            System.out.println("Get first sum " + firstSum.getfSum());
            System.out.println("Get second sum " + secondSum.getsSum());
            Thread.sleep(9000);
            System.out.println("Sum fo numbers between 1 to " + number + " is " + (firstSum.getfSum() + secondSum.getsSum()));
    }
}

///******************************************** FirstSum.java *******************************************//
public class FirstSum implements Runnable {
    int fLocalNumber; // number
    long fSum;
    public FirstSum(int fLocalNumber) {
        fLocalNumber = fLocalNumber / 2;
        this.fLocalNumber = fLocalNumber;
    }
    public long getfSum() {
        return fSum;
    }
    public void setfSum(long fSum) {
        this.fSum = fSum;
    }
    @Override
    public void run() {
        int first = 1;
        int last = fLocalNumber;

        try {
            fSum = ((long) last * (last + first)) / 2;
            setfSum(fSum);
            System.out.println("Sum of number between " + first + " and " + last + " is " + fSum);
            Thread.sleep(5000);
        } catch (NumberFormatException | InterruptedException e) {
            e.getStackTrace();
        }
        long start = System.currentTimeMillis();
        System.out.println("T1 Processing time: " + (System.currentTimeMillis() - start / 1000));
        System.out.println("Thread name: " + Thread.currentThread().getName());
    }
}

///*********************************************** SecondSum.java  ***********************************//
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
}

