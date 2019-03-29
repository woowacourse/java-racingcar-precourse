package domain;

import java.util.ArrayList;

public class CarGroup {
    private final Class<Car> clazz_car = Car.class;
    private ArrayList<Car> carInstances;

    public CarGroup(String[] args) {
        carInstances = new ArrayList<Car>();
        try {
            for (int i = 0; i < args.length; i++) {
                Car instance = clazz_car.getConstructor(String.class).newInstance(args[i]);
                carInstances.add(instance);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void makeCarRace() {
        for (Car c : carInstances) {
            c.goRace();
        }
    }

    public void getMaxCar() {
        int max_position = 0;
        String carName = "";

        for (Car c : carInstances) {
            if (c.getPosition() > max_position) {
                max_position = c.getPosition();
                carName = c.getCarName();
            }
            if (c.getPosition() == max_position) {
                carName = carName + ", " + c.getCarName();
            }
        }
    }

    /**
     * 숫자를 하이픈의 반복횟수로 변환한다.
     * ex) generateStateBar(3) -> "---"
     * @param number
     * @return "-" * number
     */
    private String generateStateBar(int number) {
        return new String(new char[number]).replace("\0","-");
    }
}
