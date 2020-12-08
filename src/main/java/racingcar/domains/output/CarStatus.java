package racingcar.domains.output;

import racingcar.domains.car.Car;

public class CarStatus implements Output {
    private static final String CAR_STATUS_PRINT_FORMAT = "%s : %s";
    private static final String MOVE_POINTER = "-";

    private Car car;

    public CarStatus(Car car) {
        this.car = car;
    }

    @Override
    public void print() {
        System.out.println(
                String.format(CAR_STATUS_PRINT_FORMAT, car.getName(), getMovePointer())
        );
    }

    private String getMovePointer() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < car.getPosition(); i++) {
            stringBuilder.append(MOVE_POINTER);
        }

        return stringBuilder.toString();
    }
}
