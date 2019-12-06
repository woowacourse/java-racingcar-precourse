## 자동차 경주 게임

## Process

1. 자동차 이름들을 입력받는다.
2. 시도할 횟수를 (N) 입력받는다.
3. 자동차를 , 단위로 split하여 각 ArrayList의 Car 인스턴스마다 이름을 지정한다.
4. 게임은 N번 반복된다.
5. ArrayList의 Length()만큼 반복하여 각 Car들의 랜덤값을 구한다.
6. 각 랜덤값에 맞게 Car를 Move() 시킨다.
7. 길이에 맞게 출력시킨다.
========================================

## 구현사항 Car
1. 차를 한칸 이동시키는 setForward() 함수 구현
2. 현재 거리를 얻을 수 있는 getPosition() 함수 구현
3. 현재 상태거리를 출력하는 positionPrint() 함수 구현 


## IoSystem
1. printCarList() 차량 리스트를 입력요청을 안내해주는 함수.
2. printCount() 시도할 횟수를 입력요청을 안내하는 함수
3. inputCarList() 차량을 입력받는 함수를 구현.
4. inputCount() 시도할 횟수를 입력받는 함수 구현
5. printResult() 실행결과 메시지를 출력하는 함수 구현
6. 랜덤 값을 반환하는 함수 구현 getRandomInt()
7. 최고거리를 도달한 차량의 이름을 출력하는 함수 구현 printResultCars()

## Controller
1. System 클래스의 있는 문자열을 ',' 단위로 나누어 Car에 담는 함수 구현 stringCommaSplit()
2. N만큼 for문 반복하여 차를 이동시키는 함수 실행하는 함수 구현 runCarsForward()
3. N만큼 for문 반복하여 차량상태를 출력하는 함수 구현 runCarsPirnt()
4. N만큼 for문 반복하여 최장거리의 차량을 리스트에 담는 getMaximumDistanceCars() 함수 구현