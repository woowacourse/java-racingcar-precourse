package racingcar;

import utils.RandomUtils;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    //test
    public void Print(){
        System.out.println(name);
        System.out.println(position);
    }

    protected void StopOrGo(){
        if(RandomUtils.nextInt(0, 9) >= 4)
            position++;
    }

    public int GetPosition(){
        return position;
    }
}
