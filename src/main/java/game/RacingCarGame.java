package game;

import com.sun.deploy.util.StringUtils;
import domain.Car;
import domain.Cars;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingCarGame {

    private Cars cars;
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
            cars.runOneTime(random);
            cars.showCarsStatus();
        }
    }

    public void holdAwardsCeremony() {
        System.out.println(makeCarsInFirstPositionString() + "가 우승했습니다.");
    }

    private String makeCarsInFirstPositionString() {
        int firsPosition = cars.measureFirstPosition();
        List<Car> carsInFirstPosition = cars.takeCarsInFirstPosition(firsPosition);
        List<String> carNamesInFirstPosition = carsInFirstPosition.stream().map(Car::getName).collect(Collectors.toList());
        return StringUtils.join(carNamesInFirstPosition, ", ");
    }

    private void initNumberOfTimes() {
        numberOfTimes = makeNumberOfTimes();
    }

    private int makeNumberOfTimes() {
        while(true) {
            try {
                String numberOfTimesString = takeNumberOfTimes();
                return Integer.parseInt(numberOfTimesString);
            } catch (NumberFormatException ne) {
                System.out.println("시도 횟수는 숫자만 입력할 수 있습니다.");
            }
        }
    }

    private void initCars() {
        List<String> names = makeNamesList();
        cars = new Cars(names);
    }

    private List<String> makeNamesList() {
        while(true) {
            try {
                String namesString = takeNames();
                List<String> names = Arrays.asList(namesString.split(","));
                validates(names);
                return names;
            } catch (IllegalArgumentException ie) {
                System.out.println(ie.getMessage());
            }
        }
    }

    private void validates(List<String> names) {
        if (checkLengthOverBasis(names)) {
            throw new IllegalArgumentException();
        }
        if (checkDuplication(names)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkLengthOverBasis(List<String> names) {
        for (String name : names) {
            if (name.length() > 5) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDuplication(List<String> names) {
        return names.stream().distinct().count() != names.size();
    }

    private String takeNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        return gameScanner.nextLine();
    }

    private String takeNumberOfTimes() {
        System.out.println("시도할 횟수는 몇회인가요?");
        return gameScanner.nextLine();
    }

}
