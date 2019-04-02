package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Racing {
    public void run() {
        List<Car> carList = getCarList(inputCarNames());
        int roundCount = getRoundCount();

        System.out.println("실행 결과");

        for (int i = 0; i < roundCount; i++) {
            runOneRound(carList);
            printResult(carList);
            System.out.printf("\n\n");
        }
        printWinnerName(carList);
    }

    private void printWinnerName(List<Car> carList) {
        List<String> winner = getWinnerName(carList);
        System.out.println(String.join(",", winner) + "가 최종 우승했습니다.");
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
            if (getRandomNumber() >= 4) {
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
        System.out.println("시도할 횟수는 몇회인가요?");
        return scan.nextInt();
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
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            carNameList = scan.next().split(",");
        } while (checkFiveWords(carNameList));

        return carNameList;
    }

    private boolean checkFiveWords(String[] carNameList) {
        for (String carName : carNameList) {
            if (carName.length() > 5) {
                System.out.println("이름이 5자가 넘었습니다. 다시 작성해주세요.");
                return true;
            }
        }
        return false;
    }
}
