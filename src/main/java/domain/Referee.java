package domain;

import java.util.List;

public interface Referee {
    void updateMaxPosition(int position);

    boolean guaranteeChampion(RacingCar racingCar);

    void announceResult(List<RacingCar> champions);
}
