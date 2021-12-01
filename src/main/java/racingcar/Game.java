package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

public class Game {
    private static List<Car> cars = new ArrayList<>();
    private static int trialNumber;

    public static void play() {
        setGame();
        System.out.println("\n실행 결과");
        for (int i = 1; i <= trialNumber; i++) {
            startRound();
        }
        Board.showResult(cars);
    }

    private static void startRound() {
        for (Car car : cars) {
            GameUtil.tryMove(car);
        }
        Board.showStatus(cars);
    }

    private static void setGame() {
        setCars();
        trialNumber = setTrialNumber();
    }

    private static void setCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input;
        do {
            input = Console.readLine();
        } while (!Validator.isValidateInput(input));
        cars = Validator.parseStringToList(new ArrayList<>(), input);
    }

    private static int setTrialNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input;
        do {
            input = Console.readLine();
        } while (!Validator.isValidateNumber(input));
        return Integer.parseInt(input);
    }

}
