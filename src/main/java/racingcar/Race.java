package racingcar;

import utils.OutPutManager;
import utils.RandomUtils;

public class Race {
    private static final int MOVE = 4;
    private static final int MINIMUM_RANDOM_VALUE = 0;
    private static final int MAXIMUM_RANDOM_VALUE = 9;
    private static final int STARTING_POINT = 0;
    private static final String NEW_LINE = "\n";
    private static final String MOVE_CHARACTER = "-";

    private RaceCars raceCars;
    private int raceRound;

    public Race(RaceCars raceCars, int raceRound) {
        this.raceCars = raceCars;
        this.raceRound = raceRound;
    }

    public void runCarRace() {
        int roundIndex = STARTING_POINT;
        StringBuilder raceResult = new StringBuilder();

        while (roundIndex < raceRound) {
            moveOrStopByRandomValue();
            createRaceResult(raceResult, raceCars);
            roundIndex++;
        }
        OutPutManager.carRacingResultPrint(raceResult.toString());
    }

    private void moveOrStopByRandomValue() {
        for (Car car : raceCars.getRaceCars()) {
            int moveStatus = RandomUtils.nextInt(MINIMUM_RANDOM_VALUE, MAXIMUM_RANDOM_VALUE);
            if (moveStatus >= MOVE) {
                car.movePosition();
            }
        }
    }

    private void createRaceResult(StringBuilder raceResult, RaceCars raceCars) {
        for (Car car : raceCars.getRaceCars()) {
            raceResult.append(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                raceResult.append(MOVE_CHARACTER);
            }
            raceResult.append(NEW_LINE);
        }
        raceResult.append(NEW_LINE);
    }
}
