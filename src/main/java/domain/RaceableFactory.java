package domain;

import java.util.List;

public interface RaceableFactory {
    List<Raceable> create(String[] names);
}
