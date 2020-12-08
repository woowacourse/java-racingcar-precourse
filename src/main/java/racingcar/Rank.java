package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Rank {

    public ArrayList<String> judgeWinner(ArrayList<Car> cars) {
        Collections.sort(cars);

        int winnerPosition = cars.get(0).getPosition();
        ArrayList<String> winnerNames =
                cars.stream().filter(it -> it.getPosition() == winnerPosition)
                        .map(it -> it.getName()).collect(Collectors.toCollection(ArrayList::new));

        return winnerNames;
    }
}
