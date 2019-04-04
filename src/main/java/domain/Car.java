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
    public boolean gostop(){
        int num = random_value();
        if(num>=4) return true;
        return false;
    }

    // 추가 기능 구현
}
