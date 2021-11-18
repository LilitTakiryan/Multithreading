package Sum;

import java.util.SortedMap;

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
