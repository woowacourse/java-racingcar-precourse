package domain;

public class Car {

    /**
     * 0에서 9까지 랜덤 정수를 만들기 위한 상수
     */
    private final static int RANGE = 10;
    private final static int GO = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String raceStatus() {
        if ((int) (Math.random() * RANGE) >= GO) {
            position++;
        }
        return getPositionInfo();
    }

    public String getPositionInfo() {
        String positionInfo = name + " : ";
        for (int i = 0; i < position; i++) {
            positionInfo += "-";
        }
        return positionInfo;
    }

    public boolean isMaxPosition(int MAX) {
        return position == MAX;
    }

    public String getName() {
    	return name;
	}

    public int getPosition() {
        return position;
    }
}
