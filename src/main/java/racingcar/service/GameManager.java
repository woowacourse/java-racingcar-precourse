package racingcar.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.resource.rule.RunnableCondition;
import racingcar.service.picker.NumberPicker;

public class GameManager {

    private final NumberPicker numberPicker;

    private Map<String, Car> carMap = new LinkedHashMap<>();
    private int winnerPosition = 0;

    public GameManager(NumberPicker numberPicker) {
        this.numberPicker = numberPicker;
    }

    public void registerNames(List<String> names) {
        names.forEach(name -> carMap.put(name, new Car(name)));
    }

    public void playRound() {
        carMap.forEach((name, car) -> {
            if (RunnableCondition.isRunnable(numberPicker.pickOne())) {
                car.forward();
            }
            if (car.isFatherThan(winnerPosition)) {
                winnerPosition++;
            }
        });
    }

    public List<String> getStatuses() {
        return carMap.values().stream().map(Car::toString).collect(Collectors.toList());
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        carMap.forEach((name, car) -> {
            if (car.isSamePosition(winnerPosition)) {
                winners.add(name);
            }
        });
        return winners;
    }

}
