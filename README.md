# 미션 - 자동차 경주 게임

---
## 🚀 기능 요구사항

초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- 아래의 프로그래밍 실행 결과 예시와 동일하게 입력과 출력이 이루어져야 한다.

<br>

---
## ✔️기능 구현 목록

### 게임 진행 로직
- [ ] 사용자는 1개 이상의 이름을 입력해야 한다.
  - [x] 이름은 쉼표(,)를 기준으로 구분된다.
  - [x] 이름은 `5`자 이하여야 한다. 아닐 시, 예외를 발생시킨다.
  - [x] 이름은 중복되어서는 안된다. 중복될 시, 예외를 발생시킨다.
  - [x] 이름은 공백이 될 수 없다. 그럴 시, 예외를 발생시킨다.

- [ ] 사용자는 라운드 횟수를 입력해야 한다.
  - [x] 라운드 횟수는 숫자여야 한다. 아닐 시, 예외를 발생시킨다.
  - [x] 라운드 횟수는 `0` 이상이어야 한다. 아닐 시, 예외를 발생시킨다.

- [ ] 주어진 횟수 동안 자동차는 전진 또는 멈출 수 있다.
  - [x] 전진하는 조건은 `0`에서 `9` 사이의 랜덤 값 중, `4` 이상이 나올 경우에 해당된다.

- [ ] 게임이 완료되면 우승자를 출력한다.
  - [x] 우승자는 여러 명이 될 수 있다.
  - [x] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

### 예외처리
- [ ] 사용자가 잘못된 값을 입력할 경우, `IllegalArgumentException`을 발생시킨다.
- [ ] 에러 메시지는 `[ERROR]`로 시작한다.
- [ ] 예외 발생 시, 그 부분부터 입력을 다시 받는다.

<br>

---



## ✍🏻 입출력 요구사항

### ⌨️ 입력

- 경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

```
pobi,woni,jun
```

- 시도할 회수

```
5
```

### 🖥 출력

- 각 차수별 실행 결과

```
pobi : --
woni : ----
jun : ---
```

- 단독 우승자 안내 문구

```
최종 우승자 : pobi
```

- 공동 우승자 안내 문구

```
최종 우승자 : pobi, jun
```

- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 [ERROR] 로 시작해야 한다.

```
[ERROR] 시도 횟수는 숫자여야 한다.
```

### 💻 프로그래밍 실행 결과 예시

```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```

<br>

---

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-racingcar-precourse/blob/master/LICENSE) licensed.
