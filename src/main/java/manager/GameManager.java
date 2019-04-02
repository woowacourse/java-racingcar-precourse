package manager;

import domain.Car;

import java.util.ArrayList;
import java.util.Scanner;

public class GameManager {
    private Car[] cars;
    private int carNumber;
    private StringBuilder sb = new StringBuilder();
    private Scanner scanner = new Scanner(System.in);
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private int gameLoop;

    public void start() {
        initRacing();
        printGameState(gameLoop);
    }

    private void initRacing() {

        boolean nameLengthChecker = false;
        String[] carNames = null;

        while (!nameLengthChecker) {
            carNames = enterCarNames();
            nameLengthChecker = checkCarNameLength(carNames);
        }
        
        makeCarObjects(carNames);
        enterLoopCount();
    }

    private String[] enterCarNames() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = scanner.next();

        return carNames.split(",");

    }

    private void enterLoopCount() {

        System.out.println("시도할 횟수는 몇회인가요?");
        
        gameLoop = scanner.nextInt();

        System.out.println();

    }

    private void makeCarObjects(String[] carNames) {

        carNumber = carNames.length;
        cars = new Car[carNames.length];

        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }

    }

    private boolean checkCarNameLength(String[] carNames) {

        for (String carName : carNames) {
            if (carName.length() > MAX_CAR_NAME_LENGTH) {
                System.out.println("자동차의 이름은 5글자 이하로 입력해주세요!");
                return false;
            }
        }
        return true;
    }

    private void printGameState(int gameRepeat) {

        System.out.println("실행결과");

        for (int i = 0; i < gameRepeat; i++) {
            for (int j = 0; j < carNumber; j++) {
                cars[j].oneLoop();
            }
            System.out.println();
        }

        findWinner();

    }

    private void printWinner(ArrayList<String> winnerList) {

        int checkWinnerNum = 0;

        if (winnerList.size() == 1) {
            System.out.println(winnerList.get(0) + "가 최종 우승했습니다.");
            return;
        }

        for (int i = 0; i < winnerList.size(); i++) {
            sb.append(winnerList.get(i));
            checkWinnerNum++;
            if (checkWinnerNum < winnerList.size()) {
                sb.append(", ");
            }
        }
        sb.append("가 최종 우승했습니다.");

        System.out.println(sb.toString());

    }

    private void findWinner() {

        int winnerPosition = cars[0].getPosition();
        ArrayList<String> winnerList = new ArrayList<>();

        for (int i = 1; i < carNumber; i++) {
            if (winnerPosition < cars[i].getPosition()) {
                winnerPosition = cars[i].getPosition();
            }
        }

        for (int i = 0; i < carNumber; i++) {
            if (cars[i].getPosition() == winnerPosition) {
                winnerList.add(cars[i].getName());
            }
        }

        printWinner(winnerList);

    }

}
