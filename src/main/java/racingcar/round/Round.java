package racingcar.round;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Car;

public class Round {
    private static final int RAN_MIN = 0;
    private static final int RAN_MAX = 9;
    private static final int MAGINOT = 3;

    public static void play(Car target, int drawResult) {
        if(drawResult > MAGINOT) {
            target.move();
        }
    }

    public static int draw() {
        return Randoms.pickNumberInRange(RAN_MIN, RAN_MAX);
    }

}
