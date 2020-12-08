package racingcar;

public class CarMaker {
    public static Car[] makeCarInstances(String[] carsList) {
        Car[] carInstances = new Car[carsList.length];
        for (int i = 0; i < carsList.length; i++) {
            carInstances[i] = new Car(carsList[i]);
        }
        return carInstances;
    }
}
