package preprocess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputPreProcessTest {

    @Test
    void getNames() {

        InputPreProcess in = new InputPreProcess();

        // 이름 길이가 5 넘어갈 경우
        String str = "name,namee,namethree";
        String[] names = in.getNames(str);
        assertNull(names);

        // 쉼표를 잘못 넣었을 경우
        str = "nameo,namet.namee";
        names = in.getNames(str);
        assertNull(names);

        // 정상
        str = "named,이름,na이름";
        names = in.getNames(str);
        assertArrayEquals(new String[]{"named", "이름", "na이름"}, names);

    }
}