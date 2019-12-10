/*
 * 레이싱 게임을 위한 자동차 클래스
 *
 * @version 1.0
 *
 * @date 2019.12.08
 * 
 * @author Jung dahee
 */

package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    
    public String getName() {
    	return name;
    }
    
    public int getPosition() {
    	return position;
    }
    
    public void moveForward() {
    	this.position++;
    }
}
