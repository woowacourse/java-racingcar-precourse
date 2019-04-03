# 프리코스 2주차 미션 (자동차 경주 게임)
## *요구 사항*
---------------------------------------------
### 1. 기능 요구 사항
1. 주어진 횟수 동안 N대 자동차 전진 or 정지
2. 자동차 이름 부여 / 게임 진행 시 출력
3. 이름 ',' 기준 입력 / 5자 이하
4. 사용자 이동 횟수 입력
5. 전진 조건 : 0~9 random 값 4이상 전진 / 3이하 stop
6. 우승자 출력 (우승자 1명 이상 가능)

<br/>

### 2. 프로그래밍 요구사항
```java
//참고
public class Car {
 private final String name;
 private int position = 0;
 public Car(String name) {
 this.name = name;
 }
 // 추가 기능 구현
}
```
1. Car 객체 구현
2. Car 기본 생성자 추가X
3. 멤버 변수 접근 제어자 (private 변경X)
4. java code conventions 지키기 
   - [참고문서1](https://myeonguni.tistory.com/1596)
   - [참고문서2](https://google.github.io/styleguide/javaguide.html)
5. indent depth 최대 2
6. if 조건절 값 return 사용하는 방식으로 else 사용X
   (switch-case 도 사용X)
   
<br/>

### 3. 기타 유의 사항 (1주차 피드백 사항)
1. 변수,클래스,함수 등 의미 있는 이름 사용 (축약X)
2. 불필요한 공백라인 사용X
3. for/while/if 문 사이 space code conventions
4. 의미 없는 주석X
  - 변수,함수 등 이름으로 의도 드러나면 주석X
  - 이름으로 의도 드러내기 힘들다면 주석 이용
5. 반복되는 코드X
6. space,tab 혼용X (PR 후 확인)
7. 값 하드코딩X (static final 상수 이용)
8. git commit message 의미있게 작성
9. 살아있는 README 파일 (상세히)



<br/>
<br/>
<br/>
<br/>


## *구현 할 기능 목록*
---------------------------------------------
## 1. class Car
 - ### variables
  |변수 명|변수 설명|수행 여부|
  |:-------|:-------|:-------:|
  |**name**|차의 이름을 저장할 변수|O|
  |**position**|차의 위치를 저장할 변수|O|
  
 - ### methods
  |메소드 명|메소드 설명|수행 여부|
  |:-------|:-------|:-------:|
  |**printName()**|차의 이름을 출력하는 메서드|O|
  |**moveCar()**|차가 전진하는 메서드|O|
  |**printPosition()**|차의 위치를 출력하는 메서드|O|
  |**getPosition()**|차의 위치를 반환하는 메서드|X|
  
<br/>
  
  ## 2. class Game
 - ### constants
  |상수 명|상수 설명|수행 여부|
  |:-------|:-------|:-------:|
  |**MAXCARNAMENUMBER**|자동차 이름 입력 최대값 나타내는 상수|O|
  |**MAXRANDOMNUMBER**|랜덤 값 생성 시 최대값 나타내는 상수|O|
  
  
 - ### variables
  |변수 명|변수 설명|수행 여부|
  |:-------|:-------|:-------:|
  |**cars**|자동차 객체들을 저장할 배열|O|
  |**trialNumber**|시도횟수를 저장할 변수|O|
  
  
 - ### methods
  |메소드 명|메소드 설명|수행 여부|
  |:-------|:-------|:-------:|
  |**start()**|게임을 시작하는 메서드|X|
  |**printCarNamesInputMessage()**|자동차 이름 입력을 지시하는 메세지를 출력하는 메서드|O|
  |**inputCarNames()**|자동차 이름을 입력받는 메서드|O|
  |**printTrialNumberInputMessage()**|시도 횟수 입력을 지시하는 메세지를 출력하는 메서드|O|
  |**inputTrialNumber()**|시도 횟수를 입력받는 메서드|O|
  |**printResultMessage()**|실행결과 메세지를 출력하는 메서드|X|
  |**playOneCycle()**|게임을 1회 시도하는 메서드|X|
  |**isMove()**|전진/정지 조건을 생성하는 메서드 (0~9까지 랜덤 값 발생 후 4이상 전진)|X|
  |**getMaxPosition()**|가장 많이 이동한 차의 위치를 반환하는 메서드|X|
  |**printWinnerMessage()**|우승자 메세지를 출력하는 메서드|X|



<br/>
<br/>
<br/>
<br/>




## *예외처리 목록*
##### (수행 시 취소선 적용)
---------------------------------------------
+ 자동차 이름 입력, 알파벳이 아닐 경우 ex) asd30, asd1a, vsf!
+ 자동차 이름 입력, 자동차 이름 길이가 6이상일 경우 ex) abcdef, asdasdas
+ 시도 횟수 입력, 양의 정수가 아닐 경우 ex) -1, 0, a, !
