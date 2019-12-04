package view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputTest {
    @Test
    public void initTest() {
        Input input = new Input();
        assertThat(input).isNotNull();
    }

}