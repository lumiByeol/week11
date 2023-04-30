//Напишите программу, которая создает два потока и выводит на экран числа от 1 до 10, сначала из первого потока, затем из второго потока. Каждое число должно быть выведено в формате "Поток X: число Y", где X - номер потока (1 или 2), а Y - число от 1 до 10.

public class Task2 {
    public static class Thread1 implements Runnable {
        @Override

        public void run() {
            for (int i = 1; i < 11; i++) {
                System.out.println("Thread 1: number " + i);
            }
        }
    }

    public static class Thread2 implements Runnable {
        @Override

        public void run() {
            for (int i = 1; i < 11; i++) {
                System.out.println("Thread 2: number " + i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());

        thread1.start();
        thread1.join();
        thread2.start();
    }
}
