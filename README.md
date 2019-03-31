# java-racingcar
n대의 자동차 중 가장 멀리 움직인 자동차가 우승하는 경주 게임

## 제약 조건
주어진 Car class를 활용하여 경주 게임을 구현한다. (**단, Car를 수정할 수는 없고 확장만 할 수 있다.**)

```$java
 public class Car {
    private final String name;
    private int position = 0;
    
    public Car(String name) {
        this.name = name;
    }
    // 추가 기능 구현
 }
```

## 구현할 기능 목록
1. 플레이어로부터 n대의 자동차 이름을 입력 받는 기능
2. 플레이어로부터 게임 진행 회차를 입력 받는 기능

## 구현된 기능 목록

1. 0~9 사이의 난수 생성
    * 0~9을 초과하는 난수가 발생할 경우 실패하는 테스트 작성 후, 테스트를 성공시키는 난수 생성 클래스 구현
    * 난수 생성에는 Random 사용
    * Nested class를 사용하여 난수의 상한선(9)/하한선(0)을 따로 저장
    
2. 난수값이 4 이상이여야 전진하는 자동차 조종 기능
    * 난수가 4 미만인데 전진하거나, 4 이상인데 멈추는 경우 실패하는 테스트 작성. 이후 테스트를 성공시키도록 Car 클래스 구현.
    * 자동차의 이전 위치를 저장하는 prevPosition을 사용해 doesCarMoved()를 구현하고, 이를 test에 활용한다.
    