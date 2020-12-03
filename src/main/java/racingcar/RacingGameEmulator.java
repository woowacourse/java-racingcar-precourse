package racingcar;

import java.util.ArrayList;

public class RacingGameEmulator {

    private final int MAX_TIMES;

    private ArrayList<Car> racingCars = new ArrayList<>();

    public RacingGameEmulator(String carNameInput, int MAX_TIMES) {
        this.MAX_TIMES = MAX_TIMES;

        String[] carNames = carNameInput.split(",");
        for (String carName : carNames) {
            Car car = new Car(carName.trim());
            racingCars.add(car);
        }
    }

    public void startRacingGame(int times) {
        for(int i = 0; i < times; i++) {
            RacingGamePlay thisTime = new RacingGamePlay(racingCars);
            thisTime.runTimes(racingCars);
        }
    }
}













    /*
    private final int TIMES;

    public static boolean gameOn;
    public static int winnerValue;
    public static ArrayList<String> winners;
    static HashMap<String, Integer> racingPlayResult;

    public RacingGameEmulator(int TIMES) {
        this.TIMES = TIMES;
        winners = new ArrayList<String>();
    }

    public void playGame() {
        while(RacingGamePlay.runTimes() != TIMES) {
            RacingGameSystemMessageOut.printEachMoves(RacingGamePlay.racingPlayBoard);
        }
        RacingGameSystemMessageOut.printEachMoves(RacingGamePlay.racingPlayBoard);
    }

    public void getResults() {
        racingPlayResult = RacingGamePlay.racingPlayBoard;
        winnerValue = RacingGamePlay.maxRace;
    }

    public void updateWinners(HashMap<String, Integer> racingPlayResult) {
        for(String carName : racingPlayResult.keySet()) {
            if (racingPlayResult.get(carName) == winnerValue) {
                winners.add(carName);
            }
        }
    }
     */
