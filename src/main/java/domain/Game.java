package domain;

import java.io.IOException;
import java.util.List;

class Game {
    private final GameService gameService;

    Game() {
        gameService = new GameService();
    }

    void play() throws IOException {
        List<Car> carList = gameService.getCarList();
        int roundCount = gameService.getRoundCount();

        gameService.roundStart();
        for (int i = 0; i < roundCount; i++) {
            round(carList);
        }

        endGame(carList);
    }

    private void round(List<Car> carList) {
        for (Car car : carList) {
            car.move(moveOrNot());
        }
        gameService.setRoundResult(carList);
    }

    private int moveOrNot() {
        return (int) (Math.random() * 10) > 3 ? 1 : 0;
    }

    private void endGame(List<Car> carList) {
        gameService.makeWinnerList(carList);
    }

}
