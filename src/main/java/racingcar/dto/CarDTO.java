package racingcar.dto;

public class CarDTO {
    private final String name;
    private final int position;

    public CarDTO(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
