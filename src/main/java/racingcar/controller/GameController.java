package racingcar.controller;

import java.util.List;

import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.view.GameView;

public class GameController {
	private Game game;
	private int count;

	public GameController(List<Car> cars, int count) {
		this.game = new Game(cars);
		this.count = count;
	}

	public void play() {
		GameView.playUI();
		for (int i = 0; i < count; i++) {
			game.play(Game.MOVE_VALUE, Game.MOVE_CONDITION);
			GameView.resultUI(game.getCars());
		}
	}

	public void winners() {
		GameView.winnersUI(game.winners());
	}
}
