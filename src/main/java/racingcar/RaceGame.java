package racingcar;

public class RaceGame {

    private final RacingCircuit racingCircuit;
    private final int maxAttempt;
    private int currentAttempt;

    public RaceGame(String[] carNameArray, int maxAttempt) {
        this.maxAttempt = maxAttempt;
        this.racingCircuit = new RacingCircuit(carNameArray);
        currentAttempt = 0;
    }

    // 서킷 내의 모든 차들이 전진을 시도하고, 현재까지의 전진 시도 횟수를 1 증가
    public void accelerateCars() {
        for (Car car : racingCircuit.getCarList()) {
            car.accelerate();
        }
        currentAttempt++;
    }

    public boolean isFinished() {
        return maxAttempt == currentAttempt;
    }

    public RacingCircuit getRacingCircuit() {
        return racingCircuit;
    }
}
