## 기능목록

-[x] 메인 부분
-[x] Movable            // 움직일 수 있는 객체를 위한 인터페이스
-[x] Car 를 구현          // Movable의 구현으로 만들기
-[x] RacingGame         // 게임을 실행 (흐름을 담당)
    - trials만큼 반복하는 부분
    - 각 trial 의 내용은 다른 클래스로 관리하자
-[x] ScoreBoard   // 특정 게임 상황을 출력, 출력을 순차적이고 효율적으로 하기 위함
    - winners도 출력하자


## 흐름
내용자체가 어렵다기 보단 
- 어떤 역할을 각자가 담당하게 할지
- 어떤 관계를 가질지
를 생각하는게 어려운 문제인 듯 하다

방법이 다양한 만큼... 직접 만들어보면서 장단점을 느껴보면 좋겠다


## 설계 흐름
1. 일단 Car 인스턴스를 list로 관리한다 
(일단은 순차로 접근 할 것이기에 그냥 클래스에 모아 놓는 것 보다 더 명시적일 것 같아서)



## 생각해볼 부분
병렬화
mock 사용 테스트 (행위를 확인해보자)


## 참조
// mockito
https://github.com/mockito/mockito/wiki/Mockito-features-in-Korean
https://static.javadoc.io/org.mockito/mockito-core/2.25.1/org/mockito/Mockito.html
