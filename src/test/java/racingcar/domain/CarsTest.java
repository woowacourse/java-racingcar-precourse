package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

class CarsTest {

    @Test
    public void 경주에_참여할_자동차를_생성한다() throws Exception {
        //given
        List<String> participants = Arrays.asList("java", "c++", "react");

        //when
        HashSet<Car> cars = participants.stream()
                .map(Car::new)
                .collect(Collectors.toCollection(HashSet::new));

        //then
        Assertions.assertThat(cars.size()).isEqualTo(3);
    }
}