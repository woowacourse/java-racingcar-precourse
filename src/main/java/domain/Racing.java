package domain;

import java.util.*;

public class Racing {
    private static final String NAME_LENGTH_ERROR = "이름이 5자가 넘었습니다. 다시 작성해주세요.";
    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_MISMATCH_ERROR = "정수만 입력해 주세요! ";
    private static final String INPUT_RUN_GAME_COUNT = "시도할 횟수는 몇회인가요?";
    private static final String GAME_RESULT = "실행 결과\n";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final int NAME_LENGTH_LIMIT = 5;
    private static final int CAR_MOVE_STANDARD_NUMBER = 4;

    public void run() {
        List<Car> carList = getCarList(inputCarNames());
        int roundCount = getRoundCount();

        System.out.println(GAME_RESULT);

        for (int i = 0; i < roundCount; i++) {
            runOneRound(carList);
            printResult(carList);
            System.out.printf("\n\n");
        }
        printWinnerName(carList);
    }

    private void printWinnerName(List<Car> carList) {
        List<String> winner = getWinnerName(carList);
        System.out.println(String.join(",", winner) + WINNER_MESSAGE);
    }

    private List<String> getWinnerName(List<Car> carList) {
        List<String> winnerList = new ArrayList<>();
        int maxPosition = getPositionMax(carList);

        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                winnerList.add(car.getName());
            }
        }

        return winnerList;
    }

    private int getPositionMax(List<Car> carList) {
        int maxPosition = 0;

        for (Car car : carList) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        return maxPosition;
    }

    private void printResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + getHyphen(car.getPosition()));
        }
    }

    private String getHyphen(int position) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < position; i++) {
            sb.append("-");
        }

        return sb.toString();
    }

    private void runOneRound(List<Car> carList) {
        for (Car car : carList) {
            if (getRandomNumber() >= CAR_MOVE_STANDARD_NUMBER) {
                car.moveCar();
            }
        }
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(9);
    }

    private int getRoundCount() {
        Scanner scan = new Scanner(System.in);
        int roundCount;

        System.out.println(INPUT_RUN_GAME_COUNT);

        while (!scan.hasNextInt()) {
            scan.next();
            System.err.println(INPUT_MISMATCH_ERROR);
            System.out.println(INPUT_RUN_GAME_COUNT);
        }

        roundCount = scan.nextInt();
        return roundCount;
    }

    private List<Car> getCarList(String[] carNameList) {
        List<Car> carList = new ArrayList<>();

        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }

        return carList;
    }

    private String[] inputCarNames() {
        Scanner scan = new Scanner(System.in);
        String[] carNameList;

        do {
            System.out.println(INPUT_CAR_NAME);
            carNameList = scan.next().split(",");
        } while (checkFiveWords(carNameList));

        return carNameList;
    }

    private boolean checkFiveWords(String[] carNameList) {
        for (String carName : carNameList) {
            if (carName.length() > NAME_LENGTH_LIMIT) {
                System.out.println(NAME_LENGTH_ERROR);
                return true;
            }
        }
        return false;
    }
}
