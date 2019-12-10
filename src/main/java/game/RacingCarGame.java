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

    private static final int MINIMUM_TRIAL_TIMES = 1;
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

    private void initNumberOfTimes() {
        numberOfTimes = makeNumberOfTimes();
    }

    private int makeNumberOfTimes() {
        while (true) {
            try {
                String numberOfTimesString = takeNumberOfTimes();
                int number = Integer.parseInt(numberOfTimesString);
                validatesNumberOfTimes(number);
                return number;
            } catch (NumberFormatException ne) {
                System.out.println(InvalidInputException.NOT_NUMBER_EXCEPTION_MESSAGE);
            } catch (InvalidInputException ie) {
                System.out.println(ie.getMessage());
            }
        }
    }

    private void validatesNumberOfTimes(int number) {
        if (number < MINIMUM_TRIAL_TIMES) {
            throw new InvalidInputException(InvalidInputException.INVALID_TRIAL_TIME_EXCEPTION_MESSAGE);
        }
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
                throw new InvalidInputException(InvalidInputException.NAME_OVER_LENGTH_EXCEPTION_MESSAGE);
            }
        }
    }

    private void checkSize(List<String> names) {
        if (names.size() < 2) {
            throw new InvalidInputException(InvalidInputException.NAMES_SIZE_EXCEPTION_MESSAGE);
        }
    }

    private void checkEmptyName(List<String> names) {
        for (String name : names) {
            if (name.length() == 0) {
                throw new InvalidInputException(InvalidInputException.NAME_EMPTY_EXCEPTION_MESSAGE);
            }
        }
    }

    private void checkDuplication(List<String> names) {
        if (names.stream().distinct().count() != names.size()) {
            throw new InvalidInputException(InvalidInputException.NAME_DUPLICATION_EXCEPTION_MESSAGE);
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
