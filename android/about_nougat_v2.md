## 고려사항
Doze 모드에서는 앱의 네트워크 연결, wake lock 등과 같은 Background 작업 요청을 무시한다.
앱에서 네트워크 연결이 필요한 경우 반드시 GCM을 활용하여, 기기가 깨어나 작업할 수 있도록 해야 한다.


## Profile-guided JIT/AOT Compilation
  * 프로필 가이드에 기반한 컴파일을 통해 AOT(Ahead-of-Time)컴파일 방식과 JIT(Just-in-Time)컴파일 방식을 혼용해서 쓸 수 있는 최적화 컴파일 제공
  * Android 4.4(Kikat)부터 별도의 스레드에서 프로파일링하여 사용빈도가 높은 메소드를 다시 컴파일하는 JIT 컴파일 방식과 유사한 기능이 도입됨
  * [참고한 글](http://realignist.me/code/2016/05/21/art-with-jit-compiler.html)


## Doze on the Go...
  * Doze system mode 지원
  * 기기가 screen-off이거나 충전중이 아닌 경우 배터리 절약을 위해 앱에서 CPU와 Network 관련 액티비티 실행을 지연시킴
