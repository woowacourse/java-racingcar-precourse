package domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingRefereeImpl implements RacingReferee {

    @Override
    public List<RacingCar> distinguishWinners(List<RacingCar> racingCars) {
        //todo: check convention
        int maxPosition = racingCars.stream()
                            .map(RacingCar::getPosition)
                            .max(Integer::compareTo)
                            .orElseThrow(IllegalArgumentException::new);

        return racingCars.stream().filter(racingCar -> racingCar.getPosition() == maxPosition).sorted().collect(Collectors.toList());
    }

    @Override
    public void announceResult(List<RacingCar> champions) {

    }
}
