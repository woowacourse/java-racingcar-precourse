/*
 *  @Name.java
 *
 *  @Version: 0.1
 *
 *  @Date: 2019.12.06
 *
 *  @Author: pandahun
 */

package domain;

public class Name {

    private static final int NAME_MAX_LENGTH = 5;
    private final String name;

    public Name(String name) {
        checkName(name);
        this.name = name;
    }

    private static void checkName(String name) {
        if(name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(name + "는 5글자를 초과한 이름입니다.");
        }
    }

    public String getName() {
        return name;
    }

}
