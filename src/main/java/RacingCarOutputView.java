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

    public void printWinner(RacingCarResult racingCarResult) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < racingCarResult.getWinner().size(); i++) {
            if(i == racingCarResult.getWinner().size()-1)
                stringBuilder.append(racingCarResult.getWinner().get(i).getName());
            else
                stringBuilder.append(racingCarResult.getWinner().get(i).getName() + ", ");
        }
        stringBuilder.append("가 최종 우승했습니다.");
        System.out.println(stringBuilder);
    }
} 
