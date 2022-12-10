package racingcar.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarOperator {
    private final NumberGenerate numberGenerate;
    private final int carAmount;

    public CarOperator(NumberGenerate numberGenerate, int carAmount) {
        this.numberGenerate = numberGenerate;
        this.carAmount = carAmount;
    }

    public List<Integer> tempPosition() {
        return IntStream.range(0, carAmount).mapToObj(index -> numberGenerate.generate()).collect(Collectors.toList());
    }
}
