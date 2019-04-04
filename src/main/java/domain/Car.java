package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getCarName(){ return this.name;}

    public int getCarPosition() {return this.position;}

    public int RandomMove(){
        Random r = new Random();
        int random = r.nextInt(10);
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
            this.position++;
        }
        return;
    }
    // 추가 기능 구현
}
