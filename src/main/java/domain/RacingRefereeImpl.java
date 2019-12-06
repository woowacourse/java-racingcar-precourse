package domain;

import java.util.List;

public class RacingRefereeImpl implements RacingReferee {

    private int maxPosition;

    RacingRefereeImpl() {
        maxPosition = RacingGameConfig.DEFAULT_MAX_POSITION;
    }

    @Override
    public void updateMaxPosition(int position) {
        if (maxPosition < position) {
            maxPosition = position;
        }
    }

    @Override
    public boolean guaranteeChampion(RacingCar racingCar) {
        return false;
    }

    @Override
    public void announceResult(List<RacingCar> champions) {

    }
}
