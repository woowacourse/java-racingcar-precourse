package racingcar;

import racingcar.model.RacingInfo;
import racingcar.reader.RacingInfoReader;

public class RacingGameManager {
	private final RacingInfoReader reader;

	public RacingGameManager(RacingInfoReader reader) {
		this.reader = reader;
	}

	public void run() {
		RacingInfo info = reader.read();
	}
}
