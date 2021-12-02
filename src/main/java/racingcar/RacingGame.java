package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class RacingGame {
    private int carNum;
    ArrayList<Car> carArrayList = new ArrayList<>();

    public void run() {
        initGame();
    }

    private void initGame() {
        processCarName(inputCarNames());
    }

    private void processCarName(String carNames) {
        StringTokenizer st = new StringTokenizer(carNames, ",");

        while(st.hasMoreTokens()) {
            validateName(st.nextToken());
        }
    }

    private void validateName(String carName) {
        if(isValid(carName)) {
            carArrayList.add(new Car(carName));
        }
    }

    private boolean isValid(String carName) {
        return carName.length() <= 5;
    }

    private String inputCarNames() {
        return Console.readLine();
    }
}
