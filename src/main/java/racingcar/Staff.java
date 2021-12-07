package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Staff {

    private static final String SEPARATOR = ",";
    private static final String WINNER_PREFIX = "최종 우승자 : ";

    Speaker speaker;
    Validator validator;

    public Staff() {
        this.speaker = new Speaker();
        this.validator = new Validator();
    }

    public String[] collectCarNames() {
        speaker.sayCarNames();
        String[] waitingCarNames = readCarNames();
        try {
            return validator.validateAllCarNames(waitingCarNames);
        } catch (IllegalArgumentException e) {
            speaker.sayErrorMessage(e.getMessage());
            return collectCarNames();
        }
    }

    public Integer collectRepeatTimes() {
        speaker.sayRepeatTimes();
        String rawRepeatTimes = readRepeatTimes();
        try {
            return validator.validateRepeatTimes(rawRepeatTimes);
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
        StringBuilder winnerList = new StringBuilder(WINNER_PREFIX);
        for (String winner : winners) {
            buildWinnerList(winnerList, winner);
        }
        formatProperWinnerList(winnerList);
        speaker.sayWinners(winnerList);
    }

    private String[] readCarNames() {
        String rawCarNames = readFromUser();
        return rawCarNames.split(SEPARATOR);
    }

    private String readFromUser() {
        return Console.readLine();
    }

    private String readRepeatTimes() {
        return readFromUser();
    }

    private void buildWinnerList(StringBuilder winnerList, String winner) {
        winnerList.append(winner).append(SEPARATOR).append(" ");
    }

    private void formatProperWinnerList(StringBuilder winnerList) {
        winnerList.deleteCharAt(lastCommaAndBlank(winnerList));
    }

    private int lastCommaAndBlank(StringBuilder winnerList) {
        return winnerList.length() - 2;
    }
}
