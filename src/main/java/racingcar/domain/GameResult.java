package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.car.Car;

public class GameResult {

    private final Player player;
    private Map<String, Integer> playerPosition = new LinkedHashMap<>();

    public GameResult(Player player) {
        this.player = player;
    }

    public void update() {
        List<Car> racingCars = player.getRacingCars();
        for (Car car : racingCars) {
            playerPosition.put(car.getName(), car.getPosition());
        }
    }

    public Map<String, Integer> getPlayerPosition() {
        return playerPosition;
    }

    public List<String> getFinalWinner() {
        List<String> finalWinner = new ArrayList<>();
        int maxValue = Collections.max(playerPosition.values());
        for (Map.Entry<String, Integer> m : playerPosition.entrySet()) {
            if (m.getValue() == maxValue) {
                finalWinner.add(m.getKey());
            }
        }
        return finalWinner;
    }
}
