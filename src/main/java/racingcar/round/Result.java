package racingcar.round;

import racingcar.Car;

public class Result {
    private String carName;
    private String progress;

    public Result(String carName, int progress) {
        this.carName = carName;
        this.progress = repeat(progress);
    }

    private String repeat(int time) {
        String result = "-";

        if(time == 0)
            return "";

        for(int i = 1; i < time; i++) {
            result += result;
        }
        return result;
    }

    public static String resultOf(Car car) {
        Result result = new Result(car.getName(), car.getPosition());
        return result.carName + " : " + result.progress;
    }
}
