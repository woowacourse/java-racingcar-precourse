package racingcar.dto;

import racingcar.domain.Car;

public class CarPositionDto {

    private final String name;
    private final int position;


    public static CarPositionDto of(Car car) {
        return new CarPositionDto(car.getName(), car.getPosition());
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
