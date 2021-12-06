# 미션 - 자동차 경주 게임
## 기능 구현

### 1. 자동차 클래스 생성

#### 구현 시 고려사항
- 자동차의 이름과 위치 정보를 담는 클래스입니다.
- 생성자의 params 값을 이름으로 받아서 자동차 이름을 저장하면서 각 객체를 생성합니다.
- 외부 클래스에서 해당 변수 값을 읽을 수 있게 getter 함수를 생성해 줍니다.
- 공통적으로 자동차의 이름과 현재 위치를 -의 수로 표현하므로 toString()을 override해서 ```자동차 이름 : ---``` 형태를 출력할 수 있게 해줍니다.
- 마지막에 점수를 비교해야 하므로 Comparable 인터페이스를 사용하여 compareTo()함수를 override하여 수가 큰 것 부터 오름차순으로 정렬할 수 있게 합니다.

#### 세부 함수
1. 위치를 1 증가시켜주는 메서드
2. 이름과 위치값을 반환해주는 메서드 (getter 함수)
3. 이름과 현재 위치 정보에 대한 정보를 출력해주는 toString 함수
4. 각 객체의 위치 값을 비교할 수 있는 함수

### 2. 자동차 이름 입력 받기

#### 구현 시 고려사항
- ```Console.readLine()``` 함수를 이용해서 ,로 구분된 자동차 이름들 입력 받기
- 자동차 이름이 5글자가 초과되면 에러 메세지 출력 후 다시 입력받기
- 받은 문자열을 ,로 구분한 후 자동차 이름을 담을 수 있는 문자열 배열을 만든 후 각각 저장

#### 세부 함수
1. ,를 포함한 자동차 이름들을 문자열로 입력 받는 메서드
2. 문자열 배열로 변경하는 메서드
3. 문자열 배열을 하나씩 탐색하면서 자동차 이름에 대한 예외 사항(5글자 초과) 체크
    - 예외 사항 발생 시 처음부터 다시 실행
4. 예외 사항에 모두 통과한 자동차 이름을 담은 문자열 배열 반환 함수

### 3. 시행 횟수 입력 받기

#### 구현 시 고려사항
- ```Console.readLine()``` 함수를 이용해서 실행 횟수 입력 받기
- 실행 횟수가 숫자가 아닌 다른 문자가 섞여있다면 에러 메세지 출력 후 다시 입력받기
- 위의 ```Console.readLine()```는 반환값이 문자열이므로 숫자로 변환
    - 만약 "034"로 입력이 되어도 ```Integer.parseInt()``` 함수를 사용하면 숫자 034 즉 34로 인식하므로 앞자리가 0인 점은 고려해주지 않아도 됩니다.

#### 세부 함수
1. 실행 횟수를 문자열로 입력 받는 메서드
2. 입력 받은 문자열이 0~9만 포함하는지(숫자로만 이뤄져있는지) 확인하는 메서드
3. 예외 사항에 문자열이 통과하는지 확인
    - 예외 발생 시, 처음부터 다시 실행
4. 모두 통과 시, 문자열을 숫자로 변환하여 반환

### 4. 게임 실행 하기

#### 구현 시 고려사항
- 자동차 배열은 앞서 2번 기능에서 만든 자동차 객체 배열을 받아서 사용합니다.
- 입력받은 실행 횟수만큼 게임을 진행하며 4점 이상일 경우 위치 + 1 해주기
- 출력 예시처럼 각 실행마다 자동차의 위치 이름과 위치 상태를 정해진 형식으로 출력해야함 
  - 예시에서 사용한 띄어쓰기나 기호 틀리지않게 사용하기

#### 세부 함수
1. 생성자를 이용해서 자동차 이름과 실행 횟수를 입력받는 객체 생성
2. 자동차 이름이 담긴 문자열 배열과 실행횟수를 입력받은 후 문자열 배열을 이용해서 객체 배열을 만드는 메서드 생성
3. 실행 횟수에 맞게 게임을 진행하는 메서드 (핵심 메서드)
    - 실행 후 5번 기능의 우승자 판별 함수를 실행하여 점수도 매김 
4. 각 게임마다 자동차 수에 맞게 랜덤 수를 생성한 후 4점 이상의 자동차는 위치를 증가시키는 메서드
5. 현재 상태를 출력해주는 메서드

### 5. 우승자 판별 

#### 구현 시 고려사항
- 4번 기능에서 실행이 완료 된 자동차 객체 배열을 받아야 함
- 그 자동차 객체 배열을 정렬 
  - 자동차 객체에서 compareTo를 override 해주었기에 점수에 대해 오름차순 정렬 가능
- 배열에서의 마지막 인덱스가 가장 큰 값이므로 결과 리스트에 저장
- 그 외의 객체 중에서도 1등과 동점인 경우가 있을 수도 있으므로 최고점과 다른 점수가 나올 때 까지 탐색하며 리스트에 저장
- 최종 우승자들을 예제 형태와 맞게 출력

#### 세부 함수
1. 생성자를 이용해서 4번 기능에서 완료된 자동차 객체 배열 전달 받기
2. 등수를 매기는 메서드(최고점을 받은 자동차를 리스트에 저장)
3. 결과를 형식에 맞게 출력하는 메서드