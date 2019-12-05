# 우아한 테크코스 2주차 자동차 게임

- 입력된 사용자마다 난수를 생성해 4이상이면 전진, 미만이면 정지를 수행하고 결과를 출력한다. 최종적으로 가장 많이 전진한 사람들을 출력한다.

## 프로그래밍 규칙

- 3항연산자를 사용하지 않는다.
- indent depth는 2이하로
- 자바 코드 컨벤션을 지킨다
- 메서드는 15라인을 넘지 않는다.
- else 예약어를 사용하지 않는다. 

## 기능 구현

- 사용자 입력 (O)

    - 사용자는 자동차의 이름을 입력할 수 있다. (O)
        - 이름은 5자 이내로 (O)
        - 사용자 수의 제한은 없으며 각 사용자는 , 로 구분 한다. (O)
    - 몇 번의 이동을 할 것인지 입력 할 수 있다.(O)

- 컴퓨터 

    - 각 사용자마다 난수를 생성한다
        - 난수는 0~9 사이의 값
        - 난수 값을 통해 4이상이면 전진 3이하이면 정지한다.
        - 사용자 입력값을 받아와 실제로 position을 처리한다.
        
- 자동차
    
    - 사용자가 입력한 이름에 맞는 자동차 객체가 할당된다.
    - 컴퓨터의 난수에 의해 position 이 결정된다.
        
- 출력
   
    - 매 경기 결과를 이름과 함께 출력한다.
    - 최종적으로 누가 우승했는 지를 출력한다. (복수가 될 수 있음)        
