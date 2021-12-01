package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class EngineRepository {
    private final List<Engines> engineRepository;

    public EngineRepository(List<String> values) {
        this.engineRepository = values.stream().map(Engines::new).collect(Collectors.toList());
    }

    public int size() {
        return engineRepository.size();
    }

    public Engines get(int index) {
        return engineRepository.get(index);
    }
}
