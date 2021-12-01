package racingcar;

import java.util.Arrays;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition(){
        return position;
    }

    public void goForward(){
        position++;
    }

    public String showPosition(){
        char[] positionBars=new char[position];
        Arrays.fill(positionBars,'-');
        String currentPosition=new String(positionBars);

        return name+" : "+currentPosition;
    }
    // 추가 기능 구현
}
