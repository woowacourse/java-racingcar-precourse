package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.view.InputView;

public class GameTest {
	@Test
	@DisplayName("문자열 입력 받아 List로 변환")
	void strToListTest() {
		String str = "abc,def,ghi,jkl";
		List<String> testList = new ArrayList<>();
		testList.add("abc");
		testList.add("def");
		testList.add("ghi");
		testList.add("jkl");
		assertThat(InputView.strToList(str)).isEqualTo(testList);
	}
}
