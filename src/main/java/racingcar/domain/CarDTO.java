package racingcar.domain;

public class CarDTO {
    private final String name;
    private final int position;

    public CarDTO(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
