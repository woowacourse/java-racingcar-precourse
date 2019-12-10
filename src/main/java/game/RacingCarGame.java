package game;

import com.sun.deploy.util.StringUtils;
import domain.Car;
import exception.InvalidInputException;

import java.util.ArrayList;
import java.util.Arrays;
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
    private static final Scanner GAME_SCANNER = new Scanner(System.in);
    private static final Random RANDOM_NUMBER_GENERATOR = new Random();

    private Host host;

    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.initCars();
        int trialTimes = racingCarGame.initNumberOfTimes();
        racingCarGame.runGame(trialTimes);
        racingCarGame.holdAwardsCeremony();
    }

    public void initCars() {
        while (true) {
            try {
                List<String> names = makeNamesList();
                host = new Host(names);
                break;
            } catch (InvalidInputException ie) {
                System.out.println(ie.getMessage());
            }
        }
    }

    private List<String> makeNamesList() {
        String carNames = takeNames();
        List<String> names = convertToCarNames(carNames);
        return names;
    }

    private List<String> convertToCarNames(String carNames) {
        return Arrays.asList(carNames.split(CAR_NAME_DELIMITER));
    }

    public int initNumberOfTimes() {
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

    public void runGame(int trialTimes) {
        for (int i = 0; i < trialTimes; i++) {
            host.runOneTime(RANDOM_NUMBER_GENERATOR);
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

    private String takeNames() {
        System.out.println(CAR_NAME_ASK_MESSAGE);
        return GAME_SCANNER.nextLine();
    }

    private String takeNumberOfTimes() {
        System.out.println(TRIAL_TIMES_ASK_MESSAGE);
        return GAME_SCANNER.nextLine();
    }

}
