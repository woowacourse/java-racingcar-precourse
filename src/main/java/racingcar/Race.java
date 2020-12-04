package racingcar;

import utils.OutPutPrinter;
import utils.RandomUtils;

public class Race {
    public static final int MOVE = 4;
    public static final int MINIMUM_RANGE = 0;
    public static final int MAXIMUM_RANGE = 10;
    public static final String NEW_LINE = "\n";
    public static final int INITIAL_VALUE = 0;

    private CarList carList;
    private int raceRound;
    private String raceResult;

    public Race(CarList carList, int raceRound) {
        this.carList = carList;
        this.raceRound = raceRound;
    }

    public void runCarRace() {
        int roundIndex = INITIAL_VALUE;
        while (roundIndex < raceRound) {
            moveCarRandomValue();
            createRaceResult(carList);
            roundIndex++;
        }
        OutPutPrinter.carRacingResultPrint(raceResult);
    }

    private void moveCarRandomValue () {
        for (Car car : carList.getCarList()) {
            int moveStatus = RandomUtils.nextInt(MINIMUM_RANGE, MAXIMUM_RANGE);
            if (moveStatus >= MOVE) {
                car.setPosition(car.getPosition() + 1);
            }
        }
    }

    private void createRaceResult(CarList carList) {
        StringBuilder result = new StringBuilder();

        for (Car car : carList.getCarList()) {
            result.append(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                result.append("-");
            }
            result.append(NEW_LINE);
        }
        raceResult += result.toString() + NEW_LINE;
    }
}
