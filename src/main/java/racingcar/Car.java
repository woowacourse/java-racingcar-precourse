package racingcar;

import utils.RandomUtils;

public class Car {
    private final String name;
    private int position = 0;
    private String bar = "-";

    public Car(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getPosition(){
        return position;
    }

    public void move(){
        int randNum = RandomUtils.nextInt(Constant.MIN_RANGE_NUM, Constant.MAX_RANGE_NUM);
        if(randNum >= Constant.ADVANCE_NUM){
            advance();
        }
    }

    public void advance(){
        position++;
    }

    public void print(){
        System.out.print(name + " : ");
        for(int i=0; i<position; i++){
            System.out.print(bar);
        }
        System.out.println();
    }
}
