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
        System.out.print(gameNumber);
 /*       for (int i = 0; i < Array.getLength(carList); i++) {
            System.out.println(carList[i].getName());
            System.out.println(carList[i].getPosition());
        }*/

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

