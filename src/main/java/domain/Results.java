package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Results {

    private final List<Result> results = new ArrayList<>();

    public void add(Result result) {
        results.add(result);
    }

    public String getResults() {
        return results.stream()
                .map(Result::getResult)
                .collect(Collectors.joining("\n"));
    }

    public List<String> getWinners() {
        Result lastResult = results.get(results.size() - 1);
        return lastResult.getWinners();
    }

}
