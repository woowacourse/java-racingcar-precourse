package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.race.RaceController;

public class RacingCarGameSystem {

    private static final String GAME_INPUT_MESSAGE = "경주 할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final RaceController raceController;

    public RacingCarGameSystem() {
        raceController = RaceController.getInstance();
    }

    public void play() {
        inputCarName();
        //TODO: 시도 횟수 만큼 경주 진행
        raceController.showRaceWinner();
    }

    private void inputCarName() {
        while(true) {
            System.out.println(GAME_INPUT_MESSAGE);
            String[] input = Console.readLine().split(",");
            if(raceController.isSatisfyAllCarName(input)) {
                return;
            }
        }
    }
}
