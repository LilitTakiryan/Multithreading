package Sum;

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

    /*public static void main(String[] args) {
        FirstSum firstSum = new FirstSum(100);
        Thread thread = new Thread(firstSum);
        thread.start();
    }*/

}
