package manager;

import domain.Car;

import java.util.ArrayList;
import java.util.Scanner;

public class GameManager {
    private Car[] cars;
    private int carNumber;

    public void startGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Scanner scanner = new Scanner(System.in);
        String carNames = scanner.next();
        makeCarObjects(carNames);

        System.out.println("시도할 횟수는 몇회인가요?");
        int gameRepeat = scanner.nextInt();
        printGameState(gameRepeat);
        System.out.println();
    }

    private void makeCarObjects(String carNames) {
        String[] carNameArray = carNames.split(",");
        cars = new Car[carNameArray.length];
        carNumber = carNameArray.length;

        for (int i = 0; i < carNameArray.length; i++) {
            cars[i] = new Car(carNameArray[i]);
        }
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

    public void printWinner(ArrayList<String> winnerList) {
        int checkWinnerNum = 0;
        String winnerStr = "";

        if (winnerList.size() == 1) {
            System.out.println(winnerList.get(0) + "가 최종 우승했습니다.");
            return;
        }
        for (int i = 0; i < winnerList.size(); i++) {
            winnerStr += winnerList.get(i);
            checkWinnerNum++;
            if (checkWinnerNum < winnerList.size()) {
                winnerStr += ", ";
            }
        }
        winnerStr += "가 최종 우승했습니다.";
        System.out.println(winnerStr);
    }

    public void findWinner() {
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
