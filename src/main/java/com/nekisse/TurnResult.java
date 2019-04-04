package com.nekisse;

import com.nekisse.domain.Car;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TurnResult {
    private Map<String, String> turnResult;

    public Map<String, String> getTurnResult() {
        return turnResult;
    }

    public TurnResult(List<Car> cars) {
        this.turnResult = setupTurnResult(cars);
    }

    private Map<String, String> setupTurnResult(List<Car> cars) {
        turnResult = new HashMap<>();
        for (Car car : cars) {
            turnResult.put(car.getCarName(), carCurrentResult(car.getPosition()));

        }
        return turnResult;
    }

    private String carCurrentResult(int position) {
        StringBuilder currentMoveResult = new StringBuilder(" : ");
        for (int i = 0; i < position; i++) {
            currentMoveResult.append("-");
        }
        return String.valueOf(currentMoveResult);
    }
}
