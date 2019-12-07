import domain.RacingCarGame;
import view.InputView;
import view.OutputView;

public class Application {
	public static void main(String[] args) {
		RacingCarGame game = new RacingCarGame(InputView.getCarNames(), InputView.getTrialCount());
		OutputView.printRacingStart();
		while (game.hasNextRace()) {
			game.race();
			OutputView.printRaceResult(game.getCars());
		}
		OutputView.printWinners(game.getWinners());
	}
}
