package racingcar.domain;

public class Car {
    private static final String HYPHEN = "-";
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        this.position++;
    }

    public StringBuilder generatePositionToHyphen() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getPosition(); i++) {
            sb.append(HYPHEN);
        }
        return sb;
    }

    @Override
    public String toString() {
        return name + " : " + generatePositionToHyphen();
    }
}
