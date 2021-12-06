package racingcar;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;

public class Application {
    static List<Car> carList = new ArrayList<>();
    static int tryTimes;

    static Message message = new Message();
    static StringManager stringManager = new StringManager();
    static Winners winners = new Winners();

    public static void main(String[] args) {
        createCars();
        setTryTimes();
        playGames();
        winners.announceWinners(carList);
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

}
