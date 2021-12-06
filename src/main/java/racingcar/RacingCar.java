package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

public class RacingCar {
    private static final String RESULT_INPUT_MESSAGE = "\n 실행 결과";
    private static final String PRINT_WINNER_MESSAGE = "최종 우승자 : ";
    private Car[] carArray;

    protected void startGame() {
        createCarArray(UserInput.inputCarName());
        int numberOfAttempt = UserInput.inputNumberOfAttempts();

        System.out.println(RESULT_INPUT_MESSAGE);

        for (int attempts = 0; attempts < numberOfAttempt; attempts++) {
            for (Car carIndex : carArray) {
                carIndex.moveCar();
                carIndex.printCarPosition();
            }
            System.out.println("");
        }
        printWinners();
    }

    private void createCarArray(String[] carNameArray) {
        carArray = new Car[carNameArray.length];

        for (int i = 0; i < carNameArray.length; i++) {
            carArray[i] = new Car(carNameArray[i]);
        }
    }

    private void printWinners() {
        ArrayList<String> winners = getWinners();

        String winnerMessage = String.join(",", winners);
        System.out.println(PRINT_WINNER_MESSAGE + winnerMessage);
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        if (Arrays.stream(carArray).mapToInt(Car::getPosition).max().isPresent()) {

            maxPosition = Arrays.stream(carArray)
                    .mapToInt(Car::getPosition)
                    .max()
                    .getAsInt();
        }
        return maxPosition;
    }

    private ArrayList<String> getWinners() {
        ArrayList<String> winners = new ArrayList<>();
        int maxPosition = getMaxPosition();

        for (Car carIndex : carArray) {
            if (carIndex.getPosition() == maxPosition) {
                winners.add(carIndex.getCarName());
            }
        }
        return winners;
    }
}
