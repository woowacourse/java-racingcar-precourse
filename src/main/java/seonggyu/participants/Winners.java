package seonggyu.participants;

import java.util.List;
import java.util.ArrayList;

public class Winners {
	private static final int INITIAL_MAX_DISTANCE = 0;

	private List<String> winners = new ArrayList<String>();
	private int maxDistance;

	public Winners() {
		this.maxDistance = INITIAL_MAX_DISTANCE;
	}

	public int getMaxDistance() {
		return maxDistance;
	}

	public void update(Car candidate) {
		if (candidate.getPosition() > this.maxDistance) {
			this.maxDistance = candidate.getPosition();
			this.winners.clear();
		}
		this.winners.add(candidate.getName());
	}

	public void printWinners() {
		String result = String.join(", ", this.winners);
		System.out.print(result + " 가 최종 우승했습니다.");
	}
}
