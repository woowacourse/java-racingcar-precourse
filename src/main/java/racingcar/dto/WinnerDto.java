package racingcar.dto;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.model.Car;

public class WinnerDto {

    private final String name;

    public static List<WinnerDto> of(List<Car> cars) {
        return cars.stream()
                .map(car -> new WinnerDto(car.getName()))
                .collect(Collectors.toList());
    }

    private WinnerDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
