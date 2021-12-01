package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Player;
import racingcar.domain.Racing;

public class RacingController {
	private Player player;

	public RacingController(Player player) {
		this.player = player;
	}

	public void start() {
		Racing racing = new Racing(player.enterCarsName(), player.enterMoveNum());
		racing.startRacing();
	}
}
