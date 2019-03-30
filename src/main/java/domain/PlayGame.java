package domain;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class PlayGame {
    Car[] carList;

    public void startGame() {
        getCarNames();
/*        for (int i = 0; i < Array.getLength(carList); i++) {
            System.out.println(carList[i].getName());
        }*/
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

