# 우아한 테크코스 2주차 자동차 게임

- 사용자는 게임을 함께 할 유저를 입력하고 입력된 유저마다 난수를 생성해 4이상이면 전진, 미만이면 정지를 수행하는 자동차 게임. 
- 플레이횟수를 결정 할 수 있고, 정해진 횟수 만큼 결과를 출력한다. 최종적으로 가장 많이 전진한 사람(들)을 출력한다.

## 프로그램 실행 

- Git clone 이 후 src/main/java/RacingCarGame 의 main() method 실행

## 프로그래밍 규칙

- 3항연산자를 사용하지 않는다. (O)
- indent depth는 2이하로. (O)
- 자바 코드 컨벤션을 지킨다. (O)
- 메서드는 15라인을 넘지 않는다. (O)
- else 예약어를 사용하지 않는다. (O)

## 기능 구현

- 사용자 입력 (O)

    - 사용자는 자동차의 이름을 입력할 수 있다. (O)
        - 이름은 5자 이내로 (O)
        - 사용자 수의 제한은 없으며 각 사용자는 , 로 구분 한다. (O)
    - 몇 번의 이동을 할 것인지 입력 할 수 있다.(O)

- 컴퓨터 (O)

    - 각 사용자마다 난수를 생성한다 (O)
        - 난수는 0~9 사이의 값 (O)

- RacingController
    
    - 난수 값을 통해 4이상이면 전진 3이하이면 정지한다.(O)
    - 실제로 각 사용자의 Car 객체 position을 처리한다.(O)
    - 우승자 찾는다 (O)
                        
- 자동차 
    
    - Setter 없이 Position을 변경해야하기에 자동차 내부에서 position을 결정 (O) 
    - 컴퓨터의 난수에 의해 position 이 결정된다. (O)
    - toString() 메서드를 통해 현재 position을 print한다. (O)
        
- 출력
   
    - 매 경기 결과를 이름과 함께 출력한다. (O)
    - 최종적으로 누가 우승했는 지를 출력한다. (복수가 될 수 있음) (O)        

## 추가 

- 버그수정 (O)
    - 사용자의 이름 양옆의 공백제거 (O)
    - 에러메세지 변경(,를 기준으로 입력 요구) (O)
    - 게임플레이에 0을 입력하는 경우

- 리팩토링 (O)
    - Output과 Computer의 역할이 모호 (O)
    - Computer과 Car (O)
    - 클래스들 사이의 관계 및 역할 재정의 (O)
    - Game이라는 인터페이스를 추가함으로써 필수 작업을 명확히 제시하자.(O)
    
- 리팩토링 문제 해결 (O)
    - RacingController를 통해, 경기 관련 처리를 모두 위임함으로써 Car와 Computer 클래스의 기능이 줄어듦 (O)
    - PrintHandler에게 모든 출력을 위임함으로써 출력 단순화 (O)

- 주석 추가(O)    
## 결과 화면

<div>
<img width="800" alt="스크린샷 2019-12-05 오후 3 49 04" src="https://user-images.githubusercontent.com/49060374/70211026-75048900-1777-11ea-9b38-cdd7f3307041.png">
</div>

