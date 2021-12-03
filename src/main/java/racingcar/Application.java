package racingcar;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public Car[] getInputCar() {
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

    public void run() {
        Car[] inputData = null;
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            try {
                inputData = getInputData();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 차의 이름은 5자 이내이어야 한다.");
            }
        }
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }
}

