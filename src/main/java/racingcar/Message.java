package racingcar;

public class Message {

    public Message() {
    }

    public void printGameCreateCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printGameSetTryTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printStartPlayGames() {
        System.out.println("\n실행 결과");
    }

    public void printNameInputError() {
        System.out.println("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
    }

    public void printTimeInputError() {
        System.out.println("[ERROR] 시도 횟수는 숫자여야 합니다.");
    }
}
