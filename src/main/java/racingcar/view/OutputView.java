package racingcar.view;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static racingcar.view.Constants.*;

public class OutputView {

    public static void printRaceResults(Map<String, Integer> raceResults) {
        System.out.println(RACE_RESULT_MSG);
        for (String carName : raceResults.keySet()) {
            String distance = String.join(
                "", Collections.nCopies(raceResults.get(carName), DISTANCE)
            );
            System.out.println(carName + RESULT_DELIMETER + distance);
        }
    }

    public static void printFinalWinners(List<String> finalWinners) {
        String winners = String.join(FINAL_WINNERS_DELIMETER, finalWinners);
        System.out.print(FINAL_WINNERS_MSG + RESULT_DELIMETER + winners);
    }

    public static void printErrorMsg(Exception e) {
        System.out.println(ERROR + e.getMessage());
    }
}
