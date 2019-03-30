package domain;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class PlayGame {
    public void startGame() {
        Car[] carList;
        getCarNames(carList);
    }

    private void getCarNames(Car[] carList) {
        Scanner myScanner = new Scanner(System.in);
        String carNameList = "";
        Boolean correctInput = false;

        while (!correctInput) {
            System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            carNameList = myScanner.nextLine();
            List<String> carNames = Arrays.asList(carNameList.split(","));
            correctInput = makeCars(carNames, carList);
            if (!correctInput)
                System.out.println("잘못된 값이 있습니다. 다시 입력해주세요.");
        }
    }

    private Boolean makeCars(List<String> carNames, Car[] carList) {
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

