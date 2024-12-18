# java-racingcar-precourse

![image](https://github.com/user-attachments/assets/bc7d4020-9201-4991-8ccc-7b4d511e539f)



# 자동차 경주 게임

---

## 기능 목록
1. **자동차 이름들을 입력받는다.**
    - 자동차 이름들은 쉼표(`,`)로 구분된다.
2. **자동차가 이동을 시도할 횟수를 입력받는다.**
3. **각 자동차는 무작위 값(0~9)을 생성한다.**
4. **각 자동차는 무작위 값이 4 이상일 경우 전진한다.**
5. **자동차의 이동 결과를 매 시도마다 출력한다.**
6. **가장 많이 전진한 자동차를 우승자로 저장한다.**
7. **우승자를 출력한다.**
    - 우승자가 여러 명일 경우, 쉼표(`, `)로 구분하여 출력한다.

## 입력 조건
1. 각 자동차 이름은 5글자 이하여야 한다.
2. 자동차 이름은 영어와 숫자로만 이루어져야 하며, 공백을 포함할 수 없다.
3. 각 자동차 이름은 유일해야 하며, 중복된 이름을 입력할 수 없다.

---

## 패키지 구조
```
src
└── main
    └── java
        └── racingcar
            ├── car
            │   ├── Car
            │   └── Cars
            ├── game
            │   ├── RacingGame
            │   └── RacingGameFactory
            ├── input
            │   ├── InputHandler
            │   ├── UserInput
            │   └── Validator
            ├── observer
            │   ├── CarObserver
            │   └── CarObserverHelper
            ├── output
            │   └── OutputHandler
            ├── util
            │   ├── RandomValueGenerator
            │   └── StringSplitter
            └── Application
```

## 각 클래스의 역할 및 책임

### 1. `car` 패키지
- **`Car`**: 
  - 개별 자동차를 나타내며, 이름과 위치 정보를 관리하고 이동 로직을 포함합니다. 
  - 옵저버 패턴을 통해 자동차의 이동을 감지하여 옵저버에게 알림을 보낼 수 있습니다.
- **`Cars`**: 
  - 일급 컬렉션으로, 여러 개의 `Car` 객체를 관리합니다. 
  - 전체 자동차의 이동 및 우승자 결정 등의 로직을 담당합니다.

### 2. `game` 패키지
- **`RacingGame`**: 
  - 게임의 전체 흐름을 관리하는 클래스입니다. 
  - 입력 처리, 자동차 초기화, 게임 실행 및 결과 출력 등의 기능을 포함합니다.
- **`RacingGameFactory`**: 
  - `RacingGame` 객체를 생성하는 팩토리 클래스입니다. 
  - 의존성 주입을 통해 필요한 객체들을 조립합니다.

### 3. `input` 패키지
- **`InputHandler`**: 
  - 사용자로부터 입력을 받아 처리하는 클래스입니다. 
  - 자동차 이름과 시도 횟수 등의 입력을 처리합니다.
- **`UserInput`**: 
  - 입력 데이터를 저장하는 데이터 전송 객체(DTO)입니다. 
  - 입력된 자동차 이름과 시도 횟수를 저장합니다.
- **`Validator`**: 
  - 입력 값의 유효성을 검사하는 클래스입니다. 
  - 자동차 이름의 형식, 시도 횟수의 범위 등 다양한 입력 조건을 검증합니다.

### 4. `observer` 패키지
- **`CarObserver`**: 
  - 옵저버 패턴의 인터페이스로, 자동차 이동 시 호출될 메서드를 정의합니다.
- **`CarMovePrinter`**: 
  - `CarObserver`를 구현한 클래스로, 자동차의 이동을 감지할 때마다 해당 상태를 출력하는 역할을 합니다.
- **`CarObserverHelper`**:
    - `CarObserver` 관련 유틸리티 기능을 제공하는 클래스입니다.
    - reflection을 이용해 주어진 클래스 타입과 매개변수를 기반으로 동적으로 `CarObserver` 인스턴스를 생성할 수 있습니다.
    - `addObserverToCar` 메서드는 `Car` 객체에 옵저버를 등록하는 역할을 합니다.

### 5. `output` 패키지
- **`OutputHandler`**: 
  - 게임의 출력 로직을 담당하는 클래스입니다. 
  - 자동차의 상태나 우승자 정보를 화면에 출력하는 역할을 합니다.

### 6. `util` 패키지
- **`RandomValueGenerator`**: 
  - 무작위 숫자 생성 기능을 제공합니다. 
  - 자동차의 이동 여부를 결정할 때 사용됩니다.
- **`StringSplitter`**: 
  - 문자열을 특정 기준(쉼표)으로 분할하는 유틸리티 클래스입니다.

### 7. `Application`
- **`Application`**: 
  - 프로그램의 진입점(Main 클래스)으로, `RacingGame`을 실행합니다.

---

이 패키지 구조는 각 클래스의 책임을 분리하여 명확하게 관리할 수 있도록 도와줍니다. 각 패키지가 특정 도메인이나 기능을 중심으로 구분되어 있어 유지보수와 확장이 용이합니다.

---

## 기능 요구 사항

- 초간단 자동차 경주 게임을 구현한다.
    - 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
    - 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
    - 자동차 이름은 쉼표(`,`)를 기준으로 구분하며, 이름은 5자 이하만 가능하다.
    - 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
    - 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
    - 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
    - 우승자가 여러 명일 경우 쉼표(`,`)를 이용하여 구분한다.
    - 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

---

## 입출력 요구 사항

### 입력
1. 경주할 자동차 이름 (이름은 쉼표(`,`) 기준으로 구분)
    - 예시: `pobi,woni,jun`
2. 시도할 횟수
    - 예시: `5`

### 출력
- 차수별 실행 결과
    - 예시:
      ```
      pobi : --
      woni : ----
      jun  : ---
      ```
- 단독 우승자 안내 문구
    - 예시: `최종 우승자 : pobi`
- 공동 우승자 안내 문구
    - 예시: `최종 우승자 : pobi, jun`

---

## 실행 결과 예시
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 횟수는 몇 회인가요?
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

---

## 프로그래밍 요구 사항 1

- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - 기본적으로 [Java Style Guide](https://google.github.io/styleguide/javaguide.html)를 원칙으로 한다.

## 프로그래밍 요구 사항 2

- **Indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다.**
    - 2까지만 허용한다.
    - 예를 들어 `while`문 안에 `if`문이 있으면 들여쓰기는 2이다.
    - **힌트**: Indent depth를 줄이는 좋은 방법은 함수를(또는 메서드를) 분리하는 것이다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- **JUnit 5**와 **AssertJ**를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
    - 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
        - [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
        - [AssertJ User Guide](https://assertj.github.io/doc/)
        - [AssertJ Exception Assertions](https://assertj.github.io/doc/#assertj-core-exception-assertions)
        - [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)

---

## 라이브러리

- `camp.nextstep.edu.missionutils`에서 제공하는 **Randoms** 및 **Console** API를 사용하여 구현해야 한다.
    - **Random 값 추출**은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

### 사용 예시

- 0에서 9까지의 정수 중 한 개의 정수 반환:
  ```java
  Randoms.pickNumberInRange(0, 9);
  
---