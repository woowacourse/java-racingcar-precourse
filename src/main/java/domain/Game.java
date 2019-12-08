package domain;

import java.util.List;

public interface Game {

    void gameStart(List<Car> users, int howManyPlay);

    List<String> getWinner(List<Car> users);


}
