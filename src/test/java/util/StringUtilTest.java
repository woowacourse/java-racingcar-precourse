package util;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StringUtilTest {

    @Test
    public void 문자열_반복_테스트() {
        //given
        String str = "-";
        int repeat = 3;

        //when
        String repeatedStr = StringUtil.repeatString(str, repeat);

        //then
        assertThat(repeatedStr, is("---"));
    }
}