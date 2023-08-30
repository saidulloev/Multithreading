public class Test {

    public static void main(String[] args) throws InterruptedException {

        MyThread myThread1 = new MyThread();
        myThread1.start();

        MyThread myThread2 = new MyThread();
        myThread2.start();
//        System.out.println("I'm going sleep");
//        Thread.sleep(3000);
//        System.out.println("I awake");

    }

}

class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello my thread  " + i);
        }
    }
}