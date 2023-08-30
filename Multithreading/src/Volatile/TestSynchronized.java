package Volatile;

public class TestSynchronized {

    private int counter;

    public static void main(String[] args) throws InterruptedException{
        TestSynchronized testSynchronized = new TestSynchronized();
        testSynchronized.doWork();   
    }

    private synchronized void increment(){
        counter++;
    }

//      private void increment(){
//        synchronized (this){
//            counter++;
//        }
//      }

    private void doWork() throws InterruptedException{
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++)
                    increment();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++)
                    increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(counter);
    }
}
