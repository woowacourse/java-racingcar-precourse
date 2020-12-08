package racingcar;

import static utils.RandomUtils.nextInt;

public class Car {
    private final String name;
    private int position = 0;
    private int MIN_NUMBER = 0;
    private int MAX_NUMBER = 9;
    private String POSITION_MARK = "-";

    public Car(String name) {
        this.name = name;
    }

    // getter
    public String getCarName() { return name; }
    public int getCarPosition() { return position; }

    // 차량 이동 메서드
    public void moveCar(){
        if (nextInt(MIN_NUMBER,MAX_NUMBER) >= 4) {this.position += 1;}
    }

    // 차량 위치 출력 메서드
    public void printCarPosition(){
        System.out.println(name + " : " + new String(new char[position]).replace("\0",POSITION_MARK));
    }

}
