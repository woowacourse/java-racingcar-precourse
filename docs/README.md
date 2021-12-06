# 미션 - 자동차 경주 게임

자동차 경주 게임을 구현하는 프로젝트 입니다.<br>

## 자동차 경주 게임이란?

- Random Number(0~9)를 생성하고 Random Number가 4이상일 경우 자동차는 한 칸 전진합니다.
- 사용자에게 ,(슁표)로 구분된 자동차 이름을 입력받고, 시도할 횟수도 입력받은 뒤 게임은 시작됩니다.
- 시도할 횟수가 지나면 최종 우승자 (여러 자동차일 수 있음)를 출력합니다.

## 기술스택

- Java 1.8

## 🚀 기능 목록

- 사용자의 입력을 받아 저장해야한다.
    - 자동차 이름을 받아 파싱해 car객체에 저장해야한다.
    - 시도할 횟수를 저장해야 한다.
    - 잘못된 값을 입력할 경우 ```IllegalArgumentException```을 발생시키고 "[ERROR]"로 시작하는 에러 메시지를 출력 후 입력을 다시 받는다.
        - 빈 문자 입력 : "[ERROR] 값을 입력해주세요."
        - 자동차이름 1글자 미만, 5글자 초과 : "[ERROR] 자동차 이름은 1글자 이상이어야 합니다." 
        - 자동차이름 공백포함 : "[ERROR] 자동차 이름은 5글자 이하여야 합니다."
        - 자동차이름 중복 : "[ERROR] 같은 이름을 가진 자동차가 있습니다."
        - 시도횟수 문자 입력 : "[ERROR] 시도할 횟수는 숫자여야 합니다."
- car객체의 포지션을 이동시킬 수 있어야 한다.
- 무작위 값을 구해야한다.
- 무작위 값으로 전진해야할지 말지 판단해야한다.
- 시도 횟수마다 자동차들의 포지션 score를 출력해야한다.
- 시도 횟수가 끝난 후 우승자를 판단해야한다.
    - 우승자가 여러명일 경우 쉼표(,)를 이용하여 구분한다.

## 사용법

1. 프로젝트 클론

```
git clone https://github.com/dongho108/java-racingcar-precourse.git
```

2. '<b>dongho</b>' branch로 이동

```
git checkout dongho
```

3. Application Run

```java
package racingcar;

import racingcar.controller.Controller;

public class Application {
	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.run();
	}
}

```

⌨️ 입력

- 경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

```
pobi,woni,jun
```

- 시도할 회수

```
5
```

🖥 출력

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

💻 사용 예시

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

