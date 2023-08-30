package Volatile;

import java.util.Scanner;

public class VolatileLauncher {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        myThread.shutdown();

    }

}

class MyThread extends Thread {

    private volatile boolean runner = true;

    public void run() {
        while (runner) {
            System.out.println("Hello my thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
    }

    public void shutdown() {
        this.runner = false;
    }

}