package domain;

import java.util.Random;

public class Car {
    private static final int TRUE = 1;
    private static final int FALSE = 0;
    private final String name;
    private Random RANDOM = new Random();
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void proceed(){
        int randomInt = RANDOM.nextInt(10);
        int progress = checkIfProgress(randomInt);
        position += progress;
    }

    public int getPosition(){
        return position;
    }
    public String getName(){
        return name;
    }

    private int checkIfProgress(int dice){
        if(dice >= 4){
            return TRUE;
        }
        return FALSE;
    }
    // 추가 기능 구현
}
