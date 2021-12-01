package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Game {
    private final static List<Car> cars = new ArrayList<>();
    private static int trialNumber;

    public static void play() {
        setGame();
        System.out.println("\n실행 결과");
        for (int i = 1; i <= trialNumber; i++) {
            startRound();
        }
        showResult();
    }

    private static void showResult() {
        List<String> winner = decideWinner();
        printResult(winner);
    }

    private static List<String> decideWinner() {
        List<String> winner = new ArrayList<>();
        int maxPosition = findMax();
        for (Car car : cars) {
            isWinner(winner, maxPosition, car);
        }
        return winner;
    }

    private static List<String> isWinner(List<String> winner, int maxPosition, Car car) {
        if (car.getPosition() == maxPosition) {
            winner.add(car.getName());
        }
        return winner;
    }

    private static int findMax() {
        List<Integer> position = new ArrayList<>();
        for (Car car : cars) {
            position.add(car.getPosition());
        }
        return Collections.max(position);
    }

    private static void printResult(List<String> winner) {
        String Result = "최종 우승자 : ";
        for (String name : winner) {
            Result += (name + ", ");
        }
        System.out.print(removeCommaAtEnd(Result));
    }

    private static String removeCommaAtEnd(String targetString) {
        return targetString.substring(0, targetString.length() - 2);
    }

    private static void startRound() {
        for (Car car : cars) {
            tryMove(car);
        }
        showStatus();
    }

    private static void showStatus() {
        for (Car car : cars) {
            System.out.println(car.showPosition());
        }
        System.out.println();
    }

    private static void tryMove(Car car) {
        if (canMove()) {
            car.goForward();
        }
    }

    private static boolean canMove() {
        return (Randoms.pickNumberInRange(0, 9) >= 4);
    }

    private static void setGame() {
        setCars();
        setTrialNumber();
    }

    private static void setCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input;
        do {
            input = Console.readLine();
        } while (!isValidateInput(input));
    }

    private static boolean isValidateInput(String input) {
        cars.clear();
        try {
          parseStringToList(input);
          for(Car car : cars){
              if(car.getName().length()>5){
                  throw new IllegalArgumentException();
              }
          }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 자동차의 이름은 5자 이하여야 한다.");
            return false;
        }
        return true;
    }

    private static void parseStringToList(String input) {
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    private static void setTrialNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        trialNumber = Integer.parseInt(Console.readLine());
    }
}
