//Напишите программу, которая создает два потока, каждый из которых выводит на экран числа от 1 до 10. Но при этом первый поток должен выводить только четные числа, а второй - только нечетные.

public class Task1 {

    static class Thread1 extends Thread {
        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                if (i % 2 == 0) {
                    System.out.println("thread 1: " + i);
                }
            }
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run(){
            for (int i = 1; i <= 10; i++) {
                if (i % 2 != 0) {
                    System.out.println("thread 2: " + i);
                }
            }
        }
    }
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();

        thread1.start();
        thread2.start();
    }
}
