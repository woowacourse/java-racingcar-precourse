# 우아한 테크코스 프리코스 2주차 자동차 경주게임

## 준비

- JDK(>=8)
- gradle or IntelliJ
- AssertJ 3.14.0
- JUnit 5

## TODO

### 프로그래밍시 지켜야할 것

- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- indent depth (< 3)
- 3항연산자 금지
- else 예악어 금지
- 하나의 메소드는 하나의 일만하도록
- 하나의 메소드의 라인수 (< 15)
- 상수 정의 잘하자

#### Car 객체

- Car 생성자 추가 금지
- 필드 변수 접근제어자 변경 금지
- setPosition() 메소드 지양


### Class & methods

#### Domain

#####  Car

- [ ] 자신의 랜덤수 설정
- [ ] 라운드 진행시 전진 또는 정지
- [ ] 현재 자신의 위치 반환

#### View

##### Input

- [x] 자동차 입력받기
- [x] 입력받은 문자열 구분하기
- [ ] 5자 이하 check
- [ ] 공백 문자 check
- [x] 횟수 입력받기
- [x] 횟수는 1이상 정수 check



##### Output

- [ ] 라운드별 상태 출력하기
- [ ] 우승자 출력하기

#### Service

- [ ] 예외처리 서비스 모음....

<hr>

### Test

#### Domain

- [x] Car initTest
- [ ] Car fieldTest

#### View

- [x] Input initTest
- [x] Input splitTest
- [x] Input times positiveIntegerTest

#### Service

- [ ]