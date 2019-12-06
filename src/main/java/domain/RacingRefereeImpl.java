package domain;

import java.util.List;

public class RacingRefereeImpl implements RacingReferee {

    private int maxPosition;

    public RacingRefereeImpl() {
        maxPosition = RacingGameConfig.DEFAULT_MAX_POSITION;
    }
    RacingRefereeImpl(int maxPosition) {
        this.maxPosition = maxPosition;
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

    @Override
    public boolean equals(Object object) {
        if ((object == null) || object.getClass() != this.getClass()) {
            return false;
        }

        return this.maxPosition == ((RacingRefereeImpl) object).maxPosition;
    }
}
