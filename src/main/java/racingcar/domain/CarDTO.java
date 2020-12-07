/**
 * CarDTO.java
 * Car객체에 대한 DTO 클래스
 *
 * 수정: Kimun Kim, github.com/tributetothemoon
 */

package racingcar.domain;

public class CarDTO {
    private final String name;
    private final int position;

    public CarDTO(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
