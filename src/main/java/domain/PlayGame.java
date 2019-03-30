package domain;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class PlayGame {
    Car[] carList;

    public void startGame() {
        int gameNumber;

        getCarNames();
        gameNumber = getGameNumber();
        playGame(gameNumber);
        printWinner();
    }

    private void printWinner() {
        String resultString = "이(가) 최종 우승했습니다.";
        resultString = getWinnerNames() + resultString;
        System.out.println(resultString.substring(2));
    }

    private String getWinnerNames() {
        int bestResult = -1;
        String resultString = "";

        for (int i = 0; i < Array.getLength(carList); i++) {
            if (carList[i].getPosition() > bestResult)
                bestResult = carList[i].getPosition();
        }
        for (int i = 0; i < Array.getLength(carList); i++) {
            if (carList[i].getPosition() == bestResult)
                resultString += ", " + carList[i].getName();
        }
        return resultString;
    }

    private void playGame(int gameNumber) {
        System.out.println("");
        System.out.println("실행결과");
        for (int i = 0; i < gameNumber; i++) {
            for (int j = 0; j < Array.getLength(carList); j++) {
                carList[j].decideMovement();
                carList[j].printPosition();
            }
            System.out.println("");
        }
    }

    private int getGameNumber() {
        Scanner myScanner = new Scanner(System.in);
        int gameNumber = -1;

        while (true) {
            System.out.println("시도할 횟수를 몇회인가요? ");
            gameNumber = myScanner.nextInt();
            if (gameNumber > 0)
                return gameNumber;
            System.out.println("1 이상의 값이어야 합니다. 다시 입력해주세요.");
        }
    }

    private void getCarNames() {
        Scanner myScanner = new Scanner(System.in);
        String carNameList = "";
        Boolean correctInput = false;

        while (!correctInput) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            carNameList = myScanner.nextLine();
            List<String> carNames = Arrays.asList(carNameList.split(","));
            correctInput = makeCars(carNames);
            if (!correctInput)
                System.out.println("잘못된 값이 있습니다. 다시 입력해주세요.");
            if (Array.getLength(carList) < 2) {
                System.out.println("경주를 위해서는 2개 이상의 자동차 이름을 입력해야합니다.");
                correctInput = false;
            }
        }
    }

    private Boolean makeCars(List<String> carNames) {
        int carNum = carNames.size();
        carList = new Car[carNum];

        for (int i = 0; i < carNum; i++) {
            carList[i] = new Car(carNames.get(i));
            if (!checkCorrectName(carList[i]))
                return false;
        }
        return true;
    }

    private boolean checkCorrectName(Car car) {
        return car.getName().length() <= 5;
    }
}

