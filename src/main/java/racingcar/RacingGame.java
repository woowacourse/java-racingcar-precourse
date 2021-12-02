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
            //validateName(st.nextToken());
        }
    }

    private String inputCarNames() {
        return Console.readLine();
    }
}
