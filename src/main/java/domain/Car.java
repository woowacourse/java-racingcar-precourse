package domain;
import java.util.Random;
import java.util.Scanner;

public class Car {
    private final String name;
    private int position = 0;
    private static Random rand = new Random(System.currentTimeMillis());

    public Car(String name) {
        this.name = name;
    }

    public boolean isGo(int val) {
        if(val >= 4) return true;
        return false;
    }
    
    public static Car[] makeCar(String names) {
        String[] name = names.split(",");
        Car[] result = new Car[name.length];
        for(int i = 0; i < name.length; i++) {
            result[i] = new Car(name[i]);
        }
        return result;
    }

    public static int makeRandInt() {
        return Car.rand.nextInt(10);
    }
    public static void main(String[]args) {
        Scanner stdIn = new Scanner(System.in);
        String names = stdIn.nextLine();
        Car[] cars = makeCar(names);

    }

    // 추가 기능 구현
}
