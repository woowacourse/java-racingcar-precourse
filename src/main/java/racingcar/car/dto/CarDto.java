package racingcar.car.dto;

public class CarDto {
    private final String name;
    private final int position;

    public CarDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public String getState() {
        StringBuilder result = new StringBuilder(name + " : ");
        for(int i = 0; i < position; ++i) {
            result.append('-');
        }
        return result.toString();
    }
}
