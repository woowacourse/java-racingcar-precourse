package domain;

import java.util.List;

import domain.utils.InputUtils;
import domain.utils.OutputUtils;

public class Main {
	public static void main(String[] args) {
		List<String> carNameList = InputUtils.getNames();
		Integer rounds = InputUtils.getRounds();
		Race race=new Race(carNameList,rounds);

		System.out.printf("\n실행 결과\n");
		race.doGame();

		List<String> winners = race.getWinnerNameList();
		OutputUtils.printWinner(winners);
		InputUtils.inputClose();
	}
}
