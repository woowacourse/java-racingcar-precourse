/**
 * 프로젝트의 동작들을 순서있게 실행시키는 클래스
 *
 * @author	MinKyu,Song
 * @version	1.0 12/10/2019
 */

package domain;

import java.util.List;

import domain.utils.InputUtils;
import domain.utils.OutputUtils;

public class Main {
	public static void main(String[] args) {
		List<String> carNameList = InputUtils.getNameList();
		Integer rounds = InputUtils.getRounds();
		Race race=new Race(carNameList,rounds);

		System.out.printf("\n실행 결과\n");
		race.playGame();

		List<String> winners = race.getWinnerNameList();
		OutputUtils.printWinner(winners);
		InputUtils.inputClose();
	}
}
