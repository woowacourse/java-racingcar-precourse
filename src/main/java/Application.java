import Domain.Cars;
import Race.RaceProcess;
import Race.Referee;
import View.InputView;

import View.OutputView;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        OutputView outputView = new OutputView();
        Cars users =  new Cars(inputView.inputCarNames());
        Referee referee = new Referee();
        RaceProcess raceProcess = new RaceProcess(inputView.inputRoundNum(), users);

        runningGame(raceProcess, outputView, referee, users);

    }

    public static void runningGame(RaceProcess raceProcess, OutputView outputView, Referee referee, Cars users) {
        raceProcess.totalRoundProcess();
        referee.saveAllWinner(users);
        outputView.showWinners(referee.getWinners());
    }
}
