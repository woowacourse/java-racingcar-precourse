package domain;
import  java.util.Random;

public class Car {
    private final static int criteria = 4;
    private final String name;
    private int position = 0;
    private Random random = new Random();

    public Car(String name) {
        this.name = name;
    }

    
    // 추가 기능 구현
    public void run(){
        if(canRun())
            position=position+1;
    }

    public boolean canRun(){
        return random.nextInt(9)>=criteria;
    }



}
