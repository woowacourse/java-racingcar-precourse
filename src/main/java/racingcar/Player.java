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
        try {
            cars = splitString(names);
            for (int i = 0; i < cars.length; i++) {
                checkNames(cars[i]);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getCarNames();
        }

    }

    public String[] splitString(String str) {
        return str.split(",");
    }

    public void getRounds() {
        System.out.println(GET_ROUNDS);
        String tmp = Console.readLine();
        try {
            checkRounds(tmp);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getRounds();
        }
    }

    public void checkNames(String name) throws IllegalArgumentException {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 이름은 다섯 글자를 넘길 수 없다.");
        }
    }

    public void checkRounds(String rounds) throws IllegalArgumentException {
        try {
            this.rounds = Integer.parseInt(rounds);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
        }
    }
}
