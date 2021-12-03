package racingcar.race;

import racingcar.car.CarService;
import racingcar.car.dto.CarDto;
import utils.CarNameValidator;

import java.util.List;

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
                CarNameValidator.validateLengthInRange(name);
                carService.createCar(name);
            }
        }catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public void race(int numberOfRaces) {
        for(int i = 0; i < numberOfRaces; ++i) {
            carService.moveForward();
            showRaceResult();
        }
    }

    private void showRaceResult() {
        List<CarDto> carDtos = carService.getCars();
        for(CarDto carDto : carDtos)  {
            System.out.println(carDto.getState());
        }
        System.out.println();
    }

    public void showRaceWinner() {
        List<String> winners = carService.getWinner();
        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);
    }
}