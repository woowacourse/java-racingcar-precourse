package racingcar.dto;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.model.Cars;

public class CarPositionDto {

    private final String name;
    private final int position;

    public static List<CarPositionDto> of(Cars cars) {
        return cars.getCars()
                .stream()
                .map(car -> new CarPositionDto(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
    }

    private CarPositionDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
