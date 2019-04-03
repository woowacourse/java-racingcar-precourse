package domain;
import java.util.Scanner;

public class Car {
    private final String name;
    private int position = 0;

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
    public static void main(String[]args) {
        Scanner stdIn = new Scanner(System.in);
        String names = stdIn.nextLine();
        Car[] cars = makeCar(names);
        System.out.print(cars);
    }

    // 추가 기능 구현
}
