package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.race.RaceController;
import utils.InputValidator;

public class RacingCarGameSystem {

    private static final String GAME_INPUT_MESSAGE = "경주 할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NUMBER_OF_RACES_MESSAGE = "시도할 횟수는 몇회인가요?";
    private final RaceController raceController;

    public RacingCarGameSystem() {
        raceController = RaceController.getInstance();
    }

    public void play() {
        inputCarName();
        raceController.race(inputNumberOfRaces());
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

    private int inputNumberOfRaces() {
        while(true) {
            System.out.println(NUMBER_OF_RACES_MESSAGE);
            String input = Console.readLine();
            if(InputValidator.isSatisfyNumberOfRaces(input)) {
                return Integer.parseInt(input);
            }
        }
    }
}
