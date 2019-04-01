package domain;

public class Main {
    public static void main(String[] args) {
        Control control = new Control();

        control.userInputCarNames();
        control.userInputLimitTime();
        // 유저로부터 car 이름과 총 시도 횟수를 입력받아 게임을 셋팅할 함수

        control.gameStart();
        control.gameEnd();
    }
}