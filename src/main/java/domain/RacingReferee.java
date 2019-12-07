package domain;

import java.util.List;

public interface RacingReferee {
    List<RacingCar> distinguishWinners(List<RacingCar> racingCars);
    void announceResult(List<RacingCar> champions);
}
