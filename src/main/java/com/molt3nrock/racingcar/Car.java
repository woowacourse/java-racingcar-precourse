package com.molt3nrock.racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car implements Comparable {

    private final static int POSITION_INCREMENT = 1;
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name.length() > 5 || name.length() < 1) {
            String errorMessage = String.format("Car: %s은 잘못된 이름입니다. 1~5자 사이의 길이로 입력해주세요.", name);
            throw new IllegalArgumentException(errorMessage);
        }
        this.name = name;
    }

    /**
     * 무작위 생성방법: 0~9까지의 숫자를 원소로하는 ArrayList 를 {@code Collections.shuffle}을 이용하여
     * 랜덤하게 섞은후 첫번째 위치에 있는 숫자를 고릅니다.
     */
    public void move() {
        final int VALID_RANDOM_MIN = 0;
        final int VALID_RANDOM_MAX = 9;
        final int MOVE_THRESHOLD = 4;
        ArrayList<Integer> randoms = IntStream
            .range(VALID_RANDOM_MIN, VALID_RANDOM_MAX)
            .boxed()
            .collect(Collectors.toCollection(ArrayList::new));
        Collections.shuffle(randoms);
        Integer pick = randoms.get(0);
        if (pick >= MOVE_THRESHOLD) {
            position += POSITION_INCREMENT;
        }
    }

    public String getName() {
        return this.name;
    }

    public String getPositionAsDashLine() {
        return String.join("", Collections.nCopies(position, "-"));
    }

    /**
     * Car 클래스의 {@code name} 과 {@code position} 을 주어진 형식값에 맞게 {@code String}으로 변환합니다.
     * 예시) car.name = "fo", car.position = 3 일 때, car.format(3) == " fo : ---"
     *
     * @param nameWidth {@code name} 공백 채우기의 넓이. {@code name}의 길이가
     *                  {@code nameWidth}보다 짧을 경우 왼쪽에 공백 문자를 채웁니다.
     */
    public String format(int nameWidth) {
        if (nameWidth < 1) {
            throw new IllegalArgumentException("Invalid Car name width format specifier.");
        }
        String formatString = String.format("%%%ds", nameWidth);
        return String.format(formatString + " : " + getPositionAsDashLine(), this.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car) {
            Car other = (Car) obj;
            // position 을 기준으로 동등성 비교
            return this.position == other.position;
        }
        return false;
    }

    public int compareTo(Object obj) {
        if (obj instanceof Car) {
            Car other = (Car) obj;
            // position 을 기준으로 내림차순 정렬을 위해 큰값이 먼저 오도록 비교 Integer.compare 호출
            return Integer.compare(other.position, this.position);
        }
        return 0;
    }
}
