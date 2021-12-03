package racingcar;

public class Application {
    public static void main(String[] args) {

        User user = new User();

        System.out.println("경주할 자동차 이름은 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        user.enterCarName();
        user.toNameArray();


    }
}
