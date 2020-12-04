package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        RacingGame racingGame = new CarRacingGame();
        String[] carNames = scanner.next().split(",");
        for (int i = 0; i < carNames.length; i++) {
            Car car = new Car(carNames[i]);
            car.carNameValidate();
            racingGame.addCar(car);
        }
        int carMoveAttemptCount = inputCarMoveAttemptCount(scanner);
        


    }

    private static int inputCarMoveAttemptCount(Scanner scanner) {
        String input = scanner.next();
        int carMoveAttemptCount = carMoveAttemptCountValidate(input);
        return carMoveAttemptCount;
    }

    private static int carMoveAttemptCountValidate(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                System.out.println("[ERROR] 시도 횟수는 숫자여야한다.");
                throw new RuntimeException();
            }
        }
        return Integer.parseInt(input);
    }
}
