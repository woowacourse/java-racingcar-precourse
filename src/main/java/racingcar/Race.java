package racingcar;

import utils.Printer;
import utils.RandomUtils;

public class Race {
    public static final int MOVE = 4;
    public static final int MINIMUM_RANGE = 0;
    public static final int MAXIMUM_RANGE = 9;

    private CarList carList;
    private int raceRound;

    public Race(CarList carList, int raceRound) {
        this.carList = carList;
        this.raceRound = raceRound;
    }

    public void runCarRace() {
        int roundIndex = 0;
        System.out.println("\n실행결과");
        while (roundIndex < raceRound) {
            moveCarRandomValue();
            roundIndex++;
            Printer.carRacingResultPrint(carList);
        }
    }

    private void moveCarRandomValue () {
        for (Car car : carList.getCarList()) {
            int moveStatus = RandomUtils.nextInt(MINIMUM_RANGE, MAXIMUM_RANGE);
            if (moveStatus >= MOVE) {
                car.setPosition(car.getPosition() + 1);
            }
        }
    }
}
