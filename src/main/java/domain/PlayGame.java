package domain;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class PlayGame {
    private Car[] carList;

    public void startGame() {
        getCarNames();
        playGame(getGameNumber());
        printWinner();
    }

    private void printWinner() {
        String resultString = getWinnerNames() + "이(가) 최종 우승했습니다.";
        //getWinnerNames()에서 return 되는 값은 ", "으로 시작하므로 그것을 지운 substring 만 출력
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
        System.out.println();
        System.out.println("실행결과");
        for (int i = 0; i < gameNumber; i++) {
            for (int j = 0; j < Array.getLength(carList); j++) {
                carList[j].decideMovement();
                carList[j].printPosition();
            }
            System.out.println();
        }
    }

    private int getGameNumber() {
        Scanner myScanner = new Scanner(System.in);
        int gameNumber = -1;
        final int minGameNumber = 1;

        while (true) {
            System.out.println("시도할 횟수를 몇회인가요? ");
            gameNumber = myScanner.nextInt();
            if (gameNumber >= minGameNumber)
                return gameNumber;
            System.out.println("1 이상의 값이어야 합니다. 다시 입력해주세요.");
        }
    }

    private void getCarNames() {
        Scanner myScanner = new Scanner(System.in);
        Boolean correctInput = false;

        while (!correctInput) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carNameList = myScanner.nextLine();
            List<String> carNames = Arrays.asList(carNameList.split(","));
            correctInput = makeCars(carNames);
            if (!correctInput)
                System.out.println("자동차 이름은 5자 이하만 가능합니다.");
            correctInput = checkCarNum(correctInput);
        }
    }

    private Boolean checkCarNum(Boolean correctInput) {
        final int minCarNumber = 2;
        if (Array.getLength(carList) < minCarNumber) {
            System.out.println("경주를 위해서는 2개 이상의 자동차 이름을 입력해야합니다.");
            return false;
        }
        return correctInput;
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
        final int maxNameLength = 5;
        return car.getName().length() <= maxNameLength;
    }
}

