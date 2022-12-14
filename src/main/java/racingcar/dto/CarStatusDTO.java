package racingcar.dto;

import java.util.List;

public class CarStatusDTO {
    private final List<CarDTO> cars;

    public CarStatusDTO(List<CarDTO> cars) {
        this.cars = cars;
    }

    public List<CarDTO> getCars() {
        return cars;
    }
}
