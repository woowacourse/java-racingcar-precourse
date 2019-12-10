package system;

import domain.Car;
import domain.RacingCars;

import java.util.List;

public class RacingCarSystem {
    public void run() {
        SettingSystem settingSystem = new SettingSystem();
        RacingCars racingCars = settingSystem.setRacingCars();
        List<Car> racingCarsList = racingCars.getCarList();

        RacingSystem racingSystem = new RacingSystem(racingCarsList);
        racingSystem.startRacing();

        RankingSystem rankingSystem = new RankingSystem(racingCarsList);
        rankingSystem.startRanking();
    }
}