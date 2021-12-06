package racingcar.model.classes;

import java.util.List;

import racingcar.model.TrackInterface;

public class Track implements TrackInterface {

	@Override
	public String makeTrack(List<Car> Cars) {
		String track = "";
		for (Car car: Cars) {
			track += car.getLine();
			track += "\n";
		}
		return track;
	}
}
