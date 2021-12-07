# 미션 - 자동차 경주 게임

## 기능 구현 목록

- [x] 사용자가 잘못된 값을 입력 처리 하기 InputView
    - [x] `IllegalArgumentException`를 발생
    - [x] 그 부분부터 입력 다시 받기
- [x] "[ERROR]"로 시작하는 에러 메시지를 출력 OutputView#printError
- [x] 각 자동차에 이름 받아오기 InputView#getNames
    - [x] 개별 이름은 5자 이하만 가능 Util#checkNamesValidation
        - 그외 빈값 허용안함, 최소2명이상 입력, 중복 허용안함 등의 검증 로직 추가
- [x] 몇 번의 이동을 할 것인지를 입력 받는 기능 InputView#getCount
    - [x] 입력된 횟수에 대한 검증 기능 Util#checkCountValidation
- [x] 입력받은 이름으로 자동차들 생성하는 로직 Cars#from
- [x] 입력받은 횟수 동안 자동차 경주를 시행하도록 하는 로직 Count#isRacingEnd
- [x] 매 경기별 각 자동차들을 움직이는 기능 RacingGame#start
    - [x] 0에서 9 사이에서 무작위 값을 구하는 기능 Util#getRandomNumber
    - [x] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈추는 기능 Car#move
        - [x] 무작위 값이 4 이상일 경우 position +1 올라가도록 구현
- [x] 매 경주당 결과 출력하는 기능 Controller#reportResultEveryRound
    - [x] 각 자동차별 결과(자동차 이름과 전진 거리)를 문자열 반환해주는 기능 racingGame#getResults
    - [X] 경주당 결과를 출력하는 기능. OutputView#printEveryRound
- [x] 자동차 경주 게임을 완료한 후 누가 우승했는지 문자열로 반환하는 기능 RacingGame#findNameOfWinners
    - [x] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분하여 문자열 반환
    - [x] 우승에 해당되는 자동차 객체들을 반환 Cars#findWinners

## 그외 요구사항 체크리스트(과제수행간 계속 추가예정)

### 1주차

- [x] 자바의 버전이 8버전인가
- [x] 자바 코드 컨벤션을 지키는가
- [x] `Randoms`의 `pickNumberInRange()`를 사용했는가
- [x] `Console`의 `readLine()`을 사용했는가
- [x] 3항 연산자를 쓰지 않는가
- [x] **indent depth가 2이하인가**
- [x] **하나의 함수가 한 가지 일만 하도록 하였는가**
- [x] **(추가) 하드코딩 하진 않았는가**
- [x] **(추가) style check 및 convention 적용 하였는가**
- [x] **`gradlew.bat clean test`의 모든 테스트가 통과하는가**
- [x] **과제 제출시 우테코 플랫폼에서도 제출하였는가**

### 2주차(피드백 및 과제에서 추가)

- [x] **함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.**
- [x] **else 예약어를 쓰지 않는다**
- [x] **기능 목록을 업데이트하고 재검토 한다**
- [x] **Class 구현순서( 상수->멤버 변수->생성자->메서드) 지키기**

### 2주차 프로그래밍 요구사항

- [x] Car 기본 생성자를 추가할 수 없다.
- [x] name, position 변수의 접근 제어자인 private을 변경할 수 없다.
- [x] **가능하면 setPosition(int position) 메소드를 추가하지 않고 구현한다.**

## ## 그외 추가 학습사항 및 과제수행시 키포인트

- **[java 기본 문법 정리하기](https://github.com/is2js/exampleStudy01)**
    - [x] 1코테~1주차 과제기간 자바의 정석 등 기본문법
    - [x] **2주차 과제기간 Enum(day10), Interface(day11) 추가
      학습** : [설명](https://github.com/is2js/exampleStudy01/blob/master/readme.md)
      ,  [코드](https://github.com/is2js/exampleStudy01/tree/master/src/main/java)
- **[백준 python 기본 구현 문제](https://github.com/is2js/python_algorithm) -> java 로 풀어보기(~ing)**
    - [x] 1~2주차 [문제풀이](https://github.com/is2js/boj_java)
      및 [개념정리](https://github.com/is2js/boj_java/blob/master/concept.md) 계속 진행중
    - [x] **2주차 과제기간 [stream 코드를 통한 개념 정리](https://github.com/is2js/boj_java/blob/master/concept.md)**
- **java로 콘솔 게시판 만들어보기 [설명](https://github.com/is2js/exampleStudy01/blob/master/board.md)
  , [코드](https://github.com/is2js/exampleStudy01/tree/master/src/main/java/board) (~ing)**
    - [x] 1주차 콘솔 게시판까지 완성
    - [x] **2주차 콘솔 게시판 정렬기능 구현(~ing)**
- **지난 과제**를 지원동기들 코드 참고하여 **다시 작성해보기**
    - [x] [1주차과제 복습](https://github.com/is2js/MVC_practice/tree/master/src/main/java/baseball2Youngyooon) : 숫자야구게임 **MVC
      + 일급콜렉션 적용** 위주로 코드 새로 짜기
    - [x] [2주차과제 복습](https://github.com/is2js/MVC_practice/tree/master/src/main/java/racingCar3devhudiForWrap) : **최소단위
      변수들도 Wrapping클래스** 만들어보기 & 인터페이스 적용해보기
- **2주차 과제 수행시 키포인트**
    - **Live template을 활용**함.
        - 1주차와 반복되는 input코드 등을 미리 작성해둠.
    - **fork한 repo를 clone후에 branch부터 바꾸자!**
        - 실수로 main브랜치에 commit and push하여 새로 작성하는 경우가 발생했었음.
    - **일급컬렉션 사용**하여 객체List에 대한 검증 및 관련 로직을 모음.
        - 쪼개어지는 Input을 받을 때 ex> Names -> Name 미리 names에서 검증을 다 해버리는 전략을 세움
        - 쪼개어놓고 내부에서 검증할 시, 다시 입력받으러 가기가 쉽지가 않음.
    - 조건절에서 getter쓰지말고, 객체.부등호를메서드화() 시켜 메세지보낼 것. 비교시 필요한 값은 메서드의 파라미터로
    - 입력 받은 **int 변수를 포장한 래핑클래스**를 만들고 countdown 메서드 구현해보기
    - 학습했던 **stream위주로 코드** 짜보기
        1. max( Comparator)를 쓰더라도 1번에 max값을 충족시키는 여러개의 객체를 구하기는 쉽지 않음.
        2. mapToInt( ) 집계값 구한 뒤 -> 일치하는 객체 List(우승자들) 구하는 방식
        3. 간단한 출력문은 toString()오버라이딩 해서 쉽게 출력되도록 이용 하기
    - 상수들 및 에러 메세지들의 **리팩토링**
        - **IDE를 이용하면 정말 간단하게 해결**할 수 있음을 깨닫게 됨.
