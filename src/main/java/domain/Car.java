package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getCarName(){
        return name;
    }

    public int RandomMove(){
        Random r = new Random();
        int random = r.nextInt(9) + 1;
        return random;
    }

    public boolean DecideToMove(){
        int random = RandomMove();
        if(random>=4){
            this.position += 4;
            return true;
        }
        return false;
    }
    // 추가 기능 구현
}
