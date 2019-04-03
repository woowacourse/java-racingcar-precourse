import domain.Car;
import util.InputUtil;
import util.RandomGenerator;

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
        while (time != 0) {
            tryOneTime(cars);
            time--;
        }
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
