package domain;

import java.util.List;

public interface RacingCarFactory {
    List<Raceable> create(String[] names);
}
