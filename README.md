- String[] getCarNames()
사용자로부터 받은 차 이름들을 가공된 형태로 반환한다.
getInput, parse, checkLength 함수를 사용한다.

- String getInput()
사용자로부터 입력을 받는다.

- String[] parse(String separator)
separator(구분자)를 활용해 String을 나누어서 배열로 반환한다.

- boolean checkLength(String[] names, int MAX)
String 배열 속 모든 String의 길이가 모두 MAX 이하면 true를 반환한다.

- Car[] generateCarByNames(String[] names)
names 속 name이 부여된 Car 객체를 names 개수만큼 생성한다.

- void doRace(Car[] cars, numOfRound)
cars의 position을 조작하고, round에 따른 결과를 사용자에게 보여준다.
TellGoOrStop, showRoundResult 함수를 사용한다.

- boolean tellGoOrStop(int TOP, int BOTTOM, int BOUNDARY)
BOUNDARY/(TOP-BOTTOM) 의 확률에 따라 true 아니면 false를 반환한다.

- void showRoundResult(Car[] cars)
cars의 position을 name:--(position수만큼 '-'출력) 형태로 출력한다.

- void chooseAndShowChampions(Car[] cars)
cars 안에서 champion들을 선별하고 출력한다.
findChampions, showChampions 함수를 사용한다.

- Car[] findChampions(Car[] cars)
cars 속에서 챔피언들을 찾는다.

- void showChampions(Car[] cars)
챔피언 차들의 이름을 출력한다.

*구현순서:
getInput -> parse -> checkLength -> getCarNames -> generateCarByNames -> tellGoOrStop -> showRoundResult
 -> doRace -> chooseAndShowChampions -> findChampions -> showChampions