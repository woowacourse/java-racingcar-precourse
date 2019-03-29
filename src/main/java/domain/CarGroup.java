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
}
