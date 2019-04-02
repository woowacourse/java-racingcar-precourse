package domain;

public class RacingGamePlay {

    private User user;
    private ManageCars cars;

    public RacingGamePlay() {
        user = new User();
        cars = new ManageCars(user.getCarNames());
    }

    public void play() {
        int trialCount;

        System.out.println("실행 결과");
        trialCount = user.getNumberOfTrials();
        while(trialCount > 0){

            trialCount--;
        }
    }
}
