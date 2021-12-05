package racingcar;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
		Race race = new Race(new ArrayList<>());
		RacingGame racingGame = new RacingGame(race);
		racingGame.startRacingGame();
    }
}
