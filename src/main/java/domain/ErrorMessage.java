/*
 * 클래스 이름: ErrorMessage.java
 * 버전 정보: 1.0.0
 * 날짜: 2019/04/03
 * Copyright 2019 Inkwon Lee
 */
package domain;

/*
 * ErrorMessage 를 등록 및 사용 하는 클래스
 */
public enum ErrorMessage {

    ERROR_OVERLAP_NAME("중복된 이름이 있습니다. 다시 입력해 주세요."),
    ERROR_OVER_LENGTH("이름에 5글자가 넘습니다. 5자 이하로 다시 입력해 주세요."),
    ERROR_OTHER_TRY_NUMBER("정수 외에 다른 문자가 입력되었습니다. 정수만 입력해 주세요."),
    ERROR_BLANK_TRY_NUMBER("아무것도 입력이 안됐습니다. 다시 입력해 주세요."),
    ERROR_BLANK_NAME("이름중에 빈칸이 있거나 입력이 안된 이름이 있습니다. 빈칸없이 다시 입력해 주세요."),
    ERROR_ONE_NAME("이름이 하나만 입력 되었습니다. 2명이상 입력해 주세요."),
    ERROR_NULL_NAME("등록된 이름이 없습니다. 다시 입력해주세요."),
    ERROR_HAVE_LAST_COMMA("마지막에 이름이 입력되지 않았습니다. 다시 입력해 주세요.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
