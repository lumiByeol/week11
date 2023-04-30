
import java.util.Random;

// Создайте программу, которая будет имитировать гонки на машине. У вас есть две машины, каждая из которых может двигаться со случайной скоростью в диапазоне от 1 до 5 метров в секунду. Заезд должен начинаться одновременно для обеих машин, и победитель определяется той машиной, которая пройдет заранее заданное расстояние.
public class Task4 {
    static int distance = 50;
    static int maxSpeed = 5;
    static int minSpeed = 1;
    static int car1distance = 0;
    static int car2distance = 0;

    public static void main(String[] args) {
        System.out.println("Race start!");

        Random random = new Random();
        int car1speed = random.nextInt(maxSpeed - minSpeed + 1) + minSpeed;
        int car2speed = random.nextInt(maxSpeed - minSpeed + 1) + minSpeed;
        Thread car1 = new Thread() {
            public void run() {
                while (car1distance < distance && car2distance < distance) {
                    car1distance = car1distance + car1speed;
                    System.out.println("Car 1 is at the " + car1distance + " mark");
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e) {
                        System.out.println("Error " + e);
                    }
                }
                if (car1distance >= 50) {
                    System.out.println("Car 1 wins the race!");
                }
            }
        };

        Thread car2 = new Thread() {
            public void run() {
                while (car2distance < distance && car1distance < distance) {
                    car2distance = car2distance + car2speed;
                    System.out.println("Car 2 is at the " + car2distance + " mark");
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e) {
                        System.out.println("Error " + e);
                    }
                }
                if (car2distance >= 50) {
                    System.out.println("Car 2 wins the race!");
                }
            }
        };

        car1.start();
        car2.start();
    }
}
