package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getPosition(){
        return position;
    }

    public void increase_one_position(){
        ++position;
    }
    // 추가 기능 구현
}
