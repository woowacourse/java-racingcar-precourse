package racingcar.runner;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.car.Car;
import racingcar.domain.service.Referee;
import racingcar.domain.lab.Lab;
import racingcar.io.ConsolePrinter;

public class RacingGame {

	private static final String START_RACE_SYSTEM_MESSAGE = "실행 결과";
	private static final String WINNER_NAME_SYSTEM_MESSAGE = "최종 우승자 : %s";

	private static final int START_INCLUSIVE = 0;
	private static final int END_INCLUSIVE = 9;

	private final Lab lab;
	private final List<Car> racers;
	private final Referee referee;
	private final ConsolePrinter printer;

	public RacingGame(Lab lab, List<Car> racers, ConsolePrinter printer, Referee referee) {
		this.lab = lab;
		this.racers = racers;
		this.printer = printer;
		this.referee = referee;
	}

	public void start() {
		startRace();
		awards();
	}

	private void awards() {
		String winners = referee.decideWinners(racers);
		printer.print(getAwardsMessage(winners));
	}

	private String getAwardsMessage(String winners) {
		return String.format(WINNER_NAME_SYSTEM_MESSAGE, winners);
	}

	private void startRace() {
		printer.newLine();
		printer.print(START_RACE_SYSTEM_MESSAGE);
		final int raceCount = lab.getLabCount();
		for (int i = 0; i < raceCount; i++) {
			race();
			printRaceResult();
		}
	}

	private void race() {
		racers.forEach(racer -> {
			int randomNumber = generateRandomNumber();
			racer.tryMove(randomNumber);
		});
	}

	private int generateRandomNumber() {
		return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
	}

	private void printRaceResult() {
		String raceResult = referee.checkRacersPosition(racers);
		printer.print(raceResult);
	}
}
