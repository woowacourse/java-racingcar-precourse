package racingcar;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;

public class Application {
    static List<Car> carList = new ArrayList<>();
    static int tryTimes;
    static List<String> winnerNames = new ArrayList<>();

    static Message message = new Message();
    static StringManager stringManager = new StringManager();

    public static void main(String[] args) {
        createCars();
        setTryTimes();
        playGames();
        announceWinners();
    }

    static void createCars() {
        message.printGameCreateCars();
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
                carNames = stringManager.parseCarNamesInput(carNamesInput);
                return carNames;
            } catch (IllegalArgumentException e) {
                message.printNameInputError();
            }
        }
    }

    static void setTryTimes() {
        message.printGameSetTryTimes();
        tryTimes = getTryTimes();
    }

    static int getTryTimes() {
        String tryTimesInput;
        int tryTimesInt;

        while (true) {
            try {
                tryTimesInput = readLine();
                tryTimesInt = stringManager.toInt(tryTimesInput);
                return tryTimesInt;
            } catch (IllegalArgumentException e) {
                message.printTimeInputError();
            }
        }
    }

    static void playGames() {
        message.printStartPlayGames();
        //printGameMessage(GAME_PLAY_START);

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
}
