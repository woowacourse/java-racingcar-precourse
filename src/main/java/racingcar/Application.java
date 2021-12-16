package racingcar;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String SPLIT_REGEX = ",";

    public Car[] getInputCarList() {
        String inputData = InputView.getUserData();
        String[] carNameList = inputData.split(SPLIT_REGEX);
        Car[] carList = new Car[carNameList.length];

        for (int i = 0; i < carNameList.length; i++) {
            Validators.validateCarName(carNameList[i]);
            carList[i] = new Car(carNameList[i]);
        }
        return carList;
    }

    public Car[] getCarList() {
        Car[] carList = null;
        while (true) {
            OutputView.println(OutputView.INTRO_INPUT_CAR);
            try {
                carList = getInputCarList();
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
        return carList;
    }

    public int getInputTryCount() {
        String InputData = InputView.getUserData();
        Validators.validateTryCount(InputData);
        int tryCount = Integer.parseInt(InputData);
        return tryCount;
    }

    public int getTryCount() {
        int tryCount = -1;
        while (true) {
            OutputView.println(OutputView.INTRO_INPUT_TRY_COUNT);
            try {
                tryCount = getInputTryCount();
                return tryCount;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    public void moveTotalCar(Car[] carList) {
        for (Car car : carList) {
            car.movement();
        }
    }

    public void printTotalCar(Car[] carList) {
        for (Car car : carList) {
            printCarData(car);
        }
    }

    public String[] getWinnerList(Car[] carList) {
        int maxValue = -1;
        int WinnerCount = 0;

        for (Car car : carList) {
            if (car.getPosition() == maxValue) {
                WinnerCount++;
                continue;
            }

            if (car.getPosition() > maxValue) {
                maxValue = car.getPosition();
                WinnerCount = 1;
            }
        }

        String[] winnerList = new String[WinnerCount];
        int index = 0;
        for (Car car : carList) {
            if (car.getPosition() == maxValue) {
                winnerList[index++] = car.getName();
            }
        }

        return winnerList;
    }

    public void printWinner(String[] winnerList) {
        OutputView.print(OutputView.INTRO_WINNER);
        for (int i = 0; i < winnerList.length; i++) {
            OutputView.print(winnerList[i]);
            if (i != winnerList.length-1) {
                OutputView.print(", ");
            }
        }
        OutputView.printBlank();
    }

    public void printCarData(Car car) {
        OutputView.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            OutputView.print("-");
        }
        OutputView.printBlank();
    }

    public void run() {
        Car[] carList = getCarList();
        int tryCount = getTryCount();
        System.out.println();

        for (int i = 0; i < tryCount; i++) {
            moveTotalCar(carList);
            printTotalCar(carList);
            System.out.println();
        }

        String[] winnerList = getWinnerList(carList);
        printWinner(winnerList);
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }
}

