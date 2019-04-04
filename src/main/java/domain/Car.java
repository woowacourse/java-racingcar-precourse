package domain;
import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    public int random_value(){
        Random generator = new Random();
        return generator.nextInt(10);
    }

    // 추가 기능 구현
}
