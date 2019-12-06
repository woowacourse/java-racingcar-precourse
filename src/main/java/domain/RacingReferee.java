package domain;

import java.util.List;

public interface RacingReferee {
    void updateMaxPosition(int position);

    boolean guaranteeChampion(RacingCar racingCar);

    void announceResult(List<RacingCar> champions);
}
