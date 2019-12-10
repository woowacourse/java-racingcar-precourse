package util;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class StringParsingTest {

	@Test
	void makeNumbersFromString() {
		String stringArray = "a, b, c";
		List<String> strings = StringParsing.makeNumbersFromString(stringArray);
		assertThat(strings).containsExactly("a", "b", "c");
	}
}