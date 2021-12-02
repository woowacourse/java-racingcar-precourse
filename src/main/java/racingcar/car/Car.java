package racingcar.car;

import racingcar.car.dto.CarDto;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward() {
        this.position += CarService.GO_FORWARD_DISTANCE;
    }

    public CarDto getCarDto() {
        return new CarDto(name, position);
    }
}
