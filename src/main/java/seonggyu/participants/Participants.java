package seonggyu.participants;

import java.util.List;
import java.util.ArrayList;

public class Participants {
	private List<Car> participants = new ArrayList<Car>();
	
	public Participants(List<String> inputNames) {
		ParticipantsConstraints.checkValidParticipantsNames(inputNames);
		inputNames.stream()
			.forEach(inputName -> addNewCar(inputName));
	}

	private void addNewCar(String inputName) {
		Car newParticipant = new Car(inputName);
		this.participants.add(newParticipant);
	}

	public void printNamesAndPositions() {
		this.participants.stream()
			.forEach(car -> car.printNameAndPosition());
		System.out.println();	// 출력 포멧 맞추기
	}
	
	public void goOrStay() {
		this.participants.stream()
			.forEach(car -> car.goOrStay());
	}
	
	/* 한바퀴 차례대로 탐색하면서 winners.add()에서 기록과 우승자를 그때그때 갱신한다 */
	public Winners getWinners() {
		Winners winners = new Winners();
		this.participants.stream()
			.filter(car -> car.isWinnerCandidate(winners.getMaxDistance()))
			.forEach(car -> winners.add(car));
		return winners;
	}
}
