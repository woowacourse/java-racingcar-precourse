package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public int getPosition()
    {
        return position;
    }
    public void start()
    {
        int dice = pickNumberInRange(0,9);
        if (canGo(dice))
            move();
    }
    private boolean canGo(int dice)
    {
        if (dice >= 4)
            return true;
        return false;
    }
    private void move()
    {
        position += 1;
    }
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" : ");

        for(int i=0;i<position;i++)
            sb.append("-");

        return sb.toString();
    }


}
