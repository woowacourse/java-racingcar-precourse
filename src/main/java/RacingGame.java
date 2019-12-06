import domain.Car;

import java.util.ArrayList;
import java.util.Scanner;


public class RacingGame {
    private static final String MESSAGE_ASK_TRIAL_NUMBER = "시도할 회수는 몇 회인가요?";
    private static final String MESSAGE_INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분";
    private static final String MESSAGE_NAME_LIMIT = "자동차 이름은 5글자 이하만 가능합니다.";
    private static final String MESSAGE_NOT_NATURAL_NUMBER = "0이 아닌 자연수가 아닙니다. 0이 아닌 자연수를 입력해주세요.";
    private static final String MESSAGE_WINNING = "가 최종 우승했습니다.";
    private static final String CAR_NAME_DELIMETER = ",";
    private static final String RACING_PROCESS_DELIMETER = ":";
    private static final String PROGRESS_BAR = "-";
    private static final String SPACE_BAR = "\n";
    private static Scanner scanner;


    private RacingGame() {
        scanner = new Scanner(System.in);    //어디 둘지, 곤란
        ArrayList<Car> cars = getCars();
        int numberOfTrial = getNumberOfTrial();
        Race(cars, numberOfTrial);
        //System.out.println(numberOfTrial);
    }

    public static void main(String[] args) {
        new RacingGame();
    }

    private String[] nameCars() {
        String[] splitedCarNames;

        do {
            System.out.println(MESSAGE_INPUT_CAR_NAMES);
            String carNames = scanner.nextLine();
            splitedCarNames = carNames.split(CAR_NAME_DELIMETER);
        } while (!validateCarNames(splitedCarNames));

        return splitedCarNames;
    }

    private boolean validateCarName(String carName) {
        return carName.length() <= 5;
    }

    private boolean validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (!validateCarName(carName)) {
                System.out.println(MESSAGE_NAME_LIMIT);
                return false;
            }
        }
        return true;
    }

    private int getNumberOfTrial() {
        String numberOfTrial;
        do {
            System.out.println(MESSAGE_ASK_TRIAL_NUMBER);
            numberOfTrial = scanner.nextLine();

        } while (!validateNaturalNumber(numberOfTrial));

        return Integer.parseInt(numberOfTrial);
    }

    private boolean validateNaturalNumber(String numberOfTrial) {
        try {
            if (Integer.parseInt(numberOfTrial) < 1) {
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            System.out.println(MESSAGE_NOT_NATURAL_NUMBER);
            return false;
        }
    }

    private void Race(ArrayList<Car> cars, int numberOfTrial) {
        for (int i = 0; i < numberOfTrial; i++) {
            for (Car car : cars) {
                car.move();
            }
            printRaceProcess(cars);
        }
        printRaceResult(cars);
    }

    private void printRaceResult(ArrayList<Car> cars) {
        int maxPostion = getMaxPostion(cars);
        ArrayList<String> winnerNames = getWinnerNames(cars, maxPostion);
        String winnerNameSerial = String.join(", ", winnerNames);
        System.out.println(winnerNameSerial + MESSAGE_WINNING);
    }

    private ArrayList<String> getWinnerNames(ArrayList<Car> cars, int maxPostion) {
        ArrayList<String> winnerNames = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPostion) {
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }

    private int getMaxPostion(ArrayList<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            if (maxPosition < car.getPosition()) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    private void printRaceProcess(ArrayList<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + RACING_PROCESS_DELIMETER + makeProgressBar(car.getPosition()));
        }
        System.out.print(SPACE_BAR);
    }

    private ArrayList<Car> getCars() {
        String[] carNames = nameCars();
        return makeCars(carNames);
    }

    private ArrayList<Car> makeCars(String[] carNames) {
        ArrayList<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }

    private String makeProgressBar(int position) {
        StringBuilder progress = new StringBuilder();
        for (int i = 0; i < position; i++) {
            progress.append(PROGRESS_BAR);
        }
        return progress.toString();
    }

}
