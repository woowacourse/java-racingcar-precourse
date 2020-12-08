package racingcar;

import java.util.ArrayList;

public interface IRacingGamePlayers {
    boolean trySetCars(String names);

    ArrayList<Car> getCars();

    ArrayList<Car> getWinner();
}
