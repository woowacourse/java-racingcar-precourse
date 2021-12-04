package racingcar.validation;

public enum ExceptionCase {

    // 예외 문자 입력을 위한 예외 케이스
    CONTAIN_NUMBER("pobi,123,jun"),
    CONTAIN_SPACE("pobi, woni,jun"),
    START_WITH_SPACE(" pobi,woni,jun"),

    // 입력값 길이 검증을 위한 예외 케이스
    EXCEED_LENGTH("pobi,woni,woowahan"),
    LACK_LENGTH(",pobi,jun"),

    // 중복값 검증을 위한 예외 케이스
    DUPLICATED("pobi,woni,pobi");

    private String content;

    ExceptionCase(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
