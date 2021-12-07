package racingcar.processor;

import racingcar.domain.result.RacingResult;

public class OutputProcessor {

	public void printResultBeginning() {
		System.out.println("\n실행 결과");
	}

	public void printResult(RacingResult racingResult) {
		System.out.println(racingResult.getPresentCarsStatus() + "\n");
	}

	public void printWinner(RacingResult racingResult) {
		System.out.println("최종 우승자 : " + racingResult.findFinalWinnerName());
	}
}
