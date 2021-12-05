package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Staff {

    Speaker speaker;
    Validator validator;

    public Staff() {
        this.speaker = new Speaker();
        this.validator = new Validator();
    }

    public String[] collectCarNames() {
        speaker.sayCarNames();
        String[] waitingCarNames = Console.readLine().split(",");
        for (int i = 0; i < waitingCarNames.length; i++) {
            waitingCarNames[i] = waitingCarNames[i].trim();
            String carName = waitingCarNames[i];
            try {
                validator.validateCarName(carName);
            } catch (IllegalArgumentException e) {
                speaker.sayErrorMessage(e.getMessage());
                return collectCarNames();
            }
        }
        return waitingCarNames;
    }

    public Integer collectRepeatTimes() {
        speaker.sayRepeatTimes();
        String rawRepeatTimes = Console.readLine();
        try {
            Integer repeatTimes = validator.convertToNumber(rawRepeatTimes);
            validator.validateRepeatTimes(repeatTimes);
            return repeatTimes;
        } catch (IllegalArgumentException e) {
            speaker.sayErrorMessage(e.getMessage());
            return collectRepeatTimes();
        }
    }

    public void startRace() {
        speaker.sayRacingStart();
    }

    public void announceScoreBoard(List<Car> lineup) {
        for (Car car : lineup) {
            speaker.sayPresentCarLocation(car.getName(), car.getPosition());
        }
        speaker.newLine();
    }

    public void awardWinners(List<String> winners) {
        StringBuilder winnerList = new StringBuilder("최종 우승자 : ");
        for (String winner : winners) {
            winnerList.append(winner).append(",");
        }
        winnerList.deleteCharAt(winnerList.length() - 1);
        speaker.sayWinners(winnerList);
    }
}
