## Types of testing in android
### unit testing
method, class, component, small module과 같은 가장 작은 기능 위주의 테스트이며,. 다른 컴포넌트들과 격리 혹은 별도로 분리되어 테스트가 진행되어야 한다.


## Test
* Unit tests / Component tests : Espresso
* Acceptance Tests (API Layer) : Robolectic on Mokito
* GUI Tests : Junit4


## Tools of the trade
* Junit4
  * Unit Testing Framework
* Hamcrest
  * Test Class에서 사용하는 assert()와 같은 Matcher를 확장한 Library
* Mockito
  * Mock Object 구현을 도와주는 Library
* Robolectic
* Jenkins


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


## Junit4


http://www.slideshare.net/godfreynolan/android-tdd-41783654
[google sample guide](https://github.com/googlesamples/android-testing/)
[Android Testing Blueprint](https://plus.google.com/+AndroidDevelopers/posts/NPagF6bpHsv)
[Esporesso testing guide](https://plus.google.com/+AndroidDevelopers/posts/NPagF6bpHsv)
