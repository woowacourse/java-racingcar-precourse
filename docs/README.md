## 기능 구현 목록 
- 자동차 이름을 입력받는다.
    - [예외] 구준자가 쉼표가 아니거나 자동차 이름이 하나인 경우
    - [예외] 구준자사이 아무런 값도 없는 경우
    - [예외] 이름사이 공백 포함한 경우
    - [예외] 이름이 5자 이상인 경우
    - [예외] 이름이 중복된 경우
- 이동 횟수를 입력받는다.
    - [예외] 숫자가 아닌 경우
    - [예외] 자연수가 아닌 경우
- 랜덤값을 생성한다.
- 랜덤값이 4 이상이면 전진, 3 이하이면 멈춘다.
- 우승자(제일 많이 전진한 자동차)를 구한다.

## 프로그래밍 실행 결과

### 정상적인 경우
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
KBJ,PYJ,IMH
시도할 회수는 몇회인가요?
5
KBJ : -
PYJ : -
IMH : 

KBJ : --
PYJ : --
IMH : -

KBJ : ---
PYJ : --
IMH : -

KBJ : ----
PYJ : --
IMH : -

KBJ : ----
PYJ : ---
IMH : --

최종 우승자: KBJ

BUILD SUCCESSFUL in 24s
2 actionable tasks: 1 executed, 1 up-to-date
오후 6:48:43: Task execution finished 'Application.main()'.
```

### 자동차 이름 예외 처리 (자동차 이름이 하나이거나 구준자가 쉼표가 아닌 경우)
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
jun.byung
```
```
Exception in thread "main" java.lang.IllegalArgumentException: [ERROR] 만들어진 자동차가 1개다.
```

### 자동차 이름 예외 처리 (자동차 이름에 공백 포함한 경우)
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
kb j,yj
```
```
Exception in thread "main" java.lang.IllegalArgumentException: [ERROR] 자동차 이름은 숫자,영문만 가능하다.
```

### 자동차 이름 예외 처리 (6자 글자 입력시)
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
kimbyungjun
```
```
Exception in thread "main" java.lang.IllegalArgumentException: [ERROR] 자동차 이름은 5자 이하만 가능하다.
```
### 자동차 이름 예외 처리 (이름이 중복된 경우)
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
kbj,kbj
```
```
Exception in thread "main" java.lang.IllegalArgumentException: [ERROR] 중복된 자동차 이름이 있다.
```

### 이동 횟수 예외 처리 (숫자가 아닌 경우)
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
KBJ,PYJ,IMH
시도할 회수는 몇회인가요?
A
Exception in thread "main" java.lang.IllegalArgumentException: [ERROR] 시도 횟수는 숫자여야 한다.
```

### 이동 횟수 예외 처리 (자연수가 아닌 경우)
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
KBJ,PYJ
시도할 회수는 몇회인가요?
-10
Exception in thread "main" java.lang.IllegalArgumentException: [ERROR] 시도 횟수는 자연수여야 한다.
```