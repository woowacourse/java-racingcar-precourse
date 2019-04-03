package com.nekisse.domain;

import org.junit.Test;

public class CarNameTest {

    @Test()
    public void 자동차이름_5글자_이하_생성() {
        CarName.newCarName("12345");
        CarName name = CarName.newCarName("가나다라마");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 자동차이름_5글자_초과_익셉션() {
        CarName.newCarName("123456");
    }

}