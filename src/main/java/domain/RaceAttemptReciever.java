package domain;

public class RaceAttemptReciever {

    private void RecieveRaceAttemptsFromUser(){
        try {
            tryToRecieveRaceAttemptsFromUser();
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
            tryToRecieveRaceAttemptsFromUser();
        }
    }

    private void tryToRecieveRaceAttemptsFromUser(){
        System.out.println("이후 구현 예정");
    }
}
