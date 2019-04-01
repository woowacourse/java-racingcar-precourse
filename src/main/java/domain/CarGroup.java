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

    public String getMaxCar() {
        int max_position = 0;
        ArrayList<String> winnerNames = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (Car c : carInstances) {
            if (c.getPosition() > max_position) {
                max_position = c.getPosition();
            }
        }

        for (Car c : carInstances) {
            if (c.getPosition() == max_position) {
                winnerNames.add(c.getCarName());
            }
        }

        for (String s : winnerNames) {
            sb.append(",");
            sb.append(s);
        }


        return sb.toString().substring(1);
    }

    /**
     * 숫자를 하이픈의 반복횟수로 변환한다.
     * ex) generateStateBar(3) -> "---"
     * @param number
     * @return "-" * number
     */
    private String generateStateBar(int number) {
        return new String(new char[number]).replace("\0", "-");
    }

    public String getRaceState() {
        StringBuilder sb = new StringBuilder();

        for (Car c : carInstances) {
            sb.append(c.getCarName() + " : ");
            sb.append(generateStateBar(c.getPosition()));
            sb.append("\n");
        }

        return sb.toString();
    }
}
