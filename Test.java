/*Write Java Program That counts sum of the numbers from 1 to 10000000  **   MutiThread (with 2 threads)*/
package Sum;
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
        Thread.sleep(4000);
        System.out.println("Get first sum " + firstSum.getfSum());
        Thread.sleep(4000);
        System.out.println("Get second sum " + secondSum.getsSum());

        System.out.println("Sum fo numbers between 1 to " + number + " is " + (firstSum.getfSum() + secondSum.getsSum()));
        System.out.println("Overall processing time: " + (firstSum.getTime() + secondSum.getTime()));

        if (firstSum.getTime() > secondSum.getTime()) {
            System.out.println(T2.getName() + " is faster than " + T1.getName());
        } else System.out.println(T1.getName() + " is faster than " + T2.getName());

    }

///******************************************** FirstSum.java *******************************************//
package Sum;

public class FirstSum implements Runnable {
    int fLocalNumber; // number
    long fSum;
    long time;

    public FirstSum(int fLocalNumber) {
        fLocalNumber = fLocalNumber / 2;
        this.fLocalNumber = fLocalNumber;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getfSum() {
        return fSum;
    }

    public void setfSum(long fSum) {
        this.fSum = fSum;
    }

    @Override
    synchronized public void run() {
        int first = 1;
        int last = fLocalNumber;
        long procTime;
        try {
            fSum = ((long) last * (last + first)) / 2;
            setfSum(fSum);
            System.out.println("Sum of number between " + first + " and " + last + " is " + fSum);
            Thread.sleep(1000);
        } catch (NumberFormatException | InterruptedException e) {
            e.getStackTrace();
        }
        long start = System.currentTimeMillis();
        procTime = (System.currentTimeMillis() - start / 1000);
        setTime(procTime);
        System.out.println(Thread.currentThread().getName() + " Processing time: " + time);
    }
}

///*********************************************** SecondSum.java  ***********************************//
public class SecondSum implements Runnable {
    int sLocalNumber; // number
    long sSum;
    long time;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

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
    synchronized public void run() {
        int first = sLocalNumber / 2;
        int last = sLocalNumber;
        long procTime;
        try {
            sSum = ((long) first * (last + (first + 1)) / 2);
            setsSum(sSum);
            System.out.println("Sum of number between " + first + " and " + last + " is " + sSum);
            Thread.sleep(1000);
        } catch (NumberFormatException | InterruptedException e) {
            e.getStackTrace();
        }
        long start = System.currentTimeMillis();
        procTime = (System.currentTimeMillis() - start / 1000);
        setTime(procTime);
        System.out.println(Thread.currentThread().getName() + " Processing time: " + time);
    }
}
