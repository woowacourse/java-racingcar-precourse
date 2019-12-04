package system;

import domain.Car;
import io.InputRacingCar;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class RacingCarSystem {
    private int repeatTime;
    private String[] carNameArr;
    private List<Car> cars = new LinkedList<>();

    public void setUpRacing() {
        String carsName = InputRacingCar.inputCarsName();
        setCarNameArr(carsName);
        setCarList();
        repeatTime = InputRacingCar.inputRepeatTime();
    }

    public void setCarNameArr(String carsName) {
        StringTokenizer st = new StringTokenizer(carsName, ",");
        carNameArr = new String[st.countTokens()];

        int index = 0;
        while (st.hasMoreTokens()) {
            carNameArr[index] = st.nextToken();
            index++;
        }
    }

    public void setCarList() {
        for (int i = 0; i < carNameArr.length; i++) {
            cars.add(new Car(carNameArr[i]));
        }
    }

    public int generateRandomNumber() {
        return (int) (Math.random() * 10);
    }

    public void startRacing() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < repeatTime; i++) {
            if (generateRandomNumber() > 3) {
                // TODO: 2019-12-04 전진
            }
            // TODO: 2019-12-04 이동 결과 출력
        }
    }
}
