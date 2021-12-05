package racingcar.console;

import camp.nextstep.edu.missionutils.Console;
import java.util.Optional;
import racingcar.MoveCount;
import racingcar.MovementGenerator;
import racingcar.util.NumberParser;

public class ConsoleMovementGenerator implements MovementGenerator {
	private static final String GUIDE_MOVE_COUNT = "시도할 회수는 몇회인가요?";

	@Override
	public MoveCount createMoveCount() {
		MoveCount moveCount;
		while (true) {
			Optional<MoveCount> optionalMoveCount = inputMoveCount();
			if (optionalMoveCount.isPresent()) {
				moveCount = optionalMoveCount.get();
				break;
			}
		}
		return moveCount;
	}

	private Optional<MoveCount> inputMoveCount() {
		System.out.println(GUIDE_MOVE_COUNT);
		try {
			return Optional.of(new MoveCount(NumberParser.parseInt(Console.readLine().trim())));
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return MoveCount.Empty();
		}
	}
}
