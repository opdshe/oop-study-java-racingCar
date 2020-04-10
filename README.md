# java-racingCar 자동차경주 게임 저장소
## 기능 요구사항
+ 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
+ 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
+ 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
+ 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
+ 전진하는 조건은 0에서 9사이에서 random 값을 구한 후 random 값이 4이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
+ 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
![capture](./image/cap.JPG)


## 구현해야할 기능 목록
+ 사용자로부터 자동차 이름, 시도할 횟수를 입력받기.
  + 사용자 이름이 5자 이하인지 확인.
  + 자동차 이름을 쉼표 기준으로 분리.
  + 자동차 이름, 시도 횟수에 널값이 들어오거나 시도 횟수에 음수값이 들어오는 등의 예외 상황 처리.
+ 0~9사이의 Random Number생성하여 그 값에따라 이동.
  + 4이상이면 전진, 4미만이면 정지.
+ 현재까지 이동한 거리를 출력해 주는 기능.
+ 최종 이동거리를 토대로 우승자를 선발하여 출력해 주는 기능.
  + 우승자는 두명이상일 수도 있다.
  + 두명 이상일 경우, 콤마로 구분할 것.

## 배운 것들
![AM](./image/AccessModifier.JPG)
+ 접근 제어자는 default보다는 public이나 private이 선호된다.  
  public은 아무데서나 접근 가능하기 때문에, 사용하기 편리하다는 장점이 있다.   
  하지만, 코드를 작성할 때는 "내가 만든 코드는 다른 누군가에게 재사용될 수 있다"는 생각을 갖고 작성하는 것이 좋다.  
  내가 짠 코드를 다른 사람이 사용할 때, 내가 원하는 대로 사용할 것이라는 생각은 버려야 한다. 
  따라서 private과 같은 접근 제어자를 사용함으로써 어느정도의 강제성을 부여하고, 다른 사용자가 내가 원하는대로 코드를 사용하도록  
  유도하여 버그를 줄이는 것이 좋다.   
  참고: https://webcoding.tistory.com/entry/JAVA-%EC%A0%91%EA%B7%BC-%EC%A0%9C%EC%96%B4%EC%9E%90%EC%9D%98-%EC%A2%85%EB%A5%98%EC%99%80-%EC%82%AC%EC%9A%A9-%EC%9D%B4%EC%9C%A0
  
+ getter, setter는 클래스의 가장 밑으로 빼 두는 것이 좋다.
  + 이유: getter, setter의 용도는 대부분의 개발자들은 이미 알고있다. 따라서 가장 아래쪽으로 빼 둠으로써 굳이 getter, setter를 읽는 데 시간을 뺏           기지 않도록 도와주자.
  
