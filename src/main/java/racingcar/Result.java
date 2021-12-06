package racingcar;

public class Result {
    private static final String DASH = "-";
    private static final String COLON = " : ";
    private static final String NEW_LINE = "\n";

    private static int max;
    private final CarList carList;

    public Result(CarList carList) {
        this.carList = carList;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : carList.getCarList()) {
            updateMax(car.getPosition());
            stringBuilder.append(car.getName()).append(COLON).append(makeDash(car.getPosition())).append(NEW_LINE);
        }

        return stringBuilder.toString();
    }

    private void updateMax(int pos) {
        if (max < pos) {
            max = pos;
        }
    }

    public static int getMax() {
        return max;
    }

    private String makeDash(int count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append(DASH);
        }

        return stringBuilder.toString();
    }
}
