package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Game implements IGame{
    @Override
    public String startGame(String[] names, int count) {
        Randoms.pickNumberInRange(0, 9);
        return null;
    }
}
