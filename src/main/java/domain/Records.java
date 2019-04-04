package domain;

import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Records {
    private final List<String> records = new ArrayList<>();

    void saveRecord(List<Car> cars) {
        String record = cars.stream()
                .map(this::parseToRecordingFormat)
                .collect(Collectors.joining());
        records.add(record);
    }

    private String parseToRecordingFormat(Car car) {
        return car.getName() + " : " + StringUtils.hyphenParser(car.getPosition()) + "\n";
    }

    public String getRecords() {
        return String.join("\n", records);
    }
}
