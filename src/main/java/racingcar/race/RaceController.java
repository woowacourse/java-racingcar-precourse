package racingcar.race;

import racingcar.car.CarService;
import utils.InputValidator;

public class RaceController {

    private final CarService carService;

    private RaceController() {
        carService = CarService.getInstance();
    }

    private static class InnerInstanceClazz  {
        private static final RaceController instance = new RaceController();
    }

    public static RaceController getInstance() {
        return InnerInstanceClazz.instance;
    }

    public boolean isSatisfyAllCarName(String[] carNames) {
        try{
            for (String name : carNames) {
                InputValidator.lengthInRange(name);
                carService.createCar(name);
            }
        }catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}