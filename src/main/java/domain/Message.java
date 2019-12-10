/*
 * Copyright (c) 2019 by SorinJin
 * All rights reserved.
 *
 * Message.java
 * 입출력 메세지들을 담고 있는 enum
 *
 * @author      Sorin Jin
 * @version     1.0
 * @date        09 Dec 2019
 *
 */

package domain;

public enum Message {

    INPUT_CAR_NAME_MESSAGE("경주할 자동자 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_NUMBER_OF_ROUNDS_MESSAGE("시도할 횟수는 몇 회 인가요? "),
    RESULT_MESSAGE("실행 결과"),
    WINNER_MESSAGE("가 최종 우승하였습니다."),
    INPUT_NAME_LENGTH_ERROR("이름은 1~5자 사이로 입력하세요."),
    INPUT_CAR_COUNT_ERROR("두 대  이상의 자동차를 입력하세요."),
    INPUT_DUPLICATION_ERROR("중복된 이름이 있습니다."),
    INPUT_NOT_A_NUMBER_ERROR("숫자를 입력해주세요."),
    INPUT_ZERO_ERROR("1이상의 수를 입력해주세요.");

    private String message;

    Message(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}