package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) { this.name = name; }

    /**
     * 자동차의 위치를 정해진 거리만큼 이동시킨다.
     */
    public void move(){
        this.position += ConstValue.MOVE_DISTANCE;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}