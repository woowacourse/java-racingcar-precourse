package racingcar.view;

import java.util.List;

import racingcar.domain.CarDto;

public class OutputView {

	public void printResults(List<CarDto> carDtos) {
		printScore(carDtos);
		printWinners(carDtos);
	}

	private void printScore(List<CarDto> carDtos) {
		for (CarDto carDto : carDtos) {
			System.out.print(carDto.getName() + " : ");
			for (int i = 0; i < carDto.getPosition(); i++) {
				System.out.print("-");
			}
			System.out.println();
		}
	}

	private void printWinners(List<CarDto> carDtos) {
		System.out.print("최종 우승자 : ");
		boolean checkPrintMark = false;
		for (int i = 0; i < carDtos.size(); i++) {
			if (carDtos.get(i).getWin()) {
				printMark(checkPrintMark);
				System.out.print(carDtos.get(i).getName());
				checkPrintMark = true;
			}
		}
		System.out.println();
	}

	private void printMark(boolean checkPrintMark) {
		if (checkPrintMark) {
			System.out.print(", ");
		}
	}

	public void printException(String message) {
		System.out.println(message);
	}
}
