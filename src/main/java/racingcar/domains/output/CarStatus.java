package racingcar.domains.output;

public class CarStatus implements Output {
    private static final String CAR_STATUS_PRINT_FORMAT = "%s : %s";
    private static final String MOVE_POINTER = "-";

    private String carName;
    private int position;

    public CarStatus(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    @Override
    public void print() {
        System.out.println(
                String.format(CAR_STATUS_PRINT_FORMAT, carName, getMovePointer())
        );
    }

    private String getMovePointer() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < position; i++) {
            stringBuilder.append(MOVE_POINTER);
        }

        return stringBuilder.toString();
    }
}
