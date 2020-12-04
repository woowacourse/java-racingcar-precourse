package racingcar;

import java.util.ArrayList;
import java.util.Collections;

public class Rank {

    public ArrayList<String> judgeWinner(ArrayList<Car> cars) {
        Collections.sort(cars);
        ArrayList<String> winnerNames = new ArrayList<>();

        String winnerName = cars.get(0).getName();
        int winnerPosition = cars.get(0).getPosition();
        winnerNames.add(winnerName);

        for (int index = 1; index < cars.size(); index++) {
            if (cars.get(index).getPosition() != winnerPosition) {
                break;
            }
            winnerNames.add(cars.get(index).getName());
        }

        return winnerNames;
    }
}
