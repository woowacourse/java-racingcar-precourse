package utils;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomGenerate {
    public int pickNum(){
        int pickedNum = pickNumberInRange(0,9);
        return pickedNum;
    }
}
