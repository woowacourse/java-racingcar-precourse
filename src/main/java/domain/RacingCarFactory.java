package domain;

import java.util.List;

public interface RacingCarFactory {
    List<RacingCar> create(String[] names);
}
