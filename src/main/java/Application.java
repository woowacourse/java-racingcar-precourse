
import java.io.IOException;
import java.util.List;

import domain.model.Car;
import domain.controller.RacingGame;
import view.PrintHandler;
import view.UserInput;

/**
 * @author 김시영
 * @apiNote 게임 실행을 위한 메인클래스입니다.
 * @since 2019-12-05
 */
public class Application {
    private static final String PROGRAM_ERROR = "올바르지 않은 실행입니다. 시스템 내부의 오류가 있는 것 같습니다.";

    public static void main(String[] args) throws IOException {
        try {
            play();
        } catch (Exception e) {
            System.out.println(PROGRAM_ERROR);
            e.printStackTrace();
        }
    }

    public static void play() throws IOException {
        UserInput userInput = new UserInput();
        RacingGame racingController = new RacingGame();

        PrintHandler.notifyCarNameRule();
        List<Car> users = userInput.makeCars();

        PrintHandler.notifyHowManyTimes();
        int howMany = userInput.chooseHowManyPlay();

        racingController.gameStart(users, howMany);
        PrintHandler.printWinners(racingController.getWinner(users));
    }
}
