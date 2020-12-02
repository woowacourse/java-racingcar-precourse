package racingcar;

import java.util.HashMap;

public class RacingGamePlay {
    static int gameCount = 0;
    static int maxRace = 0;
    static HashMap<String, Integer> racingPlayBoard = new HashMap<String, Integer>();

    public static int runTimes() {
        for (String carName : racingPlayBoard.keySet()) {
            checkMoveCar(carName);
        }
        return ++gameCount;
    }

    public static void checkMoveCar(String carName) {
          if(RacingCarMovement.moveCar()) {
              racingPlayBoard.put(carName, racingPlayBoard.get(carName) + 1);
              findMaxRunner(racingPlayBoard.get(carName) + 1);
          }
    }

    public static void findMaxRunner(int position) {
        if(position > maxRace) {
            maxRace = position;
        }
    }

}
