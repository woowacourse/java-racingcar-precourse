package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.OutputView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;

public class CarsTest {

    @Test
    public void wrongLengthOfNameTest() {
        try{
            List<String> list = new ArrayList<>();
            list.add("pobi");
            list.add("crongi");
            Cars.of(list);
        }catch (IllegalArgumentException e){
            OutputView.showErrorMessage(e);
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    public void wrongNumberOfCarTest() {
        try{
            List<String> list = new ArrayList<>();
            list.add("pobi");
            Cars.of(list);
        }catch (IllegalArgumentException e){
            OutputView.showErrorMessage(e);
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    public void alreadyExistNameTest() {
        try{
            List<String> list = new ArrayList<>();
            list.add("pobi");
            list.add("pobi");
            Cars.of(list);
        }catch (IllegalArgumentException e){
            OutputView.showErrorMessage(e);
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
        }
    }
}
