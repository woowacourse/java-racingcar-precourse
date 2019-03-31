import com.conatuseus.racingcar.appcontroller.AppController;
import com.conatuseus.racingcar.appview.AppView;
import com.conatuseus.racingcar.model.Car;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestAppView {


    @Test
    public void 자동차_이름_입력_Test(){
        String[][] names={{"a","b","c","d","e"},            // 정상 입력
                {"abc","aaaaa","ccccc","qwert","zxcvb"},    //정상입력
                {"a"," abc","cde","dfg","eabc"},            // 빈칸 들어가서 비정상
                {"a","asw8","c","d","e"},                   // 숫자 들어갔으므로 비정상
                {"a","b","aoskdoskeok","d","e"},            // length때문에 비정상
                {"a","b","c","1234","e"},                   // 숫자있는 이름 = 비정상
                {"a","b","c","d","1234567"},                // 위와 동일
                {"abcde","abcde","abcde","abcde","abcde"}   // 중복된 이름 비정상
        };

        assertThat(AppView.isNamesValid(names[0]),is(true));
        assertThat(AppView.isNamesValid(names[1]),is(true));
        assertThat(AppView.isNamesValid(names[2]),is(false));
        assertThat(AppView.isNamesValid(names[3]),is(false));
        assertThat(AppView.isNamesValid(names[4]),is(false));
        assertThat(AppView.isNamesValid(names[5]),is(false));
        assertThat(AppView.isNamesValid(names[6]),is(false));
        assertThat(AppView.isNamesValid(names[7]),is(false));
    }

    @Test
    public void 자동차_Arraylist_추가_Test(){
        AppController.carList.add(new Car("a"));
        AppController.carList.add(new Car("b"));
        AppController.carList.add(new Car("c"));
        AppController.carList.add(new Car("d"));

        assertThat(AppController.carList.get(0).getName(),is("a"));
        assertThat(AppController.carList.get(1).getName(),is("b"));
        assertThat(AppController.carList.get(2).getName(),is("c"));
        assertThat(AppController.carList.get(3).getName(),is("d"));

    }

}
