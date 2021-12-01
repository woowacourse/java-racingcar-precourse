package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Player;
import racingcar.domain.Racing;

public class RacingController {
	private Player player;
	private Racing racing;

	public RacingController(Player player, Racing racing) {
		this.player = player;
		this.racing = racing;
	}

	public void startRacing() {
		List<String> cars = player.enterCarsName();

	}
}
