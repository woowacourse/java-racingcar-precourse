package racingcar.game.model;

import java.util.HashMap;
import java.util.Map;

public class Position {
	private static final int INIT_POSITION = 0;
	private static final int MOVE_COUNT = 1;
	private static final Map<Integer, Position> map = new HashMap<>();
	public static final Position ZERO = new Position(INIT_POSITION);
	private final int position;

	public Position(final int position) {
		this.position = position;
	}

	public static Position valueOf(final int position) {
		if (map.containsKey(position)) {
			return map.get(position);
		}

		Position newPosition = new Position(position);
		map.put(position, newPosition);
		return newPosition;
	}

	public Position movePosition() {
		return Position.valueOf(position + MOVE_COUNT);
	}

	public int getPosition() {
		return position;
	}

}
