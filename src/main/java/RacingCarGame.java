import domain.Car;
import domain.RacingController;
import view.PrintHandler;
import view.UserInput;

import java.io.IOException;
import java.util.List;

/**
 * @author 김시영
 * @since 2019-12-05
 * @apiNote 게임 실행을 위한 메인클래스입니다.
 */
public class RacingCarGame {

    public static void main(String[] args) throws IOException {
        play();
    }

    public static void play() throws IOException {
        UserInput userInput = new UserInput();
        RacingController racingController = new RacingController();

        PrintHandler.notifyCarNameRule();
        List<Car> users = userInput.makeCars();

        PrintHandler.notifyHowManyTimes();
        int howMany = userInput.chooseHowManyPlay();

        racingController.gameStart(users, howMany);
        PrintHandler.printWinners(racingController.getWinner(users));

    }

}
