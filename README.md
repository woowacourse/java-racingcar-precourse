# 미션 - 자동차 경주 게임

## 구현 기능 목록

<br>

- 아래와 같이 출력하고, 그 아랫줄에서 입력을 받는다.
  ```
  경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
  ```
    <br>
- 쉼표(,) 기준으로 구분 된 경주할 자동차 이름들을 입력받고, 
  에러가 없으면 해당 이름들로 Car객체를 생성하여 ArrayList에 저장.
  
  - 쉼표(,)가 한 개 이상 존재하는지 검사.
    
    - 아닐 경우, 다음과 같이 출력한다.
      
      ```
      [ERROR] 자동차 이름은 두 개 이상이어야 합니다.
      ```
      
  - 쉼표(,)가 맨 앞이나 뒤에 존재하는지 검사.
       
    - 아닐 경우, 다음과 같이 출력한다.
         
      ```
      [ERROR] 잘못된 쉼표(,) 입력입니다.
      ```   

  - 이름이 한글 또는 영어의 문자로만 이루어져 있는지 검사.
  
    - 아닐 경우, 다음과 같이 출력한다.
    
      ```
      [ERROR] 자동차 이름은 한글 또는 영어만 가능합니다.
      ```
      
  - 자동차 이름이 모두 각각 1자 이상 5자 이하인지 검사.
  
    - 아닐 경우, 다음과 같이 출력한다.
    
      ```
      [ERROR] 자동차 이름은 1자 이상 5자 이하만 가능합니다.
      ```
      
  - 경주할 자동차의 수가 100대 이하인지 검사.
    
    - 아닐 경우, 다음과 같이 출력한다.
        
      ```
      [ERROR] 경주할 자동차 수는 100대 이하여야 합니다.
      ```
      
  - 중복된 이름이 없는지 검사.
  
    - 존재할 경우, 다음과 같이 출력한다.
    
      ```
      [ERROR] 중복된 이름이 있습니다.
      ```
      
  - 자동차 이름들로 Car객체를 생성하여 ArrayList에 저장.

<br>
      
- 아래와 같이 출력하고, 그 아랫줄에서 입력을 받는다.
  ```
  시도할 회수는 몇회인가요?
  ```

<br>

- 사용자에게 이동 시도 횟수를 입력받는다.

  - 입력받은 횟수가 숫자인지 검사.
  
    - 아닐 경우, 다음과 같이 출력한다.
    
      ```
      [ERROR] 시도 횟수는 숫자만 입력 가능합니다.
      ```
    
  - 입력받은 횟수가 1회 이상 1000회 이하인지 검사.
  
    - 아닐 경우, 다음과 같이 출력한다.
    
      ```
      [ERROR] 시도 횟수는 1회 이상 1000회 이하여야 합니다.
      ```

<br>

- 아래와 같이 출력한다.

  ```
  실행 결과
  ```
  
<br>
      
- 입력받은 횟수만큼 다음을 반복한다.

  - 각 자동차에 대해 0이상 ~ 9이하의 랜덤 숫자를 구해, 4이상이면 1만큼 전진시킨다.
  
  - 각 자동차에 대해 다음과 같이 출력한다.
    ```
    $자동차이름 : 현재 위치 만큼의 (-)문자.
    ```

<br>

- 최종 우승자를 찾는다.

  - 자동차들을 담은 ArrayList를 위치값에 대해 내림차순으로 정렬한다.
  
  - 인덱스 0번에 있는 자동차의 이동 횟수(우승자의 이동 횟수)를 구한다.
  
  - 자동차들을 담은 ArrayList의 인덱스 1번부터 우승자의 이동 횟수와 같은 자동차가 존재하면 우승자로 저장한다.
  
  - 우승자의 이동 횟수보다 작은 이동 횟수를 가진 자동차가 나오면, 우승자 찾기를 종료한다.
  
<br>

- 우승자를 출력한다.

  - 다음과 같이 출력하고, 줄바꿈을 하지 않는다.
    
    ```
    최종 우승자: 
    ``` 
    
  - 우승자가 한명일 경우, 해당 우승자의 자동차 이름을 출력한다.

  - 우승자가 2명 이상일 경우, 쉼표와 공백문자 (", ")로 구분하여 출력한다.
  
  <br> 
