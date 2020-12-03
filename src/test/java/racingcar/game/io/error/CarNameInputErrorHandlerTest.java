package racingcar.game.io.error;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.game.Cars;

class CarNameInputErrorHandlerTest {
    private final CarNameInputErrorHandler errorHandler
        = new CarNameInputErrorHandler();

    @DisplayName("정상 입력")
    @Test
    void validInput() {
        String[] carNames = {"abc,abcde", "가나다,가나다라마,ㅁㄴㅇ", "ㅁㄴㅇ,ㅣㅏㅓㅣ,ab,가나"};
        for (String carName : carNames) {
            assertTrue(errorHandler.createAndStoreIfIsValidInput(carName, new Cars()));
        }
    }

    @DisplayName("자동차 이름이 두 개 이상이 아닌 경우(쉼표(,)가 하나도 없는 경우)")
    @Test
    void duplicateCarNameError() {
        String[] carNames = {"", "abcd"};
        for (String carName : carNames) {
            assertFalse(errorHandler.createAndStoreIfIsValidInput(carName, new Cars()));
        }
    }

    @DisplayName("맨 앞이나 맨 뒤에 쉼표(,)가 존재하는 경우")
    @Test
    void invalidCommaInputError() {
        String[] carNames = {",asd", "abcd,"};
        for (String carName : carNames) {
            assertFalse(errorHandler.createAndStoreIfIsValidInput(carName, new Cars()));
        }
    }

    @DisplayName("자동차 이름이 한글 이나 영어가 아닌 경우")
    @Test
    void notEnglishOrKoreanError() {
        String[] carNames = {"abc,3ds", "가나다,ㅁㄴ*"};
        for (String carName : carNames) {
            assertFalse(errorHandler.createAndStoreIfIsValidInput(carName, new Cars()));
        }
    }

    @DisplayName("자동차 이름의 길이가 1자 이상, 5자 이하가 아닌 경우")
    @Test
    void notCorrectCarNameLengthError() {
        String[] carNames = {"abc,abcdef"};
        for (String carName : carNames) {
            assertFalse(errorHandler.createAndStoreIfIsValidInput(carName, new Cars()));
        }
    }

    @DisplayName("자동차 이름의 개수가 10대 이하가 아닌 경우")
    @Test
    void overTenCarNamesError() {
        String[] carNames = {"aaa,bbb,ccc,ddd,eee,fff,ggg,hhh,iii,jjj,kkk"};
        for (String carName : carNames) {
            assertFalse(errorHandler.createAndStoreIfIsValidInput(carName, new Cars()));
        }
    }

    @DisplayName("중복된 이름이 있는 경우")
    @Test
    void duplicatedCarNameError() {
        String[] carNames = {"abc,abcef,abc", "ㅁㅁ,sfd,ㅁㅁ"};
        for (String carName : carNames) {
            assertFalse(errorHandler.createAndStoreIfIsValidInput(carName, new Cars()));
        }
    }
}