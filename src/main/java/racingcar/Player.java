package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private final String ASK_CAR_NAME =  "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String GET_ROUNDS = "시도할 회수는 몇회인가요?";
    int rounds;
    String[] cars;

    Player() {
        getCarNames();
        getRounds();
    }

    public void getCarNames() {
        System.out.println(ASK_CAR_NAME);
        String names = Console.readLine();
        cars = splitString(names);
    }

    public String[] splitString(String str) {
        return str.split(",");
    }

    public void getRounds() {
        System.out.println(GET_ROUNDS);
        rounds = Integer.parseInt(Console.readLine());
    }
}
