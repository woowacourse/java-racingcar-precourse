package racingcar.domain;

import utils.RandomUtils;

public class Car {
    private static final int CRITERIA = 4;
    private static final int START_INDEX = 1;
    private static final int END_INDEX = 9;
    private final String name;
    private int position = 0;


    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    /**
     * 한 턴을 진행하여 일정한 확률로 전진을 결정한다.
     */
    public void oneTurn() {
        int randomCriteria = RandomUtils.nextInt(START_INDEX, END_INDEX);
        if (randomCriteria >= CRITERIA) {
            this.position++;
        }
    }

    /**
     * 지금 차가 최대 거리에 있는지에 대한 판단을 해주는 메서드
     * @param maxDistance 전체 게임 세트에서 최대거리로 판단된 수
     * @return 최대 거리인지 아닌지를 판단
     */
    public boolean isMaxDistance(int maxDistance) {
        if (this.position == maxDistance) {
            return true;
        }
        return false;
    }
}
