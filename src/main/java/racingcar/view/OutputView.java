package racingcar.view;

import java.util.ArrayList;

import racingcar.dto.CarDTO;

public class OutputView {
	public static ArrayList<CarDTO> carDTOArrayList;

	public static void showSentenceBeforeResult() {
		System.out.println("\n실행 결과");
	}

	public static void showResultThisTiming(ArrayList<CarDTO> carsDTO) {
		carsDTO.forEach(eachCarDTO -> System.out.printf("%s : %s%n", eachCarDTO.getName(), showMovingMark(eachCarDTO)));
		System.out.println();
	}

	private static String showMovingMark(CarDTO carDTO) {
		StringBuilder movingMark = new StringBuilder();
		for (int i = 0; i < carDTO.getMovingDistance(); i++) {
			movingMark.append("-");
		}
		return movingMark.toString();
	}

	public static void showThisGameWinner(ArrayList<CarDTO> carDTOArrayList) {
		OutputView.carDTOArrayList = carDTOArrayList;
		int winnerMovingDistance = findWinnerMovingDistance(carDTOArrayList);
		CarDTO[] winners = findAllWinners(winnerMovingDistance);
		makeFinalResultSentence(winners);
	}

	private static void makeFinalResultSentence(CarDTO[] winners) {
		String result = "최종 우승자 : ";
		for (CarDTO winner : winners) {
			result += winner.getName();
			if (winner != winners[winners.length - 1]) {
				result += ", ";
			}
		}
		System.out.println(result);
	}

	private static CarDTO[] findAllWinners(int winnerMovingDistance) {
		return carDTOArrayList.stream()
			.filter(eachCar -> eachCar.getMovingDistance() == winnerMovingDistance)
			.toArray(CarDTO[]::new);
	}

	private static int findWinnerMovingDistance(ArrayList<CarDTO> carsDTO) {
		return carsDTO.stream()
			.mapToInt(carDTO -> carDTO.getMovingDistance())
			.max()
			.orElseThrow(() -> new IllegalArgumentException("자동차의 최댓값이 존재하지 않습니다. 로직이 잘못되었습니다."));
	}
}
