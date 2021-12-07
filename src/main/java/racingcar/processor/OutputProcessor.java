package racingcar.processor;

import racingcar.result.Racing;

public class OutputProcessor {

	public void printResultBeginning(){
		System.out.println("\n실행 결과");
	}

	public void printResult(Racing racing) {
		System.out.println(racing.getPresentCarStatus()+"\n");
	}

	public void printWinner(Racing racing) {
		System.out.println(racing.getFinalWinnerName());
	}
}
