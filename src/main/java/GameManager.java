import domain.Car;
import util.InputUtil;
import util.OutputUtil;
import util.RandomGenerator;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private int time;
    private List<Car> cars;

    private GameManager() {
        this.time = 0;
        this.cars = new ArrayList<>();
    }

    private static class GameManagerHolder {
        public static final GameManager GAME_MANAGER_INSTANCE = new GameManager();
    }

    public static GameManager getInstance() {
        return GameManagerHolder.GAME_MANAGER_INSTANCE;
    }

    public void initGame() {
        cars = InputUtil.getCars();
        time = InputUtil.getTime();
        playGame();
    }

    private void playGame() {
        OutputView.printResult();
        while (time != 0) {
            tryOneTime(cars);
            OutputView.printProcess(cars);
            time--;
        }
        endGame();
    }

    private void endGame() {
        List<String> winners;
        winners = getWinner();
        OutputUtil.printWinners(winners);
    }

    private List<String> getWinner() {
        List<String> winners = new ArrayList<>();
        int maxNum = getMaxNum();
        for (Car car : cars) {
            if (car.getPosition() == maxNum) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int getMaxNum() {
        int maxNum = -1;
        for (Car car : cars) {
            if (maxNum < car.getPosition())
                maxNum = car.getPosition();
        }
        return maxNum;
    }

    private void tryOneTime(List<Car> cars) {
        for (Car car : cars) {
            goOrStop(car);
        }
    }

    private void goOrStop(Car car) {
        int randomNum = RandomGenerator.getRandomNumber();
        if (randomNum > 3) {
            car.move();
        }
    }
}
