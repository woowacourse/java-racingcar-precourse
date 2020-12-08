package racingcar;

public interface IRacingGame {
    /** 이름 입력이 준비됨을 출력 */
    void readyForSetCars();

    /**
     * 입력값으로 Car 생성을 시도하고 성공여부를 반환
     * @param names Car 생성에 필요한 이름 입력값
     * @return 성공여부
     */
    boolean trySetCars(String names);

    /** 시도 횟수 입력이 준비됨을 출력 */
    void readyForSetReps();

    /**
     * 입력값으로 시도 횟수 저장을 시도하고 성공여부를 반환
     * @param reps 시도 횟수 입력값
     * @return 성공여부
     */
    boolean trySetReps(String reps);

    /** 게임 시작 */
    void start();
}
