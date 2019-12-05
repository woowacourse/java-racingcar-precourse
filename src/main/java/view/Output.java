package view;

import java.io.IOException;

public class Output {

    public static void play() throws IOException {
        UserInput userInput = new UserInput();

        OutputForNotify.notifyCarName();
        userInput.makeCars();
        OutputForNotify.notifyHowManyTimes();
        userInput.chooseHowManyPlay();

    }
}
