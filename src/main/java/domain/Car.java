package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward(){
        position++;
    }

    public int getPosition(){
        return position;
    }

    public String getName(){
        return name;
    }

    // 추가 기능 구현
}
