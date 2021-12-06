package racingcar.view;

import java.util.ArrayList;

import racingcar.dto.CarDto;

public class OutputView {
	public static ArrayList<CarDto> carDtoArrayList;

	public static void showSentenceBeforeResult() {
		System.out.println("\n실행 결과");
	}

	public static void showResultThisTiming(ArrayList<CarDto> carsDtos) {
		carsDtos.forEach(eachCarDto -> System.out.printf("%s : %s\n", eachCarDto.getName(), showMovingMark(eachCarDto)));
		System.out.println();
	}

	private static String showMovingMark(CarDto carDto) {
		StringBuffer movingMark = new StringBuffer();
		for (int i = 0; i < carDto.getMovingDistance(); i++) {
			movingMark.append("-");
		}
		return movingMark.toString();
	}

	public static void showThisGameWinner(ArrayList<CarDto> carDtoArrayList) {
		OutputView.carDtoArrayList = carDtoArrayList;
		int winnerMovingDistance = findWinnerMovingDistance(carDtoArrayList);
		CarDto[] winners = findAllWinners(winnerMovingDistance);
		makeFinalResultSentence(winners);
	}

	private static void makeFinalResultSentence(CarDto[] winners) {
		StringBuffer result = new StringBuffer("최종 우승자 : ");
		for (CarDto winner : winners) {
			result.append(winner.getName());
			if (winner != winners[winners.length - 1]) {
				result.append(", ");
			}
		}
		System.out.println(result);
	}

	private static CarDto[] findAllWinners(int winnerMovingDistance) {
		return carDtoArrayList.stream()
			.filter(eachCar -> eachCar.getMovingDistance() == winnerMovingDistance)
			.toArray(CarDto[]::new);
	}

	private static int findWinnerMovingDistance(ArrayList<CarDto> carsDto) {
		return carsDto.stream()
			.mapToInt(CarDto::getMovingDistance)
			.max()
			.orElseThrow(() -> new IllegalArgumentException("자동차의 최댓값이 존재하지 않습니다. 로직이 잘못되었습니다."));
	}
}
