package racingcar;

import utils.RandomUtils;

public class Car {
    private final String name;
    private int position = 0;
    private final int moveCriteria = 3;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public int moveOrNot(){
        int computerNumber = RandomUtils.nextInt(0,9);
        if(computerNumber > moveCriteria){
            position +=1;
        }
        return position;
    }
    public String getName(){
        return name;
    }
}
