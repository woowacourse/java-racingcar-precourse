package racingcar.model;

public enum GameMessage {
    ENTER_CAR_NAMES("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)\n"),
    ENTER_NUMBER_OF_MOVES("시도할 횟수는 몇회인가요?\n"),
    ERROR_INVALID_INPUT("[ERROR] 잘못된 입력입니다. 다시 입력해주세요.\n");

    private String gameMessage;

    GameMessage(String gameMessage) {
        this.gameMessage = gameMessage;
    }

    @Override
    public String toString() {
        return gameMessage;
    }
}
