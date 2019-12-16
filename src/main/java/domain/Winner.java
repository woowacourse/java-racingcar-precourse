package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    private List<String> winner = new ArrayList<>();

    public String getWinner(List<Car> carList) {
		int max = carList.stream()
				.collect(Collectors.summarizingInt(car -> car.getPosition()))
				.getMax();
        for (Car car : carList) {
			if (car.isMaxPosition(max)){
				winner.add(car.getName());
			}
        }
        return String.join(",", winner);
    }
}
