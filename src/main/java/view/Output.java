package view;

import domain.Car;
import domain.Computer;

import java.io.IOException;
import java.util.List;

public class Output {

    public static void play() throws IOException {
        UserInput userInput = new UserInput();

        OutputForNotify.notifyCarName();
        List<Car> users = userInput.makeCars();
        OutputForNotify.notifyHowManyTimes();
        int howMany = userInput.chooseHowManyPlay();
        Computer.gameStart(users,howMany);

    }
}
