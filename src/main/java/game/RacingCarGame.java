package game;

import com.sun.deploy.util.StringUtils;
import domain.Car;
import exception.InvalidInputException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingCarGame {
    private static final int CAR_NAME_LENGTH_LIMIT = 5;
    private static final String NOT_NUMBER_EXCEPTION_MESSAGE = "시도 횟수는 숫자만 입력할 수 있습니다.";
    private static final String NAME_OVER_LENGTH_EXCEPTION_MESSAGE = "자동차의 이름은 " + CAR_NAME_LENGTH_LIMIT + "을 넘을 수 없습니다.";
    private static final String NAME_DUPLICATION_EXCEPTION_MESSAGE = "자동차의 이름은 중복될 수 없습니다.";
    private static final String NAMES_SIZE_EXCEPTION_MESSAGE = "자동차 경주는 최소 2대의 차 이름이 필요합니다.";
    private static final String NAME_EMPTY_EXCEPTION_MESSAGE = "자동차 이름은 비어있을 수 없습니다.";
    private static final String CAR_NAME_ASK_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRIAL_TIMES_ASK_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String AWARDS_TAIL_MESSAGE = "가 우승했습니다.";
    private static final String CAR_NAME_DELIMITER = ",";

    private Host host;
    private int numberOfTimes;
    private Scanner gameScanner;
    private Random random;

    RacingCarGame() {
        gameScanner = new Scanner(System.in);
        random = new Random();
    }

    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.initGame();
        racingCarGame.runGame();
        racingCarGame.holdAwardsCeremony();
    }

    public void initGame() {
        initCars();
        initNumberOfTimes();
    }

    public void runGame() {
        for (int i = 0; i < numberOfTimes; i++) {
            host.runOneTime(random);
            host.showCarsStatus();
            System.out.println();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    public void holdAwardsCeremony() {
        System.out.println(makeCarsInFirstPositionString() + AWARDS_TAIL_MESSAGE);
    }

    private String makeCarsInFirstPositionString() {
        int firsPosition = host.measureFirstPosition();
        List<Car> carsInFirstPosition = host.takeCarsInFirstPosition(firsPosition);
        List<String> carNamesInFirstPosition = carsInFirstPosition.stream().map(Car::getName).collect(Collectors.toList());
        return StringUtils.join(carNamesInFirstPosition, CAR_NAME_DELIMITER);
    }

    private void initNumberOfTimes() {
        numberOfTimes = makeNumberOfTimes();
    }

    private int makeNumberOfTimes() {
        while (true) {
            try {
                String numberOfTimesString = takeNumberOfTimes();
                return Integer.parseInt(numberOfTimesString);
            } catch (NumberFormatException ne) {
                System.out.println(NOT_NUMBER_EXCEPTION_MESSAGE);
            }
        }
    }

    private void initCars() {
        List<String> names = makeNamesList();
        host = new Host(names);
    }

    private List<String> makeNamesList() {
        while (true) {
            try {
                String carNames = takeNames();
                List<String> names = convertToCarNames(carNames);
                validates(names);
                return names;
            } catch (InvalidInputException ie) {
                System.out.println(ie.getMessage());
            }
        }
    }

    private List<String> convertToCarNames(String carNames) {
        String[] namesArray = carNames.split(CAR_NAME_DELIMITER);
        List<String> names = new ArrayList<>();

        for (String name : namesArray) {
            names.add(name.trim());
        }

        return names;
    }

    private void validates(List<String> names) {
        checkLengthOverBasis(names);
        checkSize(names);
        checkEmptyName(names);
        checkDuplication(names);
    }

    private void checkLengthOverBasis(List<String> names) {
        for (String name : names) {
            if (name.length() > CAR_NAME_LENGTH_LIMIT) {
                throw new InvalidInputException(NAME_OVER_LENGTH_EXCEPTION_MESSAGE);
            }
        }
    }

    private void checkSize(List<String> names) {
        if (names.size() < 2) {
            throw new InvalidInputException(NAMES_SIZE_EXCEPTION_MESSAGE);
        }
    }

    private void checkEmptyName(List<String> names) {
        for (String name : names) {
            if (name.length() == 0) {
                throw new InvalidInputException(NAME_EMPTY_EXCEPTION_MESSAGE);
            }
        }
    }

    private void checkDuplication(List<String> names) {
        if (names.stream().distinct().count() != names.size()) {
            throw new InvalidInputException(NAME_DUPLICATION_EXCEPTION_MESSAGE);
        }
    }

    private String takeNames() {
        System.out.println(CAR_NAME_ASK_MESSAGE);
        return gameScanner.nextLine();
    }

    private String takeNumberOfTimes() {
        System.out.println(TRIAL_TIMES_ASK_MESSAGE);
        return gameScanner.nextLine();
    }

}
