package racingcar.resource.message;

import racingcar.resource.rule.CountRange;
import racingcar.resource.rule.NameLength;

public class ErrorMessage {

    public static final String TAG = "[ERROR] ";

    public static final String NAME_DUPLICATE_MESSAGE = "중복된 이름이 있습니다.";
    public static final String NAME_EMPTY_MESSAGE = "공백은 이름이 될 수 없습니다.";
    public static final String NAME_TOO_LONG_MESSAGE = String.format("이름은 %d자 이내여야 합니다.", NameLength.getMaximum());

    public static final String COUNT_NOT_NUMBER_MESSAGE = "숫자가 아닙니다.";
    public static final String COUNT_TOO_SMALL_MESSAGE = String.format("이동횟수는 %d 이상이어야 합니다.", CountRange.getMinimum());

}
