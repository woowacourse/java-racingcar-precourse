package racingcar.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ValidatorTest {
	@Nested
	@DisplayName("Validate CarName")
	class ValidatingCarName {
		@DisplayName("유효성 통과 시 정상진행된다.")
		@Test
		public void validCarNameSuccess() throws Exception {
			// given
			String[] testStr = {"pobi", "prove", "12345", "가나다라마", "프리코스2", "토끼 거북"};
			// when
			// then
			try {
				Validator.validateCarNames(testStr);
			} catch (IllegalArgumentException e) {
				fail();
			}
		}

		@DisplayName("자동차 이름은 빈 문자열 혹은 공백이면 안된다.")
		@Test
		public void validCarNameEmptyString() throws Exception {
			// given
			String errorMsg = "[ERROR] 자동차 이름은 빈 문자열 혹은 공백이면 안된다.";
			String[] testStr1 = {""};
			String[] testStr2 = {"  "};

			// when
			IllegalArgumentException ex1 = assertThrows(IllegalArgumentException.class,
				() -> Validator.validateCarNames(testStr1));

			IllegalArgumentException ex2 = assertThrows(IllegalArgumentException.class,
				() -> Validator.validateCarNames(testStr2));

			// then
			assertEquals(ex1.getMessage(), errorMsg);
			assertEquals(ex2.getMessage(), errorMsg);
		}

		@DisplayName("자동차 이름은 5자 이하여야 한다.")
		@Test
		public void validCarNameOverMaxLentgh() throws Exception {
			// given
			String errorMsg = "[ERROR] 자동차 이름은 5자 이하여야 한다.";
			String[] testStr1 = {"일이삼사오육"};
			String[] testStr2 = {"123456"};
			String[] testStr3 = {"타인은 지옥이다"};
			String[] testStr4 = {"abcdef"};
			// when
			IllegalArgumentException ex1 = assertThrows(IllegalArgumentException.class,
				() -> Validator.validateCarNames(testStr1));

			IllegalArgumentException ex2 = assertThrows(IllegalArgumentException.class,
				() -> Validator.validateCarNames(testStr2));

			IllegalArgumentException ex3 = assertThrows(IllegalArgumentException.class,
				() -> Validator.validateCarNames(testStr3));

			IllegalArgumentException ex4 = assertThrows(IllegalArgumentException.class,
				() -> Validator.validateCarNames(testStr4));
			// then
			assertEquals(ex1.getMessage(), errorMsg);
			assertEquals(ex2.getMessage(), errorMsg);
			assertEquals(ex3.getMessage(), errorMsg);
			assertEquals(ex4.getMessage(), errorMsg);
		}
	}

	@DisplayName("Validate StageNum")
	@Nested
	class StageNum {
		@DisplayName("유효성 통과 시 정상진행된다.")
		@Test
		public void validStageNumSuccess() throws Exception {
			// given
			int[] stageNums = {1, 5, 10, 100};
			// when
			// then
			for (int stageNum : stageNums) {
				try {
					Validator.validateStageNum(stageNum);
				} catch (IllegalArgumentException e) {
					fail();
				}
			}
		}

		@DisplayName("시도할 횟수는 양수여야 한다.")
		@Test
		public void validStageNumNegative() throws Exception {
			// given
			String errorMsg = "[ERROR] 시도할 횟수는 양수여야 한다.";
			int stageNum = -1;

			// when
			IllegalArgumentException ex1 = assertThrows(IllegalArgumentException.class,
				() -> Validator.validateStageNum(stageNum));

			// then
			assertEquals(ex1.getMessage(), errorMsg);
		}

		@DisplayName("시도할 횟수는 1 이상이어야 한다.")
		@Test
		public void validStageNumZero() throws Exception {
			// given
			String errorMsg = "[ERROR] 시도할 횟수는 1 이상이어야 한다.";
			int stageNum = 0;

			// when
			IllegalArgumentException ex1 = assertThrows(IllegalArgumentException.class,
				() -> Validator.validateStageNum(stageNum));

			// then
			assertEquals(ex1.getMessage(), errorMsg);
		}
	}

}