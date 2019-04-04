package domain;

public class Car implements Movable {
    private final String name;
    private int position = 0;

    private static final String CHAR_POSITION = "-";

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    @Override
    public void tryMove() {
        System.out.println("car tryMove called");
    }

    @Override
    public String toString() {
        System.out.println("car toString called");
        return "";
    }
}
