# 프리코스 2주차 : 자동차 경주 게임

##1. 프로그램 개요

이 프로그램은 여러 대의 자동차로 경주을 진행하는 **자동차 경주 게임**이다.

자동차의 개수는 사용자의 입력에 따라 결정되며,

자동차의 전진/정지는 난수에 기반한 확률로 정해진다.

게임이 종료되면, 우승자에 대한 정보를 출력해준다.

## 2. 기능 요구사항

**메인 클래스 개발**

- 이름 입력과 그 예외처리에 대한 메서드를 만든다.
- 경기 횟수에 대한 입력 메서드를 만든다.
- 시도 횟수에 따른 게임 루프(자동차 클래스의 update 호출)를 만든다.
- 최종 우승에 따른 출력 메서드를 만든다.

**경주 클래스 개발**

- 이름의 목록과 경기 횟수를 저장한다.
- 자동차 리스트를 생성하여 이름을 넣어준다.
- 경기 횟수에 맞춰 경기를 진행한다.

**자동차 클래스 개발**

- 자동차 객체를 만들고, 전진에 필요한 메서드를 만든다.
- 내부에 상수값으로 랜덤 범위(얼마 이상일 때 전진) 를 저장한다.
- 이름과 위치값을 저장하고, 위치값은 setter 없이 내부 private 메서드로 조작한다.

**예외처리**

- 입력 예외처리

## 3. 프로그램 구조

```
java
```

추후 작성예정.

## 4. 예외처리 사항

- 이름의 길이/입력제한
- 이름 입력 문자열의 포맷 문제
- 시도 횟수의 입력 예외처리