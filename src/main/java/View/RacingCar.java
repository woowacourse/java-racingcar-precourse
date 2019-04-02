package View;

/**
 * 자동차 게임의 화면과 진행 과정
 *
 * @version         1.00 2019년 04월 02일
 * @author          윤희현
 */
public class RacingCar {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은쉼표(,)기준으로구분)");
            racingGame.inputCarName();

            System.out.println("시도할 회수는 몇회인가요?");
            racingGame.inputNum();

            System.out.println("\n시행 결과");
            racingGame.play();

            racingGame.displayResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

