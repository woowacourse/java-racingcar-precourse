import domain.Car;
import domain.Computer;
import domain.RacingController;
import view.PrintHandler;
import view.UserInput;

import java.io.IOException;
import java.util.List;

public class RacingCarGame {

    public static void main(String[] args) throws IOException {
        play();
    }

    public static void play() throws IOException {
        UserInput userInput = new UserInput();

        PrintHandler.notifyCarName();
        List<Car> users = userInput.makeCars();

        PrintHandler.notifyHowManyTimes();
        int howMany = userInput.chooseHowManyPlay();

        RacingController.gameStart(users, howMany);
        PrintHandler.printWinners(RacingController.getWinner(users));

    }

}
