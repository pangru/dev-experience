# Tests

## Introduction
소프트웨어 개발 및 유지보수 단계에서 최소한의 기능 조차도 검증되지 않은 코드가 앱에 적용될 경우, 여러 단계를 거쳐 다른 곳에서 문제를 일으킬 수 있습니다. 이러한 문제를 해결하기 위해 단계별 테스트 기법을 도입하고자 합니다. 엔지니어는 기능 개발할 때 java 클래스와 더불어 개발한 클래스의 최소 단위 기능 검증을 위한 unit test와 통합 기능 단위로 검증하는 integration test, 최종적으로 사용자의 useCase를 검증하는 Acceptance test를 개발해야 하며, 이러한 검증 단계를 통과한 코드만이 최종적으로 앱에 반영되어 릴리즈됩니다.

### Test 단계
* Unit tests
  * 최소 기능 단위를 위해 테스트 하는 단계로 프로그램의 전체 코드를 커버해야 한다.
  * Java에서 기본으로 제공하고 있는 Junit을 활용하여 테스트 코드를 작성할 수 있다.

* Integration tests
  * 프로그램의 Usecase 단위로 테스트 하는 단계. usercase의 성공/실패 시나리오를 고민하여 테스트 케이스가 작성되어야 한다.
  * 외부로 노출되는 API Layer에서부터 테스트코드를 작성한다.
  * Junit4, TestNG (Junit Integration Framework)을 함께 활용하여 테스트 코드를 작성할 수 있다.

* Acceptance Tests
  * 사용자의 interaction을 테스트 하는 단계로서, UI와 연동하여 테스트 되어야 한다.
  * Android 에서 기본 제공하는 Espresso test framework을 활용하여 테스트코드를 작성할 수 있다.

## Tools of the test trade
* Junit4
  * Unit tests를 위해 사용될 Test framework
* TestNG
  * Junit 기반의 강력한 테스트 사용성을 제공하는 test framework

* Espresso testing framework
  * Android Testing support Library
  * user interaction을 시뮬레이션할 수 있도록 UI Testing 관련 API를 제공

### support library
* Hamcrest
  * Test Class에서 사용하는 assert()와 같은 Matcher를 확장한 Library
* Mockito
  * Mock Object 구현을 도와주는 Library

### Mocking
  * Shared Prefs
  * Database
  * System Properties
  * Web Services

### Espresso
  * GUI Testing
  * OnView
  * OnData
  * execute: gradlew connectedCheck

## Related work

### White box testing Methodology
소프트웨어 실행 시에 내부 소스코드가 어떻게 동작하는 지 확인할 수 있는 테스트 기법으로써 소스 코드의 동작을 추적하고 불필요한 코드나 동작의 유효성을 확인할 수 있습니다.

#### Code coverage
소프트웨어 테스트를 진행했을 때 코드 자체가 얼마나 실행되었는지 나타내는 지표 중 하나입니다. 코드의 구조를 이루는 것은 크게 구문(statement), 조건(condition), 결정(decision)이며, 이러한 구조를 얼마나 커버했느냐에 따라 코드 커버리지의 측정 기준이 나뉩니다.
* statement coverage
  * 모든 코드가 한 번은 실행되기 입력하는 기법으로 코드의 에러여부를 파악할 수 있습니다.
* decision coverage (branch test)
  * 코드의 흐름에서 모든 진행을 테스트 합니다. if 조건구문의 전체 결과가 True or False인 경우를 테스트합니다.
* condition coverage
  * 조건문이 있을 때, if 구문의 조건을 보고 조건에 맞는 input 과 안맞는 input을 넣어서 유입되는지 테스트 합니다.
  IF (조건상황들) 이라면 조건 상황들이 true인 조건과 false인 조건을 찾아서 입력합니다.
* multiple condition coverage
  * 조건문의 true/false에 모든 상황을 고려하여 테스트 합니다.
  조건이 IF (A&B)일 때 4가지 입력이 발생합니다. (True & True, True & False, False & True, False & False)

### TDD
테스트는 앱 개발 하는 동안 코드 품질을 향상할 수 있도록 도와줍니다. TDD는 Test Driven Development 의 약자로 개발하기 전에 테스트 코드를 먼저 작성하는 개발 기법을 뜻합니다.

![](https://cdn-images-1.medium.com/max/800/1*wMfZbyyF0fPXjW36YGHLsA.png)

TDD process는 아래와 같습니다.
1. Failing Test: 실패 케이스에 대한 테스트 코드를 작성합니다.
2. Passing Test: function에서 정의하고 있는 성공 케이스에 대한 테스트 코드를 작성합니다.
3. Write Code: 1,2 단계에서 작성한 테스트를 통과할 수 있는 코드를 작성합니다.
4. Run test: 테스트 코드를 실행하여 모든 케이스를 통과하는지 검증합니다.
5. Refactor code: 코드 중복여부를 판단하고 리팩토링을 수행합니다.

TDD는 코드 개발과 함께 코드 기반 테스트 검증을 진행하기 때문에 다양한 장점이 생깁니다.
1. 엔지니어는 자신의 코드와 로직에 대한 자신감을 가집니다.
2. 코드 중복이 줄어서 깔끔한 코드를 유지할 수 있습니다.
3. code quality & maintainability가 증대됩니다.
4. 코드에 모듈화, 유연성, 확장 가능한 구조를 가질 수 있도록 도와줍니다.

### Android TDD
코드 품질 향상을 위해 3단계(unit, integration, functional)의 테스트를 진행합니다.
* Testing pyramid:
![](https://cdn-images-1.medium.com/max/600/1*9LV9happxsb-UqmmnDk-Qw.png)

* Testing in Android
  * Unit Testing
  * Instrumentation test


## References
* [Junit](http://junit.org/junit4/)
* [Junit4 example](https://github.com/junit-team/junit4)
* [TestNG](http://testng.org/doc/index.html)
* [cleanArchitecture test sample](https://github.com/android10/Android-CleanArchitecture)
* [Automating UI Tests](https://developer.android.com/training/testing/ui-testing/espresso-testing.html)
* [Mockito](http://mockito.org)
* [Android Devcon TDD Slidesare](http://www.slideshare.net/godfreynolan/android-tdd-41783654)
* [google sample guide](https://github.com/googlesamples/android-testing/)
* [Android Testing Blueprint](https://plus.google.com/+AndroidDevelopers/posts/NPagF6bpHsv)
* [Esporesso testing guide](https://plus.google.com/+AndroidDevelopers/posts/NPagF6bpHsv)
* [Code coverage wikipedia](https://en.wikipedia.org/wiki/Code_coverage)
* [TDD](https://medium.com/mobility/why-developers-scared-to-refactor-code-47efd1b854e7#.r8zppfpff)
* [android TDD](https://medium.com/mobility/how-to-do-tdd-in-android-90f013d91d7f#.ubvsb4b16)
* [google test blog](https://googletesting.blogspot.kr/2010/12/test-sizes.html)
