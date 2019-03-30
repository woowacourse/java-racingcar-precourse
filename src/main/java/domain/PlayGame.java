package domain;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class PlayGame {
    public void startGame() {
        getCarNames();
    }

    private void getCarNames() {
        Scanner myScanner = new Scanner(System.in);
        String carList = "";
        Boolean correctInput = false;

        while (!correctInput) {
            System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            carList = myScanner.nextLine();
            List<String> carNames = Arrays.asList(carList.split(","));
            correctInput = makeCars(carNames);
            if (!correctInput)
                System.out.println("잘못된 값이 있습니다. 다시 입력해주세요.");
        }
    }
}

