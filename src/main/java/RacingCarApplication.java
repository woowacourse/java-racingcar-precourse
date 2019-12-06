import system.RacingCarSystem;

public class RacingCarApplication {
    public static void main(String[] args) {
        RacingCarSystem racingCarSystem = new RacingCarSystem();
        racingCarSystem.setUpRacing();
        racingCarSystem.startRacing();
        racingCarSystem.finishRacing();
    }
}
