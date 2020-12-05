package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import utils.ValidatorUtils;

public class RacingCarGame {

    private Scanner scanner;
    private List<Car> carList = new ArrayList<>();

    public RacingCarGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startGame() {
        getCarNames();
    }

    private void getCarNames() {
        String[] carNames;
        while (true) {
            try{
                carNames = askCarNames();
                ValidatorUtils.checkUnderFiveLetters(carNames);
                break;
            }catch (IllegalArgumentException i){
                System.out.println(i.getMessage());
            }
        }
        makeCar(carNames);
    }

    private void makeCar(String[] carNames) {
        for(String carName : carNames){
            carList.add(new Car(carName));
        }
    }

    private String[] askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = scanner.nextLine().split(",");
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }
        return carNames;
    }


}
