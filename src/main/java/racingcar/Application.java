package racingcar;


import java.util.Scanner;
import utils.UserInputData;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String[] carNames = UserInputData.carNameChoice(scanner);

            System.out.println("시도할 회수는 몇회인가요?");
            int matchTryNumber = UserInputData.matchCountChoice(scanner);

            System.out.println("실행 결과");
            GameController newGame = new GameController(carNames);
            newGame.playGame(matchTryNumber);
        } catch (IllegalArgumentException e) { return;}
    }
}