package racingcar;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public Car[] getInputCarList() {
        String inputData = Console.readLine();
        String[] carNameList = inputData.split(",");
        Car[] carList = new Car[carNameList.length];

        for (int i = 0; i < carNameList.length; i++) {
            if (carNameList[i].length() > 5) {
                throw new IllegalArgumentException();
            }
            carList[i] = new Car(carNameList[i]);
        }
        return carList;
    }

    public Car[] getCarList() {
        Car[] carList = null;
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            try {
                carList = getInputCarList();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 차의 이름은 5자 이내이어야 한다.");
            }
        }
        return inputData;
    }

    public int getInputTryCount() {
        String InputData = Console.readLine();
        try {
            int tryCount = Integer.parseInt(InputData);
            return tryCount;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public int getTryCount() {
        int tryCount = -1;
        while (true) {
            System.out.println("시도할 회수는 몇회인가요?");
            try {
                tryCount = getInputTryCount();
                return tryCount;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 시도 회수는 숫자여야 한다.");
            }
        }
    }

    public void run() {
        Car[] carList = getCarList();
        int tryCount = getTryCount();
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }
}

