package racingcar.utils;

import java.io.ByteArrayInputStream;

import camp.nextstep.edu.missionutils.test.NsTest;

public abstract class CustomNsTest extends NsTest {
	public void command(final String... args) {
		final byte[] buf = String.join("\n", args).getBytes();
		System.setIn(new ByteArrayInputStream(buf));
	}

	protected abstract void runMain();
}
