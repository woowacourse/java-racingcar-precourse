# 자동차 경주 게임

## 객체

### Car

- canMove()
    - 0~9의 무작위 값이 4 이상인지 확인한다
- move()
    - canMove() == true이면 한칸 앞으로 움직인다
    - 차 이름 출력하기
- tryMove()
    - 입력받은 만큼 움직일 시도를 한다

### Umpire

- getWinner(List<Car> carList)
    - Car리스트 내림차순으로 정렬 - O(nlogn)
    - 첫번째 Car의 position과 같은 position 찾기 - O(n)
    - 해당 Car의 이름리스트 반환
- printWinner(List<String> nameList)
    - 이름 리스트 쉼표로 구분하여 출력하기

## 제한사항

- 이름은 쉼표를 기준으로 구분
- 이름은 5자 이하만 가능하다
- 우승자는 한 명 이상일 수 있다.
- 우승자는 쉼표를 이용하여 구분한다
- 잘못된 값이 일어날 경우
    - IllegalArgumentException 발생시킴
    - [ERROR]로 시작하는 에러 메세지 출력
    - 그 부분부터 입력 다시 받기

## 프로그래밍 요구 사항

- indent 2까지 허용
- 함수가 한가지 일만 하도록 최대한 작게 만든다
- 함수의 길이가 15라인 넘으면 안된다
- else쓰지 않는다
- camp.nextstep.edu.missionutils.Randoms.pickNumberInRange() 사용
- camp.nextstep.edu.missionutils.Console.readLine() 사용

```java
public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	// 추가 기능 구현
}

```

- 위의 Car객체 활용
- 기본 생성자 추가 금지
- name, position 접근제어자 private변경 금지
- setPosition메소드를 추가하지 않고 구현한다


