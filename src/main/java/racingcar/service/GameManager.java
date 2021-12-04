package racingcar.service;

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
        });
    }

    public List<String> getStatuses() {
        return carMap.values().stream().map(Car::toString).collect(Collectors.toList());
    }

}
