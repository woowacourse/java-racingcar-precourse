/*
 * class: ComparingCarName
 *
 * version: 2.0
 *
 * date: 2019.12.08
 *
 * 이 프로그램의 저작권은 정은석에게 있습니다.
 * Copyright 2019.12.08
 */

package domain;

/**
 * 중복되는 이름을 구별해주는 기능
 *
 * @author joseph415
 * @version 2.0 2019.12.08
 */
public class ComparingCarName {

    /**
     * 중복을 걸러주는 매소드
     * @param carName 비교할 차의 이름
     * @param carList 차이름을 담고있는 배열
     * @param selfIndex 비교할 차의 배열의 위치를 나타내는 Index
     * @return 같은 이름이 있으면 true 리턴
     */
    public boolean compareName(String carName,String[] carList,int selfIndex){
        int compareIndex = selfIndex +1;

        for(int i=compareIndex;i<carList.length;i++){
            if(carName.equals(carList[i])){
                return true;
            }
        }
        return false;
    }
}
