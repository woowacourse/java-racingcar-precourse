package racingcar;

import controller.CarController;
import controller.Vendor;
import preprocess.InputPreProcess;

import java.math.BigInteger;
import java.util.List;
import java.util.regex.Pattern;

public class GameBoard {


    private static final int PIVOT_NUMBER = 4;
    private static final int ERROR = -1;
    private static final int MAX_LAP_NUMBER = 10000;

    private static final String RESULT = "실행결과";
    private static final String FINAL_WINNER = "최종 우승자";
    private static final String LINE = "-";
    private static final String DIVIDE = ":";

    private static final String LAP_REGEX = "^[0-9]*$";

    private static final String LAP_ARGUMENT_ERROR = "[ERROR] 시도할 횟수는 양수이여야만 합니다.";
    private static final String LAP_MAXIMUM_EXCEEDED_ERROR = "[ERROR] 시도할 횟수가 너무 많습니다.";

    private static final String REDO_ANNOUNCE = "다시 시도해 주세요.";

    private InputPreProcess input;
    private CarController cars;

    public GameBoard(InputPreProcess input, CarController cars) {
        this.input = input;
        this.cars = cars;
    }

    public boolean getNames(String str) {

        String[] names = input.getNames(str);

        if (names == null) {
            System.out.println(REDO_ANNOUNCE);
            return false;
        }

        addCars(names);
        return true;
    }

    public boolean startRace(String lapStr) {

        int lap = checkLap(lapStr);
        if (lap == ERROR) {
            System.out.println(REDO_ANNOUNCE);
            return false;
        }

        racing(lap);

        return true;
    }

    private void racing(int lap) {

        System.out.println(RESULT);
        for (int i = 0; i < lap; i++) {

            moveCars();
            System.out.println(printAllCarStatus());
        }
        System.out.println(printWinners());
    }

    private int checkLap(String lap) {
        if (!checkLapNumberValid(lap)) {
            System.out.println(LAP_ARGUMENT_ERROR);
            return ERROR;
        }

        return checkLapRange(lap);
    }

    private int checkLapRange(String lap) {

        BigInteger tmp = new BigInteger(lap);
        BigInteger max = new BigInteger(String.valueOf(MAX_LAP_NUMBER));
        if (tmp.compareTo(max) > 0) {
            System.out.println(LAP_MAXIMUM_EXCEEDED_ERROR);
            return ERROR;
        }

        return Integer.parseInt(lap);
    }

    private boolean checkLapNumberValid(String lap) {
        return Pattern.matches(LAP_REGEX, lap);
    }

    private String printWinners() {
        StringBuilder sb = new StringBuilder();
        sb.append(FINAL_WINNER + DIVIDE + " ");

        List<Car> winners = cars.getWinners();

        for (int i = 0; i < winners.size() - 1; i++) {
            sb.append(winners.get(i).getName()).append(", ");
        }
        sb.append(winners.get(winners.size() - 1).getName());

        return sb.toString();
    }

    private String printAllCarStatus() {

        StringBuilder sb = new StringBuilder();

        for (Car car : cars.getAllCars()) {
            sb.append(printCarStatus(car)).append("\n");
        }
        sb.append("\n");

        return sb.toString();
    }

    private String printCarStatus(Car car) {

        StringBuilder sb = new StringBuilder();

        sb.append(car.getName()).append(" ").append(DIVIDE).append(" ");

        for (int i = 0; i < car.getPosition(); i++) {
            sb.append(LINE);
        }

        return sb.toString();
    }

    private void moveCars() {

        for (Car car : cars.getAllCars()) {
            if (canGo()) {
                car.moveForward();
            }
        }
    }

    private boolean canGo() {
        return Vendor.roll() >= PIVOT_NUMBER;
    }

    private void addCars(String[] names) {

        for (String name : names) {
            cars.addCar(new Car(name));
        }
    }


}
