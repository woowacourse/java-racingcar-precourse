package racingcar;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;

public class Application {
    static List<Car> carList = new ArrayList<>();
    static int tryTimes;
    static List<String> winnerNames = new ArrayList<>();

    static final String parser = ",";

    static final int GAME_CREATE_CARS = 1;
    static final int GAME_SET_TRY_TIMES = 2;
    static final int GAME_PLAY_START = 3;

    static final int NAME_INPUT_ERROR = 1;
    static final int TIME_INPUT_ERROR = 2;

    public static void main(String[] args) {
        createCars();
        setTryTimes();
        playGames();
        announceWinners();
    }

    static void createCars() {
        printGameMessage(GAME_CREATE_CARS);
        String[] carNames = getCarNames();
        addCarsToCarList(carNames);
    }

    static void addCarsToCarList(String[] carNames) {
        for (String s : carNames) {
            Car c = new Car(s);
            carList.add(c);
        }
    }

    static String[] getCarNames() {
        String carNamesInput;
        String[] carNames;

        while (true) {
            try {
                carNamesInput = readLine();
                carNames = parseCarNamesInput(carNamesInput);
                return carNames;
            } catch (IllegalArgumentException e) {
                printErrorMessage(NAME_INPUT_ERROR);
            }
        }
    }

    static String[] parseCarNamesInput(String carNamesInput) {
        String[] carNames = carNamesInput.split(parser);

        for (String s : carNames) {
            if (s.length() > 5) {
                throw new IllegalArgumentException();
            }
        }

        return carNames;
    }

    static void setTryTimes() {
        printGameMessage(GAME_SET_TRY_TIMES);
        tryTimes = getTryTimes();
    }

    static int getTryTimes() {
        String tryTimesInput;
        int tryTimesInt;

        while (true) {
            try {
                tryTimesInput = readLine();
                tryTimesInt = makeStringToInt(tryTimesInput);
                return tryTimesInt;
            } catch (IllegalArgumentException e) {
                printErrorMessage(TIME_INPUT_ERROR);
            }
        }
    }

    static int makeStringToInt(String inputString) {
        int inputInt;

        try {
            inputInt = Integer.parseInt(inputString);
            return inputInt;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    static void playGames() {
        printGameMessage(GAME_PLAY_START);

        for (int i = 0; i < tryTimes; ++i) {
            playOneTurn();
        }
    }

    static void playOneTurn() {
        for (Car c : carList) {
            c.playMoving();
        }
        System.out.println();
    }

    static void announceWinners() {
        selectWinners();
        printWinners();
    }

    static void selectWinners() {
        int maxPosition = 0;

        for (Car c : carList) {
            int thisPosition = c.getPosition();
            if (maxPosition < thisPosition) {
                maxPosition = thisPosition;
                winnerNames.clear();
                winnerNames.add(c.getName());
                continue;
            }
            if (maxPosition == thisPosition) {
                winnerNames.add(c.getName());
            }
        }
    }

    static void printWinners() {
        int numberOfWinners = winnerNames.size();

        System.out.print("최종 우승자 : " + winnerNames.get(0));
        for (int i = 1; i < numberOfWinners; ++i) {
            System.out.print(", " + winnerNames.get(i));
        }
    }


    static void printGameMessage(int gameType) {
        if (gameType == GAME_CREATE_CARS) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            return;
        }
        if (gameType == GAME_SET_TRY_TIMES) {
            System.out.println("시도할 회수는 몇회인가요?");
            return;
        }
        if (gameType == GAME_PLAY_START) {
            System.out.println("\n실행 결과");
        }
    }

    static void printErrorMessage(int errorType) {
        if (errorType == NAME_INPUT_ERROR) {
            System.out.println("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
            return;
        }
        if (errorType == TIME_INPUT_ERROR) {
            System.out.println("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }
    }
}
