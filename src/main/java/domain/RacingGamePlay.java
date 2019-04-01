package domain;

public class RacingGamePlay {

    private User user;

    public RacingGamePlay() {
        user = new User();
    }

    public void play() {
        user.input();
        System.out.println(java.util.Arrays.toString(user.getCarNames()));
        System.out.println(user.getNumberOfTrials());
    }
}
