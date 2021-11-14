import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

class MyFile implements Runnable {
    public static void main(String[] args) throws FileNotFoundException {
        MyFile myFile = new MyFile();
        Thread T1 = new Thread(myFile, "T1");
        T1.setName("T1");
        T1.start();
        Thread T2 = new Thread(myFile, "T2");
        T2.setName("T2");
        T2.start();
    }

    @Override
    public void run() {

        int numOfFiles = 10;
        int numOfLines = 5000;

        final String path = "C:\\Users\\User\\IdeaProjects\\Multithreading\\src\\FilesLocation";
        try {
            for (int i = 0; i < numOfFiles; i++) {
                System.out.print("File #" + (i + 1) + " ");
                try {
                    File file = new File(path + "file" + UUID.randomUUID() + ".txt");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    PrintWriter data = new PrintWriter(file);
                    for (int z = 0; z < numOfLines; z++) {
                        data.println(UUID.randomUUID());
                    }
                    data.close();

                    System.out.println("File successfully created" + "Thread: " + Thread.currentThread().getName());

                } catch (IOException e) {
                    e.printStackTrace();
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long start = System.currentTimeMillis();
        System.out.println((System.currentTimeMillis() - start / 1000) + " " + Thread.currentThread().getName());
    }
}
/*

how to write code that compares processing time and tells which thread was faster
when run() method doesn't return arguments or take them?
thought of using set() method in run() but it's not possible to call it using thread,
could use object, but it is given as a parameter to Thread(), so no use from it

*/
