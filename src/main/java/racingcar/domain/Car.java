package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.rule.DefaultRule;
import racingcar.domain.rule.MoveRule;

public class Car {
	private static final int START_INCLUSIVE = 0;
	private static final int END_INCLUSIVE = 9;

	private final String name;
	private int position = 0;
	private MoveRule moveRule = new DefaultRule();

	public Car(String name) {
		this.name = name;
	}

	public Car(String name, MoveRule moveRule) {
		this.name = name;
		this.moveRule = moveRule;
	}

	public void moveAccordingToRule() {
		int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
		if (moveRule.isMovable(randomNumber)) {
			move();
		}
	}

	private void move() {
		position++;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
