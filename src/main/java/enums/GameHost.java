package enums;

public enum GameHost {
    DELIMITER_TO_SPLIT_NAMES(","),
    DELIMITER_TO_SPLIT_WINNERS(", "),
    ASK_TURNS("시도할 횟수는 몇회인가요?"),
    ASK_NAMES_OF_CARS("경주할 자동차 이름을 입력하세요.(이름은 쉼표("
                        + DELIMITER_TO_SPLIT_NAMES.getMessage()
                        + ") 기준으로 구분)"),
    PROGRESS_RESULT("실행 결과"),
    PROGRESS_BAR("-"),
    FINAL_WINNER("최종 우승자: ");

    String message = "";

    GameHost(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
