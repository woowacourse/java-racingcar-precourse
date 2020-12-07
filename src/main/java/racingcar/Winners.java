package racingcar;

import java.util.ArrayList;

public class Winners {
    private int position = -1;
    private ArrayList<Car> cars;

    public Winners() {
        cars = new ArrayList<Car>();
    }

    public Winners(Car car) {
        setWinners(car);
    }

    // 입력받은 자동차와 비교하여 우승자들의 정보를 갱신한다.
    public void updateWinners(Car car) {
        int carPosition = car.getPosition();
        if (getPoisition() == carPosition) {
            // 최대값일 경우 우승자 리스트에 추가한다.
            addWinner(car);
            return;
        }
        if (getPoisition() < carPosition) {
            // 현재 최대값보다 더 멀리간 자동차가 있을 경우 최대값을 갱신하고 우승자 리스트를 새로 만든다.
            setWinners(car);
            return;
        }
    }

    // 입력받은 자동차를 우승자로 설정한다.
    private void setWinners(Car car) {
        position = car.getPosition();
        cars = new ArrayList<Car>();
        cars.add(car);
    }

    private void addWinner(Car car) {
        cars.add(car);
    }

    private int getPoisition() {
        return position;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }
}
