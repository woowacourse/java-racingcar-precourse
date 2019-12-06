# 자동차 게임

## 기능 요구사항

- 주어진 횟수동안 n대의 차량은 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다.
  - 전진할 때 자동차의 이름과 같이 출력해야한다.
  - 자동차의 이름은 쉼표로 구분한다.
  - 자동차의 이름은 5글자이하이다.
- 게임 사용자는 이동 횟수를 지정할 수 있다.
- 전진 조건은 0~9의 랜덤한 숫자중 4이상의 숫자가 나올 경우이다.
- 경주가 완료된 후 누가 우승했는지 알려준다.
  - 우승자는 1명 이상일 수 있다.



## 역할과 책임 분리

**아는것** : 멤버 변수, 멤버 변수와 관련된 값 전달

**하는것** : 메세지 전달 (메서드)

----

- **자동차**

  - 아는것
    - 자동차의 이름
    - 전진하기 위해 필요한 엔진의 출력 값
    - 자신의 위치

  - 하는것
    - 전진



- **엔진**
  - 아는것
    - 엔진의 출력의 난수 범위
  - 하는것
    - 엔진의 출력 전달



- **경주참가 자동차들(일급컬렉션)**
  - 아는것
    - 경주에 참여한 자동차들
  - 하는것
    - 전체 자동차 전진 시도
    - 우승 자동차(들) 선출



- **우승자(들)**
  - 아는것
    - 우승자(들)



- **자동차 게임**

  - 아는것

    - 자동차 게임 결과

  - 하는것

    - 이름 입력 받기

    - 게임 진행(n회)



- **사용자**
  - 하는것 : 자동차의 이름들 입력



## 예상 시나리오

1. 게임 실행
2. 자동차 이름 입력
   - 이름 입력 없음시 (ex.공백, null...)
     - IlleagalArgumentException
   - 자동차 객체 생성
     - 이름이 5글자 이상인 경우
       - IlleagalArgumentException
3. 실행 횟수 입력
   - 0 회 및 음수 입력시
     - 재입력 요구
   - 숫자가 아닐 경우
     - IlleagalArgumentException
4. 실행 횟수 만큼 진행 상황 출력
5. 우승자 출력



## Git Commit Convention

[Angular Js Git convention](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 를 일부 변형하여 사용

------

#### Format

```
<type> : <subject>
<BLANK LINE>
<body>
```



#### Type

- feat (feature)
- fix (bug fix)
- docs (documentation)
- style (formatting, missing semi colons, …)
- refactor
- test (when adding missing tests)



#### body

- includes motivation for the change and contrasts with previous behavior



#### subject

- use imperative, present tense: “change” not “changed” nor “changes”
- don't capitalize first letter
- no dot (.) at the end