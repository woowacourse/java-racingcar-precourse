package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;

public class GameManager {
    private static GameManager instance = null;
    private static final String ROUND_REGEX = "\\d";

    private ArrayList<Car> cars;
    private int totalRound;

    public static GameManager getInstance() {
        if (GameManager.instance == null) {
            GameManager.instance = new GameManager();
        }

        return GameManager.instance;
    }

    private GameManager() {
    }

    public void run() {
        initCars();
        setRound();

    }

    private void initCars() {
        while (true) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                this.cars = parseCars();
                break;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private ArrayList<Car> parseCars() {
        String buffer = Console.readLine();
        String[] carNames = buffer.split(",");
        HashSet<String> set = new HashSet<>();
        ArrayList<Car> ret = new ArrayList<>();

        for (int i = 0; i < carNames.length; i++) {
            String carName = carNames[i];

            if (carName.length() > 5) {
                throw new MyIllegalArgumentException(
                        String.format("Given input [%s]'s length must be shorter than 5", carName)
                );
            }

            if (carName.equals("")) {
                throw new MyIllegalArgumentException(
                        String.format("%dth car's name in empty. Name of car cannot be an empty string", i + 1)
                );
            }

            if (set.contains(carName)) {
                throw new MyIllegalArgumentException(
                        String.format("Duplicate car name %s. Car's name can not be duplicated", carName)
                );
            }

            set.add(carName);
            ret.add(new Car(carName));
        }

        return ret;
    }

    private void setRound() {
        while (true) {
            try {
                System.out.println("시도할 회수는 몇회인가요?");
                this.totalRound = parseRound();
                break;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private int parseRound() {
        String buffer = Console.readLine();

        if (!buffer.matches(GameManager.ROUND_REGEX)) {
            throw new MyIllegalArgumentException(
                    "Input must be a integer"
            );
        }

        if (buffer.length() > 2) {
            throw new MyIllegalArgumentException(
                    "Maximum round is 99"
            );
        }

        return Integer.parseInt(buffer);
    }
}
