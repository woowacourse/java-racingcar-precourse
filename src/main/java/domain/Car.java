package domain;

/**
 * @author 김시영
 * @since 2019-12-05
 * @apiNote 사용자별로, 자동차를 생성하고 경주하기 위한 클래스입니다.
 */
public class Car {
    private final String name;

    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void goForwardPosition(boolean goOrStop) {
        if (goOrStop) {
            position++;
        }
    }

}
