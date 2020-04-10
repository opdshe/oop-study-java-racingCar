/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package racingCar;

import domain.Car;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class App {
    static final int SUCCESS = 1;
    static final int FAIL = 0;
    static final int MAX_NAME_LENGTH = 5;
    static final int MIN_COUNT = 1;

    static Scanner sc = new Scanner(System.in);
    static List<Car> cars = new ArrayList<>();
    static int key;
    static int count;
    static int maxDistance = 0;

    public static void init() {
        setCarNames();
        setCount();
    }

    public static int checkCarNames(List<String> names) {
        if (names.isEmpty()) {
            System.out.println("자동차 이름으로 콤마를 입력했습니다. 다시 입력하세요.");
            return FAIL;
        }
        for (String name : names) {
            if (name.isBlank()) {
                System.out.println(name + "자동차 이름으로 빈 문자열을 사용할 수 없습니다.");
                return FAIL;
            } else if (name.length() > MAX_NAME_LENGTH) {
                System.out.println("자동차 이름은 다섯 글자 이하만 가능합니다.");
                return FAIL;
            }
        }
        return SUCCESS;
    }

    public static void setCarNames() {
        List<String> names;
        do {
            key = SUCCESS;
            System.out.println("경주할 자동차 이름을  입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            names = Arrays.stream(sc.nextLine().split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());
            if (checkCarNames(names) == FAIL) {
                key = FAIL;
            }
        } while (key == FAIL);
        names.forEach(name -> cars.add(new Car(name)));
    }

    public static void setCount() {
        do {
            key = SUCCESS;
            System.out.println("시도할 횟수는 몇 회인가요?");
            try{
                count = sc.nextInt();
                if (count < MIN_COUNT) {
                    System.out.println("시도 횟수는 1 이상이어야 합니다. 다시 입력하세요.");
                    key = FAIL;
                }
            }catch (InputMismatchException e){
                System.out.println("시도 횟수는 숫자(정수)값이어야 합니다.");
                key = FAIL;
                sc.next(); // 버그방지용 코드
            }
        } while (key == FAIL);
    }

    public static void printDistance() {
        cars.forEach(car -> {
            if (car.getPosition() > maxDistance) {
                maxDistance = car.getPosition();
            }
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        });
    }

    public static void printResult() {
        String candidates = cars.stream()
                .filter(car -> car.isMaxPosition(maxDistance))
                .map(Car::getName)
                .collect(joining(", "));
        System.out.println(candidates + "가 최종 우승했습니다.");
    }

    public static void main(String[] args) {
        init();
        System.out.println("실행결과");
        for (int i = 0; i < count; i++) {
            cars.forEach(Car::Go);
            printDistance();
            System.out.println();
        }
        printResult();
        sc.close();
    }
}
