package racingcar;
import camp.nextstep.edu.missionutils.Randoms;


public class Car {
    private final String name;
    private int position = 0;
    private static final int STANDARD = 4;

    public Car(String name) {
        this.name = name;
    }

    public void movement() {
        int randomData = Randoms.pickNumberInRange(0, 9);
        if (randomData >= STANDARD) {
            position += 1;
        }
    }
}
