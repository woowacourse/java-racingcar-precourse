import domain.Car;

public class RacingCarOutputView {
    public void printResultHeader() {
        System.out.println("\n실행 결과");
    }

    public String printPosition(Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < car.getPosition(); i++) stringBuilder.append("-");
        return stringBuilder.toString();
    }

    public void printTryResult(RacingCarResult racingCarResult) {
        StringBuilder stringBuilder = new StringBuilder();
        for(Car car : racingCarResult.getCars()) {
            stringBuilder.append(car.getName() + " : " +printPosition(car) + "\n");
        }
        System.out.println(stringBuilder);
    }
} 
