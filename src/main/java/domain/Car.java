package domain;
import  java.util.Random;

public class Car {
    private final static int CRITERIA = 4;
    private final String name;
    private int position = 0;
    private Random random = new Random();

    public Car(String name) {
        this.name = name;
    }

    
    // 추가 기능 구현

    public String getName(){
        return name;
    }
    public int getPosition(){
        return position;
    }

    public void run(){
        if(canRun())
            position=position+1;
    }

    public boolean canRun(){
        return random.nextInt(9)>=CRITERIA;
    }



}
