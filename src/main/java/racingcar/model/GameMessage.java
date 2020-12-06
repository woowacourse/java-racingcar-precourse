package racingcar.model;

public enum GameMessage {
    ENTER_CAR_NAMES("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)\n");

    private String gameMessage;

    GameMessage(String gameMessage) {
        this.gameMessage = gameMessage;
    }

    @Override
    public String toString() {
        return gameMessage;
    }
}
