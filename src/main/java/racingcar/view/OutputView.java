package racingcar.view;

import java.util.ArrayList;

import racingcar.domain.Car;

public class OutputView {

	public static void showSentenceBeforeResult() {
		System.out.println("\n실행 결과");
	}

	public static void showResultThisTiming(ArrayList<Car> cars) {
		cars.forEach(eachCar -> System.out.printf("%s : %s\n", eachCar.getName(), showMovingMark(eachCar)));
		System.out.println();
	}

	private static String showMovingMark(Car car) {
		StringBuffer movingMark = new StringBuffer();
		for (int i = 0; i < car.showMovingDistance(); i++) {
			movingMark.append("-");
		}
		return movingMark.toString();
	}

	// public static void showThisGameWinner(ArrayList<CarDto> carDtoArrayList) {
	// 	int winnerMovingDistance = findWinnerMovingDistance(carDtoArrayList);
	// 	CarDto[] winners = findAllWinners(carDtoArrayList, winnerMovingDistance);
	// 	makeFinalResultSentence(winners);
	// }
	//
	// private static void makeFinalResultSentence(CarDto[] winners) {
	// 	StringBuffer result = new StringBuffer("최종 우승자 : ");
	// 	for (CarDto winner : winners) {
	// 		result.append(winner.getName());
	// 		if (winner != winners[winners.length - 1]) {
	// 			result.append(", ");
	// 		}
	// 	}
	// 	System.out.println(result);
	// }
	//
	// private static CarDto[] findAllWinners(ArrayList<CarDto> carDtoArrayList, int winnerMovingDistance) {
	// 	return carDtoArrayList.stream()
	// 		.filter(eachCar -> eachCar.getMovingDistance() == winnerMovingDistance)
	// 		.toArray(CarDto[]::new);
	// }
	//
	// private static int findWinnerMovingDistance(ArrayList<CarDto> carsDto) {
	// 	return carsDto.stream()
	// 		.mapToInt(CarDto::getMovingDistance)
	// 		.max()
	// 		.orElseThrow(() -> new IllegalArgumentException("자동차의 최댓값이 존재하지 않습니다. 로직이 잘못되었습니다."));
	// }
}
