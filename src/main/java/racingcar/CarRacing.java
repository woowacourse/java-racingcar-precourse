package racingcar;

import utils.ValidateUtils;

import java.util.List;
import java.util.Scanner;

public class CarRacing {
    private final Scanner scanner;

    public CarRacing(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameInput = scanner.nextLine();
        List<String> carNamesSplitList = CarNamesSplitList.carNamesSplitList(carNameInput);
        ValidateUtils.carNameLengthCheck(carNamesSplitList);
        List<Car> carList = CarGenerate.carGenerate(carNamesSplitList);
        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = ValidateUtils.checkTryCountParseInt(scanner.nextLine());
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            CarRacingRepeat.repeatCarRacing(carList);
        }
        List<String> winnerList = CarRacingPrint.printWinnerCar(carList);
        System.out.println(String.format("최종 우승자: %s ", String.join(", ", winnerList)));
    }
}
