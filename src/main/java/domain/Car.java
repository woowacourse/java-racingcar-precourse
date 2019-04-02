package domain;

import com.sun.javafx.css.CalculatedValue;
import java.util.Calendar;
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

    public boolean DecideToMove(int random){
        if(random>=4){
            return true;
        }
        return false;
    }

    public void CalculateLocation(int random){
        if(!DecideToMove(random)){
            this.position += random;
        }
        return;
    }
    // 추가 기능 구현
}
