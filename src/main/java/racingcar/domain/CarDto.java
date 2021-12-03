package racingcar.domain;

public class CarDto {

    private final String name;
    private final int position;

    public CarDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static CarDto form(Car car) {
        return new CarDto(car.name(), car.position());
    }

    public String name() {
        return name;
    }

    public int position() {
        return position;
    }
}
