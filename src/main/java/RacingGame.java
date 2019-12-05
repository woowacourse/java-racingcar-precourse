import java.util.ArrayList;
import java.util.Collections;

import utils.InputHandler;
import view.InputView;

public class RacingGame {
	public void play() {
		ArrayList<String> carNames = getCarNames();
	}

	private ArrayList<String> getCarNames() {
		ArrayList<String> result = new ArrayList<>();
		String[] carNames = InputHandler.splitByComma(InputView.carNames());

		Collections.addAll(result, carNames);
		return result;
	}
}
